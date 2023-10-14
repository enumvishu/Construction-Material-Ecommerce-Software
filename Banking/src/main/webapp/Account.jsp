<%@page import="java.util.List"%>
<%@page import="DTO.BankAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account.jsp</title>
</head>
<body>

<h1>Welcome to Account Page</h1>

<% List<BankAccount> list =(List<BankAccount>) request.getSession().getAttribute("list");%> 

<% if(list.isEmpty())
{%>

<h1>No Active Account found</h1>

<%}else{ %>

<% for(BankAccount bankaccount:list) {%>
<a href="setactiveaccount?acno=<%=bankaccount.getAccountNo() %>"><button><%= bankaccount.getAccountNo()%></button></a>
	
	<%} %>
	<% }%>


















</body>
</html>