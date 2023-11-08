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
 <link rel="stylesheet"
 	 href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	
	.thTitle {
		font-size: 25px;
		font-family: sans-serif;
		font-weight: bolder;
		text-decoration: none;
		color: #5797af !important;
	}

</style>

</head>
<body>

	<header style="height: 30px; background-color: #5797af;"> </header>

	<div class="container">
		<div>
			<hr />
			<div class="position-absolute top-1 end-0 me-4">
				<a href="${pageContext.request.contextPath}/logout">
					<button class="btn btn-warning">Logout</button>
				</a>

			</div>
			<div class="row text-center">
			
			 	<a style="text-decoration:none; font-size:20px;" class="col-3" href="${pageContext.request.contextPath}/showWelcome">
			 		Welcome Page 
			 	</a>			
				<h3>
					Welcome <strong style="color: #1c6a73;">
						${sessionScope.username} -- ${sessionScope.loginHistoryDbId} </strong>
				</h3>


			</div>
		</div>


		<div class="container mt-4">

			<hr />

			<table class="table">
				<thead >
					<tr>
						<th>SN</th>
						<th>Username</th>
						<th>Email</th>
						<th>Login Time</th>
						<th>Logout Time</th>
						<th>
				          <a class="thTitle"  href="${pageContext.request.contextPath}/loginhistory/sortByDuration?sortOrder=asc">
				         	 <span style="font-size: 20px;"><i class="bi bi-arrow-up-circle"></i></span>
				          </a>
				          <a class="thTitle"  href="${pageContext.request.contextPath}/loginhistory/sortByDuration?sortOrder=dsc">
				         	 <span style="font-size: 20px;"><i class="bi bi-arrow-down-circle"></i></span>
				          </a> Duration ms </th>
				          
						<th>Duration</th>
						<th>Action</th>
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
							<td>${item.durationInMillis}</td>					
							<td>${item.duration}</td>
							<td><a href="${pageContext.request.contextPath}/deleteLoginHistory?lhid=${item.lhid}">
								<button type="button" class="btn btn-danger">Delete</button>
						</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<hr />
		</div>
	</div>

</body>
</html>