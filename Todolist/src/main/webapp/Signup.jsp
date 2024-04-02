<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#content{
	text-align: center;
	margin-top:190px;
	padding:25px;
	background-color:rgb(145,235,235);
}
</style>
</head>
<body>
<fieldset id="content">
<form action="Gotosignup" method="post" enctype="multipart/form-data">
id:<input type="text" name="id"><br><br>
name:<input type="text" name="name"><br><br>
email:<input type="email" name="email"><br><br>
contact:<input type="text" name="contact"><br><br>
password:<input type ="text" name="password"><br><br>
Image:<input type="file" name="image"><br><br>
<input type="submit">
</form>
</fieldset>
</body>
</html>