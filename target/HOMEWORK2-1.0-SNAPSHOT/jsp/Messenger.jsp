<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Messenger</title>
</head>
<h2>Yout text</h2>
<form action="${pageContext.request.contextPath}/api/message" method="POST">
    <p>To: <input type="text" name="toUser" /></p>
    <p>Your text: <input type="text" name="message"/></p>
    <p><input type="submit" value="Submit"></p>
</form>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics'" value="See statistics"/>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats'" value="See messages"/>
<input type="button" onclick="history.back();" value="Back"/>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp'" value="Exit"/>

<body>