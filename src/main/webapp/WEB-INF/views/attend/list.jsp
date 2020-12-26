<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Record</title>
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

		<h2>Attendance Record History</h2>
		<hr>
		<br>
		<form action="list">
			<div class="form-row">
				<div class="col-2">
					<label class="pt-2" for="dd">Filter by Date </label>
				</div>
				<div class="col">
					<input type="date" name="dd" id="dd" class="form-control" />
				</div>
				<div class="col">
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</div>
		</form>
		<hr>
		<br>

		<table class="table table-borderless">
			<thead>
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Roll No</th>
					<th>Date</th>
					<th>Attendance</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${attList}" varStatus="row" var="att">
					<tr>
						<td>${row.count}</td>
						<td>${att.studentname}</td>
						<td>${att.rollno}</td>
						<td>${att.date}</td>
						<td>${att.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>