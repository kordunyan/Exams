<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${cookie['locale'].value}"/>
<fmt:setBundle basename="locale/messages"  />
<c:set var="language" value="${not empty cookie['locale'] ? cookie['locale'].value : 'en' }"/>

<div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >
                <c:choose>
                    <c:when test="${language.equals('en')}">
                        <img  src="<c:url value="/img/en_lang.png"/>"/> <span class="nav-lang">en</span><span class="caret"></span>
                    </c:when>
                    <c:when test="${language.equals('ua')}">
                        <img  src="<c:url value="/img/ua_lang.png"/>"/> <span class="nav-lang">ua</span><span class="caret"></span>
                    </c:when>
                </c:choose>
              </a>
              <ul class="dropdown-menu">
                  <c:choose>
                      <c:when test="${!language.equals('en')}">
                          <li><a href="<c:url value="/setlocale?locale=en"/>"><img src="<c:url value="/img/en_lang.png"/>"/> en</a></li>
                      </c:when>
                      <c:when test="${!language.equals('ua')}">
                          <li><a href="<c:url value="/setlocale?locale=ua"/>"><img src="<c:url value="/img/ua_lang.png"/>"/> ua</a></li>
                      </c:when>
                  </c:choose>
              </ul>
            </li>
            <li class="dropdown">
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.user.login} <span class="caret"></span></a>
                 <ul class="dropdown-menu">
                    <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> <fmt:message key="nav.logout"/></a></li>
                </ul>
            </li>
          </ul>
      </div>
    </nav>
</div>


