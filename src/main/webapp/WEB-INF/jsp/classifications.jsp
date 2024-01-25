<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="${classifications.name}"/>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Classifications</h1>
</div>
<div>
    <c:forEach items="${classification}" var="classification">
        <div>
            <div>
                <p>${classification.name}</p>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="footer.jsp" %>