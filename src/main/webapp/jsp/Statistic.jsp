<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>

<h2>Statistic</h2>

<p>NUMBER OF MESSAGES - ${requestScope.messages}</p>
<p>NUMBER OF ACTIVE USERS - ${requestScope.loggedUsers}</p>
<p>TOTAL NUMBER OF USERS - ${requestScope.allUsers}</p>

<input type="button" onclick="history.back();" value="Back"/>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp'" value="Exit"/>
</body>
</html>