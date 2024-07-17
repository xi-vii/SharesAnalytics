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
        <th>All-time avg dividend growth, %</th>
        <th>Operations</th>
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

        <tr>
            <td>${share.name}</td>
            <td>${share.ticker}</td>
            <td>${share.type}</td>
            <td>${share.yearsPayDiv}</td>
            <td>${share.averageDivGrowth}</td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>

<input type="button" value="Add share"
       onclick="window.location.href = 'addNewShare'"/>

</body>
</html>