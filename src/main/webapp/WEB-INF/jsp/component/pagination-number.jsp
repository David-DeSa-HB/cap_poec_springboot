
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%--    <div  class="mt-auto mb-2 box-blk box-true container-security">
        <span>
            page ${pageReviews.number + 1} sur ${pageReviews.totalPages}
        </span>
    </div>--%>

<div class="mt-auto mb-2 box-blk box-true container-security">
    <span>
        <core:set var="pageNumber" value="${page.number + 1}"/>
        <core:set var="pageTotal" value="${page.totalPages}"/>
        page ${pageNumber} sur ${pageTotal}
    </span>
</div>