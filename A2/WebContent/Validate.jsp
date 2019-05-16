<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate payment</title>
</head>
<body>
<form action="ValidateServlet" method="post">
		<b>User:</b> <input type="text" name="email"><br>
		<b>Payed?:</b> <input type="text" name="payed"><br>
		<input type="submit" value="Modify">
		<input type="button" value="Go back!" onclick="history.back()">


</form>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>