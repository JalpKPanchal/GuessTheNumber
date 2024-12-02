<!DOCTYPE html>
<html lang="en">
<head>
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4" style="width: 400px;">
        <h3 class="text-center mb-3">Sign Up</h3>
        <form action="/signup" method="post">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter your first name" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Create a password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Sign Up</button>
        </form>
        <div class="mt-3 text-center">
            <p>Already have an account? <a href="/" class="text-decoration-none">Login</a></p>
        </div>
    </div>
</div>
</body>
</html>