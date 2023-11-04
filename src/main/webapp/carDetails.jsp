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
	
        .table-head {
            text-decoration: none;
            color: #004953;
            font-size: 18px;
        }
    </style>
    
</head>
<body>

<header style="height: 30px;background-color: #5797af;">
</header>

<div class="container">
	<div>
		 <hr/>
			 <div > 
			 		<div class="text-center">
			 			<h2><strong style="color: #1c6a73;">${userName}</strong>'s Car Collection</h2> 
			 		
			 		</div>
			 		<div class="text-center">
			 			<img style="height: 120px;"
							src="https://cdn.pixabay.com/photo/2012/04/12/23/47/car-30984_640.png" />
					</div>
			 </div>	 
		 <hr/>
		 <div class="mb-3">
		 	<a href="showWelcome"><button class="btn btn-success">Add New Car</button></a>
		 </div>
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
						<a class="table-head">Color</a>
					</th>
					<th> 
						<a class="table-head">Fuel Type</a>
					</th>		
					<th>
						<a class="table-head">VIN</a>
					</th>
					<th>
						<a class="table-head">Photo</a>
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
						
						<td>${item.color}</td>
						
						<td>${item.fueltype}</td>
						
						<td>${item.vin}</td>
						
						<td><img src="${item.photo}" style="height: 120px;"></td>
									
						<td>${item.doe}</td>
						
						<td>
							<button type="button" class="btn btn-danger">Delete</button>
						</td>
						
						<td>
							<button type="button" class="btn btn-info">Edit</button>
						</td> 

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