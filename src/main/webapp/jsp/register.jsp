<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="static/taglib.jsp" %>
<html>
<head>
    <c:import url="static/head.jsp"/>
    <title><fmt:message key="menu.registr"/> </title>
</head>
<body>
<c:import url="static/menu.jsp"/>
<div class="wrapper">
<div class="container">
    <div class="row">
        <div class="col-md-12">
    <form class="form-signin" action="signup" method="post">
        <p align="center"><label style="color:red" class="colortext"> ${messageRegister} </label></p>
        <div class="form-group">
        <h2 align="center"><fmt:message key="registr.signup"/> </h2>
        </div>
        <div class="form-group">
            <input placeholder="<fmt:message key="registr.login"/>"
                   minlength="3" maxlength="25" required
                   pattern="^[A-Za-z0-9_]{3,75}$"
                   class="form-control" title="<fmt:message key="registr.login"/>" name="login">
        </div>
        <div class="form-group">
            <input placeholder="<fmt:message key="registr.password"/>"
                   minlength="4" maxlength="16" type="password" name="password"
                   pattern="[A-Za-z0-9]{4,16}"
                   title="<fmt:message key="registr.password"/>"
                   required class="form-control">
        </div>
        <div class="form-group">
            <input placeholder="<fmt:message key="registr.first.name"/>"
                   minlength="3" maxlength="25" required
                   pattern="^[A-Za-z0-9_]{3,75}$"
                   class="form-control" title="" name="firstName">
        </div>
        <div class="form-group">
            <input placeholder="<fmt:message key="registr.last.name"/>"
                   minlength="3" maxlength="25" required
                   pattern="^[A-Za-z0-9_]{3,75}$"
                   class="form-control" title="" name="lastName">
        </div>

        <div class="form-group">
            <input type="email" placeholder="<fmt:message key="registr.email"/>"
                   minlength="5" maxlength="100" required
                   class="form-control" name="email">
        </div>
        <div class="form-group" align="center">
            <button class="btn btn-success btn-lg"><fmt:message key="registr.signup"/></button>
        <a href="${pageContext.request.contextPath}/" class="btn btn-warning btn-lg" role="button"><fmt:message key="button.cancel"/></a>

        </div>
    </form>
</div>
    </div>
</div>
</div>
</body>
</html>
