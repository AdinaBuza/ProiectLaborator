<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit User">
    <h1>Edit User</h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">

        <input type="hidden" name="user_id" value="${user.id}" />

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Leave empty to keep current">
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label>User Groups</label>
                <c:forEach var="user_group" items="${userGroups}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="${user_group}" id="${user_group}" name="user_groups">
                        <label class="form-check-label" for="${user_group}">
                                ${user_group}
                        </label>
                    </div>
                </c:forEach>
            </div>
        </div>

        <button class="btn btn-primary btn-lg btn-block" type="submit">Update</button>
    </form>
</t:pageTemplate>

