<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Profil</title>
</head>
<body>
	<h1>Selamat Datang ${anggotaObj.nama}</h1>
	<input type="submit" value="Book Something"
		onclick="window.location.href='/fp'" />
	<input type="submit" value="Logout"
		onclick="window.location.href='/fp/login'" />
	<br>
	<c:choose>
		<c:when test="${transaksiBean.batas == null}">
			<h2>Silahkan menuju halaman awal untuk melakukan booking</h2>
		</c:when>
		<c:otherwise>
			<h2>Remainder : Waktu anda melakukan pembayaran hingga
				${transaksiBean.batas}</h2>
			<input type="submit" value="Batal"
				onclick="window.location.href='/fp/book/batal'" />
		</c:otherwise>
	</c:choose>
</body>
</html>