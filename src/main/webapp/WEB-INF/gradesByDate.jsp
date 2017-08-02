<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All subjects</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <link rel='stylesheet' type='text/css' href="<c:url value="/css/jquery-ui.css"/>"/>

</head>
<body>

<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">Grades by date</h3>

            <form class="form-inline form-input-date" action="<c:url value="/bydate"/>">
                <div class="form-group">
                    <label for="createDate">Date</label>
                    <input type="text" class="form-control" name="date" <c:if test="${date != null}">value="${date}"</c:if> id="createDate">
                </div>
                <button type="submit" class="btn btn-default">Show</button>
            </form>

            
            <c:if test="${exams != null && exams.size() > 0 }">
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
            <c:if test="${exams != null && exams.size() == 0 }">
                <div class="alert alert-warning" role="alert">Nothing found on this date</div>
            </c:if>
        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src='<c:url value="/scripts/jquery-ui.js"/>'></script>
<script src='<c:url value="/scripts/ui.datepicker-ru.js"/>'></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/getByDate.js"/>"></script>



</body>
</html>
