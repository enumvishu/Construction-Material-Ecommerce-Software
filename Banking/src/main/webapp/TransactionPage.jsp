<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    text-align: center;
  }
  h1 {
    color: #333;
  }
  a {
    text-decoration: none;
  }
  .button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
    margin: 10px;
    border-radius: 5px;
  }
  .button:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<h1>Welcome to Transaction Page</h1>

<a href="Deposite.html" class="button">Deposit</a>
<a href="Withdraw.html" class="button">Withdraw</a>
<button class="button">Check Balance</button>
<button class="button">View Transaction History</button>

</body>
</html>
