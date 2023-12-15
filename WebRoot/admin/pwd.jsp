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
  	
<form id="reg" class="layui-form"  method="post">
                
  <div class="layui-form-item">
    <label class="layui-form-label">账户ID</label>
    <div class="layui-input-block">
      ${admin.login}
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">原始密码</label>
    <div class="layui-input-block">
      <input name="old" id="old"  lay-verify="old|twopwd2" placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-block">
      <input name="pwd" id="pwd" lay-verify="pwd"  placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">确认新密码</label>
    <div class="layui-input-block">
      <input name="twopwd" id="twopwd" lay-verify="twopwd" placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">&nbsp;</label>
    <div class="layui-input-block">
      <input class="layui-btn layui-btn-normal" id="sub" type="submit" lay-filter="demo1"  lay-submit value="修改"></input>
    </div>
  </div>
  </form>
  	

  	</td>
            <td class="mainrightborder"></td>
        </tr>
    </table>
    <%@ include file="foot.jsp"%>
  	
<script type="text/javascript">
//Demo
layui.use(['form', 'layedit', 'laydate','layer'], function(){
     var form = layui.form
     ,layedit = layui.layedit
     ,laydate = layui.laydate
     ,layer=layui.layer;
     
   //自定义验证规则
     form.verify({
       old:function(value){
    	   if("${admin.pwd}"!=value)
    		   return "原始密码输入有误";
       }
       ,pwd: [/(.+){6,12}$/, '密码必须6到12位']
       ,twopwd: function(value){
         if($("#pwd").val()!=value)
           return "两次输入的密码不一至";
       },twopwd2: function(value){
         if($("#pwd").val()==value)
           return "不能和原始密码一致";
       }
     });
   
   //监听提交
     form.on('submit(demo1)', function(data){
	       $("#reg").form("submit",{
				url : "${basePath}admin/pwd.do",
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
