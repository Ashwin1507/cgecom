<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %> <!-- Include the header -->

<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <!-- Restrict Access to Admin -->
        <c:if test="${sessionScope.loggedInUser.role != 'ADMIN'}">
            <h1 class="text-danger">Access Denied!</h1>
            <p>You are not authorized to view this page.</p>
        </c:if>
        
        <c:if test="${sessionScope.loggedInUser.role == 'ADMIN'}">
            <h1>Category Management</h1>

            <!-- Add Category Form -->
            <form action="/categories/add" method="post" class="mt-4">
                <div class="form-group">
                    <label for="categoryName">Category Name:</label>
                    <input type="text" id="categoryName" name="name" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="categoryDescription">Description:</label>
                    <textarea id="categoryDescription" name="description" class="form-control" required></textarea>
                </div>
                <button type="submit" class="btn btn-success">Add Category</button>
                <a href="/admin/dashboard" class="btn btn-success">Back to Dashboard</a>
                
            </form>

            <!-- Existing Categories -->
            <h2 class="mt-4">Existing Categories</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Category Name</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${categories}">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.description}</td>
                            <td>
                                <form action="/categories/delete" method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="${category.id}">
                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
