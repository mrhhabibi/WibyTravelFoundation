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
	<h2>Tentukan pilihan booking anda</h2>

	<table>
		<tbody>
			<tr>
				<td>Kota Asal:</td>
				<td>${bookObj.kotaAsal}</td>
			</tr>
			<tr>
				<td>Kota Tujuan:</td>
				<td>${bookObj.kotaTujuan}</td>
			</tr>
			<tr>
				<td>Tanggal:</td>
				<td>${bookObj.tanggal}</td>
			</tr>
			<tr>
				<td>Waktu:</td>
				<td>${bookObj.waktu}</td>
			</tr>
			<tr>
				<td>Kuota:</td>
				<td>${bookObj.kuota}</td>
			</tr>

			<form:form method="post" action="bookNow" commandName="transaksiBean">
				<tr>
					<td><form:label path="via">Pembayaran: </form:label></td>
					<td><form:radiobuttons path="via" items="${viaList}"></form:radiobuttons></td>
				</tr>
				<tr>
					<td><form:label path="rekening">Nomor Rekening: </form:label></td>
					<td><form:input path="rekening" /></td>
				</tr>
				<tr>
					<td><form:label path="an">Atas Nama: </form:label></td>
					<td><form:input path="an" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="submit" value="Book Now!" />
				</tr>
			</form:form>
		</tbody>
	</table>

</body>
</html>