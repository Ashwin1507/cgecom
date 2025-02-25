<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %> <!-- Include the header -->

<!DOCTYPE html>
<html>
<head>
    <title>Product List - Codegnan Ecom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">Product List</h1>

        <!-- Admin: Add Product -->
        <c:if test="${loggedInUser.role == 'ADMIN'}">
            <div class="d-flex justify-content-between mt-3 mb-3">
        		<a href="/products/add" class="btn btn-success">Add New Product</a>
        		<a href="/admin/dashboard" class="btn btn-primary">Back to Dashboard</a>
    		</div>
            
        </c:if>

        
          <!-- Check if products exist -->
        <c:choose>
            <c:when test="${not empty productPage.content}">
        <!-- Products Grid (Only Display Current Page Data) -->
        <div class="row">
            <c:forEach var="product" items="${productPage.content}">
                <div class="col-md-4 mb-4">
                    <div class="card h-100">
                        <!-- Product Image -->
                        <img src="${product.imagePath}" class="card-img-top" alt="${product.name}" style="height: 200px; object-fit: cover;">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text text-truncate">${product.description}</p>
                            <p class="text-primary font-weight-bold">${product.price}</p>
                        </div>
                        <div class="card-footer bg-transparent border-0">
                            <c:if test="${loggedInUser.role != 'ADMIN'}">
                                <form action="/cart/add" method="post" class="d-inline">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <input type="number" name="quantity" value="1" min="1" class="form-control-sm d-inline" style="width: 60px;">
                                    <button type="submit" class="btn btn-primary btn-sm">Add to Cart</button>
                                </form>
                            </c:if>
                            <c:if test="${loggedInUser.role == 'ADMIN'}">
                            
                               <!-- Show Activate/Inactivate button based on product status -->
                                        <c:choose>
                                            <c:when test="${product.active}">
                                                <a href="/products/inactivate/${product.id}" class="btn btn-danger btn-sm mt-2">Inactivate</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/products/activate/${product.id}" class="btn btn-success btn-sm mt-2">Activate</a>
                                            </c:otherwise>
                                        </c:choose>
                                        
                                        
                                <a href="/products/edit/${product.id}" class="btn btn-warning btn-sm mt-2">Edit</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
  
       
         <!-- Pagination Controls (Only Show if More than One Page Exists) -->
                <c:if test="${totalPages > 1}">
        <!-- Pagination Controls -->
        <div class="pagination mt-3">
            <c:if test="${currentPage > 0}">
                <a href="/products?page=${currentPage - 1}" class="btn btn-secondary">Previous</a>
            </c:if>
            <c:forEach var="i" begin="0" end="${totalPages - 1}">
                <a href="/products?page=${i}" class="btn ${currentPage == i ? 'btn-primary' : 'btn-light'}">${i + 1}</a>
            </c:forEach>
            <c:if test="${currentPage < totalPages - 1}">
                <a href="/products?page=${currentPage + 1}" class="btn btn-secondary">Next</a>
            </c:if>
        </div>
        
         </c:if>
        </c:when>
        
         <c:otherwise>
                <!-- Message When No Products Are Available -->
                <p class="text-center text-muted mt-4">No products available.</p>
            </c:otherwise>
        </c:choose>

        <c:if test="${loggedInUser.role != 'ADMIN'}">
            <a href="/cart" class="btn btn-secondary mt-3 float-right">View Cart</a>
        </c:if>
    </div>

    <%@ include file="footer.jsp" %> <!-- Include the footer -->
</body>
</html>
