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
<jsp:include page="../headNav.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">${msg.getString("allgrades.title")} ${subject.title}</h3>
            <c:if test="${subject.isEnabled}">
                <a href="<c:url value="/add/grade?subject=${param.subject}"/>" class="btn btn-primary btn-add-grade">${msg.getString("btn.addGrade")}</a>
            </c:if>
            <c:if test="${exams != null && exams.size() > 0 }">
                <table class="table table-striped content-table">
                    <thead>
                    <tr>
                        <th>
                            <a class="order-link" href="<c:url value="/grades?subject=${subjectId}&order=${!order}"/>">${msg.getString("allgrades.table.date")}
                                <span class="glyphicon
                        <c:choose>
                            <c:when test="${!order}">glyphicon-triangle-bottom</c:when>
                            <c:when test="${order}">glyphicon-triangle-top</c:when>
                        </c:choose>"></span>
                            </a>
                        </th>
                        <th colspan="2">${msg.getString("allgrades.table.mark")}</th>
                    </tr>
                    </thead>
                    <c:forEach var="exam" items="${exams}">
                        <tr>
                            <td>${exam.createDate}</td>
                            <td>${exam.mark}</td>
                            <td class="text-right">
                                <form action="#" class="without-margin form-delete-mark">
                                    <input type="hidden" name="mark" value="${exam.id}">
                                    <input type="submit" value="${msg.getString("btn.delete")}" class="btn btn-default">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${exams != null && exams.size() == 0 }">
                <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    This subject not have a mark
                </div>
            </c:if>


        </div>
        <div class="row">
            <div class="col-md-offset-3 col-md-9">
                <jsp:include page="../pagination.jsp"/>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="countedSubject" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Delete mark ?</h4>
            </div>
            <div class="modal-body">
                <p id="delete-subject-modal-content">Are you sure to delete this mark ?</p>
            </div>
            <div class="modal-footer">
                <form class="form-inline" action="<c:url value="/mark/delete"/>" method="post">
                    <input type="hidden" name="subject" value="${param.subject}"/>
                    <input type="hidden" name="mark" id="input-delete-mark"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Delete</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/allGeades.js"/>"></script>

</body>
</html>