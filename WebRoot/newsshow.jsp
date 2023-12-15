<%@page import="com.java.service.IntroduceService"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
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
                <div class="map"><b>祥情</b></div>
                <div style="width:100%; text-align:center; padding-bottom:20px; color:black;"><h1>${news.title}</h1></div>
                <div id="line">
                	<span>发布方：${news.form }</span>
                	<span>点击率：${news.hot }</span>
                	<span>发布日期：<fmt:formatDate value="${news.intime}" pattern="yyyy-MM-dd"/></span>
                </div>

                <div class="big">
                	${news.content}
                </div>
                <blockquote class="layui-elem-quote">
                	<button class="layui-btn layui-btn-sm layui-btn-normal" id="zan">赞(${news.zan }个)</button>
				</blockquote>
                
                
            </div>

    
    
    <%@ include file="foot.jsp" %> 
    
  	<script type="text/javascript">
//Demo
layui.use(['form', 'layedit', 'laydate','layer'], function(){
 var form = layui.form
 ,layedit = layui.layedit
 ,laydate = layui.laydate
 ,layer=layui.layer;
	
	$("#zan").click(function(){
		
		$.post("${basePath}news/zan.do", { id: "${news.id}" },
		   function(result){
				if (result.success) {
					$.messager.alert("系统提示", result.mgf, "info", function () {
						location.href='${basePath}news/show.do?id=${news.id}';
			        }); 
				} else {
					$.messager.alert("系统提示", result.mgf);
				}
		   }, "json");
	})
	
});
	
</script>
  </body>
</html>
