<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Share info</title>
</head>
<body>
<h3>Please, insert/correct data</h3>
<br><br>

<form:form action="saveShare" modelAttribute="share">
    Ticker <form:input path="share.ticker"/>
    <br><br>
    Company name <form:input path="share.name"/>
    <br><br>
    Type of share <form:input path="share.type"/>
    <br><br>
    Pay dividend, years <form:input path="share.yearsPayDiv"/>
    <br><br>
    All-time avg dividend growth, % <form:input path="share.averageDivGrowth"/>
    <br><br>
    01.02.2000-01.02.2010 growth, % <form:input path="growthHistory.growthFrom00To10"/>
    <br><br>
    01.02.2010-01.02.2020 growth, % <form:input path="growthHistory.growthFrom10To20"/>
    <br><br><br>
    <input type="button" value="Back"
           onclick="window.location.href = 'backToHomePage'"/>
    <input type="submit" value="Done!">
</form:form>


</body>
</html>
