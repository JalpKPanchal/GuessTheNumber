<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="text-center mb-4">
        <h1>Welcome, ${loggedUser.firstName}!</h1>
        <p>Your Credit Points: <strong>${loggedUser.creditPoints}</strong></p>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow p-4">
                <form action="/play" method="post">
                    <div class="mb-3">
                        <label for="guessedNumber" class="form-label">Guess a number between 1 and 10</label>
                        <input type="number" class="form-control" id="guessedNumber" name="guessedNumber" min="1" max="10" required>
                    </div>
                    <button type="submit" class="btn btn-success w-100">Submit</button>
                </form>
                <c:if test="${not empty message}">
                    <div class="alert alert-info mt-3">${message}</div>
                </c:if>
            </div>
        </div>
    </div>
    <div class="text-center mt-4">
        <a href="/leaderboard" class="btn btn-primary me-2">View Leaderboard</a>
        <a href="/" class="btn btn-secondary">Logout</a>
    </div>
</div>
</body>
</html>
