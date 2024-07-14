<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All shares</h2>
<br>

<!--Создаём таблицу-->
<table>
    <!--Шапка-->
    <tr>
        <th>Name</th>
        <th>Ticker</th>
        <th>Type</th>
        <th>Pay dividend, years</th>
        <th>Avg dividend growth, %</th>
    </tr>

    <!--Тело-->
    <c:forEach var="share" items="${allShares}">
        <tr>
            <td>${share.name}</td>
            <td>${share.ticker}</td>
            <td>${share.type}</td>
            <td>${share.yearsPayDiv}</td>
            <td>${share.averageDivGrowth}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>