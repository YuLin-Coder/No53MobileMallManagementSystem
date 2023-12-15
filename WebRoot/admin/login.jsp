<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link href="<%=basePath %>admin/css/login.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/layer/layer.js" type="text/javascript"></script>
<script src="<%=basePath %>js/layui/layui.js"  type="text/javascript"></script>
<link rel="stylesheet" href="<%=basePath %>js/layui/css/layui.css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.3.3/jquery.cookie.js"></script>

<title>登录页面</title>
</head>
<body>
	<form class="layui-form" id="sqlform" method="post">
		 <div id="loginborder">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td><input type="text" name="login"  class="val"  lay-verify="required" />
				</td>
            </tr>
            <tr>
                <td> <input type="password" name="pwd"  class="val"  lay-verify="required" />
				</td>
            </tr>
        </table>
         <input id="Button1" type="submit" onclick="return false" lay-submit  lay-filter="demo1" value="登录" class="btn" />
          </div>
         
						
	</form>
	<!-- js -->
	<script type="text/javascript">
//Demo
layui.use(['form', 'layer'], function(){
     var form = layui.form
     ,layer=layui.layer;
   
   //监听提交
     form.on('submit(demo1)', function(data){
	       $("#sqlform").form("submit",{
				url : "${basePath}admin/login.do",
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.success) {
							location.href='${basePath}admin/admin_list.do';
						} else {
							layer.alert(result.mgf,{title: '提示信息'});
						}
				}
			});  
    		 return false;
    	}) 
});

 
</script>
</body>
</html>