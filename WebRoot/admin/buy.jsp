<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
int state=Integer.parseInt(request.getParameter("state"));
String statetext=state==0?"发货":"签收";
request.setAttribute("state", state+1);
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
  		
<table class="layui-table">
    <thead>
      <tr>
        <th>客户</th>
        <th>状态</th>
        <th>下单日期</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody>
    <c:forEach var="list"  items="${list}">
      <tr>
        <td>${list.client.name}<span style="color:green" title="联系人：${list.client.name}&#10;联系电话：${list.client.tel}&#10;邮箱：${list.client.mail}">[祥细]</span></td>
        <td>${list.stateText }</td>
        <td><fmt:formatDate value="${list.intime }" pattern="MM-dd"/></td>
        
        	<td>
        	<a href="${basePath }buylist/admin_list.do?buyId=${list.id}">明细</a>
        	<c:if test="${list.state==0 }">&nbsp;|&nbsp;
        	<a href="javascript:;;" id="${list.id }" class="state">发货</a>
			</c:if>
			</td>
        
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
    <%@ include file="foot.jsp"%>
  	
    <script>
    $(function(){ 
    	$(".state").click(function(){
    		var id = $(this).attr("id");
		    $.messager.confirm("系统提示", "您确认已发货了吗？", function(r) {
				if (r) {
					$.post("${basePath}buy/state.do", {
						id:id,state:1
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
