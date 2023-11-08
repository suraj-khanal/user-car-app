<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<header style="height: 50px; background-color: #5797af;">
		<h3 class="text-center">
			Welcome <strong style="color: black;">${sessionScope.username}</strong>
		</h3>
	</header>

	<div class="container">
	<div class="mt-3">
			<a style="text-decoration:none; font-size:20px;" class="col-3" href="${pageContext.request.contextPath}/showWelcome">
				 		Welcome Page 
			</a>
		</div>
		<div>
			<hr />
			<div class="row ">
				<div class="col-3">
					<a href="/changeProfileImage" class="text-secondary fw-bold"
						style="text-decoration: none; cursor: pointer;"> 
						<img style="height: 80px; width: 80px; border-radius: 50px" alt="noavatar"					
							src="data:image/*;base64, ${userdata.userProfileImage}">
						Change Profile Picture
					</a>
				</div>
			</div>
			<div class="position-absolute top-1 end-0 me-4">
				<a href="logout">
					<button class="btn btn-warning">Logout</button>
				</a>
			</div>
			<hr style="width: 80%;" />
				<span style="font-weight: bold;font-size: 16px;color:#97a97c; font-family:monospace;">${userProfileChangeImgMsg}</span>
			<hr style="width: 80%;" />
			<h3 class="mt-4 text-secondary text-center">User Account Details</h3>
			<hr style="width: 80%;"  />

			<div class="text-center" >
				<form>

					<div class="form-group" style="width: 60%;">
						<b>Name</b> <input type="text" value="${userdata.name}"
							name="name" class="form-control" required>
					</div>

					<div class="form-group mt-3" style="width: 60%;">
						<b>Username</b> <input type="text" value="${userdata.username}"
							 name="username" class="form-control" required>
					</div>

					<div class="form-group mt-3" style="width: 60%;">
						<b>Email</b> <input type="email"  value="${userdata.email}"
						 name="email" class="form-control" required>
					</div>

					<div class="form-group mt-3" style="width: 60%;">
						<b>Password</b> <input type="password"  value="${userdata.password}"
							name="password" class="form-control" required>
					</div>

					<div class="form-group mt-3" style="width: 60%;">

						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form>

			</div>
		</div>

	</div>

	<hr />

</body>

</html>