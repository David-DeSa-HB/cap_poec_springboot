<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${business_models.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <h1>Modèles Economiques</h1>
</div>

<div>
    <c:forEach items="${business_model}" var="business_model">
            <div>
                <div>
                    <p>${business_model.name}</p>
                </div>
            </div>
    </c:forEach>
</div>

<%@ include file="../footer.jsp" %>