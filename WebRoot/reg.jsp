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

          <form id="reg" class="layui-form"  method="post">
            <div class="layui-form-item">
              <label class="layui-form-label">姓名<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">用户名<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="login" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">密码<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="pwd" id="pwd" lay-verify="required|pwd"  placeholder="请输入" autocomplete="off" class="layui-input" type="password">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">确认密码<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="twopwd" id="twopwd" lay-verify="required|twopwd" placeholder="请输入" autocomplete="off" class="layui-input" type="password">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">性别<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="sex" value="男" title="男" checked="" type="radio">
                <input name="sex" value="女" title="女" type="radio">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">联系电话<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="tel" id="tel" lay-verify="required|phone" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">收件地址<span style="color: red">*</span></label>
              <div class="layui-input-block">
                <input name="address" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">邮箱</label>
              <div class="layui-input-block">
                <input name="mail" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">&nbsp;</label>
              <div class="layui-input-block">
                <input class="layui-btn layui-btn-normal" id="sub" type="submit" lay-filter="demo1"  lay-submit value="注册"></input>
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

        //自定义验证规则
        form.verify({
          pwd: [/(.+){6,12}$/, '密码必须6到12位'],
          twopwd: function(value) {
            if ($("#pwd").val() != value)
              return "两次输入的密码不一至";
          },phone: [/^1[3|4|5|6|7|8]\d{9}$/, '手机必须11位，只能是数字,并且是正确的是手机号！']
        });

        //监听提交
        form.on('submit(demo1)', function(data){
          $("#reg").form("submit",{
            url : "${basePath}client/client_add.do",
            onSubmit : function() { },
            success : function(result) {
              var result = eval('(' + result + ')');
              if (result.success) {
                layer.alert(result.mgf,{title: '提示信息'}, function () {
                  location.href='${basePath}login.jsp';
                });

              } else {
                layer.alert(result.mgf,{title: '提示信息'});
                return;
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
