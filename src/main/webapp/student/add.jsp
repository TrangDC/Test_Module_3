<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/4/2023
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>Them Student</title>
</head>
<body>

<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                Add new user
            </div>
            <div>
                <c:out value="${message}"></c:out>
            </div>
            <div class="card-body">
                <form method="post">
                    <%--                    <div class="mb-3">--%>
                    <%--                        <label for="exampleInputEmail1" class="form-label">Id</label>--%>
                    <%--                        <input type="text" name="id" class="form-control" id="id" aria-describedby="name">--%>
                    <%--                    </div>--%>
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" id="name" >
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" id="email" >
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" name="address" class="form-control" id="address" >
                    </div>
                    <div class="mb-3">
                        <label for="dob" class="form-label">Date of Birth:</label>
                        <input type="date" name="dob" class="form-control" id="dob" >
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="number" name="phone" class="form-control" id="phone" >
                    </div>
                    <div>
                        <label for="class">Class:</label>
                        <select id="class" name="class" required>
                            <c:forEach var="classroom" items="${classrooms}">
                                <option value="${classroom.getName()}">${classroom.getName()}</option>
                            </c:forEach>
                        </select><br>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/students" class="btn btn-info">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>

</html>
