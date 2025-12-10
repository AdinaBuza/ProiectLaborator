<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>

    <%-- Butonul ADD USER - Vizibil doar pentru WRITE_USERS --%>
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
        <a href="${pageContext.request.contextPath}/AddUser" class="btn btn-primary btn-lg mb-3">Add User</a>
    </c:if>

    <div class="row">
        <c:forEach var="user" items="${users}">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${user.username}</h5>
                        <p class="card-text">${user.email}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>