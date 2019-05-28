<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate Return Book</title>
</head>
<body>
<form action="addBookServlet" method="post">
		<b>id:</b> <input type="text" name="id"><br>
		<b>title:</b> <input type="text" name="title"><br>
		<b>author:</b> <input type="text" name="author"><br>
		<b>genre:</b> <input type="text" name="genre"><br>
		<b>release date:</b> <input type="text" name="date"><br>
		<b>description</b> <input type="text" name="description"><br>
		<b>stock</b><input type = "text" name ="stock"><br>
		<input type="submit" value="Validate">
		<input type="button" value="Go back!" onclick="history.back()">


</form>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>