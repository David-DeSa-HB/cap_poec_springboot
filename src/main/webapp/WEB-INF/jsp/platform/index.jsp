<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${platforms.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <h1>Plateformes</h1>
</div>

<div>
    <c:forEach items="${platform}" var="platform">
        <div>
            <div>
                <p>${platform.name}</p>
            </div>
        </div>
    </c:forEach>
</div>

<%@ include file="../footer.jsp" %>