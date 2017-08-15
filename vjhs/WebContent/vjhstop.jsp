<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js_files/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js_files/jquery-ui.js"></script>
<script type="text/javascript" src="js_files/jquery.validate.min.js"></script>
<script type="text/javascript" src="js_files/teacher_registration.js"></script>
<script type="text/javascript" src="js_files/register.js"></script>
<script type="text/javascript" src="js_files/vjhs_util.js"></script>
<link rel="stylesheet" type="text/css" href="css_files/jquery-ui.css" />
<script type="text/javascript" src="js_files/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="css_files/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="css_files/style.css" />
<!-- <link rel="stylesheet" type="text/css" href="css_files/vjhs_util.css" /> -->
<script type="text/javascript">
	$(function() {
		var t;
		window.onload = resetTimer;
		window.onmousemove = resetTimer;
		window.onmousedown = resetTimer; // catches touchscreen presses
		window.onclick = resetTimer; // catches touchpad clicks
		window.onscroll = resetTimer; // catches scrolling with arrow keys
		window.onkeypress = resetTimer;

		function logout() {
			window.location.href = 'logout.admin';
		}

		function resetTimer() {
			clearTimeout(t);
			t = setTimeout(logout, 600000); // time is in milliseconds
		}
	});

	$(document).ready(function() {
		$(".err").slideToggle("slow");
		setTimeout(function() {
			$(".err").slideToggle("slow");
		}, 3000);
	});
</script>
<c:if test="${msgCode!=null && msgCode=='success'}">
	<div class="err ale-succ noHide">
		<c:out value="${message}" />
	</div>
</c:if>

<c:if test="${msgCode!=null && msgCode=='error'}">
	<div class="err ale-err noHide">
		<c:out value="${message}" />
	</div>
</c:if>

<div class="mainBody">
	<div class="head700">
		<div class="mainHead">
			<h1>Vignana Jyothi High School (E.M.)</h1>
		</div>
		<div class="logInfo">
			<c:forEach items="${cookie}" var="currentCookie">
				<c:if
					test="${currentCookie.key == 'userName' && currentCookie.value.value != ''}"> 
				Welcome Back,&nbsp;<c:out value="${currentCookie.value.value }"></c:out> &nbsp;<a
						href="logout.admin" class="btnStyle">Logout</a>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>