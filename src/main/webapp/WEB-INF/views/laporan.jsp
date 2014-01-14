<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Laporan</title>
</head>
<body>
	<input type="submit" value="Kembali"
		onclick="window.location.href='/fp'" />
	<table border="1">
		<tbody>
			<tr>
				<td><b>Nama</b></td>
				<td><b>Kota Asal</b></td>
				<td><b>Kota Tujuan</b></td>
				<td><b>Tanggal</b></td>
				<td><b>Penumpang</b></td>
				<td><b>Total Harga</b></td>
			</tr>
			<c:forEach var="transaksi" items="${transaksis}">
				<tr>
					<td><c:out value="${(transaksi.anggota).nama}"></c:out></td>
					<td><c:out value="${(transaksi.jadwal).kotaAsal}"></c:out></td>
					<td><c:out value="${(transaksi.jadwal).kotaTujuan}"></c:out></td>
					<td><c:out value="${(transaksi.jadwal).tanggal}"></c:out></td>
					<td><c:out value="${transaksi.kuota}"></c:out></td>
					<td><c:out value="${(transaksi.jadwal).harga}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>