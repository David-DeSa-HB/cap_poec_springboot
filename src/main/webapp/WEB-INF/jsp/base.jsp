<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Titre de la page";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="${contextPath}/css/main.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script type="text/javascript" src="${contextPath}/js/alert.js"></script>
        <script type="text/javascript" src="${contextPath}/js/hide-form.js"></script>
        <script type="text/javascript" src="${contextPath}/js/init-sortable.js"></script>
        <script type="text/javascript" src="${contextPath}/js/multiple-select.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg sticky-top box-standard">
            <div class="row w-100 d-flex justify-content-between">
                <div class="col-2 d-flex align-items-center">
                    <a class="navbar-brand ms-3" href="${contextPath}/">
                        <i class="fa-solid fa-gamepad fa-2xl" style="color: #e46b1b;"></i>
                    </a>
                </div>

                <%--<div class="col-3">
                    <security:authorize access="hasRole('MODERATOR')">
                        <div class="d-flex justify-content-end">
                            <a class="nav-link" href="${UrlRoute.URL_REVIEWS}">Moderation</a>
                        </div>
                    </security:authorize>
                </div>

                <div class="col-4">
                    <div class="main-container p-2">
                        <div class="d-flex">
                            <input type="text"
                                   class="form-control"
                                   placeholder="Starcraft, FPS, ..."
                                   data-search-bar-games
                            >
                            <a class="my-auto me-3">
                                <i class="fa fa-magnifying-glass"></i>
                            </a>
                        </div>
                        <div class="search-response-container">
                        </div>
                    </div>
                </div>--%>

                <div class="col-4">
                    <security:authorize access="!isAuthenticated()">
                        <div class="d-flex justify-content-end">
                            <a class="nav-link" href="${UrlRoute.URL_REGISTER}">S'inscrire</a>
                        </div>
                        <div class="d-flex justify-content-end">
                            <a class="nav-link" href="${UrlRoute.URL_LOGIN}">Se connecter</a>
                        </div>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <div class="d-flex justify-content-end">
                            <span class="ms-2">
                                Bienvenue
                                <security:authentication property="name"/>
                            </span>
                        </div>
                        <div class="d-flex justify-content-end">
                            <form method="POST" action="${UrlRoute.URL_LOGOUT}" autocomplete="off">
                                <button type="submit" tabindex="3" class="btn btn-link">Se déconnecter</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                        </div>
                    </security:authorize>
                </div>
            </div>
        </nav>
        <c:if test="${not empty flashMessage.message}">
            <div class="container">
                <div class="alert alert-${flashMessage.type}">
                        ${flashMessage.message}
                </div>
            </div>
        </c:if>