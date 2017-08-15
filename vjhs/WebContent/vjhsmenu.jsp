<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainMenuStyle">
	<div class="menuStyle">
		<a href="overview.profile"><span
			class="profileStyle mainMenuSubStyle <c:if test="${page == 'PROFILE'}">activeProfile</c:if>">Profile</span></a> <a
			href="add.student"><span
			class="mainMenuSubStyle studentProfile 
				<c:if test="${page == 'STUDENT'}">activeProfile</c:if>
				 ">Students</span></a>
		<a href="add.teacher"><span
			class="mainMenuSubStyle teacherProfile
			<c:if test="${page == 'TEACHER'}">activeProfile</c:if>
			">Teachers</span></a> <a
			href="academic_calander.schedule"><span
			class="mainMenuSubStyle scheduleProfile
			<c:if test="${page == 'SCHEDULE'}">activeProfile</c:if>
			">Schedule</span></a> <a
			href="attendance.examinations"><span
			class="mainMenuSubStyle examsProfile
			<c:if test="${page == 'EXAM'}">activeProfile</c:if>
			">Exams</span></a> <a href="http://instant.quickcst.com"><span
			class="mainMenuSubStyle smsProfile
			<c:if test="${page == 'SMS'}">activeProfile</c:if>
			">SMS</span></a> <%-- <a href="#"><span
			class="mainMenuSubStyle libraryProfile
			<c:if test="${page == 'LIBRIRY'}">activeProfile</c:if>
			">Library</span></a> <a href="#"><span
			class="mainMenuSubStyle vehiclesProfile
			<c:if test="${page == 'VEHICLE'}">activeProfile</c:if>
			">Vehicles</span></a> <a href="#"><span
			class="mainMenuSubStyle accountsProfile
			<c:if test="${page == 'ACCOUNT'}">activeProfile</c:if>
			">Accounts</span></a> --%>
	</div>
</div>