<%@page import="product.model.*"%>
<%@page import="master.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
ProductDAO dao = new ProductDAO();
ProductVO iValue = dao.indexValue((Integer)session.getAttribute("mid"));

ProductDAO dao2 = new ProductDAO();
List<MasterPicVO> list1 = dao2.indexNatrix1((Integer)session.getAttribute("mid"));
List<MasterPicVO2> list2 = dao2.indexNatrix2((Integer)session.getAttribute("mid"));
%>




<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Furrever admin is super flexible, powerful, clean &amp; modern responsive bootstrap 5 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, Furrever admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="Tha102G3">
<link rel="icon"
	href="<%=request.getContextPath()%>/backEnd/assets/images/favicon.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/backEnd/assets/images/favicon.png"
	type="image/x-icon">
<title>Frever - Dashboard</title>
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd/assets/css/linearicon.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/themify.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/ratio.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/remixicon.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/feather-icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/scrollbar.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/animate.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd/assets/css/vendors/slick.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/backEnd/assets/css/style.css">
</head>

<body>
	<div class="tap-top">
		<span class="lnr lnr-chevron-up"></span>
	</div>

	<div class="page-wrapper compact-wrapper" id="pageWrapper">
		<div class="page-header">
			<div class="header-wrapper m-0">
				<div class="header-logo-wrapper p-0">
					<div class="logo-wrapper">
						<a href="<%=request.getContextPath()%>/backEnd/back_index.jsp">
							<img class="img-fluid main-logo"
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/1.png"
							alt="logo"> <img class="img-fluid white-logo"
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/1-white.png"
							alt="logo">
						</a>
					</div>
					<div class="toggle-sidebar">
						<i class="status_toggle middle sidebar-toggle"
							data-feather="align-center"></i> <a
							href="<%=request.getContextPath()%>/backEnd/back_index.jsp">
							<img
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/1.png"
							class="img-fluid" alt="">
						</a>
					</div>
				</div>

				<div class="nav-right col-6 pull-right right-header p-0">
					<ul class="nav-menus">
						<li><span class="header-search"> <i
								class="ri-search-line"></i>
						</span></li>

						
						<li class="profile-nav onhover-dropdown pe-0 me-0">
							<ul class="profile-dropdown onhover-show-div">
								<li><a
									href="<%=request.getContextPath()%>/backEnd/order-list.html">
										<i data-feather="archive"></i> <span>訂單</span>
								</a></li>
								<li><a
									href="<%=request.getContextPath()%>/backEnd/profile-setting.html">
										<i data-feather="settings"></i> <span>設置</span>
								</a></li>
								<li><a data-bs-toggle="modal"
									data-bs-target="#staticBackdrop" href="javascript:void(0)">
										<i data-feather="log-out"></i> <span>登出</span>
								</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>


		<div class="page-body-wrapper">
			<div class="sidebar-wrapper">
