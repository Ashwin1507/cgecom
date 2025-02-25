<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    /* Professional Header Styling */
    header {
        background: linear-gradient(90deg, #2c3e50, #27ae60); /* Gradient background */
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 15px 20px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        position: sticky;
        top: 0;
        z-index: 1000;
    }

    /* Logo and Title Styling */
    header h1 {
        font-size: 2rem;
        margin: 0;
        font-weight: bold;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    /* Navigation Section */
    .nav-links {
        display: flex;
        align-items: center;
    }

    .order-history-btn {
        background-color: #f39c12; /* Bootstrap warning color */
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 1rem;
        font-weight: 500;
        margin-right: 20px;
        transition: background-color 0.3s ease, transform 0.2s;
    }

    .order-history-btn:hover {
        background-color: #e67e22; /* Darker orange for hover effect */
        transform: scale(1.05);
    }

    /* User Info and Logout Button */
    .user-info {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .user-info p {
        margin: 0;
        font-size: 1rem;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .logout-btn {
        background-color: #e74c3c; /* Bootstrap danger color */
        border: none;
        padding: 8px 15px;
        color: white;
        font-size: 1rem;
        cursor: pointer;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease, transform 0.2s;
    }

    .logout-btn:hover {
        background-color: #c0392b; /* Slightly darker red on hover */
        transform: scale(1.05);
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        header {
            flex-direction: column;
            align-items: flex-start;
        }

        .nav-links {
            flex-direction: column;
            align-items: flex-start;
            gap: 10px;
        }

        .order-history-btn {
            margin-right: 0;
        }
    }
</style>

<header>
    <!-- Left Corner: CGEcom Logo/Title -->
    <h1>CGEcom</h1>

    <!-- Right Corner: Navigation Links and User Info -->
    <div class="nav-links">
        <!-- Display 'Order History' button only for users with role USER -->
        <c:if test="${loggedInUser != null && loggedInUser.role == 'USER'}">
            <a href="/orders" class="order-history-btn">Order History</a>
        </c:if>

        <!-- User Info -->
        <div class="user-info">
            <c:if test="${loggedInUser != null}">
                <p>Welcome, ${loggedInUser.username}!</p>
                <a href="/logout" class="logout-btn">Sign Out</a>
            </c:if>
        </div>
    </div>
</header>
