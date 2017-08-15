<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js_files/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js_files/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="css_files/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="css_files/style.css" />
<script type="text/javascript">
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
<div class="lgnHead700">
	<h1>Vignana Jyothi High School (E.M.)</h1>
	<c:forEach items="${cookie}" var="currentCookie">
		<c:if
			test="${currentCookie.key == 'userName' && currentCookie.value.value != ''}">
			<%-- <c:url url="sessionAlive.admin" /> --%>
			<jsp:forward page="sessionAlive.admin"></jsp:forward>
		</c:if>
	</c:forEach>
</div>

<%-- <div class="mainBody">
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
					<c:out value="${currentCookie.value.value }"></c:out>
					<c:redirect url="sessionAlive.admin" />
				</c:if>
			</c:forEach>
		</div>
	</div>
</div> --%>
