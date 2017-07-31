<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>All grades</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">All grades of ${subject.title}</h3>

            <a href="<c:url value="/add/grade?subject=${param.subject}"/>" class="btn btn-primary btn-add-grade">+ Add grade</a>

            <table class="table table-striped content-table">
                <thead>
                <tr>
                    <th>
                        <a class="order-link" href="<c:url value="/grades?subject=${subjectId}&order=${!order}"/>">Date
                            <span class="glyphicon
                        <c:choose>
                            <c:when test="${!order}">glyphicon-triangle-bottom</c:when>
                            <c:when test="${order}">glyphicon-triangle-top</c:when>
                        </c:choose>"></span>
                        </a>
                    </th>
                    <th>Mark</th>
                </tr>
                </thead>
                <c:forEach var="exam" items="${exams}">
                    <tr>
                        <td>${exam.createDate}</td>
                        <td>${exam.mark}</td>
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