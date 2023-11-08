<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">

	.errorMsg{
		font-family: monospace;
		font-size: 20px;
		font-weight: bold;
	}

</style>

</head>
<body>

	<header style="height: 50px; background-color: #5797af;">
		<h3 class="text-center">
			 <strong style="color: black;">Hello There User</strong>
		</h3>
	</header>
	
	<hr/>
	
	<div class="errorMsg text-center">
		<h3>Oops Something Went Wrong! </h3>
		<h5>Please Try Again !!</h5>
	</div>

	<hr />

</body>

</html>