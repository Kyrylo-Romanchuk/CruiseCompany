<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="static/taglib.jsp" %>
<html>
<head>
    <title><fmt:message key="login.signin"/></title>
    <c:import url="static/head.jsp"/>
</head>
<body>
<c:import url="static/menu.jsp"/>
<div class="wrapper">
    <c:if test="${message!= null}">
        <h2><p align="center"><label style="color:red" class="colortext"> ${message} </label></p></h2>
    </c:if>
    <div class="container">

        <form class="form-signin" action="signin">
            <div class="form-group">
                <h2 align="center"><fmt:message key="login.signin"/></h2>
            </div>
            <div class="form-group">
                <input required name="email" type="email" class="form-control"
                       minlength="3" maxlength="75"
                       placeholder="<fmt:message key="login.email"/>">
            </div>
            <div class="form-group">
                <input type="password" required name="password" class="form-control"
                       minlength="4" maxlength="16" pattern="[A-Za-z0-9]{4,16}"
                       placeholder="<fmt:message key="login.password"/>">
            </div>
            <div class="form-group" align="center">
                <button class="btn btn-success btn-lg"><fmt:message key="login.signin"/></button>
                <a href="${pageContext.request.contextPath}/registration" class="btn btn-warning btn-lg"
                   role="button"><fmt:message key="login.button.create.account"/>
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
