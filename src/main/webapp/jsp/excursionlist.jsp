<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
</head>
<body>

<div align="center">
    <p align="center"><label class="colortext"> ${msg} </label></p>
    <table style="width:100%">
        <h2>Excursion List</h2>
        <c:forEach var="excursion" items="${excursions}">
            <tr>
                <th>excursion_id</th>
                <td><c:out value="${excursion.id}"/></td>
            </tr>
            <tr>
                <th>country</th>
                <td><c:out value="${excursion.country}"/></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><c:out value="${excursion.name}"/></td>
            </tr>
            <tr>
                <th>description</th>
                <td><c:out value="${excursion.description}"/></td
            </tr>
            <tr>
                <th>price</th>
                <td><c:out value="${excursion.price}"/></td>
            </tr>
<%--            <c:forEach var="image" items="${excursion.excursionImageList}">--%>
<%--                <tr>--%>
<%--                    <th>URI</th>--%>
<%--                    <td><c:out value="${image.uri}"/></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            <tr>
                <th>&nbsp</th>
                <td>&nbsp</td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
