<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<jsp:useBean id="userbean" class="by.voloshchuk.JSPSetBean" scope="request" />

<mytag:jspset set="${userbean}" />

<br/>

<mytag:bodyjspset num="${userbean.size}">
    ${userbean.element}
</mytag:bodyjspset>

</body>
</html>

