<%@page import="com.java.service.IntroduceService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="css/css.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
    <div class="big">
                <div class="map"><b>${introduce.type }</b></div>
                <p>
					${introduce.content}
				</p>    
            </div>
            
    
    
    <%@ include file="foot.jsp" %> 
  </body>
</html>
