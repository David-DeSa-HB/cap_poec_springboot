<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="${user.nickname}"/>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Home de test</h1>
</div>

<%@ include file="footer.jsp" %>
