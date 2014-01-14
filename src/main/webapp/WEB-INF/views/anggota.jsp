<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Jadwal</title>
</head>
<body>
	<input type="submit" value="Kembali"
		onclick="window.location.href='/fp'" />
	<table border="1">
		<tbody>
			<tr>
				<td><b>Nama</b></td>
				<td><b>Email</b></td>
				<td><b>Kontak</b></td>
			</tr>
			<c:forEach var="anggota" items="${anggotas}">
				<tr>
					<td><c:out value="${anggota.nama}"></c:out></td>
					<td><c:out value="${anggota.email}"></c:out></td>
					<td><c:out value="${anggota.kontak}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>