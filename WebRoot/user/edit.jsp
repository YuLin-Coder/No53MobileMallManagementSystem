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
    <table cellpadding="0" cellspacing="0" id="maintable">
        <tr>
            <td class="lefttd">
                <%@ include file="left.jsp" %> 
              </td>
            <td>
                
                <form class="layui-form" id="edit" method="post">
                
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      ${client.login }
    </div>
  </div>
<div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div> 
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input name="sex" value="男" title="男" checked="" type="radio">
      <input name="sex" value="女" title="女" type="radio">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input name="tel"  lay-verify="required|phone" placeholder="请输入" autocomplete="off" class="layui-input" type="text" value="${client.tel }">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">收货地址</label>
    <div class="layui-input-block">
      <input name="address" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text" value="${client.address }">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input name="mail" lay-verify="email" placeholder="请输入" autocomplete="off" class="layui-input" type="text" value="${client.mail }">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">&nbsp;</label>
    <div class="layui-input-block">
      <input class="layui-btn layui-btn-normal" lay-submit  lay-filter="demo1"  type="submit" value="修改"></input>
    </div>
  </div>
  </form>
                
            </td>
            <td class="mainrightborder"></td>
        </tr>
    </table>
    
    <%@ include file="foot.jsp" %> 
    <script type="text/javascript">
//Demo
layui.use(['form', 'layedit', 'laydate','layer'], function(){
     var form = layui.form
     ,layedit = layui.layedit
     ,laydate = layui.laydate
     ,layer=layui.layer;
   
   //监听提交
     form.on('submit(demo1)', function(data){
	       $("#edit").form("submit",{
				url : "${basePath}client/edit.do",
				onSubmit : function() { },
				success : function(result) {
					var result = eval('(' + result + ')');
					$.messager.alert("系统提示", result.mgf); 
				}
			});  
    		 return false;
    	}) 
});

 
</script>
  </body>
</html>
