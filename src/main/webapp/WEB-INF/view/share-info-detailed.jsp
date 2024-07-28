<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detailed share information</title>
</head>
<br><br>

<body>
<h3>Share history growth</h3>
<br>
<table border="1">
    <tr>
        <th bgcolor="yellow">Name</th>
        <th bgcolor="yellow">Ticker</th>
        <th bgcolor="yellow">01.02.2000-01.02.2010 growth, %</th>
        <th bgcolor="yellow">01.02.2010-01.02.2020 growth, %</th>
    </tr>

    <tr>
        <td>${growthHistory.name}</td>
        <td>${growthHistory.ticker}</td>
        <td align="center">${growthHistory.growthFrom00To10}</td>
        <td align="center">${growthHistory.growthFrom10To20}</td>
    </tr>

</table>
<br>

<input type="button" value="Back"
       onclick="window.location.href = 'backToHomePage'"/>

</body>
</html>