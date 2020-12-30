<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Record</title>
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


		<h2>Detail Record</h2>
		<hr>
		<br>
		<div class="row row-md ml-2">
			<div class="col">
				<label>Name: ${result.studentname}</label>
			</div>
			<div class="col">
				<label>Exam: ${result.examtypename}</label>
			</div>
			<div class="col">
				<label>Total Mark: ${result.mark}</label>
			</div>
		</div>
		<hr>
		<br>
		<div class="cards">
			<c:forEach items="${ques}" varStatus="row" var="q">
				<div class="card">
					<div class="card-body">
						<label style="float: right; margin-left: 20px;">${q.mark}
							Mark</label>
						<p>${row.count}. ${q.questionname}</p>
						<c:forEach items="${q.answers}" var="ans">
							<label class="ml-5"> ${ans.ans1}</label>
							<br>
						</c:forEach>

					</div>
					<div class="row row-md">
						<c:forEach items="${q.correctAns}" var="ca">
							<label class="ml-5 text-info col">Correct Answer is:
								${ca.ans1}</label>
							<br>
						</c:forEach>
						<label class="text-warning col" style="float: right;">Choose
							No: ${q.answername}</label>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>