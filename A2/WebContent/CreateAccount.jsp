<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
  width: 130px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: white;
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  padding: 12px 20px 12px 40px;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
  width: 100%;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="RegisterServlet" method="post">

	<br>
	<br>
	<br>
	<br>
	 <center>
    <b>First name:</b> <input type="text" name="first"/><br>
    <b>Last name:</b> <input type="text" name="last"/><br>
    <b>Email:</b><input type="text" name="username"/><br>
    <b>Password:</b> <input type="password" name="password" /><br>
    <b>Confirm Password:</b>    <input type="password" name="password1" /><br>
    <b>Choose Payment:</b> &nbsp&nbsp<input type="text" name="payment" /> <br> 
    *Payment can be weekly, montly or yearly and cash only
    <br>
   <input type="submit" value="Register"/>
    </center>    
    

</form>

</body>
</html>