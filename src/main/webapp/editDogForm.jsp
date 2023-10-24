<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Dog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<header style="height: 30px; background-color: #7b99ff;"></header>

<div class="container">
    <h2>Dog Edit Form</h2>

    <img style="height: 120px;" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcR2v8jGQFEHwDE0bEIm2Sofs-0n5RUWyiNtY_JQw46IozVB-YPU" />
    <img style="height: 120px;" src="https://images.unsplash.com/photo-1511367461989-f85a21fda167?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJvZmlsZXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80" />
    <img style="height: 120px;" src="https://i.pinimg.com/originals/13/c9/cf/13c9cf501cc135841abeea0fc0584318.png" />
    <hr>
    <span style="font-weight: bold; font-size: 18px; color: blue">${message}</span>
    <hr />

    <form action="updateDog" method="post">
        <div>
            <input type="hidden" name="originalName" value="${dog.name}" />
        </div>

        <div class="form-group" style="width: 50%;">
            <label for="name"><b>Name</b></label>
            <input type="text" name="name" value="${dog.name}" class="form-control">
        </div>

        <div class="form-group" style="width: 50%;">
            <label for="color"><b>Color</b></label>
            <select name="color" class="form-control">
                <option>Select</option>
                <option value="Red" ${dog.color == 'Red' ? 'selected' : ''}>Red</option>
                <option value="White" ${dog.color == 'White' ? 'selected' : ''}>White</option>
                <option value="Black" ${dog.color == 'Black' ? 'selected' : ''}>Black</option>
                <option value="Yellow" ${dog.color == 'Yellow' ? 'selected' : ''}>Yellow</option>
                <option value="Brown" ${dog.color == 'Brown' ? 'selected' : ''}>Brown</option>
            </select>
        </div>

        <div class="form-group" style="width: 50%;">
            <label for="breed"><b>Breed</b></label>
            <select name="breed" class="form-control">
                <option>Select</option>
                <option value="Labrador" ${dog.breed == 'Labrador' ? 'selected' : ''}>Labrador</option>
                <option value="Poodle" ${dog.breed == 'Poodle' ? 'selected' : ''}>Poodle</option>
                <option value="Pomeranian" ${dog.breed == 'Pomeranian' ? 'selected' : ''}>Pomeranian</option>
                <option value="Chihuahua" ${dog.breed == 'Chihuahua' ? 'selected' : ''}>Chihuahua</option>
                <option value="Maltese" ${dog.breed == 'Maltese' ? 'selected' : ''}>Maltese</option>
            </select>
        </div>

        <div class="form-group" style="width: 50%;">
            <label for="url"><b>Photo</b></label>
            <input type="text" name="url" value="${dog.url}" class="form-control">
        </div>

        <div class="form-group" style="width: 50%; margin-top: 20px;">
        	<a href="/updateDog">
            <button type="submit" class="btn btn-primary">Update Dog</button>
            </a>
            <a href="show-dogs">
                <button type="button" class="btn btn-success">Data</button>
            </a>
        </div>
    </form>
    <hr />
    <img style="height: 60px;" src="https://www.iconpacks.net/icons/1/free-user-group-icon-307-thumb.png" />
</div>

</body>
</html>
