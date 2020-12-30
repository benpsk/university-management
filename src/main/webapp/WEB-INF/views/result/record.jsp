<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Record</title>
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


		<h2>Exam Record</h2>
		<br>
		<form action="record">
			<div class="row">
				<div class="col-4">
					<select name="eid" class="form-control">
						<option value="0">Select Exam</option>
						<c:forEach items="${etype}" var="e">
							<option value="${e.id}">${e.type}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col-4">
					<form:form action="record" modelAttribute="g">
						<form:select path="id" class="form-control">
							<option value="0">Select Grade</option>
							<c:forEach items="${grade}" var="g">
								<option value="${g.id}">${g.name}</option>
							</c:forEach>
						</form:select>
					</form:form>
				</div>
				<div class="col">
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</div>
		</form>
		<hr>
		<br>
		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Roll no</th>
					<th>T. Mark</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result}" varStatus="row" var="r">
					<tr>
						<td>${row.count}</td>
						<td>${r.studentname}</td>
						<td>${r.rollno}</td>
						<td>${r.mark}</td>
						<td><a href="view/${r.studentid}/${r.examtypeid}"
							class="btn btn-sm btn-success">Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>