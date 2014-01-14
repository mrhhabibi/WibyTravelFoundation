<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<!-- Codrops top bar -->
		<div class="codrops-top">
			<a href=""> <strong>Wiby Corporation: </strong>Wiby Travel
				Foundation
			</a> <span class="right"> <a
				href="/fp">
					<strong>Halaman Utama</strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<!--/ Codrops top bar -->
		<header>
			<h1>
				Wiby Travel Foundation <span>Registrasi Anggota</span>
			</h1>
			<nav class="codrops-demos">
				<!--<span>Click <strong>"Join us"</strong> to see the form switch</span>-->
			</nav>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form:form method="post" action="registerProcess"
							commandName="anggotaBean">
							<h1>Registrasi</h1>
							<p>
								<form:label path="nama" data-icon="u">Nama Lengkap</form:label>
								<form:input path="nama" placeholder="Muhammad Rizky Habibi" />
							</p>
							<p>
								<form:label path="email">Email</form:label>
								<form:input path="email" placeholder="rizkyhabibi09@gmail.com" />
							</p>
							<p>
								<form:label path="kontak">Kontak</form:label>
								<form:input path="kontak" placeholder="085733030815" />
							</p>
							<p>
								<form:label path="password" data-icon="p">Password</form:label>
								<form:input type="password" path="password"
									placeholder="MuhRizHab9274" />
							</p>
							<p class="login button">
								<input type="submit" value="Register" />
							</p>
							<p class="change_link">
								<a class="to_register">@WibyFoundation</a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>