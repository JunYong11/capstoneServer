<%@page import="com.db.healthInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   healthInfo health = healthInfo.getInstance();

	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");

   String part = request.getParameter("part");   
   
   String returns = health.connectionDB(part);

   System.out.println("part="+part);
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>