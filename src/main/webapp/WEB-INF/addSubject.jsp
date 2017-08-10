<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie['locale'].value}"/>
<fmt:setBundle basename="locale/messages"  />
<html>
<head>
    <meta charset="utf-8">
    <title>Add subject</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>
<body>
<jsp:include page="../headNav.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center"><fmt:message key="addsubject.title"/></h3>

            <form class="form-horizontal add-form" id="formAddSubject" action="<c:url value="/add/subject"/>" method="post">
                <div class="form-group <c:if test="${messages.containsKey(\"title\")}">has-error</c:if>">
                    <label for="subjectTitle" class="col-sm-2 control-label"><fmt:message key="addsubject.form.title"/></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="title" value="${param.title}" id="subjectTitle" placeholder="<fmt:message key="addsubject.form.title"/>">
                        <span class="help-block">${messages.get("title")}</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="btnSubmit" class="btn btn-primary"><fmt:message key="btn.add.subject"/></button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/jquery.cookie.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/addSubject.js"/>"></script>

</body>
</html>

