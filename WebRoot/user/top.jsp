<%@ page language="java" import="java.util.*,com.java.model.*" pageEncoding="utf-8"%>
<%
	String path_top = request.getContextPath();
	String basePath_top = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path_top + "/";
	request.setAttribute("thingtype", request.getSession().getAttribute("thingtype"));
	request.setAttribute("basePath", basePath_top);
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

	<link href="<%=basePath_top %>user/css/css.css" rel="stylesheet" type="text/css" />
	<div id="top">
        <b>手机商城</b>
        <ul id="topmenu">
            <li><a href="<%=basePath_top %>index.do" >返回首页</a></li>
            <li><a href="javascript:;;" class="exit" >退出系统</a></li>
        </ul>
    </div>

        
        <script>
        $(".exit").click(function(){
            
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

    

 