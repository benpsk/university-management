<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
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

		<h2>Student List</h2>
		<br>

		<form action="stdList">
			<div class="form-row">
				<div class="col-2">
					<label class="pt-2" for="search">Search by Grade</label>
				</div>
				<div class="col">
					<select name="gradeid" id="search" class="form-control">
						<option value="0">All Grade</option>
						<c:forEach items="${grade}" var="g">
							<option value="${g.id}">${g.name}</option>
						</c:forEach>
					</select>
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
					<th>Roll NO</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${std}" varStatus="row" var="s">
					<tr>
						<td>${row.count}</td>
						<td>${s.name}</td>
						<td>${s.rollno}</td>
						<td>${s.gradename}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>