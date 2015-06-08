
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.info.connectionjdbc.JDBCConnection"%>
<%@ page import="data.info.factorydaoorder.JDBCFactoryDao"%>
<%@ page import="data.info.factorydaoorder.DaoFactory"%>
<%@ page import="data.info.entity.Category"%>
<%@ page import="data.info.entity.Message"%>
<%@ page import="comand.read.dalist.DataCategoryList"%>
<%@ taglib prefix="order" uri="putorder"%>
<%@ taglib prefix="regist" uri="registuser"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>ТЕСТ</title>
<link href="<c:url value="/css/customer.css" />" rel="stylesheet">
<script type="text/javascript">
	function ChangeText() {
		document.location.href = "\log.jsp ";
	}
</script>
</head>
<body>
<fmt:setBundle  basename ="res" var = "rb"/>

	<div id="main">
		<div id="header">
			<div id="haderMain">

				<h1> <fmt:message key ="hotel" bundle="${rb}" /></h1>
			
				<!-- Готель Ромашка -->
				<div id="ur">
					<form action="../MainServlet" method="post">
						 <input type = "hidden" name="command" value= "localservlet"/>
						<c:set scope="session" var="page" value="jsp/customer.jsp"/>
						<table id="tabl">
							<tr>
								<td><input type="submit" value="ru_RU" name="loc" /></td>
								<td><input type="submit" value="en_US" name="loc" /></td>
							</tr>
						</table>
					</form>
				</div>

			</div>
		</div>
		<div id=hederlog>
			<div class="regist">
				<h4 onclick="ChangeText ()"> <fmt:message key = "registration"  bundle="${rb}" /></h4>
			</div>
			<div class="log">
			<c:set var="enterr"> <fmt:message key = "enter"  bundle="${rb}" /></c:set>
				<regist:registC  enter = "${enterr} " />
			</div>
		</div>
		<div id="ansver">
			<div id=" order">
				<c:if test="${sessionScope.idlogName != null}">
				<c:set var="category"> <fmt:message key = "category"  bundle="${rb}" /></c:set>
				<c:set var="phon"> <fmt:message key = "phon"  bundle="${rb}" /></c:set>
				<c:set var="arrivalDate"> <fmt:message key = "arrival_date"  bundle="${rb}" /></c:set>
				<c:set var="dateOfDepaerture"> <fmt:message key = "date_of_departure"  bundle="${rb}" /></c:set>
				<c:set var="book"> <fmt:message key = "book"  bundle="${rb}" /></c:set>
				
					<form action="../MainServlet" method="post">
						<order:form   category= "${category} "  phon = "${phon} "  arrival_date = "${arrivalDate} "  date_of_depaerture = "${dateOfDepaerture} " 
						  book = "${book} " />
					
							
					</form>
				</c:if>
			</div>
		</div>

 
		<div id="massage">

			<c:if test="${sessionScope.idlogName != null}">

				<p>  <fmt:message key = 'good_afternoon'  bundle='${rb}' />  ${sessionScope.idlogName}</p>
			</c:if>

			<c:if test="${sessionScope.idlogName == null}">

				<p> <fmt:message key = 'good_afternoon'  bundle='${rb}' /></p>
				<p> <fmt:message key = 'book_room'  bundle='${rb}' /></p>

				<p> <fmt:message key = 'regist_login'  bundle='${rb}' />.</p>

			</c:if>


			<c:if test="${sessionScope.messagelist != null}">
				<P> <fmt:message key = 'order'  bundle='${rb}' /></P>
				<table>
				    <tr>
						<th> <fmt:message key = 'room_number'  bundle='${rb}' /></th>
						<th> <fmt:message key = 'cost'  bundle='${rb}' /></th>
						<th><fmt:message key = 'notification_armor'  bundle='${rb}' /></th>

					</tr>
					<c:forEach var="massage1" items="${sessionScope.messagelist}">

						<tr>
							<td>${massage1.idRoom}</td>
							<td>${massage1.costLiving}</td>
							<c:if test="${massage1.reservation}">
								<td> <fmt:message key = 'reservations'  bundle='${rb}' /></td>
							</c:if>
							<c:if test="${massage1.reservation == false}">
								<td> <fmt:message key = 'no_seats'  bundle='${rb}' /></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>

	</div>


</body>

</html>