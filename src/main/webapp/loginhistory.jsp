<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login History Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<header style="height: 30px; background-color: #5797af;"> </header>

	<div class="container">
		<div>
			<hr />
			<div class="position-absolute top-1 end-0 me-4">
				<a href="logout">
					<button class="btn btn-warning">Logout</button>
				</a>

			</div>
			<div class="row text-center">
				
					<h3>
						Welcome <strong style="color: #1c6a73;">${userName}</strong>
					</h3>

		
			</div>
		</div>


		<div class="container mt-4">
			
			<hr />

			<table class="table">
				<thead>
					<tr>
						<th>SN</th>
						<th>Username</th>
						<th>Email</th>
						<th>Login Time</th>
						<th>Log Out</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${loginHistory}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${item.userSignup.username}</td>
							<td>${item.userSignup.email}</td>
							<td>${item.login_time}</td>
							<td>${item.logout_time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<hr />
		</div>
	</div>

</body>
</html>