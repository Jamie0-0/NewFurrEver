let content_html = '<textarea class="content_update" id="summernote1"></textarea>';
let title_html = '<input type="text" class="title_post w-100" placeholder="輸入標題">';
let imgFiles = null;
let imgFilesLength = 0;
let formData = new FormData();
let urlArtId = 0;

function fetchComment() {
	fetch("comment").then(response => response.json()).
		then(data => {
			console.log(data);
			for (let i = 0; i < data.length; i++) {
				let dataId = data[i].comId;
				comTotal = data.length;
				const responseItem = `
			<div class="com_wrapper_inner">
				<div class="card w-100">
					<div class="comment-report position-absolute top-0 end-0 me-1">
						<i type="button" class="fa-solid fa-flag com-report" comId="${data[i].comId}"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop"></i>
					</div>
					<div class="card-body">
						<div class="row message_author">
							<div class="col-12">
								<ul
									class="list-group list-group-horizontal d-flex justify-content-start">
									<li class="list-group-item border-0">
										<img alt="Avatar" class="avatar rounded-circle img-fluid"
											src="avatar?uid=${data[i].comUserId}">
									</li>
									<li class="list-group-item border-0 com_username">
										${data[i].artUser.uname}
									</li>
									<li class="list-group-item com_time border-0 d-none d-md-block">
										${data[i].comDateTime}
									</li>
									<li class="list-group-item com-content border-0 card-text fw-bold fs-5 my-2">
										${data[i].comContent}
									</li>
								</ul>
							</div>
						</div>
						<div>
							<i type="button"
								class="fa-solid fa-reply com-reply-btn${dataId} fa-rotate-180 ms-1"></i>
						</div>
						<div class="com-reply-wrapper${dataId} row d-none">
						</div>
					</div>
				</div>
			</div>
    `;
 
				$("#com_wrapper").append(responseItem);
				// 擴充: 回覆的回覆
				$(`.com-reply-btn${dataId}`).on("click", function () {
					// 要發送的 replyComId
					let replyComId = dataId;
					let url = "reply?replyComId=" + replyComId;
					const comReplyWrapper = $(`.com-reply-wrapper${dataId}`);

					if($(`div.com-reply-wrapper${dataId}`).hasClass("d-none")){

					//  添加reply的留言區塊
					const replybutt = `
								<form action="replyInsert" method="post">
									<input name="replyContent" type="text" class="card-text w-100" placeholder="留言">
									<div class="post-button-list2">
										<button class="card-link btn btn-secondary post-button"
											type="submit" style="float:right;">回覆</button>
									</div>
									<input name="replyComId" type="hidden" value="${replyComId}">
									<input name="replyUserId" type="hidden" value="1">
								</form>
								`;


					let that = $(this).closest("div.card-body").find("div").last();
						that.after(replybutt);
						that.find("button").attr("replyComId", replyComId);
					
					//  添加reply的留言區塊 end

					fetch(url)
						.then(response => response.json())
						.then(data => {
							for (let k = 0; k < data.length; k++) {
								const replyItem = `
<div class="col-11 offset-1">
    <div class="card">
        <div class="post-reply w-100 position-relative">
            <div class="border-0 row">
                <div class="border-0 col-2 col-sm-2">
                    <img alt="Avatar"
                        class="avatar rounded-circle img-fluid"
                        alt="./images/Avatar.png"
                        src="avatar?uid=${data[k].replyUserId}">
                </div>
                <div class="reply_username border-0 col-2 col-sm-2">
                    ${data[k].artUser.uname}
                </div>
                <p class="reply_time d-none d-sm-block border-0 col-1 col-sm-2">
                    ${data[k].replyDateTime}
                </p>
                <div class="reply-content border-0 col col-sm fw-bold fs-6">
                    ${data[k].replyContent}
                </div>
            </div>
            <i type="button"
                class="fa-solid fa-flag reply-report position-absolute end-0 top-0 d-none d-md-block"
                data-bs-toggle="modal" data-bs-target="#staticBackdrop"
                replyId="${data[k].replyId}"></i>
        </div>
    </div>
</div>
  `;
								comReplyWrapper.append(replyItem);

							} //小迴圈 end
						});

					// reply report button
					$(`.com-reply-wrapper${dataId}`).on("click", "i.reply-report", function (e) {
						e.stopPropagation();
						let replyId = $(this).attr("replyId");
						$("#report-submit").attr("replyId", replyId);
						$("#report-submit").attr("artId", 0);
						$("#report-submit").attr("comId", 0);
						// 傳id去 $("#report-submit")
					});
					$(`div.com-reply-wrapper${dataId}`).removeClass(" d-none");
						
						}else{
							$(`div.com-reply-wrapper${dataId}`).addClass(" d-none");
							$(this).closest("div.card-body").find("form").remove();  //移除發言區塊
							comReplyWrapper.empty();   // 移除留言
						}
				});  // 擴充 end						
			}  // 大迴圈 end

			// 避免YT影響RWD
			$("iframe").removeAttr("width").removeAttr("height");
			$("iframe").addClass("mw-100").css("aspect-ratio", "16/9");
			$("li.com-content p").addClass(" fs-5");
		});  // fetch end

}

