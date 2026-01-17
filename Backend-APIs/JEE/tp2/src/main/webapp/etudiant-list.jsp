<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liste des Étudiants</title>
    <style>
        table, th, td { border: 1px solid black; border-collapse: collapse; padding: 5px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Liste de la Promo</h2>

    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Note</th>
                <th>Décision</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="etu">
                <tr>
                    <td> ${etu.nom} </td>
                    <td> ${etu.note} </td>
                    <td>
                        <c:choose>
                        <c:when test="${etu.note >= 10}">
                                    Admis
                            </c:when>
                            <c:otherwise>
                                Non Admis
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>

