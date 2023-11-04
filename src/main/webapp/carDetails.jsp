<%@ taglib uri = "http://java.su2n.com/jsp/jstl/core" prefix = "c" %>
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

<header style="height: 30px;background-color: #5797af;">
</header>

<div class="container">
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
						src="https://www.freeiconspng.com/thumbs/car-icon-png/black-car-icons-9.png" />
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
						<a class="table-head">Make</a>
					</th>
					<th> 
						<a class="table-head">Fuel Type</a>
					</th>
					<th>
						<a class="table-head">Photo</a>
					</th>
					<th>
						<a class="table-head">Car Body</a>
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
				<c:forEach var="item" items="${dogdata}">
					<tr>
						<td>${item.name}</td>
						<td>${item.color}</td>
						<td>${item.breed}</td>
						<td><img src="${item.url}" style="height: 120px;"> <a
							href="/editDogImage?dogname=${item.name}"><button
									type="button" class="btn btn-secondary">Edit Img</button></a></td>
						<td>${item.cdate}</td>
						<td><a href="deleteDog?dogname=${item.name} ">
								<button type="button" class="btn btn-danger">Delete</button>
						</a></td>
						<td><a href="/editDog?dogname=${item.name}">
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