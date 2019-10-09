<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/jsp/static/taglib.jsp" %>
<!-- NAVBAR -->

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/main"><fmt:message key="menu.main"/><span
                        class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/cruise"><fmt:message key="menu.cruise"/></a></li>

                <c:if test="${sessionScope.role == 'ADMIN' }">
                     <li class="dropdown">
                         <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message key="menu.admin"/><span
                                 class="caret"></span></a>
                         <ul class="dropdown-menu" role="menu">
                             <li><a href="${pageContext.request.contextPath}/country"><fmt:message key="menu.country"/></a></li>
                             <li><a href="${pageContext.request.contextPath}/ship"><fmt:message key="menu.ship"/></a></li>
                             <li><a href="${pageContext.request.contextPath}/cruise"><fmt:message key="menu.cruises"/></a></li>
                             <li><a href="${pageContext.request.contextPath}/orderall"><fmt:message key="menu.orders"/></a></li>
                             <li class="divider"></li>
                         </ul>
                     </li>
                 </c:if>

            </ul>


            <ul class="nav navbar-nav navbar-right">

                <li><a href="${pageContext.request.contextPath}/contact">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <li><a href="${pageContext.request.contextPath}/login"> <fmt:message key="menu.login"/></a></li>
                        <li><a href="${pageContext.request.contextPath}/registration"> <fmt:message key="menu.registr"/> </a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">${sessionScope.userName}<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="${pageContext.request.contextPath}/profile"><fmt:message key="menu.profile"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/logout"><fmt:message key="menu.logout"/></a></li>
                                <li class="divider"></li>

                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/cart"><img class="cart"
                                                                                   src="${pageContext.request.contextPath}/images/cart.png"></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <%--------------Language--%>
            <form class="navbar-form" >
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="label.lang.en"/></option>
                    <option value="uk" ${language == 'uk' ? 'selected' : ''}><fmt:message key="label.lang.uk"/></option>

                </select>
            </form>
            <%--------------Language--%>

        </div><!-- /.navbar-collapse -->

    </div><!-- /.container -->

</nav>
<!-- NAVBAR END -->


