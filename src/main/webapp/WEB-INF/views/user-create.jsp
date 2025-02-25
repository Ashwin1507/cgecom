<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %> <!-- Include the header -->
<!DOCTYPE html>
<html>
<head>
    <title>Create User</title>
    <link rel="stylesheet" href="/styles.css"> <!-- Link to the shared styles.css -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
    
      <!-- Display error message if user creation fails -->
                <c:if test="${not empty error}">
                    <div class="alert alert-danger text-center">
                        ${error} <!-- Display the error message -->
                    </div>
                </c:if>
    
    
        <h1>Create New User</h1>
        <form action="/users/create" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role" class="form-control" required>
                    <option value="USER">User</option>
                    <option value="ADMIN">Admin</option>
                </select>
            </div>
            
            
            
            
               <div class="form-group">
                <label for="phone_number">Phone Number:</label>
                <input type="text" id="phone_number" name="phone_number" class="form-control" required>
            </div>
            
            
              
               <div class="form-group">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" class="form-control" required>
            </div>
            
            
            
            
            
            <button type="submit" class="btn btn-primary">Create User</button>
        </form>
		<a href="/login" class="btn btn-secondary mt-3">Proceed to Login</a>
 </div>
        <%@ include file="footer.jsp" %> <!-- Include the footer -->
 
</body>
</html>
