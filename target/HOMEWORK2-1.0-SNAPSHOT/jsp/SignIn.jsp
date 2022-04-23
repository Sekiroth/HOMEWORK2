
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<h2>Sign in here:</h2>
<form action="${pageContext.request.contextPath}/api/login" method="POST">
    <p>Login: <input type="text" name="login" /></p>
    <p>Password: <input type="text" name="password"/></p>
    <p><input type="submit" value="Submit"></p>
</form>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp'" value="Exit"/>
</body>
</html>
