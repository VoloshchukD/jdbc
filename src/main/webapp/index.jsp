<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDateTime" %>

<%--<%@ taglib uri="letsCodeTags" prefix="lct" %>--%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="./libs/webix/webix.css" type="text/css" media="screen" charset="utf-8">
    <link rel="h" href="./libs/webix/webix.css" type="text/css" media="screen" charset="utf-8">
<%--    <script src="./js/header.js" type="text/javascript" charset="utf-8"></script>--%>
    <script src="./libs/webix/webix.js" type="text/javascript" charset="utf-8"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="loc" />
    <fmt:message bundle="${loc}" key="local.message" var="message" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />

<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="author" content="">--%>
<%--    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">--%>

<%--    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">--%>

    <!-- Bootstrap core CSS -->
<%--    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
<%--    <link href="signin.css" rel="stylesheet">--%>
</head>
<body>

<form action="${pageContext.request.contextPath}/hello" method="post">
    <input type="submit" value="tap me" /><br />
</form>



<form action="${pageContext.request.contextPath}/hello" method="post">
    <input type="hidden" name="local" value="ru" /> <input type="submit" value="${ru_button}" /><br />
</form>

<form action="${pageContext.request.contextPath}/hello" method="post">
    <input type="hidden" name="local" value="en" /> <input type="submit" value="${en_button}" /><br />
</form>

<c:out value="${message}" />

<script>
    webix.ui({
        rows: [
            getHeader(),
            {
                id: 1622740907326,
                cols: [
                    { view: "template", template: "You can place any widget here..", role: "placeholder" },
                    {
                        id: "log_form",
                        autoheight: false,
                        view: "form",
                        rows: [
                            {
                                label: "${LocalDateTime.now()}",
                                view: "label",
                                height: 38,
                                borderless: 0,
                                align: "center",
                                id: 1622740907327
                            },
                            {
                                view: "text",
                                label: "Email",
                                name: "email",
                                height: 38,
                                id: 1622740907328,
                                type: "email"
                            },
                            { label: "Password", view: "text", height: 38, id: 1622740907329, type: "password" },
                            { view: "text", name: "name", label: "First name", id: 1622740907330, type: "text" },
                            { label: "Last name", "view": "text", "height": 38, "id": 1622740907331, type: "text" },
                            { label: "Company", "view": "text", "height": 38, "id": 1622740907332, type: "text" },
                            {
                                label: "Role",
                                view: "select",
                                options:[
                                    { id:1, value:"Customer" },
                                    { id:2, value:"Manager" },
                                    { id:3, value:"Developer" }
                                ],
                                height: 38,
                                id: 1622740907333
                            },
                            { label: "Position", view: "text", height: 38, id: 1622740907334, type: "text" },
                            {
                                label: "Experience",
                                view: "text",
                                height: 38,
                                id: 1622740907335,
                                type: "number",
                                placeholder: "years"
                            },
                            {
                                label: "Salary",
                                view: "text",
                                height: 38,
                                id: 1622740907336,
                                type: "number",
                                placeholder: "$"
                            },
                            {
                                label: "Primary skill",
                                view: "text",
                                height: 38,
                                id: 1622740907337,
                                type: "text",
                                placeholder: "Exmpl: Node.js"
                            },
                            { label: "Skills description", view: "textarea", id: 1622740907338 },
                            { view: "button", css: "webix_primary", label: "Save",
                                id: 1622740907339,
                                click: function () {
                                    webix.send("http://localhost:8080/jdbc_war_exploded/hello", $$("log_form").getValues());
                                }
                            }
                        ]
                    },
                    { view: "template", template: "You can place any widget here..", role: "placeholder" }
                ]
            }
        ]
    });
</script>
<%--<form method="post" action="${pageContext.request.contextPath}/hello" class="form-signin">--%>
<%--    <label for="inputEmail" class="sr-only">Email address</label>--%>
<%--    <input name="inputEmail" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>--%>
<%--    <label for="inputPassword" class="sr-only">Password</label>--%>
<%--    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
<%--    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
<%--    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>--%>
<%--</form>--%>

<%--<lct:emptyTag />--%>
<%--<%=LocalDateTime.now()%>--%>

</body>
</html>

