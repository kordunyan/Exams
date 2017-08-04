<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="text-center">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">

            <li>
                <a href="<c:url value="/?page=1"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${currentPage > 1}">
            <li>
                <a href="<c:url value="/?page=${currentPage-1}"/>" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach var="p" begin="${startPage}" end="${endPage}">
            <li
                    <c:if test="${p == currentPage}">class="active"</c:if>  ><a
                    href="<c:url value="/?page=${p}"/>">${p}</a></li>
        </c:forEach>
        <c:if test="${currentPage < pages}">
            <li>
                <a href="<c:url value="/?page=${currentPage+1}"/>" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${currentPage != pages}">
            <li>
                <a href="<c:url value="/?page=${pages}"/>" aria-label="Previous">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>