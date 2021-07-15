<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All employees</title>
</head>
<body>
    <h2>All employees:</h2>
    <table>
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>department</th>
            <th>salary</th>
            <th>options</th>
        </tr>
        <c:forEach var="emp" items="${allEmps}">

            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>
            <c:url var="deleteButton" value="/deleteEmp">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <input type="button" value="Update"
                        onclick="window.location.href = '${updateButton}'"/>

                    <input type="button" value="Delete"
                           onclick="window.location.href = '${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="Add"
           onclick="window.location.href = '/empInfo'"/>
</body>
</html>
