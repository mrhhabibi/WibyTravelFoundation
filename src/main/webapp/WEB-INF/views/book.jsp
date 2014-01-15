<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Booking</title>
</head>
<body>
	<h2>Tentukan pilihan booking anda</h2>

	<table>
		<tbody>
			<form:form method="post" action="../../book/bookNow" commandName="jadwalBean">
				<tr>
					<td><form:label path="kotaAsal">Kota Asal: </form:label></td>
					<td><form:label path="kotaAsal" />${jadwalBean.kotaAsal}</td>
				</tr>
				<tr>
					<td><form:label path="kotaTujuan">Kota Tujaun: </form:label></td>
					<td><form:label path="kotaTujuan" />${jadwalBean.kotaTujuan}</td>
				</tr>
				<tr>
					<td><form:label path="tanggal">Tanggal: </form:label></td>
					<td><form:label path="tanggal" />${jadwalBean.tanggal}</td>
				</tr>
				<tr>
					<td><form:label path="waktu">Waktu: </form:label></td>
					<td><form:label path="waktu" />${jadwalBean.waktu}</td>
				</tr>
				<tr>
					<td><form:label path="harga">Harga: </form:label></td>
					<td><form:label path="harga" />${totalHarga}</td>
				</tr>
			</form:form>
			<form:form method="post" action="../../book/bookNow" commandName="bookingBean">
				<tr>
					<td><form:label path="kuota">Kuota: </form:label></td>
					<td><form:label path="kuota" />${bookingBean.kuota}</td>
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