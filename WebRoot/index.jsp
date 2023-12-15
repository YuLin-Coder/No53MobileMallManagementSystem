<%@page import="com.java.service.IntroduceService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="css/css.css" rel="stylesheet" type="text/css" />
    <title>手机购物网站</title>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
    <div id="marq" class="big">
       <img src="<%=basePath_top %>images/banner2.jpg" style="width:100%" />
    </div>
    
    <div class="big">
    	<div class="mainmap">
    		<b>欢迎光临</b>
    		<em>WELCOME TO OUR SHOP</em>
    		<p>欢迎大家的到来，本店经营的理念是：以诚信为本，顾客至上，全力为您打造出货真价实的手机世界，让您享受便捷的一站式购机服务。 </p>
    		<p>在经营品牌上，我们更是与多家着名数码手机企业成为战略共赢商业伙伴，与华为，oppo,vivo,苹果，三星，波导，联想等知名厂商形成了稳固供销关系，
    为产品来源提高优质保障，同时为消费者提供快捷的维修保养和受理回访服务，想顾客之所想，急顾客之所急，至真至诚。本店经营范围主要包括手机销售等电子产品，手机维修，
    手机保养，手机装饰，手机缴费办卡等五大项业务。价格不贵一分，服务更胜一筹，一切以诚信为本，用心为您打造货真价实的手机世界。 </p>
			<p>此网站购买电子产品只限于乌鲁木齐市同城配送，当天下单，当天拿货。如有需要，可在主页选择手机导购或者联系我们随时为您解决</p>

    	</div>
    </div>
    
     <div class="big">
    	<div class="mainmap">
    		<b>科技与手机</b>
    		<em>Disease and nutrition</em>
    		<div class="marq">
    			<ul>
    				<li><img src="<%=basePath_top %>images/3.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/1.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/2.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/5.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/4.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/6.jpg" /></li>
    				<li><img src="<%=basePath_top %>images/7.jpg" /></li>
    			</ul>
    		</div>
    		<script>
			 function scroll(){
			 $(".marq ul").animate({"margin-left":"-340px"},function(){
			   $(".marq ul li:eq(0)").appendTo($(".marq ul"))
			   $(".marq ul").css({"margin-left":0})
			 })
			 }
			  setInterval(scroll,3000)
			</script>
    	</div>
    </div>
    
     <div class="big">
    	<div class="mainmap">
    		<b>产品推荐</b>
    		<em>Product recommendations</em>
    		<div class="big">
    			<ul class="imglistul">
                	<c:forEach var="list"  items="${thing}">
                    <li><img src="<%=basePath_top %>${list.img}" /><a href="<%=basePath_top %>thing/show.do?id=${list.id}">${list.name}</a></li>
                    </c:forEach>
                </ul> 
    		</div>
    	</div>
    </div>
    
    
    <%@ include file="foot.jsp" %> 
  </body>
</html>
