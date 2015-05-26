<%@page import="com.zdz.articleCommit.DAO.ArticleDao"%>
<%@page import="com.zdz.articleCommit.service.ArticleService"%>
<%@page import="com.zdz.articleCommit.model.Article"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="java.sql.Date"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String title = request.getParameter("title");
String contend = request.getParameter("contend");

System.out.println(request.getParameter("userId"));
System.out.println(request.getParameter("title"));
System.out.println(request.getParameter("pid"));
int userId = Integer.parseInt(request.getParameter("userId"));

Article article = new Article();
article.setTitle(title);
article.setContent(contend);
article.setUserId(userId);
article.setDate(new Date(System.currentTimeMillis()));
ArticleService articleService = new ArticleService();
ArticleDao articleDao = new ArticleDao();
articleService.setArticleDao(articleDao);
articleService.save(article);

response.sendRedirect("articleCommitSuccess.jsp");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
