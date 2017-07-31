<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All subjects</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">All subjects</h3>

            <table class="table table-striped content-table">
                <thead>
                <tr>
                    <th colspan="4"></th>
                </tr>
                </thead>
                <c:forEach var="subject" items="${subjects}">
                    <tr>
                        <td>${subject.title}</td>
                        <td><a href="<c:url value="/grades?subject=${subject.id}"/>">Grades</a></td>
                        <td><a href="<c:url value="/avg?subject=${subject.id}"/>">AVG grade</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>

</body>
</html>