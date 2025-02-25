<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Product - Codegnan Ecom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">Edit Product</h1>
        
        <!-- Product Edit Form -->
        <form action="/products/edit/${product.id}" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}">
            
            <!-- Category Selection -->
            <div class="form-group">
                <label for="category">Category:</label>
                <select id="category" name="categoryId" class="form-control" required>
                    <option value="" <c:if test="${product.category == null}">selected</c:if>>Category not selected</option>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}" <c:if test="${category.id == product.category.id}">selected</c:if>>
                            ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <!-- Product Name -->
            <div class="form-group">
                <label for="name">Product Name</label>
                <input type="text" id="name" name="name" class="form-control" value="${product.name}" required>
            </div>
            
            <!-- Product Description -->
            <div class="form-group">
                <label for="description">Product Description</label>
                <textarea id="description" name="description" class="form-control" rows="4" required>${product.description}</textarea>
            </div>
            
            <!-- Price -->
            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" id="price" name="price" class="form-control" value="${product.price}" step="0.01" required>
            </div>

            <!-- Active/Inactive Dropdown -->
            <div class="form-group">
                <label for="isActive">Status</label>
                <select id="isActive" name="isActive" class="form-control" required>
                    <option value="true" <c:if test="${product.active}">selected</c:if>>Active</option>
                    <option value="false" <c:if test="${!product.active}">selected</c:if>>Inactive</option>
                </select>
            </div>

            <!-- Upload New Image -->
            <div class="form-group">
                <label for="imageFile">Upload New Image</label>
                <input type="file" id="imageFile" name="imageFile" class="form-control">
                <small class="form-text text-muted">Leave empty if you do not want to change the image.</small>
            </div>

            <!-- Display Existing Image -->
            <div class="form-group">
                <label>Current Image</label><br>
                <img src="${product.imagePath}" alt="${product.name}" style="width: 150px; height: auto;">
            </div>
            
            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Update Product</button>
        </form>
        
        <!-- Link to Cancel -->
        <a href="/products" class="btn btn-secondary mt-3">Cancel</a>
    </div>
</body>
</html>
