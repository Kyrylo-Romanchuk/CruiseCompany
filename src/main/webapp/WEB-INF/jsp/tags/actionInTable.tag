<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="url" %>
<%@ attribute name="method" %>
<%@ attribute name="id" %>

<c:set var="formId" value="${method}-${url.replace('/', '-')}-${id}}"/>
<form method="${method}" action="${url}" class="btn btn-sm btn-dark" id= ${formId}>
    <input type="hidden" name="id" value="${id}">
<%--        <div onclick="$('#${formId}').submit();">--%>
        <div onclick="document.forms['${formId}'].submit();">
            <jsp:doBody/>
        </div>
</form>