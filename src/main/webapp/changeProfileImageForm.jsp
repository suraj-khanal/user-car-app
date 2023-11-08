<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Profile Image Change</title>
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
		<div>
			<hr />
			
			<div class="position-absolute top-1 end-0 me-4">
				<a href="logout">
					<button class="btn btn-warning">Logout</button>
				</a>
			</div>
			<hr/>
			<h3 class="mt-4 text-secondary text-center">Change Profile Image</h3>
			<hr/>

			<div class="text-center" >
			
				<form action="/changeProfileImage" method="post" enctype="multipart/form-data">
				
				    <input type="file" name="imageFile" accept="image/*">
				    
				    <button class="btn btn-primary" type="submit">Upload Profile Picture</button>
				</form>

			</div>
		</div>

	</div>

	<hr />

</body>

</html>