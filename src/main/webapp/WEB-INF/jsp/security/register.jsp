<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container-security">
  <div class="security-form">
      <h2 class="form-security-heading">Créer un compte</h2>
      <f:form method="POST" modelAttribute="userForm" class="form-signin">
        <div class="form-group ${status.error ? 'has-error' : ''} mt-security">
          <f:input type="text" path="nickname" class="form-control" placeholder="Nickname"
                      autofocus="true"/>
          <f:errors path="nickname" cssClass="invalid-feedback"/>
        </div>
        <div class="form-group ${status.error ? 'has-error' : ''} mt-security">
          <f:input type="text" path="email" class="form-control" placeholder="toto@toto.toto"
                      autofocus="true"/>
          <f:errors path="email" cssClass="invalid-feedback"/>
        </div>
        <div class="form-group ${status.error ? 'has-error' : ''} mt-security">
          <f:input type="password" path="password" class="form-control" placeholder="Password"/>
          <f:errors path="password" cssClass="invalid-feedback"/>
        </div>
        <div class="form-group ${status.error ? 'has-error' : ''} mt-security">
          <f:input type="date" path="birthAt" class="form-control" placeholder="Date"/>
          <f:errors path="birthAt" cssClass="invalid-feedback"/>
        </div>
        <div class="d-flex justify-content-center">
          <button class="btn btn-form" type="submit">Envoyer</button>
        </div>
        <div class="mt-cool">
        <p class="text-center">Déjà membre ?</p>
        <a class="d-flex justify-content-center link-if" href="${UrlRoute.URL_LOGIN}">
          S'identifier.
        </a>
        </div>
    </f:form>
  </div>
</div>

<%@ include file="../footer.jsp" %>