<!-- 				<div id="sidebarEffect"></div> -->
				<div>
					<div class="logo-wrapper logo-wrapper-center">
						<a href="<%=request.getContextPath()%>/backEnd/back_index.jsp"
							data-bs-original-title="" title=""> <img
							class="img-fluid for-white"
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/full-white.png"
							alt="logo">
						</a>
						<div class="back-btn">
							<i class="fa fa-angle-left"></i>
						</div>
					</div>
					<div class="logo-icon-wrapper">
						<a href="<%=request.getContextPath()%>/backEnd/back_index.jsp">
							<img class="img-fluid main-logo main-white"
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/logo.png"
							alt="logo"> <img class="img-fluid main-logo main-dark"
							src="<%=request.getContextPath()%>/backEnd/assets/images/logo/logo-white.png"
							alt="logo">
						</a>
					</div>
					<nav class="sidebar-main">
						<div class="left-arrow" id="left-arrow">
							<i data-feather="arrow-left"></i>
						</div>

						<div id="sidebar-menu">
							<ul class="sidebar-links" id="simple-bar">
								<li class="back-btn"></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title link-nav"
									href="<%=request.getContextPath()%>/backEnd/back_index.jsp">
										<i class="ri-home-line"></i> <span>主頁</span>
								</a></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-store-3-line"></i>
										<span>產品</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a
											href="<%=request.getContextPath()%>/backEnd/products.jsp">所有產品</a>
										</li>

										<li><a
											href="<%=request.getContextPath()%>/backEnd/add-new-product.jsp">添加產品</a>
										</li>
									</ul></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-archive-line"></i> <span>訂單</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a
											href="<%=request.getContextPath()%>/backEnd/order-list.html">訂單列表</a>
										</li>
										<li><a
											href="<%=request.getContextPath()%>/backEnd/order-list2.html">團購訂單</a>
										</li>
									</ul></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-settings-line"></i>
										<span>編輯</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a
											href="<%=request.getContextPath()%>/backEnd/profile-setting.html">
												個人設定</a></li>
									</ul></li>
							</ul>
						</div>

						<div class="right-arrow" id="right-arrow">
							<i data-feather="arrow-right"></i>
						</div>
					</nav>
				</div>
			</div>



			<div class="page-body">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-6 col-xxl-3 col-lg-6">
							<div class="main-tiles border-5 border-0  card-hover card o-hidden">
								<div class="custome-1-bg b-r-4 card-body">
									<div class="media align-items-center static-top-widget">
										<div class="media-body p-0">
											<span class="m-0">近30天收入</span>
											<h4 class="mb-0 counter"><%=iValue.getA()%>
												<span class="badge badge-light-primary grow"> <i
													data-feather="trending-up"></i>8.5%
												</span>
											</h4>
										</div>
										<div class="align-self-center text-center">
											<i class="ri-database-2-line"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-6 col-xxl-3 col-lg-6">
							<div class="main-tiles border-5 card-hover border-0 card o-hidden">
								<div class="custome-2-bg b-r-4 card-body">
									<div class="media static-top-widget">
										<div class="media-body p-0">
											<span class="m-0">近30天訂單數</span>
											<h4 class="mb-0 counter"><%=iValue.getB()%>
												<span class="badge badge-light-danger grow"> <i
													data-feather="trending-down"></i>8.5%
												</span>
											</h4>
										</div>
										<div class="align-self-center text-center">
											<i class="ri-shopping-bag-3-line"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-6 col-xxl-3 col-lg-6">
							<div class="main-tiles border-5 card-hover border-0  card o-hidden">
								<div class="custome-3-bg b-r-4 card-body">
									<div class="media static-top-widget">
										<div class="media-body p-0">
											<span class="m-0">產品數</span>
											<h4 class="mb-0 counter"><%=iValue.getC()%>
												<a
													href="<%=request.getContextPath()%>/backEnd/add-new-product.jsp"
													class="badge badge-light-secondary grow"> 添加</a>
											</h4>
										</div>

										<div class="align-self-center text-center">
											<i class="ri-chat-3-line"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-6 col-xxl-3 col-lg-6">
							<div class="main-tiles border-5 card-hover border-0 card o-hidden">
								<div class="custome-4-bg b-r-4 card-body">
									<div class="media static-top-widget">
										<div class="media-body p-0">
											<span class="m-0">近30天消費人數</span>
											<h4 class="mb-0 counter"><%=iValue.getD()%>
												<span class="badge badge-light-success grow"> <i
													data-feather="trending-down"></i>8.5%
												</span>
											</h4>
										</div>

										<div class="align-self-center text-center">
											<i class="ri-user-add-line"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xl-6 col-md-12">
							<div class="card o-hidden card-hover">
								<div class="card-header card-header-top card-header--2 px-0 pt-0">
									<div class="card-header-title">
										<h4>最暢銷產品</h4>
									</div>
								</div>

								<div class="card-body p-0">
									<div class="table-responsive">
										<table
											class="best-selling-table w-image w-image w-image table border-0">
											<tbody>
												<c:forEach var="productVO" items="<%=list1%>">
													<tr>
														<td>
															<div class="best-product-box">
																<div class="product-image">
																<img src="data:image/jpeg;base64,${productVO.p_pic_one}" alt="Product Image" width="200">
																</div>
																<div class="product-name">
																	<h6>商品名稱:</h6>
																	<h5>${productVO.p_name}</h5>
																</div>
															</div>
														</td>

														<td>
															<div class="product-detail-box">
																<h6>數量</h6>
																<h5>${productVO.b}</h5>
															</div>
														</td>
														<td>
															<div class="product-detail-box">
																<h6>收益</h6>
																<h5>${productVO.c}</h5>
															</div>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>


						<div class="col-xl-6">
							<div class="card o-hidden card-hover">
								<div class="card-header card-header-top card-header--2 px-0 pt-0">
									<div class="card-header-title">
										<h4>最近的訂單</h4>
									</div>

									<div class="best-selling-box d-sm-flex d-none">
										<div class="dropdown">
											<ul class="dropdown-menu"
												aria-labelledby="dropdownMenuButton2">
												<li><a class="dropdown-item" href="#">Action</a></li>
												<li><a class="dropdown-item" href="#">Another
														action</a></li>
												<li><a class="dropdown-item" href="#">Something
														else here</a></li>
											</ul>
										</div>
									</div>
								</div>

								<div class="card-body p-0">
									<div>
										<div class="table-responsive">
											<table class="best-selling-table w-image w-image w-image table border-0">
												<tbody>
													<c:forEach var="productVO2" items="<%=list2%>">
														<tr>
															<td>
																<div class="best-product-box">
																	<div class="product-image">
																		<img src="data:image/jpeg;base64,${productVO2.u_pic}" alt="Product Image" width="200">
																	</div>
																	<div class="product-name">
																		<h6>收件者:</h6>
																		<h5>${productVO2.order_r_name}</h5>
																	</div>
																</div>
															</td>

															<td>
																<div class="product-detail-box">
																	<h6>電話</h6>
																	<h5>${productVO2.order_r_phone}</h5>
																</div>
															</td>
															<td>
																<div class="product-detail-box">
																	<h6>地址</h6>
																	<h5>${productVO2.order_r_addr}</h5>
																</div>
															</td>
															<td>
																<div class="product-detail-box">
																	<h6>消費金額</h6>
																	<h5>${productVO2.order_t}</h5>
																</div>
															</td>
															<td>
																<div class="product-detail-box">
																	<h6>付款狀態</h6>
  																	<jsp:useBean id="payStatusSvc" scope="page"
  																	class="payStatus.model.PayStatusService" />
 																	<c:forEach var="payStatusVO" items="${payStatusSvc.getAll()}">
 																		<h5>${productVO2.order_pay.equals(payStatusVO.pa_id) ? payStatusVO.pa_name : ''}</h5>
 																	</c:forEach>
																</div> 
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="container-fluid">
					<footer class="footer">
						<div class="row">
							<div class="col-md-12 footer-copyright text-center">
								<p class="mb-0">Copyright 2022 © FURREVER theme by THA102G3</p>
							</div>
						</div>
					</footer>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<h5 class="modal-title" id="staticBackdropLabel">登出</h5>
					<p>是否登出?</p>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
					<div class="button-box">
						<button type="button" class="btn btn--no" data-bs-dismiss="modal">No</button>
						<button type="button" class="btn  btn--yes btn-primary">Yes</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/jquery-3.6.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/scrollbar/simplebar.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/scrollbar/custom.js"></script>
	<script src="<%=request.getContextPath()%>/backEnd/assets/js/config.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/sidebar-menu.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/notify/bootstrap-notify.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/chart/apex-chart/apex-chart1.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/chart/apex-chart/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/chart/apex-chart/apex-chart.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/chart/apex-chart/stock-prices.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/slick.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/custom-slick.js"></script>
	<script src="<%=request.getContextPath()%>/backEnd/assets/js/ratio.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/sidebareffect.js"></script>
	<script src="<%=request.getContextPath()%>/backEnd/assets/js/script.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/chart/apex-chart/chart-custom1.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/bootstrap/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/icons/feather-icon/feather.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd/assets/js/icons/feather-icon/feather-icon.js"></script>
</body>

</html>