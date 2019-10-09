<%@include file="static/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="static/head.jsp"/>
    <c:if test="${country != null}">
   <title> <fmt:message key="country.edit"/></title>
        </c:if>
        <c:if test="${country == null}">
        <title> <fmt:message key="country.addNew"/></title>
            </c:if>
</head>
<body>
<c:import url="static/menu.jsp"/>
<div class="container">
    <c:if test="${country != null}">
    <form class="form-signin" action="countryupdate" method="post">
        </c:if>
        <c:if test="${country == null}">
            <form class="form-signin" action="countryadded" method="post">
            </c:if>


        <div class="form-group">
            <h2 align="center">
                <c:if test="${ country != null}">
                    <fmt:message key="country.edit"/>
                </c:if>
                <c:if test="${country == null}">
                    <fmt:message key="country.addNew"/>
                </c:if>

            </h2>
        </div>
                <input type="hidden" name="id" value="<c:out value='${country.id}' />" />
        <div class="form-group">
            <input required name="name" type="text" class="form-control"
                   minlength="2" maxlength="16"
                   placeholder=" <fmt:message key="country.name"/>" value="<c:out value='${country.name}' />">
        </div>
        <div class="form-group">
            <input type="text" required name="city" class="form-control"
                   minlength="2" maxlength="16"
                   placeholder=" <fmt:message key="country.city"/>" value="<c:out value='${country.city}' />">
        </div>
        <div class="form-group" align="center">
            <button class="btn btn-success btn-lg"> <fmt:message key="button.add"/></button>
        </div>
    </form>
    </form>
</div>
</body>
</html>
