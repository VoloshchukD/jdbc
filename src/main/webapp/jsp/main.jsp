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
         style="height: 300px; padding: 30px; background-image: url('https://www.teahub.io/photos/full/238-2389250_wallpaper-dubai-united-arab-emirates-skyscrapers-dubai-dual.jpg');">
        <div class="text-center">
            <h1 class="fw-bolder pt-5">Welcome to Teams</h1>
            <p class="lead">A functional Bootstrap 5 boilerplate for one page scrolling websites</p>
            <a class="btn btn-lg btn-light mb-5" href="#about">Get to know us better!</a>
        </div>
    </div>

    <section class="wow fadeIn animated" style="visibility: visible; animation-name: fadeIn;">
        <hr>
        <div class="row my-5">
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="300ms"
                 style="visibility: visible; animation-duration: 300ms; animation-name: fadeInUp;"><i
                    class="fa fa-birthday-cake medium-icon"></i> <span id="anim-number-pizza"
                                                                       class="counter-number"></span> <span
                    class="timer counter alt-font appear" data-to="980" data-speed="7000">12</span>
                <p class="counter-title">Years On The Market</p>
            </div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="600ms"
                 style="visibility: visible; animation-duration: 600ms; animation-name: fadeInUp;"><i
                    class="fa fa-heart medium-icon"></i> <span class="timer counter alt-font appear" data-to="980"
                                                               data-speed="7000">980</span> <span class="counter-title">Happy Clients</span>
            </div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin-small text-center counter-section wow fadeInUp xs-margin-bottom-ten animated"
                 data-wow-duration="900ms"
                 style="visibility: visible; animation-duration: 900ms; animation-name: fadeInUp;"><i
                    class="fa fa-anchor medium-icon"></i> <span class="timer counter alt-font appear" data-to="810"
                                                                data-speed="7000">810</span> <span
                    class="counter-title">Projects Completed</span></div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 text-center counter-section wow fadeInUp animated" data-wow-duration="1200ms"
                 style="visibility: visible; animation-duration: 1200ms; animation-name: fadeInUp;"><i
                    class="fa fa-user medium-icon"></i> <span class="timer counter alt-font appear" data-to="600"
                                                              data-speed="7000">600</span> <span class="counter-title">Clients Served</span>
            </div> <!-- end counter -->
        </div>
        <hr>
        <div class="row my-5">
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="300ms"
                 style="visibility: visible; animation-duration: 300ms; animation-name: fadeInUp;"><i
                    class="fa fa-beer medium-icon"></i> <span id="anim-number-pizza2" class="counter-number"></span>
                <span class="timer counter alt-font appear" data-to="980" data-speed="7000">2800</span>
                <p class="counter-title">Beer Ordered</p>
            </div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="600ms"
                 style="visibility: visible; animation-duration: 600ms; animation-name: fadeInUp;"><i
                    class="fa fa-heart medium-icon"></i> <span class="timer counter alt-font appear" data-to="980"
                                                               data-speed="7000">980</span> <span class="counter-title">Happy Clients</span>
            </div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 bottom-margin-small text-center counter-section wow fadeInUp xs-margin-bottom-ten animated"
                 data-wow-duration="900ms"
                 style="visibility: visible; animation-duration: 900ms; animation-name: fadeInUp;"><i
                    class="fa fa-anchor medium-icon"></i> <span class="timer counter alt-font appear" data-to="810"
                                                                data-speed="7000">810</span> <span
                    class="counter-title">Projects Completed</span></div> <!-- end counter -->
            <!-- counter -->
            <div class="col-md-3 col-sm-6 text-center counter-section wow fadeInUp animated" data-wow-duration="1200ms"
                 style="visibility: visible; animation-duration: 1200ms; animation-name: fadeInUp;"><i
                    class="fa fa-user medium-icon"></i> <span class="timer counter alt-font appear" data-to="600"
                                                              data-speed="7000">600</span> <span class="counter-title">Clients Served</span>
            </div> <!-- end counter -->
        </div>

    </section>

    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="https://images.unsplash.com/photo-1606044466411-207a9a49711f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
                                   alt="..."/></div>
        <div class="col-lg-5">
            <h1 class="font-weight-light">Business Name or Tagline</h1>
            <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it
                makes a great use of the standard Bootstrap core components. Feel free to use this template for any
                project you want!</p>
            <a class="btn btn-primary" href="#!">Call to Action!</a>
        </div>
    </div>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-5">
            <h1 class="font-weight-light">Business Name or Tagline</h1>
            <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it
                makes a great use of the standard Bootstrap core components. Feel free to use this template for any
                project you want!</p>
            <a class="btn btn-primary" href="#!">Call to Action!</a>
        </div>
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="https://images.unsplash.com/photo-1606044466411-207a9a49711f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
                                   alt="..."/></div>
    </div>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="https://images.unsplash.com/photo-1606044466411-207a9a49711f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
                                   alt="..."/></div>
        <div class="col-lg-5">
            <h1 class="font-weight-light">Business Name or Tagline</h1>
            <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it
                makes a great use of the standard Bootstrap core components. Feel free to use this template for any
                project you want!</p>
            <a class="btn btn-primary" href="#!">Call to Action!</a>
        </div>
    </div>
    <hr>

</div>
<jsp:include page="../WEB-INF/jspf/footer.jspf"/>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>
