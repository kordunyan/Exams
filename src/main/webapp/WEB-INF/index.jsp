<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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

            <table class="table content-table">
                <thead>
                <tr>
                    <th colspan="4"></th>
                </tr>
                </thead>
                <c:forEach var="subject" items="${subjects}">
                    <tr <c:if test="${!subject.isEnabled}">class="warning"</c:if>>
                        <td>${subject.title}</td>
                        <td><a href="<c:url value="/grades?subject=${subject.id}"/>">Grades</a></td>
                        <td><a href="<c:url value="/avg?subject=${subject.id}"/>">AVG grade</a></td>
                        <td class="text-right">
                            <form class="without-margin form-delete-subject" action="#" method="get">
                                <input type="hidden" name="subject" value="${subject.id}"/>
                                <input type="submit" value="Delete" class="btn btn-default"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <jsp:include page="../pagination.jsp"/>
        </div>
    </div>
</div>


<div class="modal fade" id="countedSubject" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Delete subject ?</h4>
            </div>
            <div class="modal-body">
                <p id="delete-subject-modal-content"></p>
            </div>
            <div class="modal-footer">
                <form class="form-inline" action="<c:url value="/subject/delete"/>" method="post">
                    <input type="hidden" name="subject" id="input-delete-subject"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Delete</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="error-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Error !</h4>
            </div>
            <div class="modal-body">
                <p>Server error. Please try later</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Delete</button>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/indexPage.js"/>"></script>

</body>
</html>