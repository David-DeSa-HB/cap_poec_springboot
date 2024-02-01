<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container-security">
  <div class="security-form">
    <h2 class="form-security-heading">Connexion</h2>
    <form method="POST" action="${UrlRoute.URL_LOGIN}">
      <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input autocomplete="off" name="username" type="text" class="form-control mb-3" placeholder="Pseudo"/>
        <input autocomplete="off" name="password" type="password" class="form-control" placeholder="Mot de passe"/>
        <p class="invalid-feedback">${error}</p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </div>
      <div class="d-flex justify-content-center">
        <button class="btn btn-form" type="submit">Envoyer</button>
      </div>
      <div class="mt-cool">
        <p class="text-center">Pas encore membre ?</p>
        <a class="d-flex justify-content-center link-if" href="${UrlRoute.URL_REGISTER}">
          Creez votre compte.
        </a>
      </div>
    </form>
  </div>
</div>

<%@ include file="../footer.jsp" %>