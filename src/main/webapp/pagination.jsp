<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="text-center">
    <ul class="pagination">
        <c:if test="${pagination.current != 1}">
            <li>
                <a href="<c:url value="${pagination.url}1"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pagination.current > 1}">
            <li>
                <a href="<c:url value="${pagination.url}${pagination.current-1}"/>" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pagination.countPages > 1}">
            <c:forEach var="p" begin="${pagination.start}" end="${pagination.end}">
                <li <c:if test="${p == pagination.current}">class="active"</c:if>  >
                    <a href="<c:url value="${pagination.url}${p}"/>">${p}</a>
                </li>
            </c:forEach>
        </c:if>
        <c:if test="${pagination.current < pagination.countPages}">
            <li>
                <a href="<c:url value="${pagination.url}${pagination.current+1}"/>" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pagination.current != pagination.countPages && pagination.countPages != 0}">
            <li>
                <a href="<c:url value="${pagination.url}${pagination.countPages}"/>" aria-label="Previous">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>