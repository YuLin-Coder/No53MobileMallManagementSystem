<%@page import="com.java.service.IntroduceService"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
    <%@ include file="top.jsp" %>
    <table cellpadding="0" cellspacing="0" id="maintable">
        <tr>
            <td class="lefttd">
                <%@ include file="left.jsp" %> 
              </td>
            <td>
                

  <table class="layui-table">
    <thead>
      <tr>
      	<th>购买日期</th>
        <th>状态</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody>
    <c:forEach var="list"  items="${list}">
      <tr>
      	<td><fmt:formatDate value="${list.intime }" pattern="MM-dd hh:mm:ss"/></td>
        <td>${list.stateText }</td>
        <td>
        	<c:if test="${list.state==1 }">
        	<a href="javascript:;;" id="${list.id }" class="state">确认收货</a>&nbsp;|&nbsp;
			</c:if>
        	<a href="${basePath }buylist/my_list.do?buyId=${list.id}">明细</a></td>
      </tr>
      </c:forEach>
    </tbody>
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
    <%@ include file="foot.jsp" %> 
    
   <script>
    $(function(){ 
    	$(".state").click(function(){
    		var id = $(this).attr("id");
		    $.messager.confirm("系统提示", "您确认已签收了吗？", function(r) {
				if (r) {
					$.post("${basePath}buy/state.do", {
						id:id,state:2
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