function addUpload() {
	$("#upload_img_label").removeClass(" d-none");

	$('#upload_img').on('change', function () {
		imgFiles = $(this)[0].files;

		imgFilesLength = imgFiles.length
		$(".carousel-item").remove();
		if (imgFiles.length > 5) {
			alert("最多只能上傳五張照片，請重新選擇")
			return;
		}
		for (i = 0; i < imgFiles.length; i++) {
			filePath = imgFiles[i].name
			fileFormat = filePath.split('.')[1].toLowerCase()
			src = window.URL.createObjectURL(imgFiles[i])
			let isActive = i === 0 ? " active" : "";  // 加入active才不會bootstrap一次顯示多張圖導致重疊
			let element = `<div class="carousel-item${isActive}"><img class="img-thumbnail card-img-top article d-block w-100" id="carouPic${i}" src="${src}"></div>`

			$(".carousel-inner").append(element);
		}
	});
	return imgFiles;
}

function buildArticle() {
	fetch("article")
		.then(response => response.json())
		.then(data => {
			if (data === null) {
				alert("這篇文章不存在，即將送您回交流天地");
				setTimeout(function () {
					$(window).attr('location', 'forum.html');
				}, 2000);
			} else {
				$(".author").text(data.artUser.uname); 
				$(".author").attr("uid", data.artUserId); 
				$("time.post-time").text(data.artPoTime);
				$("button.blog-button").attr("artId", data.artId);
				$("#article-title").text(data.artTitle);
				$("#article-content").append(data.artContent);
				$("i.fa-heart").text(data.artLike);
				$("#ownerAvatar").attr("src", "avatar?uid=" + data.artUserId);
				$("#article-report").attr("artId", data.artId)
				urlArtId = data.artId;
				console.log("urlArtId"+urlArtId)

				// Like
				$("#article-like").on("click", function (e) {
					// 避免重複點擊
					e.stopPropagation();
					$(this).css("pointer-events", "none");

					fetch(`artLike?artId=${data.artId}&uid=3`)
						.then(response => response.json())
						.then(data => {
							if (data === -1) {

							} else {
								$("i.fa-heart").text(data);
							}
						})
						.finally(() => {
							// 從元素中完全移除pointer-events屬性，恢復點擊事件
							$(this).removeAttr("style");

						});
				});

				// Like end

				// Share button
				$("#share-tooltip").on("click", () => {

					let url = "localhost:8080/FurrEver/articleXxx?artId=" + urlArtId;
					navigator.clipboard.writeText(url);
					alert(`文章網址${url}已複製成功`);
				})
				// Share button end

				// carousel控tag
				fetch("artDnone")
					.then(response => response.json())
					.then(data => {
						for (let i = 5; i > data; i--) {
							$(`#carouPic${i}`).parent('div').remove();
						}
					});

				let comTotal = 0;
				const comReplyWrapper = null;

				fetchComment();
			}
		});
}

