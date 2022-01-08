<%@page import="Like_manager.Like"%>
<%@page import="Like_manager.CMLikeImp"%>
<%@page import="Invitation_manager.CInvitation"%>
<%@page import="User_manager.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% User u=(User)session.getAttribute("user"); 
		if(u!=null){
	%>
	<%
		if(request.getParameter("op").equalsIgnoreCase("follow")){
			CInvitation ci=new CInvitation();
			int id=Integer.parseInt(request.getParameter("id"));
			if(ci.addinvitation(u.getId(), id)>0){
				response.sendRedirect("../index.jsp");
			}
		}
		else if(request.getParameter("op").equalsIgnoreCase("annuler")){
			CInvitation ci=new CInvitation();
			int id=Integer.parseInt(request.getParameter("id"));
			if(ci.deleteInvitation(u.getId(), id)>0){
				response.sendRedirect("../index.jsp");
			}
		}else if(request.getParameter("op").equalsIgnoreCase("like")){
			int idp=Integer.parseInt(request.getParameter("idposte"));
			Like like=new Like(u.getId(),idp);
			if(like!=null){
				CMLikeImp clike=new CMLikeImp();
				if(clike.addLike(like)>0){
					response.sendRedirect("../index.jsp");
				}
			}
		}else if(request.getParameter("op").equalsIgnoreCase("accept")){
			CInvitation ci=new CInvitation();
			int id=Integer.parseInt(request.getParameter("id"));
			if(ci.AcceptAmie(id)>0){
				response.sendRedirect("../index.jsp");
			}
		}else if(request.getParameter("op").equalsIgnoreCase("dislike")){
			int idp=Integer.parseInt(request.getParameter("idposte"));
			CMLikeImp clike=new CMLikeImp();
				if(clike.removeLike(idp, u.getId())>0){
					response.sendRedirect("../index.jsp");
				}
		}
	%>
	<%
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>