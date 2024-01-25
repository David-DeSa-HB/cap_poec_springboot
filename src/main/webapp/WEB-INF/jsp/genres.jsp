<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="${genres.name}"/>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Genres</h1>
</div>

<div>
    <c:forEach items="${genre}" var="genre">
        <div>
            <div>
                <p>${genre.name}</p>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="footer.jsp" %>