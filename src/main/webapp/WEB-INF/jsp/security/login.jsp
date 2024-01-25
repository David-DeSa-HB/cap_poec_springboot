<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container-security">
  <security:authentication property="name"/>
  <div class="security-form">
    <h2 class="form-security-heading">Log in</h2>
    <form method="POST" action="${UrlRoute.URL_LOGIN}">
      <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input autocomplete="off" name="username" type="text" class="form-control mb-3" placeholder="Pseudo"/>
        <input autocomplete="off" name="password" type="password" class="form-control" placeholder="Mot de passe"/>
        <p class="invalid-feedback">${error}</p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="d-flex justify-content-center">
          <div class="row">
            <button class="btn btn-link mt-security" type="submit">Log In</button>
            <a class="text-center link-if" href="${contextPath}/register">
              Create an account
            </a>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>

<%@ include file="../footer.jsp" %>