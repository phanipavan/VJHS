<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Overview</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="PROFILE" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Manage Profile</div>
				<ul>
					<li><a href="overview.profile">Overview</a></li>
					<li class="activeLeftPane"><a href="classstrength.profile">Classes
							&amp; Strengths</a></li>
					<li><a href="feestructure.profile">Fee Structure</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<fmt:bundle basename="com.vjhs.labels.label">
					<div>
						<fieldset>
							<legend>Classes &amp; Strengths</legend>
							<div>
								<table id="width40" class="exampleClsStr display compact">
									<thead>
										<tr>
											<th><fmt:message key="CLASS"></fmt:message></th>
											<th><fmt:message key="STRENGTH"></fmt:message></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${classStrengthList}" var="classStrength">
											<tr>
												<td><c:out value="${classStrength.className}"></c:out></td>
												<td><c:out value="${classStrength.strength}"></c:out></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</fieldset>
					</div>
					<div class="minHeightDiv"></div>
				</fmt:bundle>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
	<script type="text/javascript">
		$('.exampleClsStr').dataTable({
			paging : false,
			searching : false,
			info : false,
			"bSort" : false
		});
	</script>
</body>
</html>