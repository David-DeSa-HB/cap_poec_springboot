<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Jeux"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Les Jeux</li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}/">Accueil</a></li>
        </ol>
    </nav>

    <div class="d-flex justify-content-between ">
        <div class="d-flex justify-content-center box-blk my-2 box-true">

            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="publishedAt"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Nom"/>
            <c:set var="sortable" value="name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Genre"/>
            <c:set var="sortable" value="genre.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Editeur"/>
            <c:set var="sortable" value="publisher.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <%@ include file="../component/filter-reset.jsp" %>
        </div>

        <c:set var="page" scope="request" value="${pageGames}"/>
        <%@ include file="../component/pagination-number.jsp" %>
    </div>

    <security:authorize access="hasRole('MODERATOR')">
        <div>
            <a href="${UrlRoute.URL_GAME_NEW}" class="btn btn-link">
                <i class="fa fa-circle-plus link-green me-1"></i>
                Ajouter un Jeu
            </a>
        </div>
    </security:authorize>

    <div class="row box-blk">
        <c:forEach items="${pageGames.content}" var="game">
            <%@ include file="../component/entity/game-card.jsp" %>
        </c:forEach>
    </div>

    <c:set var="page" scope="request" value="${pageGames}"/>
    <%@ include file="../component/pagination.jsp" %>

</div>
<%@ include file="../footer.jsp" %>