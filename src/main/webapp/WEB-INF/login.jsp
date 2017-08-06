<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <form action="<c:url value="/login"/>" method="post">
                            <c:if test="${messages.containsKey(\"login\")}">
                                <div class="alert alert-danger">
                                    ${messages.get("login")}
                                </div>
                            </c:if>
                            <div class="form-group <c:if test="${messages.containsKey(\"username\")}">has-error</c:if>">
                                <input type="text" class="form-control" name="login" placeholder="Login" value="admin">
                                <span class="help-block">${messages.get("username")}</span>
                            </div>
                            <div class="form-group <c:if test="${messages.containsKey(\"password\")}">has-error</c:if>">
                                <input type="password" class="form-control" name="password" placeholder="Password" value="12345">
                                <span class="help-block">${messages.get("password")}</span>
                            </div>
                            <button type="submit" class="btn btn-default">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>