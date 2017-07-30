<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-3">
    <ul class="main-nav nav nav-pills nav-stacked">
        <li role="presentation" <c:if test="${page.equals(\"home\")}">class="active"</c:if>><a href="/">Home</a></li>
        <li role="presentation"><a href="/addbook">Add subject</a></li>
        <li role="presentation" <c:if test="${page.equals(\"bydate\")}">class="active"</c:if>><a href="/bydate">Grades by date</a></li>
    </ul>
</div>
