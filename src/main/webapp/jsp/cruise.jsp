<%@include file="static/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cruizeStyle.css">
    <c:import url="static/head.jsp"/>
    <title><fmt:message key="cruise"/></title>
</head>

<body>
<c:import url="static/menu.jsp"/>

<p align="center"><label class="colortext"> ${msg} </label></p>

<c:forEach var="cruise" items="${cruises}">

    <section id="crCruiseListings">
        <article class="crCruiseListing">
            <div class="crListBox">
<%--                <figure class="crShipImage">--%>
<%--                    <div>--%>
<%--                        <span class="stars" title="4.4">★★★★</span>--%>
<%--                        <img class="maglass" height="15" width="15" alt="See Details" data-sid="1249"--%>
<%--                             src="${pageContext.request.contextPath}/images/magnifying-glass.png"/>--%>
<%--                    </div>--%>
<%--                </figure>--%>
<%--                <div class="crCruiseBox">--%>

                    <h3 class="crLengthDestination"><c:out value="${cruise.durability}"/>
                        <span class="CruiseTitleDays">★</span><c:out value="${cruise.ship.name}"/></h3>
                    <div class="crVendorCruise"><fmt:message key="cruise"/> • <span><c:out value="${cruise.name}"/></span>
                    </div>
                    <div class="crPortList"><fmt:message key="cruise.from"/>: <c:out value="${cruise.countryFrom.name}"/>(<c:out
                            value="${cruise.countryFrom.city}"/>)
                    </div>
                    <div class="crPortList"><fmt:message key="cruise.to"/> : <c:out value="${cruise.countryTo.name}"/>(<c:out
                            value="${cruise.countryTo.city}"/>)
                    </div>
                    <div class="crSailingDates">

                        <fmt:message key="cruise.departure"/> :
                        <c:out value="${cruise.departureFormat}"/>
                    </div>
                    <div class="crSailingDates">
                        <fmt:message key="cruise.arrival"/>:
                        <c:out value="${cruise.arrivalFormat}"/>
                    </div>
                    <div class="crCategory">

                        <fmt:message key="cruise.category"/> :
                        <c:out value="${cruise.category.name()}"/>
                        <fmt:message key="cruise.bonuse"/> :

                        <c:out value="${cruise.category.bonus}"/>
                    </div>
                    <div class="crCapacityAndPort">
                        <fmt:message key="ship.capacity"/> :
                        <c:out value="${cruise.ship.capacity}"/>
                        <fmt:message key="cruise.port"/> :
                        <c:out value="${cruise.countPort}"/>
                    </div>
                    <div class="crPrices">
                        <fmt:message key="cruise.price"/>: :
                        <div class="price">
                            <span class="currencyCode">USD </span>$ <c:out value="${cruise.price}"/>
                        </div>


                    </div>
<%--                </div>--%>

            </div>
            <div class="crButtonAddToCart" align="right">
                <a href="${pageContext.request.contextPath}/cruise_card?id=<c:out value='${cruise.id}' />"
                   class="btn btn-primary"><fmt:message key="cruise.add.to.cart"/></a>
            </div>
        </article>

    </section>
</c:forEach>
<div class="col-sm-12" align="center">
    <hr>
    <div class="col-ms-4">
        <c:forEach begin="1" end="${requestScope.page}" var="i">
            <a href="${pageContext.request.contextPath}/${requestScope.pathPage}/${i}">${i}</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </c:forEach>
    </div>

</div>
<div class="col-sm-12">
<hr>
<footer>
    <p align="center">&copy;Cruise Company </p>
</footer>
</div>
</body>
</html>
