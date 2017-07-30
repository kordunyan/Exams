<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>AVG grade</title>

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

            <h3 class="text-center">AVG grade of ${curSubject.title}</h3>

            <form class="form-inline form-input-date" action="/avg">
                <div class="form-group">
                    <label for="subjectList">Subject</label>
                    <select name="subject" id="subjectList" class="form-control">
                        <option value="0">Select subject</option>
                        <c:forEach items="${subjects}" var="subject">
                            <option <c:if test="${curSubject.equals(subject)}">selected</c:if> value="${subject.id}">${subject.title}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Show</button>
            </form>
            <c:if test="${curSubject != null}">
                <h4 class="p-avg">AVG grade = ${avg}</h4>
            </c:if>
        </div>
    </div>
</div>

<script src="scripts/jquery-2.1.4.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>

</body>
</html>
