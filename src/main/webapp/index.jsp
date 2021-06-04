<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./webix/webix.css" type="text/css" media="screen" charset="utf-8">
    <script src="./pages/header.js" type="text/javascript" charset="utf-8"></script>
    <script src="./webix/webix.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<script>
    webix.ui({
        rows: [
            getHeader(),
            {
                id: 1622740907326,
                cols: [
                    { view: "template", template: "You can place any widget here..", role: "placeholder" },
                    {
                        autoheight: false,
                        view: "form",
                        rows: [
                            {
                                label: "Registration",
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
                            { view: "button", css: "webix_primary", label: "Save", id: 1622740907339 }
                        ]
                    },
                    { view: "template", template: "You can place any widget here..", role: "placeholder" }
                ]
            }
        ]
    });
</script>
<%--<script>--%>
<%--    webix.ui({--%>
<%--        rows: [--%>
<%--            {--%>
<%--                id: 1622785188193,--%>
<%--                rows: [--%>
<%--                    {--%>
<%--                        height: 53,--%>
<%--                        cols: [--%>
<%--                            {--%>
<%--                                view: "button",--%>
<%--                                height: 52,--%>
<%--                                type: "image",--%>
<%--                                borderless: true,--%>
<%--                                disabled: true,--%>
<%--                                image: "file:///C:/Users/pagubnoe/Desktop/logo.png"--%>
<%--                            },--%>
<%--                            { view: "template", role: placeholder, borderless: true },--%>
<%--                            { view: "template", role: placeholder, borderless: 1 },--%>
<%--                            { view: "template", role: placeholder, borderless: 1 },--%>
<%--                            { label: "Sign in", view: button, height: 52, borderless: 1 },--%>
<%--                            { label: "Sign up", view: button, height: 52, borderless: 1 }--%>
<%--                        ]--%>
<%--                    },--%>
<%--                    {--%>
<%--                        cols: [--%>
<%--                            { view: "template", role: "placeholder", id: 1622785185676, borderless: true },--%>
<%--                            {--%>
<%--                                rows: [--%>
<%--                                    {--%>
<%--                                        height: 0,--%>
<%--                                        cols: [--%>
<%--                                            {--%>
<%--                                                label: "image",--%>
<%--                                                view: "button",--%>
<%--                                                height: 0,--%>
<%--                                                borderless: true,--%>
<%--                                                type: "image",--%>
<%--                                                disabled: true--%>
<%--                                            },--%>
<%--                                            { view: "label", height: 0, borderless: 1 }--%>
<%--                                        ]--%>
<%--                                    },--%>
<%--                                    {--%>
<%--                                        height: 193,--%>
<%--                                        cols: [--%>
<%--                                            { label: "Label", view: "label", height: 0, borderless: 1 },--%>
<%--                                            {--%>
<%--                                                label: "Image",--%>
<%--                                                view: "button",--%>
<%--                                                height: 0,--%>
<%--                                                type: "image",--%>
<%--                                                disabled: true,--%>
<%--                                                borderless: true--%>
<%--                                            }--%>
<%--                                        ]--%>
<%--                                    },--%>
<%--                                    {--%>
<%--                                        height: 223,--%>
<%--                                        cols: [--%>
<%--                                            {--%>
<%--                                                label: "image",--%>
<%--                                                view: "button",--%>
<%--                                                height: 0,--%>
<%--                                                borderless: true,--%>
<%--                                                type: "image",--%>
<%--                                                disabled: true--%>
<%--                                            },--%>
<%--                                            {--%>
<%--                                                rows: [--%>
<%--                                                    { label: "Label", view: "label", height: 0, borderless: 1 },--%>
<%--                                                    { label: "Create account", view: "button", height: 38 }--%>
<%--                                                ],--%>
<%--                                                height: 0--%>
<%--                                            }--%>
<%--                                        ]--%>
<%--                                    }--%>
<%--                                ],--%>
<%--                                width: 681--%>
<%--                            },--%>
<%--                            { view: "template", role: "placeholder", id: 1622785185682, width: 169, borderless: true }--%>
<%--                        ],--%>
<%--                        height: 0--%>
<%--                    }--%>
<%--                ]--%>
<%--            }--%>
<%--        ]--%>
<%--    });--%>
<%--</script>--%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="/hello-servlet">Hello Servlet</a>
</body>
</html>

