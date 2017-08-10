<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie['locale'].value}"/>
<fmt:setBundle basename="locale/messages"  />
<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-primary login-panel">
                    <div class="panel-heading"><fmt:message key="login.title"/></div>
                    <div class="panel-body">
                        <form action="<c:url value="/login"/>" method="post">
                            <c:if test="${messages.containsKey(\"login\")}">
                                <div class="alert alert-danger">
                                    ${messages.get("login")}
                                </div>
                            </c:if>
                            <div class="form-group <c:if test="${messages.containsKey(\"username\")}">has-error</c:if>">
                                <input type="text" class="form-control" name="login" placeholder="<fmt:message key="login.input.login"/>" value="admin">
                                <span class="help-block">${messages.get("username")}</span>
                            </div>
                            <div class="form-group <c:if test="${messages.containsKey(\"password\")}">has-error</c:if>">
                                <input type="password" class="form-control" name="password" placeholder="<fmt:message key="login.input.password"/>" value="12345">
                                <span class="help-block">${messages.get("password")}</span>
                            </div>
                            <button type="submit" class="btn btn-default"><fmt:message key="btn.signin"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>