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
	<c:choose>
		<c:when test="${anggotaObj.tipe=='user'}">
			<input type="submit" value="Profil"
				onclick="window.location.href='/fp/user'" />
			<input type="submit" value="Logout"
				onclick="window.location.href='/fp/logout'" />
		</c:when>
		<c:when test="${anggotaObj.tipe=='admin'}">
			<input type="submit" value="Jadwal"
				onclick="window.location.href='/fp/jadwal'" />
			<input type="submit" value="Anggota"
				onclick="window.location.href='/fp/anggota'" />
			<input type="submit" value="Laporan"
				onclick="window.location.href='/fp/laporan'" />
			<input type="submit" value="Logout"
				onclick="window.location.href='/fp/logout'" />
		</c:when>
		<c:otherwise>
			<input type="submit" value="Login/Register"
				onclick="window.location.href='/fp/login'" />
		</c:otherwise>
	</c:choose>
	<c:if test="${anggotaObj.tipe!='admin'}">
		<br>
		<h2>Silahkan Cari Tujuan Anda!</h2>

		<form:form method="post" action="filterjadwal"
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
						<td><form:label path="kuota">Kuota: </form:label></td>
						<td><form:input id="kuotaId" path="kuota" /></td>
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
			<tbody>
				<tr>
					<td><b>Kota Asal</b></td>
					<td><b>Kota Tujuan</b></td>
					<td><b>Tanggal</b></td>
					<td><b>Waktu</b></td>
					<td><b>Sisa Kuota</b></td>
					<td><b>Harga</b></td>
					<c:if test="${anggotaObj.tipe=='user'}">
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
						<c:if test="${anggotaObj.tipe=='user'}">
							<td><input type="submit" value="Book"
								onclick="window.location.href='book/${jadwal.id}'" /></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${anggotaObj.tipe!=user && anggotaObj.tipe!=admin}">
			<h3>Silahkan Login/Register untuk Booking</h3>
		</c:if>
	</c:if>
</body>
</html>