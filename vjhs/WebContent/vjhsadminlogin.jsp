<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS : Login</title>
</head>
<body>
	<jsp:include page="vjhstopb.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<fmt:bundle basename="com.vjhs.labels.label">
				<div class="lgnLeftBin">
					<div class="fulWidth">${succMessage}</div>
				</div>
				<div class="lgnRightBin">
					<form action="checkAdminUser.admin" method="POST" name="adminUser"
						id="adminUser">
						<div class="fulWidth">${ errorMessage }</div>
						<div class="fulWidth">
							<input type="text" name="userName" id="userName"
								placeholder="User Name" class="loginInput" />
						</div>
						<div class="fulWidth">
							<input type="password" name="password" id="password"
								placeholder="Password" class="loginInput" />
						</div>
						<div class="fulWidth">
							<input type="submit" value="Login" class="btnStyle" />
						</div>
					</form>
					<div class="fulWidth">
						<a href="showAddAdminLogin.admin" class="loginAnchr">Create
							New Account</a>
					</div>
					<div class="fulWidth">
						<a href="showUpdateAdminPass.admin" class="loginAnchr">Forgot
							Password</a>
					</div>
				</div>
			</fmt:bundle>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>