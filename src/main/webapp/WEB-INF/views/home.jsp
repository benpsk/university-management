<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
	<div class="container-fluid pt-4">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container pt-4">

		<h3>University Management System</h3>
		<br> <a class="btn btn-success ml-3 mb-3"
			href="/UniversitySystem/result/take">Take Exam</a> <a
			class="btn btn-success ml-3 mb-3" href="/UniversitySystem/att/show">Attendance</a>
		<br>
		<table class="table table-borderless">
			<tr>
				<td>All Student Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Student<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/stdList">Student
									List </a> <a class="dropdown-item" href="/UniversitySystem/stdForm">Add
									New Student</a> <a class="dropdown-item"
									href="/UniversitySystem/manageStd">Manage Student</a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Grade Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Grade<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/gradeForm">Add
									New Grade </a> <a class="dropdown-item"
									href="/UniversitySystem/manageGrade">Manage Grade</a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Teacher Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Teacher<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/teachList">Teacher
									List </a> <a class="dropdown-item"
									href="/UniversitySystem/teachForm">Add New Teacher</a> <a
									class="dropdown-item" href="/UniversitySystem/manageTeach">Manage
									Teacher </a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Department Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Department<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/deptForm">Add
									New Department </a> <a class="dropdown-item"
									href="/UniversitySystem/manageDept">Manage Department</a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Exam Type Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Exam Type<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/etype/examList">Exam
									List </a> <a class="dropdown-item"
									href="/UniversitySystem/etype/etypeForm">Add New ExamType </a>
								<a class="dropdown-item" href="/UniversitySystem/etype/manage">
									Manage Exam Type </a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Exam Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Exam<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/exam/examForm">Add
									New Exam</a> <a class="dropdown-item"
									href="/UniversitySystem/exam/manage">Manage Exam </a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Q&amp;A Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Q&amp;A<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/q/list">Q&amp;A
									List </a> <a class="dropdown-item" href="/UniversitySystem/q/save">Add
									New Question</a> <a class="dropdown-item"
									href="/UniversitySystem/q/manage">Manage Q&amp;A</a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Exam History Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Take Exam<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/result/take">Take
									Exam</a> <a class="dropdown-item"
									href="/UniversitySystem/result/history">Exam History</a>
							</div></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Attendance Information</td>
				<td>
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Attendance<span class="sr-only">(current)</span>
						</a>
							<div class="dropdown-menu btn btn-outline-success"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/UniversitySystem/att/show">Record
									Attendance </a> <a class="dropdown-item"
									href="/UniversitySystem/att/list">Attendance History</a>
							</div></li>
					</ul>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>