<%@page import="com.db.searchInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   searchInfo search = searchInfo.getInstance();

	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");

   String keyword = request.getParameter("keyword");

   
   String returns = search.connectionDB(keyword);

   System.out.println("keyword="+keyword);
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>