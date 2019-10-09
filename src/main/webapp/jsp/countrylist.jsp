<%@include file="static/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> <fmt:message key="country.list"/></title>
    <c:import url="static/head.jsp"/>
    <c:import url="static/table.jsp"/>

</head>
<body>
<c:import url="static/menu.jsp"/>
<div id="wrapper">
<h1><fmt:message key="menu.country"/></h1>

<table id="keywords" cellspacing="0" cellpadding="0">
<thead>
<tr>
    <th><span> № </span></th>
    <th><span><fmt:message key="country.name"/></span></th>
    <th><span><fmt:message key="country.city"/></span></th>
    <th colspan="2"><span><fmt:message key="label.action"/></span></th>
</tr>
</thead>
<c:forEach var="country" items="${countries}">
    <tbody>
    <tr>
    <td class="lalign"><c:out value="${country.id}"/></td>
    <td class="lalign"><c:out value="${country.name}"/></td>
    <td class="lalign"><c:out value="${country.city}"/></td>
        <td class="lalign">
            <a href="${pageContext.request.contextPath}/countryedit?id=<c:out value='${country.id}' />" class="btn btn-warning btn-sm"><fmt:message key="button.edit"/></a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/countrydelete?id=<c:out value='${country.id}' />" class="btn btn-success btn-sm"><fmt:message key="button.delete"/></a>
        </td>
    </tr>
    </tbody>
</c:forEach>
    </table>
    <div align = "center">
    <a href="${pageContext.request.contextPath}/countryadd?id=<c:out value='${country.id}' />"
       class="btn btn-primary btn-sm"><fmt:message key="button.add"/></a>
    </div>
    </div>
    </body>
    </html>
