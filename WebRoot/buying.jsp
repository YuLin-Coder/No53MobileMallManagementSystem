<%@page import="com.java.service.IntroduceService"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <div class="big">
    <div class="map"><b>购物车</b></div>

      <table class="layui-table">
        <thead>
        <tr>
          <th>选择</th>
          <th>图片</th>
          <th>名称</th>
          <th>库存数量</th>
          <th>价格</th>
          <th>数量</th>
          <th>总额</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list"  items="${buying}">
          <tr>
            <td><input type="checkbox" onclick="chickCheckBox()" id="${list.thing.id }Checked" checked/></td>
            <td><img src="${basePath }${list.thing.img}" style="width:100px; border:#CCCCCC; padding:3px" /></td>
            <td>${list.thing.name}</td>
            <td>${list.thing.num}</td>
            <td>${list.thing.price }元</td>
            <td><button onclick="addNum('${list.thing.id }','${list.thing.price }','${list.thing.num}')">+</button><span id="${list.thing.id }">1</span><button onclick="cutNum('${list.thing.id }','${list.thing.price }')") >-</button></td>
            <td><span class="allMoney" id="${list.thing.id }All">${list.thing.price }</span>元</td>
            <td><a href="javascript:;;" id="${list.thing.id }" class="del">删除</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>


      <div style="width:100%; text-align:right; font-size:16px"><button type="button" id="buy"  class="layui-btn layui-btn-primary">共计人民币<b id="allMoneyTal" style="color:red">${sum }</b>元,确认订单</button></div>

    
            </div>
            
    <%@ include file="foot.jsp" %> 
    
    <script>
      function chickCheckBox(){
        si();
      }
      function addNum(id,price,numMax){
        if(Number($("#"+id).text())<Number(numMax)){
          $("#"+id).text(Number($("#"+id).text())+1)
          $("#"+id+'All').text(Number(price)*Number($("#"+id).text()));
          si();
        }
      }

      function si(){
        var all=0;
        $(".allMoney").each((i,e)=>{

          console.log($(e));
          console.log($(e).attr('id'));
          let idAll=$(e).attr('id');
          let id=idAll.substring(0,idAll.length-3)
          console.log(id)
          if($("#"+id+'Checked').prop("checked")){
            all+=Number( $(e).text());
          }
        })
        $("#allMoneyTal").text(all);
      }


      function cutNum(id,price){

        if(Number($("#"+id).text())>1){
          $("#"+id).text(Number($("#"+id).text())-1)
          $("#"+id+'All').text(Number(price)*Number($("#"+id).text()));
          si();
        }

      }


    $(function(){ 
    	
    	$(".del").click(function(){
    		var id = $(this).attr("id");
		    $.messager.confirm("系统提示", "您确认要取消吗？", function(r) {
				if (r) {
					$.post("${basePath}buy/delbuying.do", {
						tid:id
					}, function(result) {
						if (result.success) {
								 $.messager.alert("系统提示", result.mgf, "info", function () {
									window.location.reload();
						        }); 
						} else {
							$.messager.alert("系统提示", result.mgf);
						}
					}, "json");
				}
			});
    	});
    	

    	
    	
    	$("#buy").click(function(){

    		layer.confirm("确认商品生成订单？",{ title: '提示信息',btn:["确定","再想想"],yes:function(index){
    			layer.close(index);
                let allStr='';
                var all=0;
                $(".allMoney").each((i,e)=>{
                  let idAll=$(e).attr('id');
                  let id=idAll.substring(0,idAll.length-3)
                  console.log(id)
                  if($("#"+id+'Checked').prop("checked")){
                    allStr+=id+"_"+$("#"+id).text()+",";
                    all+=Number( $(e).text());
                  }
                })
                if(all==0){
                  return layer.msg('购物车总额不能为0!');
                }

    			layer.open({
    			      type: 1,
    			      btn:["确认支付","取消"],
    			      title: '请付款'+all+'元',
    			      shade: false,
    			      content: '<img style="width: 200px;" src="${basePath}images/er.jpg" />',
    			      yes:function(index){
    			    	  layer.close(index);
    			    	  $.post("${basePath}buy/add.do",{allStr:allStr}, function(result) {
    							if (result.success) {
    									 $.messager.alert("系统提示", result.mgf, "info", function () {
    										location.href="${basePath}buy/my_list.do";
    							        }); 
    							} else {
    								$.messager.alert("系统提示", result.mgf);
    							}
    						}, "json");
    			      }
    			 });
    		}})
    		
    	})
    	
    })
    </script>

  </body>
</html>
