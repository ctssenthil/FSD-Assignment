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
<form:form method="post" modelAttribute="book" action="${pageContext.request.contextPath}/addBook">
<table>
		<tr>
			<th colspan="2">Add Book</th>
		</tr>
		<tr>
		<form:hidden path="bookId" />
          <td><form:label path="title">Book Title:</form:label></td>
          <td><form:input path="title" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
		  <td><form:label path="price">Book Price:</form:label></td>
          <td><form:input path="price" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
            <td><form:label path="volume">Book Volume:</form:label></td>
            <td><form:input path="volume" size="30" maxlength="30"></form:input></td>
        </tr>
      	<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Book List</h3>
<c:if test="${!empty listOfBooks}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Title</th>
		<th width="120">Price</th>
		<th width="120">Volume</th>
		<th width="120">PublishDate</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfBooks}" var="book">
		<tr>
			<td>${book.bookId}</td>
			<td>${book.title}</td>
			<td>${book.price}</td>
			<td>${book.volume}</td>
            <td>${book.publishedDate}</td>
        	<td><a href="<c:url value='/updateBook/${book.bookId}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteBook/${book.bookId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
