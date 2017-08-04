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
                        <form>
                            <div class="form-group">

                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Login">
                            </div>
                            <div class="form-group">

                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
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
