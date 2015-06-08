<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.info.entity.Order"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page import="data.info.connectionjdbc.JDBCConnection"%>
<%@ page import="data.info.factorydaoorder.JDBCFactoryDao"%>
<%@ page import="data.info.factorydaoorder.DaoFactory"%>
<%@ page import="data.info.entity.Category"%>
<%@ page import="data.info.entity. HotelRoom"%>
<%@ page import="search.category.SearchCategory"%>
<%@ page import="data.info.entity.AllocationCalendarsRooms"%>
<%@ page import="search.loginname.SearchNameLogin"%>
<%@ taglib prefix ="regist" uri="registuser" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/css/customer.css" />" rel="stylesheet">
<title>manager site</title>

</head>
<body>
 <fmt:setBundle  basename ="res" var = "rb"/>
	<%!Logger logger = Logger.getLogger("managerSite.jsp");%>
	<div id="main">
		<div id="header">
			<div id="haderMain">

				<h1><fmt:message key ="hotel" bundle="${rb}" /></h1>
              
			</div>
			<div>
			<div id="ur">
					<form action="..\MainServlet" method="post">
						 <input type = "hidden" name="command" value= "localservlet"/>
						 <c:set scope="session" var="page" value="jsp/manager.jsp"/>
				<table id="tabl">
							<tr>
								<td><input type="submit" value="ru_RU" name="loc" /></td>
								<td><input type="submit" value="en_US" name="loc" /></td>
							</tr>
						</table>
					</form>
				</div>
			<c:set var="enterr"> <fmt:message key = "enter"  bundle="${rb}" /></c:set>
				<regist:registC  enter = "${enterr} " />
			</div>
			</div>
			<div id="massage">

			
			<c:if test="${sessionScope.idlogName != null}">

				<p> <fmt:message key = 'good_afternoon'  bundle='${rb}' /> ${sessionScope.idlogName} </p>
			</c:if>
			</div>
		

		<div id="ansver">
			<div class="inner">

				<form action="..\MainServlet" method="post">
				  <input type = "hidden" name="command" value= "addpersonnel"/>
					<table id="tabl">
						<tr>
							<td>имя:</td>
							<td><input type="text" name="nameP" required="required" /></td>
						</tr>
						<tr>
							<td>фамилия:</td>
							<td><input type="text" name="secondNameP"
								required="required" /></td>
						</tr>
						<tr>
							<td>дата рождения:</td>
							<td><input type="text" name="PDateYear" required="required" /></td>
							<td><input type="text" name="PDateMonth" required="required" /></td>
							<td><input type="text" name="PDateDay" required="required" /></td>
						</tr>
						<tr>
							<td>серия и номер паспорта:</td>
							<td><input type="text" name="seriesPas" required="required" /></td>
						</tr>
						<tr>
							<td>пост в компании :</td>
							<td><input type="text" name="post" required="required" /></td>
						</tr>
						<tr>
							<td>дата принятия на работу:</td>
							<td><input type="text" name="stDateYear" required="required" /></td>
							<td><input type="text" name="stDateMonth"
								required="required" /></td>
							<td><input type="text" name="stDateDay" required="required" /></td>
						</tr>
						<tr>
							<td>адрес:</td>
							<td><input type="text" name="address" required="required" /></td>
						</tr>
						<tr>
							<td>логин</td>
							<td><input type="text" name="login" required="required" /></td>
							<td>пароль</td>
							<td><input type="text" name="password" required="required" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="добавить персонал" /></td>
						</tr>
					</table>
				</form>


			</div>
		</div>
	</div>
</body>
</html>