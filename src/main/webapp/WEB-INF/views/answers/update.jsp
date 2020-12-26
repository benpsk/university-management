<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Answers</title>
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

			<h2>Update Answers</h2>
			<br>

			<form:form action="updateA" method="post"
				modelAttribute="ans">
				<form:hidden path="id" />
				<div class="form-group">
					<label>Question</label>
					<form:select path="questionid" class="form-control">
						<form:option value="${ques.id}">${ques.qname}</form:option>
					</form:select>
				</div>
				<label>Create Multiple Choice for Answers</label>
				<div class="form-row mt-2 mb-3">
					<div class="col">
						<label>Option 1</label>
						<form:input path="ans1" class="form-control" />
						<label>Option 2</label>
						<form:input path="ans2" class="form-control" />
					</div>
					<div class="col">
						<label>Option 3</label>
						<form:input path="ans3" class="form-control" />
						<label>Option 4</label>
						<form:input path="ans4" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label>Choose Correct Answer</label>
					<div class="form-control">
						<form:checkbox path="status1" value="true" />
						<label>Option 1</label>
						<form:checkbox path="status2" value="true" />
						<label>Option 2</label>
						<form:checkbox path="status3" value="true" />
						<label>Option 3</label>
						<form:checkbox path="status4" value="true" />
						<label>Option 4</label>

					</div>
				</div>
				<input type="submit" value="Save" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>