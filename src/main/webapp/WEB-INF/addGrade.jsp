<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Add grade</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <link rel='stylesheet' type='text/css' href="<c:url value="/css/jquery-ui.css"/>"/>

</head>
<body>

<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">Add grade</h3>

            <c:if test="${subject != null && subject.isEnabled}">
                
                <c:if test="${examError != null}">
                    <div class="alert alert-danger" role="alert"><strong>Oh snap!</strong> ${examError.message}</div>
                </c:if>
                
                <form class="form-horizontal add-form" id="form-add-grade" action="<c:url value="/add/grade"/>" method="post">
                    <input type="hidden" name="subject" value="${param.subject}">
                    <div class="form-group <c:if test="${titleError != null}">has-error</c:if>">
                        <label class="col-sm-2 col-sm-offset-2 control-label">Subject</label>
                        <div class="col-sm-5">
                            <p class="form-info">${subject.title}</p>
                        </div>
                    </div>

                    <div class="form-group <c:if test="${errorDate != null}">has-error</c:if>">
                        <label for="createDate" class="col-sm-2 col-sm-offset-2 control-label">Date</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="createdate" value="${param.createdate}" id="createDate" placeholder="yyyy-mm-dd">
                            <span class="help-block">${errorDate.message}</span>
                        </div>
                    </div>

                    <div class="form-group <c:if test="${errorMark != null}">has-error</c:if>">
                        <label for="mark" class="col-sm-2 col-sm-offset-2 control-label">Mark</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="mark" value="${param.mark}" id="mark" placeholder="mark">
                            <span class="help-block">${errorMark.message}</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <button type="submit" class="btn btn-primary">Add grade</button>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${subject == null}">
                <div class="alert alert-danger" role="alert"><strong>Oh snap!</strong> Such subject not exists</div>
            </c:if>
            <c:if test="${!subject.isEnabled}">
                <div class="alert alert-danger" role="alert"><strong>Subject ${subject.title} is disabled! </strong></div>
            </c:if>
        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src='<c:url value="/scripts/jquery-ui.js"/>'></script>
<script src='<c:url value="/scripts/ui.datepicker-ru.js"/>'></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/addGrade.js"/>"></script>

</body>
</html>

