<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Add subject</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link rel='stylesheet' type='text/css' href='css/jquery-ui.css'/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">

            <h3 class="text-center">Add subject</h3>

            <form class="form-horizontal add-form" action="/add/subject" method="post">
                <div class="form-group <c:if test="${titleError != null}">has-error</c:if>">
                    <label for="subjectTitle" class="col-sm-2 control-label">Title</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="title" value="${param.title}" id="subjectTitle" placeholder="Title">
                        <span class="help-block">${titleError.message}</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Add subject</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="/scripts/jquery-2.1.4.min.js"></script>
<script src="/scripts/bootstrap.min.js"></script>

</body>
</html>

