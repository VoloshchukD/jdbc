<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Checkout example for Bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body class="bg-light">

<div class="container-xxl" style="background-color: #D3D3D3;" >
    <div class="py-5 text-center">
        <p class="frame">
            <img class="d-block mx-auto mb-3" src="/images/logo.png" alt="" width="100" height="100">
        </p>
        <h4>Join Teams</h4>
        <h2>Create your account</h2>
    </div>

    <div class="row">
        <div class="col-4">

        </div>

        <div class="col-4">

            <form method="POST" action="controller" enctype="text/plain" >
                <input type="hidden" name="command" value="registration" id="command"/>
                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="" required>
                    <div class="invalid-feedback">
                        Please enter your email.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password">Password </label>
                    <input type="password" class="form-control" id="password" placeholder="">
                    <div class="invalid-feedback">
                        Please enter a valid password
                    </div>
                </div>

                <hr class="mb-4">

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="company">Company</label>
                    <input type="text" class="form-control" id="company" placeholder="" required>
                    <div class="invalid-feedback">
                        Please enter your company.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="position">Position</label>
                    <input type="text" class="form-control" id="position" placeholder="" required>
                    <div class="invalid-feedback">
                        Please enter your position.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="role">Role</label>
                    <select class="form-select" aria-label="Default select example" id="role">
                        <option value="1">Manager</option>
                        <option value="2">Developer</option>
                        <option value="3">Customer</option>
                    </select>

                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="experience">Experience</label>
                        <input type="text" class="form-control" id="experience" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="salary">Salary</label>
                        <input type="text" class="form-control" id="salary" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="primary">Primary skill</label>
                        <input type="text" class="form-control" id="primary" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col mb-3">
                        <label for="skillsDescription">Skills description</label>
                        <textarea class="form-control" aria-label="With textarea" id="skillsDescription"></textarea>
                    </div>

                </div>

                <div class="d-flex justify-content-center">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
                </div>
                <div class="mt-3 text-center">
                    Already have an account? <a href="?command=authorization">Sign in.</a>
                </div>

            </form>
        </div>
        <div class="col-4">
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
