<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All shares</h2>
<br>

<!--Создаём таблицу-->
<table border="1">
    <!--Шапка-->
    <tr>
        <th bgcolor="yellow">Name</th>
        <th bgcolor="yellow">Ticker</th>
        <th bgcolor="yellow">Type</th>
        <th bgcolor="yellow">Pay dividend, years</th>
        <th bgcolor="yellow">All-time avg dividend growth, %</th>
        <th bgcolor="yellow">Operations</th>
    </tr>

    <!--
    Тело таблицы
    Проходим по каждому элементу из allShares и заполняем таблицу построчно
    -->
    <c:forEach var="share" items="${allShares}">

        <!--Делаем ссылки на кнопках:
        Update на метод updateShare() (связан через @RequestMapping("/updateShare"))
        Delete на метод deleteShare()
        -->
        <c:url var="deleteButton" value="/deleteShare">
            <c:param name="shareTicker" value="${share.ticker}"/>
        </c:url>

        <c:url var="updateButton" value="/updateShare">
            <c:param name="shareTicker" value="${share.ticker}"/>
        </c:url>

        <c:url var="exploreButton" value="/exploreShare">
            <c:param name="shareTicker" value="${share.ticker}"/>
        </c:url>

        <tr>
            <td>${share.name}</td>
            <td>${share.ticker}</td>
            <td>${share.type}</td>
            <td align="center">${share.yearsPayDiv}</td>
            <td align="center">${share.averageDivGrowth}</td>
            <td>
                <input type="button" value="Explore" onclick="window.location.href = '${exploreButton}'"/>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>

<input type="button" value="Add share"
       onclick="window.location.href = 'addNewShare'"/>

</body>
</html>