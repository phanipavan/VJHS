<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS : Forgot Password</title>
</head>
<body>
	<jsp:include page="vjhstopb.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<fmt:bundle basename="com.vjhs.labels.label">
				<form action="forgotPassword.admin" name="fgtPassword"
					id="fgtPassword" method="post">
					<fieldset>
						<div class="fulWidth subHead">Forgot Password</div>
						<div class="fulWidth">
							<label class="lgnLeftLbl">Enter User Name</label> <label
								class="lgnRightLbl"><input type="text" name="userName"
								id="userName" placeholder="User Name" class="loginInput" /></label>
						</div>
						<div class="fulWidth">
							<label class="lgnLeftLbl">Enter Password</label> <label
								class="lgnRightLbl"><input type="password"
								name="password" id="password" placeholder="Password"
								class="loginInput" /></label>
						</div>
						<div class="fulWidth">
							<label class="lgnLeftLbl">Confirm Password</label> <label
								class="lgnRightLbl"><input type="password"
								name="re_password" id="re_password"
								placeholder="Confirm Password" class="loginInput" /></label>
						</div>
						<div class="formButtons">
							<input type="submit" value="Submit" class="btnStyle" />
						</div>
					</fieldset>
				</form>
			</fmt:bundle>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>