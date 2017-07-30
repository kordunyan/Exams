<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All subjects</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel='stylesheet' type='text/css' href='css/jquery-ui.css'/>

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

            <h3 class="text-center">Grades by date</h3>

            <form class="form-inline form-input-date" action="/bydate">
                <div class="form-group">
                    <label for="createDate">Date</label>
                    <input type="text" class="form-control" name="date" <c:if test="${date != null}">value="${date}"</c:if> id="createDate">
                </div>
                <button type="submit" class="btn btn-default">Show</button>
            </form>

            
            <c:if test="${date != null}">
                <table class="table table-striped content-table">
                    <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Mark</th>
                    </tr>
                    </thead>
                    <c:forEach items="${exams}" var="exam">
                        <tr>
                            <td>${exam.subject.title}</td>
                            <td>${exam.mark}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>

<script src="scripts/jquery-2.1.4.min.js"></script>
<script src='scripts/jquery-ui.js'></script>
<script src='scripts/ui.datepicker-ru.js'></script>
<script src="scripts/bootstrap.min.js"></script>
<script src="scripts/getByDate.js"></script>



</body>
</html>