<%@page import="com.db.QueDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   QueDB queDB = QueDB.getInstance();
	String returns;
   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html; charset=UTF-8");

   String name = request.getParameter("NM");
   String result = request.getParameter("RT");
   
   System.out.println("이름=" + name);
   System.out.println("증상=" + result);

   // 데이터 삽입
   returns = queDB.connectionDB(name, result);

   System.out.println("result ="+returns);
   out.println(returns);
 	out.close();
%>