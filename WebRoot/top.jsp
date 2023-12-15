<%@ page language="java" import="java.util.*,com.java.model.*" pageEncoding="utf-8"%>
<%
	String path_top = request.getContextPath();
	String basePath_top = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path_top + "/";
	request.setAttribute("thingtype", request.getSession().getAttribute("thingtype"));
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<%=basePath_top %>js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=basePath_top %>js/layer/layer.js" type="text/javascript"></script>
<script src="<%=basePath_top %>js/layui/layui.js"  type="text/javascript"></script>
<link rel="stylesheet" href="<%=basePath_top %>js/layui/css/layui.css" />
<link class="uiTheme" rel="stylesheet" type="text/css" href="<%=basePath_top %>js/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath_top %>js/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="<%=basePath_top %>js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath_top %>js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath_top %>js/jquery-easyui-1.3.3/jquery.cookie.js"></script>
<style>
	.layui-layer{
		top:150px!important;
	}
</style>
	<link href="<%=basePath_top %>css/StyleSheet.css" rel="stylesheet" type="text/css" />
	<div id="top">
		<div class="big vipdiv">
			<%if(session.getAttribute("client")==null){ %>
			<a href="<%=basePath_top %>login.jsp">登陆</a>
			<a href="<%=basePath_top %>reg.jsp">注册</a>
			<%}else{
	   			Client c=(Client)session.getAttribute("client");
			 %>
			 
			 <a id="exit" href="javascript:;;" style="color:red">[退出]</a>
			<a href="<%=basePath_top %>buy/getbuying.do">我的购物车</a>
			 <a href="<%=basePath_top %>buy/my_list.do">欢迎您：<%=c.getLogin() %></a>
			 <%} %>
		</div>
	</div>
    <div class="big mapmenu">
        <img src="<%=basePath_top %>images/logo.png"  />
        <ul>
            <li><a href="<%=basePath_top %>index.do">首页</a></li>
            <c:forEach var="list"  items="${thingtype}">
            <li><a href="<%=basePath_top %>thing/web_list.do?thingtypeId=${list.id}">${list.type }</a></li>
            </c:forEach>
            <c:forEach var="list"  items="${menu}">
            <li><a href="<%=basePath_top %>news/web_list.do?newstypeId=${list.id}">${list.type }</a></li>
            </c:forEach>
            <li><a href="<%=basePath_top %>introduce/call.do?id=2">联系我们</a></li>
            <li>
            	<form action="<%=basePath_top %>thing/web_list.do"  method="post">
            	<div>
            		<input name="name" type="text" class="key" value="${searchTitle}"  />
            		<input type="submit" class="btn" value="" />
            	</div>
            	</form>
            </li>
        </ul>
    </div>

        
        <script>
        $("#exit").click(function(){
            
          //询问框
            layer.confirm('确认要退出吗？', {
				title: '提示信息',
              btn: ['退出','取消'] //按钮
            }, function(){
            	$.post("${basePath}client/exit.do", function(result) {
    				if (result.success) {
    						 layer.alert(result.mgf,{title: '提示信息'},  function () {
    							location.href='${basePath}index.do';
    				        }); 
    				} else {
    					layer.alert(result.mgf,{title: '提示信息'});
    				}
    			}, "json"); 
            }, function(){
              
            });
            return false; // 阻止表单自动提交事件
        });
        </script>

    

 