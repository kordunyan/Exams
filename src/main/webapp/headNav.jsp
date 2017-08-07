<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >
                <c:forEach var="locale" items="${locales}">
                    <c:if test="${lang.equals(locale.getTitle())}">
                        <img  src="<c:url value="/img/${locale.getImg()}"/>"/> <span class="nav-lang">${locale.getTitle()}</span><span class="caret"></span>
                    </c:if>
                 </c:forEach>
              </a>
              <ul class="dropdown-menu">
                <c:forEach var="locale" items="${locales}">
                    <c:if test="${!lang.equals(locale.getTitle())}">
                        <li><a href="<c:url value="/setlocale?locale=${locale.getTitle()}"/>"><img  src="<c:url value="/img/${locale.getImg()}"/>"/> ${locale.getTitle()}</a></li>
                    </c:if>
                </c:forEach>
              </ul>
            </li>
            <li class="dropdown">
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.user.login} <span class="caret"></span></a>
                 <ul class="dropdown-menu">
                    <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> ${msg.getString("nav.logout")}</a></li>
                </ul>
            </li>
          </ul>
      </div><!-- /.container-fluid -->
    </nav>
</div>


