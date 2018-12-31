<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<form:form method="post" modelAttribute="subject" action="${pageContext.request.contextPath}/addSubject">
<table>
		<tr>
			<th colspan="2">Add Subject</th>
		</tr>
		<tr>
		<form:hidden path="subjectId" />
          <td><form:label path="subTitle">Subject Title:</form:label></td>
          <td><form:input path="subTitle" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
		  <td><form:label path="durationInHours">Subject Durations:</form:label></td>
          <td><form:input path="durationInHours" size="30" maxlength="30"></form:input></td>
		</tr>
		 <tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Subject List</h3>
<c:if test="${!empty listOfSubjects}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="80">Durations</th>
		<th width="120">Durations</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfSubjects}" var="subject">
		<tr>
			<td>${subject.subjectId}</td>
			<td>${subject.subTitle}</td>
			<td>${subject.durationInHours}</td>
			<td><a href="<c:url value='/updateSubject/${subject.subjectId}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteSubject/${subject.subjectId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
