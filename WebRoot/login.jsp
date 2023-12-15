<%@page import="com.java.service.IntroduceService"%>
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
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
    <%@ include file="top.jsp" %>
    
    <div class="regdiv">
    	<div class="big">
	    	<div class="borderdiv">
	    		
	    		<form id="sqlform" class="layui-form"  method="post">
          
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input name="login" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input name="pwd" id="pwd" lay-verify="pwd"  placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">&nbsp;</label>
    <div class="layui-input-block">
      <input class="layui-btn layui-btn-normal" id="sub" type="submit" lay-filter="loginbtn"  lay-submit value="登陆"></input>
      <input class="layui-btn layui-btn-normal" onclick="location.href='<%=basePath %>client/reg.do'" type="button"   lay-submit value="注册"></input>
    </div>
  </div>
  </form>
	    		
	    	</div>
    	</div>
    </div>
    
    
    
        	<script type="text/javascript">
//Demo
layui.use(['form', 'layedit', 'laydate','layer'], function(){
     var form = layui.form
     ,layedit = layui.layedit
     ,laydate = layui.laydate
     ,layer=layui.layer;
   
   //监听提交
     form.on('submit(loginbtn)', function(data){
	       $("#sqlform").form("submit",{
				url : "${basePath_left}client/login.do",
				onSubmit : function() { },
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.success) {
							layer.alert(result.mgf,{title: '提示信息'}, function () {
								location.href='${basePath}index.do';
					        }); 
						} else {
							layer.alert( result.mgf,{title: '提示信息'});
						}
				}
			});  
    		 return false;
    	}) 
});
 
</script>
    <%@ include file="foot.jsp" %> 
    
  </body>
</html>
