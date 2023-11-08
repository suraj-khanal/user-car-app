<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Car Details Page</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>	
	
	<style type="text/css">
        /* Define custom CSS styles */
        .table-head {
            text-decoration: none;
            color: #004953;
            font-size: 20px;
        }
    </style>
    
</head>
<body>

<header style="height: 50px;background-color: #5797af;">
<h3 class="text-center">Welcome <strong style="color: black;">${sessionScope.username}</strong></h3>
</header>

<div class="container">
	<div class="mt-3">
			<a style="text-decoration:none; font-size:20px;" class="col-3" href="${pageContext.request.contextPath}/showWelcome">
				 		Welcome Page 
			</a>
		</div>
	<div>
		 <hr/>
			 <div > 
			 		<div class="text-center">
			 			<h2>Car Details</h2> 
			 		
			 		</div>
			 		
			 		<img style="height: 120px;"
						src="https://cdn.pixabay.com/photo/2012/04/12/23/47/car-30984_640.png" />
					<img style="height: 120px;"
					src="https://imteg.weebly.com/uploads/5/4/9/8/54982803/3690206_orig.jpg" />
								 		<img style="height: 120px;"
						src="https://cdn.pixabay.com/photo/2012/04/12/23/47/car-30984_640.png" />

			 </div>	 
		 <hr/>
	<div>
			<table class="table table-bordered">
			<thead>
				<tr>
					<th>
						<a class="table-head">Car Name</a>
					</th>		
					<th> 
						<a class="table-head">Car Make</a>
					</th>
					<th> 
						<a class="table-head">Fuel Type</a>
					</th>
					<th>
						<a class="table-head">Photo</a>
					</th>
					<th>
						<a class="table-head">VIN</a>
					</th>
					<th>
						<a class="table-head">DOE</a>
					</th>
					<th>
						<a class="table-head">Action</a>
					</th>
					<th>
						<a class="table-head">Action</a>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cardata}">
					<tr>
						<td>${item.carname}</td>
						<td>${item.carmake}</td>
						<td>${item.fueltype}</td>
						<td><img src="${item.photo}" style="height: 120px;"></td>
						<td>${item.vin}</td>
						<td>${item.doe}</td>					
						
						 <td><a href="deleteCar?carId=${item.cid} ">
								<button type="button" class="btn btn-danger">Delete</button>
						</a></td>
						<td><a href="editCar?carId=${item.cid}">
								<button type="button" class="btn btn-info">Edit</button>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	
	
	</div> 
		 
		 
		 
		 
 </div>
	 
	 <div>
	 
	 
	 
	 </div>
	 	
	 
</div>


</body>
</html>