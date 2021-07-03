<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/main.css">

</head>
<body>
<jsp:include page="../WEB-INF/jspf/header.jspf"/>
<div class="container-xxl">

    <div class="text-white my-5"
         style="height: 330px; padding: 30px; background-color: #020230;" >
        <img class="d-block mx-auto" src="/images/logo.png" alt="" width="100" height="100">
        <div class="text-center">
            <h1 class="fw-bolder pt-2">Welcome to Teams</h1>
            <p class="lead">Application for the competent interaction of the performers team with the customer.</p>
            <a class="btn btn-lg btn-light " href="?command=about">Get to know us better!</a>
        </div>
    </div>

    <section class="wow fadeIn animated" style="visibility: visible; animation-name: fadeIn;">
        <hr>
        <div class="row my-5">
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="300ms"
                 style="visibility: visible; animation-duration: 300ms; animation-name: fadeInUp;"><i
                    class="fa fa-birthday-cake medium-icon"></i> <span id="anim-number-pizza"
                                                                       class="counter-number"></span> <span
                    class="timer counter alt-font appear" data-to="980" data-speed="7000">12</span>
                <p class="counter-title">Years On The Market</p>
            </div>
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="600ms"
                 style="visibility: visible; animation-duration: 600ms; animation-name: fadeInUp;"><i
                    class="fa fa-graduation-cap medium-icon"></i> <span class="timer counter alt-font appear" data-to="980"
                                                               data-speed="7000">980</span> <span class="counter-title">Average employees<p> experience</span>
            </div>
            <div class="col-md-3 col-sm-6 bottom-margin-small text-center counter-section wow fadeInUp xs-margin-bottom-ten animated"
                 data-wow-duration="900ms"
                 style="visibility: visible; animation-duration: 900ms; animation-name: fadeInUp;"><i
                    class="fa fa-anchor medium-icon"></i> <span class="timer counter alt-font appear" data-to="810"
                                                                data-speed="7000">810</span> <span
                    class="counter-title">Projects Completed</span></div>
            <div class="col-md-3 col-sm-6 text-center counter-section wow fadeInUp animated" data-wow-duration="1200ms"
                 style="visibility: visible; animation-duration: 1200ms; animation-name: fadeInUp;"><i
                    class="fa fa-user medium-icon"></i> <span class="timer counter alt-font appear" data-to="600"
                                                              data-speed="7000">600</span> <span class="counter-title">Clients Served</span>
            </div>
        </div>
    </section>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="/images/customer_main.jpg"
                                   alt="..."/></div>
        <div class="col-lg-5">
            <h1 class="font-weight-light">For those who need a development team</h1>
            <p>If you are a customer with a product idea or some aims that are still not realized, we are ready to fulfill all your requests.
                Our app is a great opportunity for you to get a high-quality product for the best price and in a small period of time.</p>
            <a class="btn btn-primary" href="?command=registration">Ready to start?</a>
        </div>
    </div>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-5">
            <h1 class="font-weight-light">For those who need a manager's position</h1>
            <p>In case you are a manager with a good knowledges and rich experience. Our product development processes are always ruled by the manager.
                We will be glad to see you in our team and reach the success together.</p>
            <a class="btn btn-primary" href="?command=registration">Waiting for you!</a>
        </div>
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="/images/manager_main.jpg"
                                   alt="..."/></div>
    </div>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="/images/developer_main.jpg"
                                   alt="..."/></div>
        <div class="col-lg-5">
            <h1 class="font-weight-light">For the developers seeking employment</h1>
            <p>If you are a top level developer with a valuable experience and you are looking for the stable source of projects,
                you are exactly where you should be. Our Teams app provides their employees
                a great opportunity to achieve all you want in your profession.</p>
            <a class="btn btn-primary" href="?command=registration">Join us!</a>
        </div>
    </div>
    <hr>

</div>
<jsp:include page="../WEB-INF/jspf/footer.jspf"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>
