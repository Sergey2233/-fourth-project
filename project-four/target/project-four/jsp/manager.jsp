
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
<%@ taglib prefix="manOrder" uri="managerOr"%>
<%@ taglib prefix="allor" uri="ollordmanager"%><!-- all order one manager -->
<%@ taglib prefix="cl" uri="calendar"%>
<%@ taglib prefix="r" uri="roomhotel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>manager</title>
<link href="<c:url value="/css/customer.css" />" rel="stylesheet">

</head>

<body>
	<%!Logger logger = Logger.getLogger("manager.jsp");%>
	<fmt:setBundle  basename ="res" var = "rb"/>
	<div id="main">
		<div id="header">
			<div id="haderMain">

				<h1><fmt:message key ="hotel" bundle="${rb}" /></h1>

			</div>
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
			<div class="log">
			<c:set var="enterr"> <fmt:message key = "enter"  bundle="${rb}" /></c:set>
				<regist:registC  enter = "${enterr} " />
			</div>
			<div id="massage">
                 <c:if test = "${sessionScope.idlogName != null}">
                 
                 <p>
					Добрый день  ${sessionScope.idlogName}
					
				</p>
                 </c:if>
                  
                  <c:if test = "${sessionScope.idlogName == null}">
                 
                 <p>
					Добрый день  
					
				</p>
                 </c:if>
				
			</div>
		</div>
		<div id="ansver">
			<div class="inner">
             <manOrder:managerOr />
			</div>
			 <div>
			  <h3>календарь</h3> 
			   <cl:cln/>
			 </div>
			 
		    <div>
		    <h3>заказы</h3>
		       
		        <c:if test="${sessionScope.listOrder.size() > 0 }">
                     <allor:allorMan listOrder1="${sessionScope.listOrder}"/>
			</c:if>
           
			 <c:if test="${sessionScope.listOrder.size()  == 0}" >
              <p>нет заказов</p>
			</c:if>
				
			</div>
			
			<div>
				<h3>комнаты</h3>
				  <r:room/>
			</div>
		</div>


	</div>


</body>
</html>