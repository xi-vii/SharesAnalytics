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
    Ticker <form:input path="ticker"/>
    <br><br>
    Company name <form:input path="name"/>
    <br><br>
    Type of share <form:input path="type"/>
    <br><br>
    Pay dividend, years <form:input path="yearsPayDiv"/>
    <br><br>
    All-time avg dividend growth, % <form:input path="averageDivGrowth"/>
    <br><br><br>
    <input type="submit" value="Done!">
</form:form>

</body>
</html>
