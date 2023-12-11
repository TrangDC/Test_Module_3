<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/5/2023
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                Update User
            </div>
            <div>
                <c:out value="${message}"></c:out>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/admin/listuserdata?action=update&id=<c:out value="${user.getId()}"/>" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Name</label>
                        <input type="text" name="name" value="<c:out value="${user.getName()}"/>" class="form-control" id="" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" value="<c:out value="${user.getEmail()}"/>" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Address</label>
                        <input type="text" name="address" value="<c:out value="${user.getAddress()}"/>" class="form-control" id="address">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">UserName</label>
                        <input type="text" name="username" value="<c:out value="${user.getUserName()}"/>" class="form-control" id="username">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Password</label>
                        <input type="text" name="password" value="<c:out value="${user.getPassword()}"/>" class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Role</label>
                        <select name="role" id="role">
                            <option <c:if test="${user.getRole() == 'admin'}"> selected </c:if> value="admin">Admin</option>
                            <option <c:if test="${user.getRole() == 'user'}"> selected </c:if>  value="user">User</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/admin/listuserdata" class="btn btn-info">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
