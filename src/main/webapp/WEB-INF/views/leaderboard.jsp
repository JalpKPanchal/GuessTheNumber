<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Leaderboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <h1 class="text-center mb-4">Leaderboard</h1>
    
    <c:if test="${not empty error}">
        <div class="alert alert-warning text-center">${error}</div>
    </c:if>

    <c:if test="${not empty users}">
        <table class="table table-striped table-bordered shadow">
            <thead class="table-dark">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Credit Points</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.email}</td>
                        <td>${user.creditPoints}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty users}">
        <p class="text-center">No users available to display on the leaderboard.</p>
    </c:if>

    <div class="text-center mt-4">
        <a href="/home" class="btn btn-secondary">Back to Home</a>
    </div>
</div>
</body>
</html>
