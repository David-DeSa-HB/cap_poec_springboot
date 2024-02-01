<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${game.name}"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}/">Accueil</a></li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAMES}">Les jeux</a></li>
            <li class="breadcrumb-item active" aria-current="page">${game.name}</li>
            <li class="breadcrumb-item active"><a class="btn-link" href="#game-reviews">Les commentaires</a></li>
        </ol>
    </nav>
    <div class="row d-flex justify-content-evenly">
        <div class="col-md-4 col-sm-12">
            <div class="container-img p-3">
                <img alt="${game.name}" src="${game.image}">
            </div>
        </div>
        <div class="col-md-6 col-sm-12 pt-4">
            <div class="d-flex justify-content-start">
            <h1>${game.name}</h1>
            <security:authorize access="hasRole('MODERATOR')">

                <a class="btn btn-link rating-5"
                   href="${UrlRoute.URL_GAME_DELETE}/${game.id}"
                   title="Supprimer"
                >
                    <i class="fa-solid fa-xmark fa-2x"></i>
                </a>
            </security:authorize>
            </div>
            <div class="box-blk mt-5">
                <c:if test="${game.platforms.size() > 0}">
                    <div class="d-flex justify-content-start">
                    <p class="m-0">Disponible sur : </p>
                    <ul class="list-unstyled">
                        <c:forEach items="${game.platforms}" var="platform">
                            <li>
                                <a class="link-if" href="#">
                                        ${platform.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    </div>
                    <p class="mt-2">Parution: ${game.publishedAt}</p>
                    <p class="mt-2">Genre: ${game.genre.name}</p>
                    <p class="mt-2">Editeur: ${game.businessModel.name}</p>
                    <p class="mt-2">Modèle Economique: ${game.publisher.name}</p>
                    <p class="mt-2">Classification: ${game.classification.name}</p>

                </c:if>
            </div>
        </div>
    </div>

    <div class="box-blk">
        <h2 class="my-5">Description</h2>

        <div class="text-center description">
            <c:out value="${game.description}" escapeXml="false"/>
        </div>

    </div>

    <div id="game-reviews" class="my-5 box-blk">
        <h2>
            Commentaires
            <button class="ms-2 btn btn-link"
                    title="Ajouter un commentaire"
                    data-hide-show-button="formReview"
            >
                <i class="fa fa-pen fa-2x"></i>
            </button>
        </h2>

        <div class="my-3 d-none" data-hide-show-container="formReview">
            <f:form cssClass="col-md-8 col-sm-12 mx-auto"
                    action="${currentUrl}"
                    method="post"
                    modelAttribute="reviewDto"
            >

                <div class="mb-3 row">
                    <f:label path="description" class="col-sm-2 col-form-label">Description</f:label>
                    <div class="col-sm-10">
                        <f:textarea cssClass="form-control" path="description"/>
                        <f:errors path="description" cssClass="invalid-feedback"/>
                    </div>
                </div>

                <div class="my-3 row">
                    <f:label path="rating" class="col-sm-2 col-form-label">Note</f:label>
                    <div class="col-sm-10">
                        <f:input type="number" step="0,5" cssClass="form-control" path="rating"/>
                        <f:errors path="rating" cssClass="invalid-feedback"/>
                    </div>
                </div>
                <f:button type="submit" class="btn btn-success">
                    <i class="fa fa-check"></i> Ajouter
                </f:button>
            </f:form>
        </div>

            <c:if test="${pageReviews.size > 0}">
                <div class="d-flex justify-content-between">
                    <div class="d-flex box-blk box-true">
                        <!-- Label à afficher -->
                        <c:set var="label" scope="request" value="Date"/>
                        <!-- Sur quelle propriété de l'objet on souhaite trier -->
                        <c:set var="sortable" value="createdAt"/>
                        <%@ include file="../component/sortable.jsp" %>

                        <c:set var="label" scope="request" value="Note"/>
                        <c:set var="sortable" value="rating"/>
                        <%@ include file="../component/sortable.jsp" %>

                        <c:set var="label" scope="request" value="Joueur"/>
                        <c:set var="sortable" value="gamer.nickname"/>
                        <%@ include file="../component/sortable.jsp" %>

                        <%@ include file="../component/filter-reset.jsp" %>
                    </div>

                    <c:set var="page" scope="request" value="${pageReviews}"/>
                    <%@ include file="../component/pagination-number.jsp" %>
                </div>
                <div class="row">
                    <c:forEach items="${pageReviews.content}" var="review">
                        <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                            <%@ include file="../component/entity/review-card.jsp" %>
                        </div>
                    </c:forEach>
                </div>
                <%@ include file="../component/pagination.jsp" %>
            </c:if>

    </div>
</div>

<%@ include file="../footer.jsp" %>