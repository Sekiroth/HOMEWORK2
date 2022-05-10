<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Airports</title>
    <style>
        .aligncenter {
            text-align: center;
        }
        .text {
            text-align: center;
        }
        table {
            width: 1500px;
            border: 1px solid red;
            border-collapse: collapse;
            margin: auto;
        }
        td, th {
            border: 1px solid red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="aligncenter">
    <img src="piglet.jpg" alt="centered image" />
</div>
<div class="text">
    <h2>Where to fly from? Find your airport!</h2>
</div>
<table>
    <tr>
        <th>Airport code</th>
        <th>Airport name</th>
        <th>City</th>
        <th>Coordinates</th>
        <th>Timezone</th>
    </tr>
    <c:forEach items="${airports}" var="airport" >
        <tr>
            <td>${airport.getCode()}</td>
            <td>${airport.getName()}</td>
            <td>${airport.getCity()}</td>
            <td>${airport.getCoordinates()}</td>
            <td>${airport.getTimezone()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>