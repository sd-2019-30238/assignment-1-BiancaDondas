<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">

    <b>Username:</b>   &nbsp <input type="text" name="username"/><br>
    <b>Password1:</b>   <input type="text" name="password" /><br>
    <b>Password2:</b>    <input type="text" name="password1" /><br>
    <b>Payment plan:</b>    <input type="text" name="payment_plan" /> (Choose from: "monthly" or "yearly")<br> 
    <input type="submit" value="Register"/>

</form>

</body>
</html>