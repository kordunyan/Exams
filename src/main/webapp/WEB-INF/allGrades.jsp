<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>All grades</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">All grades of ${subject.title}</h3>

            <a href="" class="btn btn-primary btn-add-grade">+ Add grade</a>

            <table class="table table-striped content-table">
                <thead>
                <tr>
                    <th>
                        <a class="order-link" href="/grades?subject=${subjectId}&order=${!order}">Date
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

<script src="scripts/jquery-2.1.4.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>

</body>
</html>