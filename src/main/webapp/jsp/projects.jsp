<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="../WEB-INF/jspf/header.jspf" %>
    <title><fmt:message bundle="${loc}" key="local.projects"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/projects.css">
</head>
<body>
<div class="container-xxl">
    <div class="container py-3">
        <div class="title h1 text-center">Your Projects</div>
        <c:forEach items="${projects}" var="project">
        <div class="card">
            <div class="row ">
                <div class="col-md-7 px-3">
                    <div class="card-block px-6">
                        <h4 class="card-title">${project.name}</h4>
                        <p class="card-text">${project.description}</p>
                        <p class="card-text"></p>
                        <a href="#" class="mt-auto btn btn-primary  ">Read More</a>
                    </div>
                </div>
                <div class="col-md-5">
                    <img class="d-block" src="https://picsum.photos/450/300?image=1072" alt="">
                </div>
            </div>
        </div>
        </c:forEach>
    </div>

        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="?command=projects&projectsPerPage=${projectsPerPage}&currentPage=1">First</a>
                </li>
            </c:if>
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="?command=projects&projectsPerPage=${projectsPerPage}&currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${allPagesNumber}" var="i" varStatus="theCount">
<%--                ${theCount.count}--%>
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${(currentPage eq i - 1) || (currentPage eq i + 1)}">
                            <li class="page-item"><a class="page-link"
                                                     href="?command=projects&projectsPerPage=${projectsPerPage}&currentPage=${i}">${i}</a>
                            </li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage < allPagesNumber}">
                <li class="page-item"><a class="page-link"
                                         href="?command=projects&projectsPerPage=${projectsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>

            <c:if test="${currentPage != allPagesNumber}">
                <li class="page-item"><a class="page-link"
                                         href="?command=projects&projectsPerPage=${projectsPerPage}&currentPage=${allPagesNumber}">Last</a>
                </li>
            </c:if>
        </ul>

    </main>
</div>
<%@ include file="../WEB-INF/jspf/footer.jspf" %>
</body>
</html>
