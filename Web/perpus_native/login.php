<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <title>Login</title>
</head>

<body>
    <main>
        <div class="row" style="margin-top:50px;">
            <div class="col-md"></div>
            <div class="col-md round bg-light" style="box-shadow: 4px 4px 5px-px; padding: 10px;">
                <form action="proses_login.php" method="post">
                    <h3 align="center">LOGIN Perpus Online</h3>
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" class="form-control">
                    <label for="password">Password:</label>
                    <input type="text" name="password" id="password" class="form-control">
                    <center><input type="submit" value="LOGIN" id="login" name="login" class="btn btn-primary"></center>
                </form>
            </div>
            <div class="col-md"></div>
        </div>
    </main>
</body>

</html>