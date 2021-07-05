<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="../WEB-INF/jspf/header.jspf" %>
    <title><fmt:message bundle="${loc}" key="local.main"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<div class="container-xxl">
    <div class="text-white my-5"
         style="height: 330px; padding: 30px; background-color: #020230;">
        <img class="d-block mx-auto" src="/images/logo.png" alt="" width="100" height="100">
        <div class="text-center">
            <h1 class="fw-bolder pt-2"><fmt:message bundle="${loc}" key="local.welcome"/></h1>
            <p class="lead"><fmt:message bundle="${loc}" key="local.slogan"/></p>
            <a class="btn btn-lg btn-light " href="?command=about"><fmt:message bundle="${loc}"
                                                                                key="local.call-to-about"/></a>
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
                <p class="counter-title"><fmt:message bundle="${loc}" key="local.years"/></p>
            </div>
            <div class="col-md-3 col-sm-6 bottom-margin text-center counter-section wow fadeInUp sm-margin-bottom-ten animated"
                 data-wow-duration="600ms"
                 style="visibility: visible; animation-duration: 600ms; animation-name: fadeInUp;"><i
                    class="fa fa-graduation-cap medium-icon"></i> <span class="timer counter alt-font appear"
                                                                        data-to="980"
                                                                        data-speed="7000">980</span> <span
                    class="counter-title"><fmt:message bundle="${loc}" key="local.employees"/></span>
            </div>
            <div class="col-md-3 col-sm-6 bottom-margin-small text-center counter-section wow fadeInUp xs-margin-bottom-ten animated"
                 data-wow-duration="900ms"
                 style="visibility: visible; animation-duration: 900ms; animation-name: fadeInUp;"><i
                    class="fa fa-anchor medium-icon"></i> <span class="timer counter alt-font appear" data-to="810"
                                                                data-speed="7000">810</span> <span
                    class="counter-title"><fmt:message bundle="${loc}" key="local.completed"/></span></div>
            <div class="col-md-3 col-sm-6 text-center counter-section wow fadeInUp animated" data-wow-duration="1200ms"
                 style="visibility: visible; animation-duration: 1200ms; animation-name: fadeInUp;"><i
                    class="fa fa-user medium-icon"></i> <span class="timer counter alt-font appear" data-to="600"
                                                              data-speed="7000">600</span> <span
                    class="counter-title"><fmt:message bundle="${loc}" key="local.clients"/></span>
            </div>
        </div>
    </section>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0"
                                   src="/images/customer_main.jpg"
                                   alt="..."/></div>
        <div class="col-lg-5">
            <h1 class="font-weight-light"><fmt:message bundle="${loc}" key="local.for-customer"/></h1>
            <p><fmt:message bundle="${loc}" key="local.customer-text"/></p>
            <a class="btn btn-primary" href="?command=registration"><fmt:message bundle="${loc}" key="local.call-to-reg1"/></a>
        </div>
    </div>
    <hr>
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
        <div class="col-lg-5">
            <h1 class="font-weight-light"><fmt:message bundle="${loc}" key="local.for-manager"/></h1>
            <p><fmt:message bundle="${loc}" key="local.manager-text"/></p>
            <a class="btn btn-primary" href="?command=registration"><fmt:message bundle="${loc}" key="local.call-to-reg2"/></a>
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
            <h1 class="font-weight-light"><fmt:message bundle="${loc}" key="local.for-developer"/></h1>
            <p><fmt:message bundle="${loc}" key="local.developer-text"/></p>
            <a class="btn btn-primary" href="?command=registration"><fmt:message bundle="${loc}" key="local.call-to-reg3"/></a>
        </div>
    </div>
    <hr>

</div>

<%@ include file="../WEB-INF/jspf/footer.jspf" %>
<%--<jsp:include page="../WEB-INF/jspf/footer.jspf"/>--%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>
