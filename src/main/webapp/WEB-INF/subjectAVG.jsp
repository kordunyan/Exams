<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>AVG grade</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">AVG grade of ${curSubject.title}</h3>

            <form class="form-inline form-input-date" action="<c:url value="/avg"/>">
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
            <c:if test="${curSubject != null && avg != null}">
                <h4 class="p-avg">AVG grade = ${avg}</h4>
            </c:if>
            <c:if test="${curSubject != null && avg == null}">
                <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    Subject ${subject.title} dont have any marks
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>

</body>
</html>
