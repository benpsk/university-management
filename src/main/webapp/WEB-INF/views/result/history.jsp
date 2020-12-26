<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Record History</title>
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


		<h2>Exam Record History</h2>
		<br>

		<div class="dropdown form-inline pb-4"
			style="float: right; margin-left: 20px;">
			<button class="btn btn-outline-success dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Filter by Result</button>
			<div class="dropdown-menu btn btn-outline-success"
				aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="pass">Pass</a> <a
					class="dropdown-item" href="fail">Fail</a>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>S. Name</th>
					<th>E. Type</th>
					<th>Total Q.</th>
					<th>Correct A.</th>
					<th>T. Mark</th>
					<th>Remark</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result}" varStatus="row" var="r">
					<tr>
						<td>${row.count}</td>
						<td>${r.studentname}</td>
						<td>${r.examtypename}</td>
						<td>${r.qno}</td>
						<td>${r.correctno}</td>
						<td>${r.mark}</td>
						<td>${r.remark}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>