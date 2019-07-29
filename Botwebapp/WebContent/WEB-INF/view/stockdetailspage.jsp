<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!--  <script> 
            $(document).ready(function(){ 
                $("#submitbuttion").click(function(){ 
                    $("#tabledata").load("/gettabledata"); 
                }); 
            }); 
        </script> --> 
<title>Insert title here</title>
</head>
<body>


<script type="text/javascript">
function getvalue() {
	var x = document.getElementById("dropdown").value;
//		document.getElementById("sample").readOnly = false;
	document.getElementById("sample").value = x;
//		document.getElementById("sample").readOnly = true;
}
</script>
	<form:form modelAttribute="stocksearchbean" action="gettabledata">
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
StockCode:
<form:input path="stockcode" id="stockcode" type="text" />
		<br>
InstrumentCode:
<form:input path="instrumentcode" id="instrumentcode" type="text"/>
		<br>
		
<br>
Candle:
<form:input path="candle" id="" value="30mins" readonly="true"/>	

<br>
Strategy:	
	
<form:select path="strategy">
<form:option value="SMA">SimpleMovingAverage</form:option>
</form:select>	

<br>

ShortDuration :
<form:select path="shortduration">
<form:option value="8c">8Candles</form:option>
<form:option value="20c">20Candles</form:option>
<form:option value="8D">8Days</form:option>
<form:option value="20D">20Days</form:option>
</form:select>	

<br>
LongDuration :
<form:select path="longduration">
<form:option value="8c">8Candles</form:option>
<form:option value="20c">20Candles</form:option>
<form:option value="8D">8Days</form:option>
<form:option value="20D">20Days</form:option>
</form:select>	

<br>
	<input type="submit" value ="submit" id="submitbuttion" >
	</form:form>
	<br>
	<br> Sample input :
	<input id="sample"  value="">
	<select id="dropdown" onchange="getvalue()">
		<option disabled selected>Choose Colour</option>
		<option value="Green">Green</option>
		<option value="Red">Red</option>
		<option value="Orange">Orange</option>
	</select>
	
	
	<br><br>
	
	<table id="tabledata">
	<tr><th>Data</th></tr>
	<tr>
	<td>${command}</td>
	</tr>
	</table>
	<!-- <script type="text/javascript">
		function setinputfields() {
			var data = ${stocklist};
			
			var dropdowndata = document.getElementById("stockdropdown").value;
			for(var i=0;i<data.length;i++){
				if(i.stockname==dropdowndata){
			document.getElementById("stockcode").value = i.stockcode;
			document.getElementById("instrumentcode").value = i.instrumentcode;
			break;
				}
			}
		}
	</script> -->
	<%-- <select>
		<c:forEach items="${stocklist}" var="g">
			<option label="${g.stockname}" value="${g.stockname}"/>
		</c:forEach>
	</select>> --%>
</body>
</html>