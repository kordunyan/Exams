<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie['locale'].value}"/>
<fmt:setBundle basename="locale/messages"  />
<html>
<head>
    <meta charset="utf-8">
    <title>Add grade</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <link rel='stylesheet' type='text/css' href="<c:url value="/css/jquery-ui.css"/>"/>

</head>
<body>
<jsp:include page="../headNav.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center"><fmt:message key="addgrade.title"/></h3>

            <form class="form-horizontal add-form" id="form-add-grade" action="<c:url value="/add/grade"/>"
                  method="post">
                <input type="hidden" name="subject" value="${param.subject}">
                <c:if test="${messages.containsKey(\"global\")}">
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-9">
                            <div class="alert alert-danger" role="alert"> ${messages.get("global")}</div>
                        </div>
                    </div>
                </c:if>

                <div class="form-group">
                    <label class="col-sm-2 col-sm-offset-2 control-label"><fmt:message key="addgrade.form.subject"/></label>
                    <div class="col-sm-5">
                        <p class="form-info">${subject.title}</p>
                    </div>
                </div>

                <div class="form-group <c:if test="${messages.containsKey(\"createDate\")}">has-error</c:if>">
                    <label class="col-sm-2 col-sm-offset-2 control-label"><fmt:message key="addgrade.form.date"/></label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="createdate" value="${param.createdate}"
                               placeholder="yyyy-mm-dd">
                        <span class="help-block">${messages.get("createDate")}</span>
                    </div>
                </div>

                <div class="form-group <c:if test="${messages.containsKey(\"mark\")}">has-error</c:if>">
                    <label for="mark" class="col-sm-2 col-sm-offset-2 control-label"><fmt:message key="addgrade.form.mark"/></label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="mark" value="${param.mark}" id="mark"
                               placeholder="<fmt:message key="addgrade.form.mark"/>">
                        <span class="help-block">${messages.get("mark")}</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-5">
                        <button type="submit" id="btnSubmit" class="btn btn-primary"><fmt:message key="btn.addgrade"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/jquery.cookie.js"/>"></script>
<script src='<c:url value="/scripts/jquery-ui.js"/>'></script>
<script src='<c:url value="/scripts/ui.datepicker-ru.js"/>'></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>
<script src="<c:url value="/scripts/addGrade.js"/>"></script>

</body>
</html>

