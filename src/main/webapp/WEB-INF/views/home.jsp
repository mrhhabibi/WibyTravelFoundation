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
	<input type="submit" value="Login/Register"
		onclick="window.location.href='/fp/login'" />
	<br>
	<table border="1">
		<thead>
			Jadwal Travel
		</thead>
		<tbody>
			<tr>
				<td><b>Kota Asal</b></td>
				<td><b>Kota Tujaun</b></td>
				<td><b>Tanggal Keberangkatan</b></td>
				<td><b>Kuota</b></td>
			</tr>
			<c:forEach var="jadwal" items="${jadwals}">
				<tr>
					<td><c:out value="${jadwal.kotaAsal}"></c:out></td>
					<td><c:out value="${jadwal.kotaTujuan}"></c:out></td>
					<td><c:out value="${jadwal.tanggal}"></c:out></td>
					<td><c:out value="${jadwal.kuota}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form method="post" action="tambahjadwal" commandName="jadwalBean">
		<table>
			<thead>
				Tambahkan Jadwal
			</thead>
			<tbody>
				<tr>
					<td><form:label path="kotaAsal">Kota Asal: </form:label></td>
					<td><form:select path="kotaAsal" items="${kotaList}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="kotaTujuan">Kota Tujuan: </form:label></td>
					<td><form:select path="kotaTujuan" items="${kotaList}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="tanggal">Tanggal: </form:label></td>
					<td><form:input path="tanggal" /></td>
				</tr>
				<tr>
					<td><form:label path="kuota">Kuota: </form:label></td>
					<td><form:input path="kuota" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="submit" value="Submit" />
				</tr>
			</tbody>
		</table>
	</form:form>
	<table border="1">
		<thead>
			Daftar Anggota
		</thead>
		<tbody>
			<tr>
				<td><b>Nama Lengkap</b></td>
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