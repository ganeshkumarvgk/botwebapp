<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Display Page</title>
</head>
<body>

<div align="center" style="overflow: auto;height: 500px; width: 520px;">
  <table style="width: 500px;">
  <tr>
    <th>ID</th>
    <th>StockName</th>
    <th>SMAPeriod</th>
    <th>CrossOverSignal</th>
  </tr>
  <c:forEach var="listitem" items="${list}">
  <tr>
  <td>${listitem.id}</td>
  <td>${listitem.stockname}</td>
  <td>${listitem.smaperiod}</td>
  <td>${listitem.crossoversignal}</td>
  </c:forEach>
  </table>
</div>
  <br>
  <a href="/Botwebapp/tabledata/1">1</a>
  <a href="/Botwebapp/tabledata/2">2</a>
  <a href="/Botwebapp/tabledata/3">3</a>
</body>
</html>