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
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
    <div class="big">
                <div class="map"><b>${title }</b></div>
                <ul class="imglistul">
                	<c:forEach var="list"  items="${list}">
                    <li><img src="<%=basePath %>${list.img}" /><a href="<%=basePath %>thing/show.do?id=${list.id}">${list.name}</a></li>
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
