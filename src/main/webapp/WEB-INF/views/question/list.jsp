<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question List</title>
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

<style>
.cards {
		display: flex;
		flex-wrap: wrap;
		gap: 1rem;
		padding-top: 1.5rem;
}

.card {
		display: flex;
		flex-direction: column;
		width: 100%;
		overflow: hidden;
}
</style>
</head>
<body>
	<div class="container-fluid p-4">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</div>
	<div class="container pt-4">
		<h1>Questions List</h1>

		<div class="cards">
			<c:forEach items="${ques}" varStatus="row" var="q">
				<div class="card">
					<div class="card-body">
						<label style="float: right; margin-left: 20px;">${q.mark}
							Mark</label>
						<p>${row.count}. ${q.qname}</p>
						<c:forEach items="${q.ans}" var="ans">
							<label class="ml-5"> ${ans.ans1}</label>
							<br>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>