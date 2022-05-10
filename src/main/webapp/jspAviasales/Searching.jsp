<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Flights</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/flights" method="GET">
            <select name="arrivalAirport">
                <c:forEach items="${requestScope.airports}" var="item">
                    <option
                            <c:if test="${item.code eq requestScope.arrivalAirport}">
                                selected
                            </c:if>
                            value="${item.code}">${item.code} - ${item.name}</option>
                </c:forEach>
            </select>

            <select name="departureAirport">
                <c:forEach items="${requestScope.airports}" var="item">
                    <option
                            <c:if test="${item.code eq requestScope.departureAirport}">
                                selected
                            </c:if>
                            value="${item.code}">${item.code} - ${item.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Find" />

            <p>Departure date: <input type="date" name="scheduledDeparture"/></p>
            <p>Arrival date: <input type="date" name="scheduledArrival"/></p>
        </form>
    </div>
    <div>
        <table class="table table-striped">
            <tr>
                <th>Flight ID</th>
                <th>Flight number</th>
                <th>Scheduled departure time</th>
                <th>Scheduled arrival time</th>
                <th>Airport of departure</th>
                <th>Airport of arrival</th>
                <th>Flight status</th>
                <th>Aircraft code</th>
                <th>Actual departure time</th>
                <th>Actual arrival time</th>
            </tr>
            <c:forEach items="${requestScope.flights}" var="item">
                <tr>
                    <td>${item.getFlightId()}</td>
                    <td>${item.getFlightMo()}</td>
                    <td>${item.getScheduledDeparture()}</td>
                    <td>${item.getScheduledArrival()}</td>
                    <td>${item.getDepartureAirport()}</td>
                    <td>${item.getArrivalAirport()}</td>
                    <td>${item.getStatus()}</td>
                    <td>${item.getAircraftCode()}</td>
                    <td>${item.getActualDeparture()}</td>
                    <td>${item.getActualArrival()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
