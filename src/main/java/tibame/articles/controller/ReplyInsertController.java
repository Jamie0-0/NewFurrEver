package tibame.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tibame.articles.service.ReplyService;
import tibame.articles.vo.Reply;

@Controller
public class ReplyInsertController {

	private final ReplyService service;

	@Autowired
	public ReplyInsertController(ReplyService service) {
		this.service = service;
	}

	@PostMapping("/replyInsert") // 後OK 前端form表單就不能用RequestBody接
	public String insertReply(@RequestParam String replyContent, @RequestParam Integer replyComId,
			@RequestParam Integer replyUserId) {

		Reply reply = Reply.builder().replyContent(replyContent).replyComId(replyComId).replyUserId(replyUserId)
				.build();

		service.insertReply(reply);

		return "redirect:/article.html";
	}

}
