<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS : Create Account</title>
</head>
<body>
	<jsp:include page="vjhstopb.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<fmt:bundle basename="com.vjhs.labels.label">
				<fieldset>
					<div class="fulWidth subHead">Create New Account</div>
					<form method="POST" action="addAdminLogin.admin"
						name="createAdminUser" id="createAdminUser">
						<div class="fulWidth">
							<label class="lgnLeftLbl">Enter Name</label> <label
								class="lgnRightLbl"><input type="text" name="name"
								id="name" placeholder="Name" class="loginInput" /></label>
						</div>
						<div class="fulWidth">
							<label class="lgnLeftLbl">Enter email id</label> <label
								class="lgnRightLbl"><input type="email" name="email"
								id="email" placeholder="User Email address" class="loginInput" /></label>
						</div>
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
						<div class="fulWidth">
							<label class="lgnLeftLbl">Select Branch</label> <label
								class="lgnRightLbl"><select name="branch"
								class="loginSelect" id="branch">
									<option value="Nadakuduru">Nadakuduru</option>
									<option value="Karapa">Karapa</option>
									<option value="Penuguduru">Penuguduru</option>
							</select></label>
						</div>
						<div class="fulWidth">
							<label class="lgnLeftLbl">Select Role</label> <label
								class="lgnRightLbl"><select name="role" id="role"
								class="loginSelect">
									<option value="admin">Administrator</option>
									<option value="teacher">Teacher</option>
									<option value="guest">Guest</option>
							</select></label>
						</div>
						<div class="formButtons">
							<input type="submit" value="Create" class="btnStyle" />&nbsp;&nbsp;
							<input type="reset" value="Reset" class="btnStyle" />
						</div>
					</form>
				</fieldset>
			</fmt:bundle>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>