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
		<form action="show">
			<div class="form-row">
				<div class="col-2">
					<label class="pt-2" for="grade">Select Grade : </label>
				</div>
				<div class="col">
					<select name="gid" class="form-control" id="grade">
						<option value="0">Select Grade</option>
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
		<h2>Attendance Record</h2>
		<hr>
		<br>
		<form:form action="save" method="post" modelAttribute="attList">
			<div class="form-row">
				<div class="col-2">
					<label for="date" class="pt-2">Select Date :</label>
				</div>
				<div class="col">
					<form:input type="date" path="date" class="form-control" id="date" />
				</div>
				<div class="col">
				<label class="pt-2 text-danger">*Please select date!</label>
				</div>
			</div><br>
			<table class="table table-borderless">
				<thead>
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Roll No</th>
						<th>Attendance Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${std}" varStatus="row" var="s">
						<tr>
							<td>${row.count}<form:hidden
									path="attList[${row.index}].studentid" value="${s.id}" /></td>
							<td>${s.name}</td>
							<td>${s.rollno}</td>
							<td><form:select path="attList[${row.index}].status"
									class="form-control">
									<option value="true">Present</option>
									<option value="false">Absent</option>
								</form:select></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary">Save Record</button>
		</form:form>
	</div>

</body>
</html>