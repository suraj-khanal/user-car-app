<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<header style="height: 30px;background-color: #5797af;">
</header>

<div class="container">
	 <h2>User Login  form</h2>

	<img style="height: 120px;" src="https://t4.ftcdn.net/jpg/05/58/06/81/360_F_558068185_sZmfyrWuzHTfzLdwJuj1ALQcBtbKAtbA.jpg"/>
	 <img style="height: 120px;" src="https://www.shutterstock.com/image-vector/man-character-holding-phone-login-260nw-1974579347.jpg"/>
	 <img style="height: 120px;" src="https://static.vecteezy.com/system/resources/previews/008/442/086/non_2x/illustration-of-human-icon-user-symbol-icon-modern-design-on-blank-background-free-vector.jpg"/>
	<hr>
	<span style="font-weight: bold;font-size: 16px;color:red; font-family:monospace;">${loginErrMsg}</span>
	<span style="font-weight: bold;font-size: 16px;color:red; font-family:monospace;">${messageLogout}</span>
	 <hr/>
	 
	<form action="auth" method="post">
	
	 <div class="form-group" style="width: 60%;">
  	           <b>Username</b>
  	           <input type="text" name="username" class="form-control" required>
	    </div>
	    
	     <div class="form-group mt-3" style="width: 60%;">
  	           <b>Password</b>
  	           <input type="password" name="password" class="form-control" required>
	    </div>
	    
	     <div class="form-group" style="width: 40%;margin-top: 20px;">
  	           <button type="submit"  class="btn btn-primary">Sign In</button>
	    </div>
	    
	    <div class="form-group" style="width: 60%; margin-top: 20px;">
  	          <a href="/showSignup">Not yet Registered? Signup Here</a>
	    </div>
	</form>    
	    <hr/>
	     <img style="height: 60px;" src="https://www.iconpacks.net/icons/1/free-user-group-icon-307-thumb.png"/>

</div>


</body>
</html>