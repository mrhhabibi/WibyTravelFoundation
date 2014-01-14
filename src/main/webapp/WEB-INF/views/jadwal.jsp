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
				<td><b>Kota Asal</b></td>
				<td><b>Kota Tujuan</b></td>
				<td><b>Tanggal</b></td>
				<td><b>Waktu</b></td>
				<td><b>Kuota</b></td>
				<td><b>Harga</b></td>
				<c:if test="${anggotaObj!=null}">
					<td />
				</c:if>
			</tr>
			<c:forEach var="jadwal" items="${jadwals}">
				<tr>
					<td><c:out value="${jadwal.kotaAsal}"></c:out></td>
					<td><c:out value="${jadwal.kotaTujuan}"></c:out></td>
					<td><c:out value="${jadwal.tanggal}"></c:out></td>
					<td><c:out value="${jadwal.waktu}"></c:out></td>
					<td><c:out value="${jadwal.kuota}"></c:out></td>
					<td><c:out value="${jadwal.harga}"></c:out></td>
					<td><a href="jadwal/hapus/${jadwal.id}">Hapus</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form method="post" action="jadwal/tambah"
		commandName="jadwalBean">
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
					<td><form:label path="waktu">Waktu: </form:label></td>
					<td><form:input path="waktu" /></td>
				</tr>
				<tr>
					<td><form:label path="kuota">Kuota: </form:label></td>
					<td><form:input path="kuota" /></td>
				</tr>
				<tr>
					<td><form:label path="harga">Harga: </form:label></td>
					<td><form:input path="harga" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="submit" value="Tambah" />
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>