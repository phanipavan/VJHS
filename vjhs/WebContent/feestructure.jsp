<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Fee Structure</title>
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
					<li><a href="classstrength.profile">Classes &amp;
							Strengths</a></li>
					<li class="activeLeftPane"><a href="feestructure.profile">Fee
							Structure</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<fmt:bundle basename="com.vjhs.labels.label">
					<div>
						<fieldset>
							<legend>Fee Structure Overview</legend>
							<table class="display compact example">
								<thead>
									<tr>
										<th><fmt:message key="CLASS"></fmt:message></th>
										<th><fmt:message key="ADMISSION_FEE"></fmt:message></th>
										<th><fmt:message key="APPLICATION_FEE"></fmt:message></th>
										<th><fmt:message key="TUTION_FEE"></fmt:message></th>
										<th><fmt:message key="BOOKS_FEE"></fmt:message></th>
										<th><fmt:message key="EXAMINATION_FEE"></fmt:message></th>
										<th><fmt:message key="OTHER_FEE"></fmt:message></th>
										<th><fmt:message key="TOTAL_FEE"></fmt:message></th>
										<th><fmt:message key="UPDATE"></fmt:message></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${feeStruList}" var="feeStructure">
										<c:url value="editFeeStru.profile" var="modifyClass">
											<c:param name="className" value="${feeStructure.className}" />
										</c:url>
										<tr>
											<td><c:out value="${feeStructure.className}"></c:out></td>
											<td><c:out value="${feeStructure.admissionFee}"></c:out></td>
											<td><c:out value="${feeStructure.applicationFee}"></c:out></td>
											<td><c:out value="${feeStructure.tutionFee}"></c:out></td>
											<td><c:out value="${feeStructure.booksFee}"></c:out></td>
											<td><c:out value="${feeStructure.examFee}"></c:out></td>
											<td><c:out value="${feeStructure.otherFee}"></c:out></td>
											<td><c:out value="${feeStructure.totalFee}"></c:out></td>
											<td><a href="<c:out value="${modifyClass}"></c:out>">Modify</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</fieldset>
					</div>
					<div class="minHeightDiv"></div>
				</fmt:bundle>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$('.example').dataTable({
				paging : false,
				searching : false,
				info : false,
				"bSort" : false
			});
		});
	</script>
</body>
</html>