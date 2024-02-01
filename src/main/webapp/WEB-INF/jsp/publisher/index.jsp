<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${publishers.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <h1>Editeurs</h1>
</div>

<div>
    <c:forEach items="${publisher}" var="publisher">
        <div>
            <div>
                <p>${publisher.name}</p>
            </div>
        </div>
    </c:forEach>
</div>

<%@ include file="../footer.jsp" %>