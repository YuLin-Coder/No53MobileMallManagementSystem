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
  	<button class="layui-btn layui-btn-normal" onclick="location.href='<%=basePath%>thingtype2/addpage.do'">添加</button>
  		<table id="sqltable">
		                <tr class="title">
			               <td>分类</td>
			                <td>操作</td>
		                </tr>
                		<c:forEach var="list"  items="${list}">
		                <tr class="rows">
			                <td>${list.type}</td>
			                <td>
				                <a href="<%=basePath %>thingtype2/editpage.do?id=${list.id}">更新</a>
				                <a href="javascript:;;" id="${list.id }" class="del">删除</a>
			                </td>
		                </tr>
		                </c:forEach>
	                </table>
  	</td>
            <td class="mainrightborder"></td>
        </tr>
    </table>
    <%@ include file="foot.jsp"%>
  	
      	 <script>
    $(function(){ 
    	$(".del").click(function(){
    		var id = $(this).attr("id");//以逗号作为分隔字符串
		    $.messager.confirm("系统提示", "您确认要删除这条数据吗？", function(r) {
				if (r) {
					$.post("${basePath}thingtype2/del.do", {
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
				}
			});
    	});
    })
    </script>
  </body>
</html>
