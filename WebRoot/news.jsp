<%@page import="com.java.service.IntroduceService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
                <div class="map"><b>${ title}</b></div>
                <ul class="imglistul_news">
                	<c:forEach var="list"  items="${list}">
                    <li><img src="<%=basePath %>${list.img}" />
                    <a href="<%=basePath %>news/show.do?id=${list.id}">${list.title}</a>
                    <p>${fn:substring(list.content,0,150) }...</p>
                    </li>
                    </c:forEach>
                </ul> 
                
                <div style="width:100%; margin-left:24px; background:white; text-align:center" id="pagediv">
						<style>
						#pagediv a,#pagediv a:visited{ color:#A51010; margin:5px; font-size:12px}
						</style>
				  		${pages }
				  		</div>
                
            </div>
            
    
    
    <%@ include file="foot.jsp" %> 
  </body>
</html>
