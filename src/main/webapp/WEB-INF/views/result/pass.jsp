<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter By Result</title>
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

			<h2>Pass Result</h2>
			<br>

			<table class="table">
				<thead>
					<tr>
						<th>No</th>
						<th>Student Name</th>
						<th>Exam Type</th>
						<th>Total Q.</th>
						<th>Correct A.</th>
						<th>Total Mark</th>
						<th>Remark</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pass}" varStatus="row" var="r">
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
	</div>
</body>
</html>