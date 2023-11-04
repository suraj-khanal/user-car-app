<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<header style="height: 30px;background-color: #5797af;">
</header>

<div class="container">
	<div>
		 <hr/>
				 <div class="position-absolute top-1 end-0 me-4">
				 
				    <a href="logout">
				   		 <button class="btn btn-warning">Logout</button>
				    </a>
				    
				    </div>
			 <div class="row text-center"> 
			 		<div class="col-md-6">
				        <h3>Welcome <strong style="color: #1c6a73;">${welcomeMsg}</strong></h3>
				        <img style="height: 80px; width: 80px; border-radius: 50px" alt="noavatar" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
				        <div class="text-secondary"><a href="#"> View Profile --> soon </a></div>
				    </div>
			 </div>
			
	 </div>
	<div class="text-center">
		<a href="showLoginHistory">
			<button class="btn btn-primary">LoginHistory</button>
		</a>
	</div>
	 
	 <div class="container mt-4">
	 <div class="row">
	 <div class="col-9" >
	 
	 <h3>Add New Car</h3>
	 </div>
		<div class="col-3 ">
		 <div> <a href="show-cars"><button class="btn btn-info">CarDetails</button></a></div>
	</div>
	</div>
	<hr>
	<span style="font-weight: bold;font-size: 18px;color:blue"></span>
	 <hr/>
	 
	<form action="addCar" method="post">
	
		<div class="form-group" style="width: 60%;">
  	           <b>Car Name</b>
  	           <input type="text" name="carname" class="form-control" required>
	    </div>
	    
	    <div class="form-group mt-2" style="width: 60%;">
  	           <b>Car Make</b>
  	           <input type="text" name="carmake" class="form-control" required>
	    </div>
	    
	    <div class="form-group mt-2" style="width: 60%;">
  	           <b>Color</b>
  	           <input type="text" name="color" class="form-control" required>
	    </div>
	    
	    <div class="form-group mt-2" style="width: 60%;">
  	           <b>Vin</b>
  	           <input type="text" name="vin" class="form-control" required>
	    </div>
	    
	    <div class="form-group mt-2" style="width: 60%;">
  	           <b>Fuel Type</b>
  	            <select name="fueltype" class="form-control">
  	           		<option>Select</option>
  	              <option value="gasoline" >Gasoline</option>
  	              <option value="diesel" >Diesel</option>
  	              <option value="electric" >Electric</option>
  	           </select>
	    </div>
	    
	    <div class="form-group mt-2" style="width: 60%;">
  	           <b>Photo</b>
  	           <input type="text" name="photo" class="form-control" >
	    </div>
		
	     <div class="form-group mt-3" style="width: 60%;">
	     
  	           <button type="submit"  class="btn btn-primary">Add</button>
	    </div>
	    
	</form> 
	   
	    <hr/>
</div>
</div>



</body>
</html>