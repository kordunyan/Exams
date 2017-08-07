<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-3">
    <ul class="main-nav nav nav-pills nav-stacked">
        <li role="presentation" <c:if test="${page.equals(\"home\")}">class="active"</c:if>><a href="<c:url value="/"/>">${msg.getString("nav.home")}</a></li>
        <li role="presentation" <c:if test="${page.equals(\"add/subject\")}">class="active"</c:if>><a href="<c:url value="/add/subject"/>">${msg.getString("nav.addSubject")}</a></li>
        <li role="presentation" <c:if test="${page.equals(\"bydate\")}">class="active"</c:if>><a href="<c:url value="/bydate"/>">${msg.getString("nav.grades")}</a></li>
        <li role="presentation" <c:if test="${page.equals(\"database\")}">class="active"</c:if>><a href="<c:url value="/database"/>">${msg.getString("nav.database")}</a></li>

    </ul>
</div>