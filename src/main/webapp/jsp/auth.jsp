<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Checkout example for Bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body class="bg-light">

<div class="container-xxl" style=" background-color: #D3D3D3;" >


    <div class="row h-100 justify-content-center">

        <div class="col-4 my-auto ">
            <div class="py-4 text-center">
                <p class="frame">
                    <img class="d-block mx-auto mb-3" src="/images/logo.png" alt="" width="100" height="100">
                </p>
                <h4>Join Teams</h4>
                <h2>Create your account</h2>
            </div>
            <form method="POST" action="controller">
                <input type="hidden" name="command" value="authorization" id="command"/>
                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="" required>
                    <div class="invalid-feedback">
                        Please enter your email.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password">Password </label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="">
                    <div class="invalid-feedback">
                        Please enter a valid password
                    </div>
                </div>

                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-lg btn-primary">Sign in</button>
                </div>
                <div class="mt-3 text-center">
                    New to Teams? <a href="?command=registration">Create an account.</a>
                </div>
            </form>
        </div>

    </div>


</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>
</body>
</html>
