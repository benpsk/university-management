<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css">

</head>
<body>

	<div class="container-fluid p-4">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="jumbotron">

			<h2>Update Student</h2>
			<br>

			<form:form action="/UniversitySystem/upStd" modelAttribute="std">
				<form:hidden path="id" />
				<div class="form-group">
					<label>Choose Class</label>
					<form:select path="gradeid" class="form-control">
						<c:forEach items="${grade}" var="g">
							<form:option value="${g.id}">${g.name}</form:option>
						</c:forEach>
					</form:select>
				</div>

				<div class="form-group">
					<label>Enter Student Name </label>
					<form:input path="name" class="form-control" />
				</div>
				<div class="form-group">
					<label>Enter Roll No. </label>
					<form:input path="rollno" class="form-control" />
				</div>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>