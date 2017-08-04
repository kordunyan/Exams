<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Add subject</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="row">
        <jsp:include page="../nav.jsp"/>

        <div class="col-md-9 main-book-wraper">
            <h3 class="text-center">Database</h3>

                        <form class="form-horizontal add-form" id="formAddSubject" action="<c:url value="/dtabase/upload"/>" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="col-sm-10 col-sm-offset-2">
                                     <input type="file" name="dump" id="exampleInputFile" class="form-group">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">Load</button>
                                    <a href="<c:url value="/database/dump"/>" class="btn btn-default">Dump</a>
                                </div>
                            </div>
                        </form>



        </div>
    </div>
</div>

<script src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/scripts/bootstrap.min.js"/>"></script>

</body>
</html>
