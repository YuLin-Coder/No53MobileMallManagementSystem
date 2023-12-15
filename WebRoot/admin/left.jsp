<%@ page language="java" import="java.util.*,com.java.model.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menumain">
     <div><b>订单管理</b></div>
     <ul>
        <li><a href="${basePath }buy/admin_list.do?state=0">待发货</a></li>
        <li><a href="${basePath }buy/admin_list.do?state=1">待签收</a></li>
        <li><a href="${basePath }buy/admin_list.do?state=2">订单记录</a></li>
    </ul>
</div>

<div class="menumain">
     <div><b>商品管理</b></div>
     <ul>
        <li><a href="${basePath }thing/addpage.do">添加商品</a></li>
        <li><a href="${basePath }thing/admin_list.do">商品管理</a></li>
    </ul>
</div>

<div class="menumain">
     <div><b>商品类型管理</b></div>
     <ul>
        <li><a href="${basePath }thingtype/admin_list.do">分类管理</a></li>
        <li><a href="${basePath }thingtype2/admin_list.do">品牌管理</a></li>
    </ul>
</div>

<div class="menumain">
     <div><b>资讯管理</b></div>
     <ul>
		<li><a href="${basePath }news/add.do">发布资讯</a></li>
        <li><a href="${basePath }news/news_list.do">资讯管理</a></li>
      </ul>
</div>

<div class="menumain">
     <div><b>系统中心</b></div>
     <ul>
     	<li><a href="${basePath }introduce/introduce_list.do">网站信息</a></li>
         <li><a href="${basePath }admin/admin_list.do">用户管理</a></li>
         <li><a href="${basePath }admin/pwdpage.do">修改密码</a></li>
         <li><a href="${basePath }index.do" >返回前台</a></li>
    </ul>
</div>

<script>
    $(function (){
        var url = window.location.href;
        $("a").each(function (i,e){
            if( $(e).attr('href')==url){
                $(e).css("color","red");
            }
        })


    })
</script>