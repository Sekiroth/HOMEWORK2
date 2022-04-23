<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Answer</title>
</head>
<body>
<c:out value="${requestScope.answer}" />
<input type="button" onclick="history.back();" value="Back"/>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp'" value="Exit"/>
</body>
</html>