<%@page import="com.db.QueDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   QueDB queDB = QueDB.getInstance();

   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html; charset=UTF-8");

   String name = request.getParameter("NM");
   String result = request.getParameter("RT");

   // 데이터 삽입
   String returns = queDB.connectionDB(name, result);

   System.out.println("이름=" + name);
   System.out.println("증상=" + result);
   
   out.println(returns);
%>