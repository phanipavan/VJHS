<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<fieldset>
		<legend>Cumulative Marks Report</legend>
		<div class="fulWidth">
			<div class="fulWidth">
				<label class="leftLabelST">Name of the Student
					&nbsp;&nbsp;&nbsp;</label> <label class="rightLabelST">Praveen
					Kumar Reddy Karanam</label>
			</div>
			<div class="fulWidth">
				<label class="leftLabelST">Class :&nbsp;&nbsp;</label><label
					class="rightLabelST">VIII</label>
			</div>
			<div class="fulWidth">
				<label class="leftLabelST">Admission Number :&nbsp;&nbsp;</label><label
					class="rightLabelST">119X1F0028</label>
			</div>
		</div>
		<div class="fulWidth">
			<table class="studentMarks" border="1">
				<tr>
					<th rowspan="2" class="subName">Subjects</th>
					<th colspan="5" class="fA">Formative Assessment</th>
					<th colspan="3" class="sA">Summative Assessment</th>
					<th colspan="2" class="pAE">Pre-Annual Examination</th>
					<th colspan="2" class="aE">Annual Examination</th>
					<th rowspan="2" class="remarksTab">Remarks</th>
				</tr>
				<tr>
					<th>I</th>
					<th>II</th>
					<th>III</th>
					<th>IV</th>
					<th>TOT Marks</th>
					<th>I</th>
					<th>II</th>
					<th>TOT Marks</th>
					<th>Marks Obtained</th>
					<th>TOT Marks</th>
					<th>Marks Obtained</th>
					<th>TOT Marks</th>
				</tr>
				<c:forEach begin="1" end="6">
					<tr>
						<td class="subjects">Mathematics</td>
						<td>20</td>
						<td>20</td>
						<td>20</td>
						<td>20</td>
						<td>25</td>
						<td>90</td>
						<td>90</td>
						<td>100</td>
						<td>90</td>
						<td>100</td>
						<td>90</td>
						<td>100</td>
						<td>Good</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="subjects">Marks Gained</td>
					<td>120</td>
					<td>120</td>
					<td>120</td>
					<td>120</td>
					<td>150</td>
					<td>540</td>
					<td>540</td>
					<td>600</td>
					<td>540</td>
					<td>600</td>
					<td>540</td>
					<td>600</td>
					<td></td>
				</tr>
				<tr>
					<td class="subjects">Grade Points Average</td>
					<td>A1</td>
					<td>A1</td>
					<td>A1</td>
					<td>A1</td>
					<td>10</td>
					<td>A1</td>
					<td>A1</td>
					<td>10</td>
					<td>A1</td>
					<td>10</td>
					<td>A1</td>
					<td>10</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>&nbsp;</div>
		<table class="cumulativeAveTab">
			<tr>
				<th>Cumulative Grade Points Average (CGPA) :</th>
				<th>10</th>
			</tr>
		</table>
		<div>
			&nbsp;<br>&nbsp;<br>&nbsp;<br>
		</div>
		<div>
			<div>
				&nbsp;<br>&nbsp;<br>
			</div>
			<div class="corresHeader">
				<label>Correspondent</label>
			</div>
			<div class="princeHeader">
				<label>Principal</label>
			</div>
			<div>&nbsp;</div>
		</div>
	</fieldset>
</div>
