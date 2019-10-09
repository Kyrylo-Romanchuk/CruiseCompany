<%@include file="static/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> <fmt:message key="profile"/></title>
    <c:import url="static/head.jsp"/>
    <c:import url="static/table.jsp"/>
</head>
<body>
<c:import url="static/menu.jsp"/>


<h1><u><fmt:message key="profile.info"/></u></h1>
 <h1> <fmt:message key="registr.login"/> : ${sessionScope.user.login}</h1>
<h1> <fmt:message key="profile.first.name"/> : ${sessionScope.user.firstName}</h1>

    <h1><fmt:message key="profile.last.name"/> :    ${sessionScope.user.lastName}</h1>


        <h1> <fmt:message key="profile.email"/> :    ${sessionScope.user.email}</h1>


<hr>
<div id="wrapper2">
    <h1><u><fmt:message key="profile.order"/></u></h1>

    <table id="keywords"  cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span> № </span></th>
            <th><span><fmt:message key="cruise.name"/></span></th>
            <th><span><fmt:message key="cruise.from"/></span></th>
            <th><span><fmt:message key="cruise.to"/></span></th>
            <th><span><fmt:message key="cruise.departure"/></span></th>
            <th><span><fmt:message key="cruise.arrival"/></span></th>
            <th><span><fmt:message key="cruise.durability"/></span></th>
            <th><span><fmt:message key="ship.name"/></span></th>
            <th><span><fmt:message key="cruise.category"/></span></th>
            <th><span><fmt:message key="excursion.name"/></span></th>
            <th><span><fmt:message key="order.total.price"/></span></th>
        </tr>
        </thead>
        <c:forEach var="orders" items="${orderItemBeans}">
            <tbody>
            <tr>
                <td class="lalign"><c:out value="${orders.order.order_id}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.name}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.countryFrom.name}"/>(<c:out
                        value="${orders.cruise.countryFrom.city}"/>)</td>
                <td class="lalign"><c:out value="${orders.cruise.countryTo.name}"/>(<c:out
                        value="${orders.cruise.countryTo.city}"/>)</td>
                <td class="lalign"><c:out value="${orders.cruise.departureFormat}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.arrivalFormat}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.durability}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.ship.name}"/></td>
                <td class="lalign"><c:out value="${orders.cruise.category.name()}"/></td>
                <c:choose>
                    <c:when test="${orders.excursion.id == 0}">
                        <td class="lalign"><fmt:message key="none"/></td>
                    </c:when>
                    <c:when test="${orders.excursion != null}">
                        <td class="lalign"><c:out value="${orders.excursion.name}"/></td>
                    </c:when>
                    <c:otherwise>
                        <td class="lalign"><fmt:message key="none"/></td>
                    </c:otherwise>
                </c:choose>
                <td class="lalign"><c:out value="${orders.order.price_total}"/></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
