<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate Return Book</title>
</head>
<body>
<form action="ValidateReturn" method="post">
		<b>User:</b> <input type="text" name="email"><br>
		<b>Book:</b> <input type="text" name="title"><br>
		<input type="submit" value="Validate">
		<input type="button" value="Go back!" onclick="history.back()">


</form>
<script>
function goBack() {
  window.history.back();
}
</body>
</html>