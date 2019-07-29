<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
<script>
$(function() {
  $("#datepicker").datepicker({
  changeMonth:true,
  changeYear:true
  });
});
</script>
</head>
<body>

<form:form>

Date :<form:input path="" type="text" id="datepicker"/>

<br>
StocksDropDownList:
		<datalist id="suggestions">
			<form:select id="stockdropdown" path="stockname"
				onchange="setinputfields()">
				<c:forEach items="${stocklist}" var="g">
					<form:option label="${g.stockname}" value="${g.stockname}" />
				</c:forEach>
			</form:select>
		</datalist>
		<input autoComplete="on" list="suggestions" />
		<br>

Strategy :

<form:select path="">
<form:option value="SMA">SimpleMovingAverage</form:option>
</form:select>	
<br>


<input type="submit" value="submit">

</form:form>









</body>
</html>