<%@ page language="java" import="java.util.*,com.java.model.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menumain">
     <div><b>订单管理</b></div>
     <ul>
        <li><a href="${basePath }buy/my_list.do">我的订单</a></li>
<%--        <li><a href="${basePath }pinglun/my_list.do">我的点评</a></li>--%>
    </ul>
</div>

<div class="menumain">
     <div><b>个人中心</b></div>
     <ul>
       <li> <a href="${basePath }client/editform.do">修改资料</a></li>
        <li><a href="${basePath }client/pwd.do">修改密码</a></li>
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

  