$(document).ready(function () {
	$("#summer2").on("click", function () {
		console.log("comArtId="+urlArtId);
		var markupStr = $('#summernote2').val();
		$.ajax({
			url: "commentInsert",
			type: "GET",
			contentType: "application/json", 
			data: {
				"comArtId": urlArtId
				, comUserId: 1
				, comContent: markupStr
			},
			dataType: "json",
			success: function (data) {
				if (data === 1) {
					$("#com_wrapper").empty();
					$('.note-editable').empty();
					$("#article-content").empty();
					buildArticle();
				} else {
					alert("新增留言失敗");
				}
			}
		});
	});

	if (window.location.search.includes("fromRule=true")) {
		$(".from-rule").addClass(" d-none");
		$(".carousel-item").remove();
		$("#article-content").after(content_html);
		$("#article-title").after(title_html);

		imgFiles = addUpload();

		$("#upload_img_label").after('<button type="button" class="btn btn-primary position-absolute end-0 top-0" id="post-new">送出</button>')
		$('#summernote1').summernote({
			placeholder: '請輸入文章內容',
			tabsize: 2,
			height: 120,
			toolbar: [
				['style', ['style']],
				['font', ['bold', 'underline', 'clear']],
				['color', ['color']],
				['para', ['ul', 'ol', 'paragraph']],
				['table', ['table']],
				['insert', ['link', 'picture', 'video']],
				['view', ['fullscreen', 'codeview', 'help']]
			]
		});


		$("#post-new").on("click", function () {

			content_value = $('#summernote1').val().trim();
			title_value = $(".title_post").val().trim();
			
			// 有時間再處理僅換行也可以發文的問題
			if(content_value == "" || title_value == ""){
				alert("標題以及跟內容跟毛小孩一樣不能走失喔!")
			}else{
				formData = new FormData();  // 洗掉之前的formData; 因為是全域變數 不new會越來越多
			//	formData.append('artUserId', 1); // 暫定1 應為登入者	
				formData.append('artTitle', title_value);
				formData.append('artContent', content_value);
	
				for (let i = 0; i < imgFilesLength; i++) {
					formData.append('images', imgFiles[i]);
				}
	
				$.ajax({
					url: "insertArticle",
					type: "POST",
					data: formData,
					processData: false,
					contentType: false,
					success: function (data) {
	
						if (data === 1) {
							alert("發文成功")
							fetch("refresh")
								.then(response => response.json())
								.then(data => {
									console.log("refresh=" + data);
								});
							$(window).attr("location", "forum.html")
	
						} else {
							alert("發文失敗")
						}
					},
				});
			}
		});

	} else {
		for (let i = 1; i <= 5; i++) {
			$(`#carouPic${i}`).attr("src", `carousel?picOrder=${i-1}`);
		}

		buildArticle();

		// 編輯文章
		let content_value = "";
		let title_value = "";
		$("#article-edit").on("click", function () {

			let article_content = $("#article-content").find("*");
			let article_title = $("#article-title").text();
			content_html = `<textarea class="content_update" id="summernote1" value="${article_content}"></textarea>`;
			title_html = '<input type="text" class="title_update w-100" placeholder="輸入標題" value="' + article_title + '">';

			imgFiles = addUpload();

			if ($("textarea.content_update").length == 0) {
				$("#article-title").after(title_html);
				$("#article-content").after(content_html);
				$("#article-content, #article-title").toggleClass("d-none");
				$(".forSummer2").toggleClass(" d-none");
				$(this).text("送出");

				$('#summernote1').summernote({
					placeholder: '請輸入文章內容',
					tabsize: 2,
					height: 120,
					toolbar: [
						['style', ['style']],
						['font', ['bold', 'underline', 'clear']],
						['color', ['color']],
						['para', ['ul', 'ol', 'paragraph']],
						['table', ['table']],
						['insert', ['link', 'picture', 'video']],
						['view', ['fullscreen', 'codeview', 'help']]
					]
				});

			} else {

				title_value = $("input.title_update").val().trim();
				if ($(".note-editable").find("*").length == 0 || title_value == "") {
					alert("內容不可空白");
				} else if ($(".note-editable").find("*") == article_content && title_value == article_title && imgFilesLength == 0) {
					alert("並未作任何修改");
				} else {
					content_value = $('#summernote1').val();
					formData = new FormData();  // 洗掉之前的formData; 因為是全域變數 不new會越來越多
					formData.append('artId', urlArtId);
					formData.append('artTitle', title_value);
					formData.append('artContent', content_value);
					formData.append('artLike',$("i.fa-heart").text())

					for (let i = 0; i < imgFilesLength; i++) {
						formData.append('images', imgFiles[i]);
					}

					$.ajax({
						url: "insertArticle",
						type: "POST",
						data: formData,
						processData: false,
						contentType: false,
						dataType: "json",
						success: function (data) {
							if (data === 1) {

								alert("更新成功")
								$("#article-content,#article-title").toggleClass(" d-none");
								$("#summernote1").remove();
								$("#article-content").empty();
								$("#article-edit").text("編輯");
								$("input.title_update").remove();
								$(".note-editor").eq(0).remove();
								$("#upload_img_label").addClass(" d-none")
								$(".forSummer2").toggleClass(" d-none");
								buildArticle();

							} else {
								alert("更新失敗")

								for (let i = 1; i <= 5; i++) {
									$(`#carouPic${i}`).attr("src", `carousel?picOrder=${i}`);
								}
							}
						}
					});
				}
			}
		});
	}
});



// article comment button
$("#article-comment").on("click", function () {
	console.log("跳到留言");
});

// comment report button 事件委派到父元素
$("#com_wrapper").on("click", "i.com-report", function (e) {
	e.stopPropagation();
	let comId = $(this).attr("comId");
	console.log(comId);
	$("#report-submit").attr("comId", comId);
	$("#report-submit").attr("artId", 0);
	$("#report-submit").attr("replyId", 0);
	// 傳id去 $("#report-submit")
});

// article report button
$("#article-report").on("click", function () {
	let artId = $(this).attr("artId");
	$("#report-submit").attr("artId", artId);
	$("#report-submit").attr("comId", 0);
	$("#report-submit").attr("replyId", 0);
	// 傳id去 $("#report-submit")

})


$("#report-submit").on("click", function () {

	let artId = $("#report-submit").attr("artId");
	let comId = $("#report-submit").attr("comId");
	let replyId = $("#report-submit").attr("replyId");
	let selectedReason = $("input[name='listGroupRadio']:checked").val();

	$.ajax({
		url: "artReport",
		type: "GET",
		data: {
			repArtId: artId,
			crepComId: comId,
			rrepReplyId: replyId,
			repReason: selectedReason,
			uid: "1"   // 暫定1 應為登入者id
		},
		dataType: "json",
		beforesend: function () {
			$("#report-submit").addClass(" disabled");
		},
		success: function () {
			$("#report-submit").removeClass(" disabled");
			$(window).attr('location', 'article.html');
		}
	});
});

