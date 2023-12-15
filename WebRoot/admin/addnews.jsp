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
  		<form class="layui-form" id="sqlform" method="post">
  		<table cellpadding="0" cellspacing="0" id="addtable"> 
	  	            <tr>
	  		            <td class="left">欣赏标题：</td>
	  		            <td class="right"><input type="text" lay-verify="required" name="title" class="layui-input" value="${news.title}" /></td>
	  	            </tr>
	  	            <tr>
	  		            <td class="left">来源：</td>
	  		            <td class="right"><input type="text" lay-verify="required" name="form" class="layui-input" value="${news.form}" /></td>
	  	            </tr>
	  	            <tr>
	  		            <td class="left">欣赏封面：</td>
	  		            <td class="right">
	  		            	<input type="hidden" id="img" name="img" value="${news.img}" />
							<button type="button" class="layui-btn" id="test1">上传图片</button>
							  <div class="layui-upload-list">
							    <img class="layui-upload-img" id="demo1" style="width:100px">
							    <p id="demoText"></p>
							  </div>
						</td>
	  	            </tr>
	  	            <tr>
	  		            <td class="left">分类：</td>
	  		            <td class="right">
							<select name="newstypeId" lay-filter="aihao">
							<c:forEach var="list"  items="${newstype}">
						        <option value="${list.id }">${list.type }</option>
						        </c:forEach>
						      </select>
						</td>
	  	            </tr>
	  	            <tr>
	  		            <td class="left">内容：</td>
	  		            <td class="right"><textarea id="content" name="content" lay-verify="content" style="width:98%; height:300px">${news.content}</textarea></td>
	  	            </tr>
	  	            <tr>
	  		            <td class="left">&nbsp;</td>
	  		            <td class="right"><input class="layui-btn layui-btn-normal" lay-submit  lay-filter="demo1"  type="submit" value="提交"></input></td>
	  	            </tr>
	  	        </table>
	  	  </form>
  	</td>
            <td class="mainrightborder"></td>
        </tr>
    </table>
    <%@ include file="foot.jsp"%>



<script type="text/javascript">
//Demo
layui.use(['form', 'layedit', 'laydate','layer','upload'], function(){
   var form = layui.form
   ,layedit = layui.layedit
   ,laydate = layui.laydate
   ,layer=layui.layer
   ,upload = layui.upload;;
   
   
   layedit.set({
	   uploadImage: {
	   url: '${basePath}upload.do' //接口url
	   ,type: 'post' //默认post
	   }
	   });
   var editIndex = layedit.build('content'); 
   //同步编辑器，否则获取不到更新的内容
   form.verify({
	   content: function(value){
		      layedit.sync(editIndex);
		    }
	})
	
 //监听提交
   form.on('submit(demo1)', function(data){
	       $("#sqlform").form("submit",{
				url : "${basePath}news/news_add.do?id=${news.id}",
				onSubmit : function() { },
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.success) {
							$.messager.alert("系统提示", result.mgf, "info", function () {
								location.href='${basePath}news/news_list.do';
					        }); 
						} else {
							$.messager.alert("系统提示", result.mgf);
						}
				}
			});  
  		 return false;
  	}) 
});
	
</script>
<script>
layui.use('upload', function(){
  var $ = layui.jquery
  , upload = layui.upload;

   //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,accept:'images'
    ,auto:true
    ,size:102400//上传附件大小
    ,url: '../upload.do'
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#demo1').attr('src', result); //图片链接（base64）
      });
    }
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      $("#img").val(res.data.src);
      return layer.msg('上传成功');
    }
    ,error: function(){
      //演示失败状态，并实现重传
      var demoText = $('#demoText');
      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
      demoText.find('.demo-reload').on('click', function(){
        uploadInst.upload();
      });
    }
  });
  
});
    </script>
    
  </body>
</html>
