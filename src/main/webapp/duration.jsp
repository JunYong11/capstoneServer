<%@page import="com.db.durationInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   durationInfo duration = durationInfo.getInstance();

	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");

   String dName = request.getParameter("dName");

   
   String returns = duration.connectionDB(dName);

   System.out.println("dName="+dName);
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>