<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Wiby Travel Foundation</title>
</head>
<body>
	<h1>Selamat Datang ${anggotaObj.nama}</h1>
	<input type="submit" value="Book Something"
		onclick="window.location.href='/fp'" />
	<input type="submit" value="Logout"
		onclick="window.location.href='/fp/login'" />
	<br>
	<h2>Reminder : </h2>
	
</body>
</html>