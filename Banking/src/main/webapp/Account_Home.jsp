<%@page import="DTO.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To Account Home</h1>
<% List<BankAccount> list=(List<BankAccount>)request.getSession().getAttribute("list"); %>
<table border="1">
<tr>
<th>Account_Number</th>
<th>Account_Type</th>
<th>Blance</th>
<th>Account_Limit</th>
<th>Account_Status</th>
<th>Customer_Name</th>
<th>Customer_Id</th>

<%for(BankAccount bankaccount:list) {%>
<tr>

<th><%=bankaccount.getAccountNo() %></th>
<th><%=bankaccount.getAccountType() %></th>
<th><%=bankaccount.getAmount() %></th>
<th><%=bankaccount.getAccountLimit() %></th>
<th><%=bankaccount.isStatus() %></th>

<th><%=bankaccount.getCustomer().getName() %></th>
<th><%=bankaccount.getCustomer().getCustid()%></th>
<th>Change_Status</th>

<%}%>
</tr>
</table>
</body>
</html>