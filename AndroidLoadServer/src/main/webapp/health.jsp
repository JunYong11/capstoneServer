<%@page import="com.db.healthInfo"%>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   healthInfo health = healthInfo.getInstance();
	String returns[] = new String[8];
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
	
   String part = request.getParameter("dName");
   
   returns = health.connectionDB(part);
	
	
   System.out.println("part="+part);

   
	try{
	for(int j=0;j<8;j++){
	 System.out.println(returns[j]);   
	 out.println(returns[j]);   
	}
	
	out.flush();
	out.close();	
	}catch(IOException e){
		System.out.println("healthInfo 전송완료");
	}
	
	
	
%>