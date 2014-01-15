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

	<c:if test="${bookingBean.batas == null}">
		<input type="submit" value="Book Something"
			onclick="window.location.href='/fp'" />
	</c:if>
	<input type="submit" value="Logout"
		onclick="window.location.href='/fp/login'" />
	<br>
	<c:choose>
		<c:when test="${bookingBean.batas == null}">
			<h2>Silahkan menuju halaman awal untuk melakukan booking</h2>
		</c:when>
		<c:otherwise>
			<td><h1>Reminder</h1></td>
			<h2>Waktu anda melakukan pembayaran hingga ${bookingBean.batas}</h2>
			<table>
				<tr>
					<td>Dari rekening</td>
					<td>${bookingBean.rekening }</td>
				</tr>
				<tr>
					<td>Atas nama</td>
					<td>${bookingBean.an }</td>
				</tr>
				<tr>
					<td>Ke rekening</td>
					<td>081515941406</td>
				</tr>
				<tr>
					<td>Atas nama</td>
					<td>Wiby Punya</td>
				</tr>
			</table>
			<input type="submit" value="Konfimarsi"
				onclick="window.location.href='/fp/book/batal'" />
			<input type="submit" value="Batal"
				onclick="window.location.href='/fp/book/batal'" />
		</c:otherwise>
	</c:choose>
	<table border="1">
		<tbody>
			<tr>
				<td><b>Kota Asal</b></td>
				<td><b>Kota Tujuan</b></td>
				<td><b>Tanggal</b></td>
				<td><b>Kuota</b></td>
				<td><b>Harga</b></td>
				<td><b>Status</b></td>
			</tr>
			<c:forEach var="trans" items="${transaksis}">
				<tr>
					<td><c:out value="${trans.jadwal.kotaAsal}"></c:out></td>
					<td><c:out value="${trans.jadwal.kotaTujuan}"></c:out></td>
					<td><c:out value="${trans.jadwal.tanggal}"></c:out></td>
					<td><c:out value="${trans.kuota}"></c:out></td>
					<td><c:out value="${trans.jadwal.harga}"></c:out></td>
					<td>Passed</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>