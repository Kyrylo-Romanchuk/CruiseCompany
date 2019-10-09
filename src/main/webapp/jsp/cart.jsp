<%@include file="static/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:import url="static/head.jsp"/>
    <link rel="stylesheet" href="css/cruizeStyle.css">
    <title><fmt:message key="cart.list"/></title>

</head>
<body>
<c:import url="static/menu.jsp"/>
<c:forEach var="item" items="${items}">
    <form action="pay" class="form-border">
        <hr>

        <input type="hidden" name="cart_id" value=${item.cart.cart_id}>
        <input type="hidden" name="cruise_id" value=${item.cruise.id}>
        <section id="crCruiseListings">
            <article class="crCruiseListing">
                <div class="crListBox">
                    <figure class="crShipImage">
                        <c:forEach var="image" items="${item.cruise.ship.shipImageList}">
                            <img class="crImgCruize" alt="<c:out value="${item.cruise.ship.name}"/>"
                                 src="<c:out value="${image.uri}"/>"/>
                        </c:forEach>

                        <div>
                            <img class="vlogo" src="images/cruiseCompany.png" alt="Cunard"/>
                            <span class="stars" title="4.4">★★★★</span>
                            <img class="maglass" height="15" width="15" alt="See Details" data-sid="1249"
                                 src="images/magnifying-glass.png"/>
                        </div>
                    </figure>
                    <div class="crCruiseBox">

                        <h3 class="crLengthDestination"><c:out value="${item.cruise.durability}"/>
                            <span class="CruiseTitleDays">★</span><c:out value="${item.cruise.ship.name}"/></h3>
                        <div class="crVendorCruise"><fmt:message key="cruise"/> • <span><c:out value="${item.cruise.name}"/></span>
                        </div>
                        <div class="crPortList"><fmt:message key="cruise.from"/> : <c:out value="${item.cruise.countryFrom.name}"/>(<c:out
                                value="${item.cruise.countryFrom.city}"/>)
                        </div>
                        <div class="crPortList"><fmt:message key="cruise.to"/> : <c:out value="${item.cruise.countryTo.name}"/>(<c:out
                                value="${item.cruise.countryTo.city}"/>)
                        </div>
                        <div class="crSailingDates">
                            <fmt:message key="cruise.departure"/>:
                            <c:out value="${item.cruise.departureFormat}"/></div>
                        <div class="crSailingDates">
                            <fmt:message key="cruise.arrival"/>:
                            <c:out value="${item.cruise.arrivalFormat}"/></div>
                        <div class="crCategory">
                            <fmt:message key="cruise.category"/> :
                            <c:out value="${item.cruise.category.name()}"/>
                            <fmt:message key="cruise.bonuse"/>:
                            <c:out value="${item.cruise.category.bonus}"/>
                        </div>
                        <div class="crCapacityAndPort">
                            <fmt:message key="ship.capacity"/> :
                            <c:out value="${item.cruise.ship.capacity}"/>
                            <fmt:message key="cruise.port"/> :
                            <c:out value="${item.cruise.countPort}"/>
                        </div>
                        <div class="crPrices">
                            <div class="label">
                                <span class="ListingPricesLabel"><fmt:message key="cruise.price"/> :</span></div>

                            <div class="price">
                                <span class="currencyCode">USD </span>$ <c:out value="${item.cruise.price}"/>
                            </div>


                        </div>
                    </div>

                </div>
                <div>
                    <button class="btn btn-success btn-sm"><fmt:message key="cart.pay"/></button>
                </div>

            </article>
        </section>

       <div class="cartTitleExcursion"><h1 align="center"><fmt:message key="excursion.list"/> : </h1></div>
        <div class="cartExcursion">
            <c:choose>

                <c:when test="${item.excursion != null}">
                    <c:forEach items="${item.excursion}" var="excursion">
                        <input type='checkbox' name='excursion_id' value=
                            <c:out value="${excursion.id}"/> id=<c:out value="${excursion.id}"/> />

                        <label for="<c:out value="${excursion.id}"/>">
                            <c:forEach var="image" items="${excursion.excursionImageList}">
                                <img class="imgExcursion" src="<c:out value="${image.uri}"/>/100px180/"
                                     alt="">
                            </c:forEach>
                            <div class="cartExcursionText">
                                <p><fmt:message key="excursion.name"/>:<c:out value="${excursion.name}"/></p>
                                <p><fmt:message key="excursion.description"/> :<c:out value="${excursion.description}"/></p>
                                <p><fmt:message key="excursion.price"/> :<c:out value="${excursion.price}"/></p>
                            </div>
                        </label>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                   <h1 align="center" style="margin-top: 100px"> <p> <fmt:message key="none"/></p></h1>
                </c:otherwise>
            </c:choose>
        </div>
<hr>
    </form>

</c:forEach>

</body>
</html>
