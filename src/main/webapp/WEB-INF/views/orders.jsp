<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %> <!-- Include the header -->

<!DOCTYPE html>
<html>
<head>
    <title>Your Orders</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center">Your Orders</h1>
        <c:if test="${not empty orders}">
            <div class="accordion" id="ordersAccordion">
                <c:forEach var="order" items="${orders}">
                    <div class="card">
                        <div class="card-header" id="heading${order.id}">
                            <h5 class="mb-0">
                                <button class="btn btn-link" type="button" data-toggle="collapse" 
                                    data-target="#collapse${order.id}" aria-expanded="true" 
                                    aria-controls="collapse${order.id}">
                                    Order ID: ${order.id} - Total: ${order.totalPrice}
                                </button>
                            </h5>
                        </div>
                        <div id="collapse${order.id}" class="collapse" aria-labelledby="heading${order.id}" 
                             data-parent="#ordersAccordion">
                            <div class="card-body">
                                <h6>Order Status: ${order.orderStatus}</h6>
                                <ul class="list-group">
                                    <c:forEach var="item" items="${order.orderItems}">
                                        <li class="list-group-item">
                                            <strong>Product:</strong> ${item.product.name} <br>
                                            <strong>Price:</strong> ${item.price} <br>
                                            <strong>Quantity:</strong> ${item.quantity}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <c:if test="${empty orders}">
            <p class="text-center">You have no orders yet. <a href="/products">Start Shopping</a></p>
        </c:if>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
               <%@ include file="footer.jsp" %> <!-- Include the footer -->
    
</body>
</html>
