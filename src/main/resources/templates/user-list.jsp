<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <ul>
        <li th:each="user : ${users}" th:text="${user.name}"></li>
    </ul>
</body>
</html>
