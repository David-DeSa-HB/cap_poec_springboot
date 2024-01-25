<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container-security">
  <div class="security-form">
      <h2 class="form-security-heading">Create your account</h2>
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
          <button class="btn btn1" type="submit" style="width: 50%;">Submit</button>
        </div>
    </f:form>
  </div>
</div>

<%@ include file="../footer.jsp" %>