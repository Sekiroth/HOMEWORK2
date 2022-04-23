<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<h2>Hejo!!!</h2>
<h2>Sign up here:</h2>
<form action="${pageContext.request.contextPath}/api/user" method="POST">
    <p>First name: <input type="text" name="firstName"/></p>
    <p>Last name: <input type="text" name="lastName"/></p>
    <p>Date of birth: <input type="date" name="birthday"/></p>
    <p>Login: <input type="text" name="login" /></p>
    <p>Password: <input type="text" name="password"/></p>
    <p><input type="submit" value="Submit"></p>
</form>
<h2>Or just sign in if you already have an account:</h2>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn'" value="Sign in here"/>
</body>
</html>