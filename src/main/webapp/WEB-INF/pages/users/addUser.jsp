<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
  <h1>Users</h1>

  <form method="POST" action="${pageContext.request.contextPath}/Users">
    <div class="container text-center">

      <div class="row mb-3">
        <div class="col text-start">
          <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
            <a href="${pageContext.request.contextPath}/AddUser" class="btn btn-primary">Add User</a>
          </c:if>

          <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
            <button type="submit" class="btn btn-secondary">Invoice</button>
          </c:if>
        </div>
      </div>

      <div class="row fw-bold border-bottom">
        <div class="col-1">Select</div>
        <div class="col">Username</div>
        <div class="col">Email</div>
        <div class="col">Actions</div>
      </div>

      <c:forEach var="user" items="${users}">
        <div class="row border-bottom py-2 align-items-center">
          <div class="col-1">
            <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
              <input type="checkbox" name="user_ids" value="${user.id}" />
            </c:if>
          </div>
          <div class="col">${user.username}</div>
          <div class="col">${user.email}</div>
          <div class="col">
            <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
              <a href="${pageContext.request.contextPath}/EditUser?id=${user.id}" class="btn btn-secondary btn-sm">Edit</a>
            </c:if>
          </div>
        </div>
      </c:forEach>
    </div>
  </form>

  <c:if test="${not empty invoices}">
    <h2 class="mt-4">Invoices</h2>
    <ul class="list-group">
      <c:forEach var="username" items="${invoices}" varStatus="status">
        <li class="list-group-item">${status.index + 1}. ${username}</li>
      </c:forEach>
    </ul>
  </c:if>
</t:pageTemplate>