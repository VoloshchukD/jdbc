<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>

<form action="${pageContext.request.contextPath}/hello" method="post">
<div >
    <div >
        <h4>Sign In to Teams</h4>
    </div>
    <div>
        <input type="email" placeholder="email">
    </div>
    <div >
        <input type="password" placeholder="password">
    </div>
    <input type="hidden" name="command" value="authorization">
    <div >
        <button type="submit">Sign In</button>
    </div>
</div>
</form>

</body>
</html>
