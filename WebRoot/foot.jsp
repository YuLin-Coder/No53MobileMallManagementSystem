<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path_foot = request.getContextPath();
	String basePath_foot = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path_foot + "/";
%>
<div class="foot">
<div class="big">
        <a style="display: inline-block" href="<%=basePath_foot%>admin/login.jsp">后台管理</a>&nbsp;&nbsp;
		<a style="display: inline-block" href="https://armycodes.com/" target=_blank>Copyright &copy; 从戎源码网 from 2023.</a>
    </div>
</div>
