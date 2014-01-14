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
	<h1>Wiby Travel Foundation</h1>
	<input type="submit" value="Login/Register"
		onclick="window.location.href='/fp/login'" />
	<br>
	<h2>Silahkan Cari Tujuan Anda!</h2>

	<form:form method="post" action="filterjadwal" commandName="jadwalBean">
		<table>
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
					<td><input type="submit" value="Cari" /> <a href="/fp">Tampilkan
							Semua</a></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<table border="1">
		<thead>Jadwal Travel
		</thead>
		<tbody>
			<tr>
				<td><b>Kota Asal</b></td>
				<td><b>Kota Tujaun</b></td>
				<td><b>Tanggal</b></td>
				<td><b>Waktu</b></td>
				<td><b>Kuota</b></td>
				<td />
			</tr>
			<c:forEach var="jadwal" items="${jadwals}">
				<tr>
					<td><c:out value="${jadwal.kotaAsal}"></c:out></td>
					<td><c:out value="${jadwal.kotaTujuan}"></c:out></td>
					<td><c:out value="${jadwal.tanggal}"></c:out></td>
					<td><c:out value="${jadwal.waktu}"></c:out></td>
					<td><c:out value="${jadwal.kuota}"></c:out></td>
					<td><input type="submit" value="Book"
						onclick="window.location.href='book/${jadwal.id}'" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>