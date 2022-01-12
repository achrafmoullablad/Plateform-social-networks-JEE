<%@page import="Comment_manager.Comment"%>
<%@page import="Comment_manager.CMCommentImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@page import="Invitation_manager.Invitation"%>
<%@page import="Like_manager.Like"%>
<%@page import="Like_manager.CMLikeImp"%>
<%@page import="Poste_manager.CmPoste"%>
<%@page import="Poste_manager.Poste"%>
<%@page import="Invitation_manager.CInvitation"%>
<%@page import="User_manager.Cmuser"%>
<%@page import="java.util.List"%>
<%@page import="User_manager.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WorkWise</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="assets/css/animate.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/line-awesome.css">
<link rel="stylesheet" type="text/css" href="assets/css/line-awesome-font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/lib/slick/slick.css">
<link rel="stylesheet" type="text/css" href="assets/lib/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
</head>
<body>
	<% User u=(User)session.getAttribute("user"); 
		if(u!=null){
	%>
		<header>
			<div class="container">
				<div class="header-data">
					<div class="logo">
						<a href="index.jsp" title=""><img src="images/logo.png" alt=""></a>
					</div><!--logo end-->
					<div class="search-bar">
						<form>
							<input type="text" name="search" placeholder="Search...">
							<button type="submit"><i class="la la-search"></i></button>
						</form>
					</div><!--search-bar end-->
					<nav>
						<ul>
							<li>
								<a href="index.jsp" title="">
									<span><img src="images/icon1.png" alt=""></span>
									Home
								</a>
							</li>
							<li>
								<a href="companies.jsp" title="">
									<span><img src="images/icon2.png" alt=""></span>
									Companies
								</a>
								<ul>
									<li><a href="companies.jsp" title="">Companies</a></li>
									<li><a href="company-profile.html" title="">Company Profile</a></li>
								</ul>
							</li>
							<li>
								<a href="projects.html" title="">
									<span><img src="images/icon3.png" alt=""></span>
									Projects
								</a>
							</li>
							<li>
								<a href="profiles.html" title="">
									<span><img src="images/icon4.png" alt=""></span>
									Profiles
								</a>
								<ul>
									<li><a href="user-profile.html" title="">User Profile</a></li>
									<li><a href="my-profile-feed.html" title="">my-profile-feed</a></li>
								</ul>
							</li>
							<li>
								<a href="jobs.html" title="">
									<span><img src="images/icon5.png" alt=""></span>
									Jobs
								</a>
							</li>
							<li>
								<a href="#" title="" class="not-box-open">
									<span><img src="images/icon6.png" alt=""></span>
									Messages
								</a>
								<div class="notification-box msg">
									<div class="nt-title">
										<h4>Setting</h4>
										<a href="#" title="">Clear all</a>
									</div>
									
									<div class="nott-list">
										<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img1.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="messages.html" title="">Jassica William</a> </h3>
							  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do.</p>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="view-all-nots">
						  					<a href="messages.html" title="">View All Messsages</a>
						  				</div>
									</div><!--nott-list end-->
								</div><!--notification-box end-->
							</li>
							<li>
								<a href="#" title="" class="not-box-open">
									<span><img src="images/icon7.png" alt=""></span>
									Notification
								</a>
								<div class="notification-box">
									<div class="nt-title">
										<h4>Setting</h4>
										<a href="#" title="">Clear all</a>
									</div>
									<div class="nott-list">
										<%
											CInvitation cin=new CInvitation();
											Cmuser cmu=new Cmuser();
											List<Invitation> lv=cin.showAllInvitation(u.getId());
											for(Invitation in:lv){	
												if(cin.checkAcceptation(u.getId(), in.getIde())==null){
													User we=cmu.find_user_byid(in.getIdi());
										%>
										<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img1.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<a href="pages/followuser.jsp?op=accept&id=<%= in.getId() %>" class="btn btn-secondary">Accept</a>
							  					<span><%= we.getEmail() %></span>
							  				</div><!--notification-info -->
						  				</div>
						  				<% }} %>
						  				<div class="view-all-nots">
						  					<a href="#" title="">View All Notification</a>
						  				</div>
									</div><!--nott-list end-->
								</div><!--notification-box end-->
							</li>
						</ul>
					</nav><!--nav end-->
					<div class="menu-btn">
						<a href="#" title=""><i class="fa fa-bars"></i></a>
					</div><!--menu-btn end-->
					<div class="user-account">
						<div class="user-info">
							<img src="http://via.placeholder.com/30x30" alt="">
							<a href="#" title="">Profil</a>
							<i class="la la-sort-down"></i>
						</div>
						<div class="user-account-settingss">
							<h3>Online Status</h3>
							<ul class="on-off-status">
								<li>
									<div class="fgt-sec">
										<input type="radio" name="cc" id="c5">
										<label for="c5">
											<span></span>
										</label>
										<small>Online</small>
									</div>
								</li>
								<li>
									<div class="fgt-sec">
										<input type="radio" name="cc" id="c6">
										<label for="c6">
											<span></span>
										</label>
										<small>Offline</small>
									</div>
								</li>
							</ul>
							<h3>Custom Status</h3>
							<div class="search_form">
								<form>
									<input type="text" name="search">
									<button type="submit">Ok</button>
								</form>
							</div><!--search_form end-->
							<h3>Setting</h3>
							<ul class="us-links">
								<li><a href="profile-account-setting.html" title="">Account Setting</a></li>
								<li><a href="#" title="">Privacy</a></li>
								<li><a href="#" title="">Faqs</a></li>
								<li><a href="#" title="">Terms & Conditions</a></li>
							</ul>
							<h3 class="tc"><a href="desc.jsp" title="">Logout</a></h3>
						</div><!--user-account-settingss end-->
					</div>
				</div><!--header-data end-->
			</div>
		</header><!--header end-->
	<div class="wrapper">
		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3 col-md-4 pd-left-none no-pd">
								<div class="main-left-sidebar no-margin">
									<div class="user-data full-width">
										<div class="user-profile">
											<div class="username-dt">
												<div class="usr-pic">
													<img src="http://via.placeholder.com/100x100" alt="">
												</div>
											</div><!--username-dt end-->
											<div class="user-specs">
												<h3><%= u.getEmail() %></h3>
												<span><%= u.getRole() %></span>
											</div>
										</div><!--user-profile end-->
										<ul class="user-fw-status">
											<li>
												<% List<Invitation> lusy=cin.ShowAmie(u.getId()); %>
												<h4>Following</h4>
												<span><%= lusy.size() %></span>
											</li>
											<li>
												<% List<Invitation> lock=cin.showAllInvitation(u.getId()); %>
												<h4>Followers</h4>
												<span><%= lock.size() %></span>
											</li>
											<li>
												<a href="#" title="">View Profile</a>
											</li>
										</ul>
									</div><!--user-data end-->
									
								</div><!--main-left-sidebar end-->
							</div>
							<div class="col-lg-6 col-md-8 no-pd">
								<div class="main-ws-sec">
									<div class="post-topbar">
										<div class="user-picy">
											<img src="http://via.placeholder.com/100x100" alt="">
										</div>
										<div class="post-st">
											<ul>
												<li><a class="post_project" href="#" title="">Post</a></li>
											</ul>
										</div><!--post-st end-->
									</div><!--post-topbar end-->
									<div class="posts-section">
										
										<div class="top-profiles">
											<div class="pf-hd">
												<h3>Top Profiles</h3>
												<i class="la la-ellipsis-v"></i>
											</div>
											<div class="profiles-slider">
												<% 
													List<User> ls=cmu.ListUser();
													for(User us:ls){
														if(u.getId()!=us.getId()){
												%>
												<div class="user-profy">
													<img src="http://via.placeholder.com/57x57" alt="">
													<h3><%= us.getEmail() %></h3>
													<span><%= us.getRole() %></span>
													<ul>
														<% if(cin.ShowInvit(u.getId(), us.getId())==null){ %>
															<li><a href="pages/followuser.jsp?op=follow&id=<%= us.getId() %>" title="" class="followw">Follow</a></li>
														<% }else if(cin.checkAcceptation(u.getId(), us.getId())!=null){
														%>
															<li><a href="pages/followuser.jsp?op=annuler&id=<%= us.getId() %>" title="" class="btn btn-primary">Friend</a></li>
														<%	
														}else{ %>
															<li><a href="pages/followuser.jsp?op=annuler&id=<%= us.getId() %>" title="" class="btn btn-secondary">Cancel</a></li>
														<% } %>
													</ul>
													<a href="showprofile.jsp?op=profile&id=<%= us.getId() %>" >View Profile</a>
												</div><!--user-profy end-->
												<% }} %>
											</div><!--profiles-slider end-->
										</div><!--top-profiles end-->
										<%
											CmPoste cpost=new CmPoste();
											List<Poste> lspost=cpost.List_poste(u.getId());
											for(Poste post:lspost){
												User user=cmu.find_user_byid(post.getIduser());
										%>
										<div class="posty">
											<div class="post-bar no-margin">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="http://via.placeholder.com/50x50" alt="">
														<div class="usy-name">
															<% if(u.getId()==user.getId()){ %>
															<h3>Moi</h3>
															<% }else{ %>
															<h3><%= user.getEmail() %></h3>
															<% } %>
															<span><img src="images/clock.png" alt=""><%= post.getDate() %></span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												
												<div class="job_descp">
													<p><%= post.getContenu() %></p>
													
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li>
															<% 
																CMLikeImp clike=new CMLikeImp();
																List<Like> lslike=clike.getAllLikePost(post.getId());
																Like le=clike.getLike(u.getId(), post.getId());
																if(le==null){
															%>
																<a href="pages/followuser.jsp?op=like&idposte=<%= post.getId() %>"><i class="la la-heart"></i> Like</a>
																<img src="images/liked-img.png" alt="">
															<% }else{%>
																<a href="pages/followuser.jsp?op=dislike&idposte=<%= post.getId() %>"><i class="la la-heart-o"></i>Like</a>
																<img src="images/liked-img.png" alt="">
															<% } %>
															
															<span><%= lslike.size() %></span>
														</li> 
														<li><a href="#mycomment" title="" class="com"><img src="images/com.png" alt=""> Comment</a></li>
													</ul>
													<a><i class="la la-eye"></i>Views</a>
												</div>
												
											</div><!--post-bar end-->
											<div class="comment-section" id="mycomment">
												<%
													CMCommentImp cmit=new CMCommentImp();
													List<Comment> lstm=cmit.getAllCommentByPoste(post.getId());
													if(lstm!=null){
													for(Comment cm:lstm){
												%>
												<div class="comment-sec">
													<ul>
														<li>
															<div class="comment-list">
																<div class="comment">																	
																	<span><%= cm.getDate() %></span>
																	<p><%= cm.getContenu() %> </p>
																	<a href="#" title=""><i class="fa fa-reply-all"></i>Reply</a>
																</div>
															</div>
														</li>
													</ul>
												</div><!--comment-sec end-->
												<% }} %>
												<div class="post-comment">
													<div class="cm_img">
														<img src="http://via.placeholder.com/40x40" alt="">
													</div>
													<div class="comment_box">
														<form method="POST">
															<input type="text" placeholder="Post a comment" name="commentaire">
															<input type="hidden" name="idcomt" value="<%= post.getId() %>">
															<button type="submit">Send</button>
														</form>
													</div>
												</div><!--post-comment end-->
											</div><!--comment-section end-->
										</div>
									</div><!--posts-section end-->
									<%} %>
										<%
											CMCommentImp cmi=new CMCommentImp();
											String comment=request.getParameter("commentaire");											
											if(comment!=null){
												int idcomt=Integer.parseInt(request.getParameter("idcomt"));
												Comment c=new Comment(comment,u.getId(),idcomt);
												cmi.addComment(c);
											}
										%>
								</div><!--main-ws-sec end-->
							</div>
							
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>

		<div class="post-popup pst-pj">
			<div class="post-project">
				<h3>Poster</h3>
				<div class="post-project-fields">
					<%
						String description=request.getParameter("description");
						Poste post=new Poste(description,u.getId());
						if(description!=null){
							CmPoste cpt=new CmPoste();
							if(cpt.add_poste(post)>0){
								description=null;
							}
						}
					%>
					<form action="" method="POST">
						<div class="row">
							<div class="col-lg-12">
								<textarea name="description" placeholder="Description"></textarea>
							</div>
							<div class="col-lg-12">
								<ul>
									<li><button class="active" type="submit" value="post">Post</button></li>
									<li><a href="#" title="">Cancel</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div><!--post-project-fields end-->
				<a href="#" title=""><i class="la la-times-circle-o"></i></a>
			</div><!--post-project end-->
		</div><!--post-project-popup end-->
<%@include file="footer.jsp" %>
<%
	}else{
		response.sendRedirect("login.jsp");
	}
%>