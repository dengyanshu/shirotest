<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <%@ include file="/common/head.jsp"%>
  </head>
  
  <body>
        <h1>欢迎${userinfo.userName}光临!请选择你的操作:</h1>
	    <ul>
	       <li>增加</li>
	       <li>删除</li>
	       <li>修改</li>
	       <li>查询</li>
	    </ul>
	    
	   
	    <a href="${path}/user/add.action?userName=chouchou&userPassword=1234&userCode=chouchoumingzi&role.roleId=1">模拟增加用户操作</a>
       <a href="${path}/logout.action">点我注销</a>
  </body>
</html>
