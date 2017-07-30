<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All subjects</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

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
                        <td><a href="/grades?subject=${subject.id}">Grades</a></td>
                        <td><a href="/avg?subject=${subject.id}">AVG grade</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

<script src="/scripts/jquery-2.1.4.min.js"></script>
<script src="/scripts/bootstrap.min.js"></script>

</body>
</html>