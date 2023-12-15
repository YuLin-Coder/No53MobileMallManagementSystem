<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
</head>

  </head>
  
  <body>
  	<%@ include file="top.jsp" %>
    <table cellpadding="0" cellspacing="0" id="maintable">
        <tr>
            <td class="lefttd">
                <%@ include file="left.jsp" %> 
              </td>
            <td>
  		<table id="sqltable" >
		               <tr class="title">
			               <td>编号</td>
				    		<td>用户名</td>
				    		<td>密码</td>
				    		<td>性别</td>
				    		<td>电话</td>
				    		<td>邮箱</td>
				    		<td>地址</td>
				    		<td>操作</td>
		                </tr>
                		<c:forEach var="list"  items="${list}">
		                <tr class="rows">
			                <td>${list.id}</td>
				    		<td>${list.login}</td>
				    		<td>${list.pwd}</td>
				    		<td>${list.sex}</td>
				    		<td>${list.tel}</td>
				    		<td>${list.mail}</td>
				    		<td>${list.address}</td>
				    		<td><a href="javascript:;;" id="${list.id }" class="del">删除</a></td>
		                </tr>
		                </c:forEach>
	                </table>
	                <div style="width:100%; margin-left:24px; background:white; text-align:center" id="pagediv">
						<style>
						#pagediv a,#pagediv a:visited{ color:#A51010; margin:5px; font-size:12px}
						</style>
				  		${pages }
				  		</div>
  	</td>
            <td class="mainrightborder"></td>
        </tr>
    </table>
    <%@ include file="foot.jsp"%>
  	
    <script>
    $(function(){ 
    	$(".del").click(function(){
    		var id = $(this).attr("id");
		    $.messager.confirm("系统提示", "您确认要删除这条数据吗？", function(r) {
				if (r) {
					$.post("${basePath}client/client_del.do", {
						id:id
					}, function(result) {
						if (result.success) {
								 $.messager.alert("系统提示", result.mgf, "info", function () {
									window.location.reload();
						        }); 
						} else {
							$.messager.alert("系统提示", result.mgf);
						}
					}, "json");
					/* $.ajax({
			           url : "${basePath}client/client_del.do",
			           type : "POST",
			           dataType:"JSON",  
			           //如果后台你声明了具体的类型来接收参数，那么你就需要设置  contentType类型为 application/json。同时配置Spring的 Json转换器，它的作用是 将传递过来的Json进行序列化成你声明的类型。
			           //如果后台是使用注解@RequestParam 来进行接收参数的话，那么 ajax 就不用添加contentType为application/json，它默认的application/x-www-form-urlencoded就是我们所需要的。
			           contentType:"application/json",  
			           data : {id:id},
			           success : function(result, status, req) {
			        	   if (result.success) {
								$.messager.alert("系统提示", result.mgf);
								location.href=window.location.href;
							} else {
								$.messager.alert("系统提示", result.mgf);
							}
			           },
			           error : function(req, status, reason) {
			        	   $.messager.alert("系统提示", reason);
			           }
			         }) */
				}
			});
    	});
    })
    </script>
  </body>
</html>
