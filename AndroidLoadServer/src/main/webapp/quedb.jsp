<%@page import="com.db.QueDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   QueDB queDB = QueDB.getInstance();

	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");

   String name = request.getParameter("NM");
   String result = request.getParameter("RT");
   
   
   String returns = queDB.connectionDB(name, result);

   System.out.println("이름="+name+"증상="+result);
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>