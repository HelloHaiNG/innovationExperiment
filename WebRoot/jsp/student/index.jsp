<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <TITLE>南昌航空大学军训线上网站</TITLE> 
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<FRAMESET frameSpacing=0 rows=80,* frameBorder=0>
	<FRAME name=top src="/innovationExperiment/jsp/student/top.jsp" frameBorder=0 noResize
		scrolling=no>
	<FRAMESET frameSpacing=0 frameBorder=0 cols=220,*>
		<FRAME name=menu src="/innovationExperiment/jsp/student/menu.jsp" frameBorder=0 noResize>
		<FRAME name=main src="/innovationExperiment/jsp/student/welcome.jsp" frameBorder=0>
	</FRAMESET>
	<NOFRAMES>
		<p>This page requires frames, but your browser does not support
			them.</p>
	</NOFRAMES>
</FRAMESET>
  </head>
  
  <body>
   
  </body>
</html>
