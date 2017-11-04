<%--
    Document   : pricelist
    Created on : Jan 12, 2017, 8:07:45 AM
    Author     : new
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of All Persons </h1>
        <div style="align-self: auto; background-color: darkgrey">
            <c:forEach items="${listAllPersons}" var="listAllPersons">
                <div>Id : <input type ="text" id="id1"  readonly="true" value='<c:out value="${listAllPersons.id}"></c:out>'></input></div>
                <div>Employment History Id : <input type ="text" id="id1"  readonly="true" value='<c:out value="${listAllPersons.empHistId}"></c:out>'></input></div>
                <div>Name : <input type ="text" id="name1"  value='<c:out value="${listAllPersons.name}"></c:out>'></input></div>
                <div>Country :  <input type ="text" id="country1"  value='<c:out value="${listAllPersons.country}"></c:out>'></input></div>
                <div>Pan Number :  <input type ="text" id="panNumber1"  value='<c:out value="${listAllPersons.panNumber}"></c:out>'></input></div>
                <div>Person Image :   <img src="/WebApplication2/imgs/<c:out value="${listAllPersons.personImage}"></c:out>"  /> </div>
                <div><div><a href="<c:url value='/deletePerson/${listAllPersons.id}'></c:url>">Delete</a></div>
                    <div><a href="<c:url value='/editPerson/${listAllPersons.id}/${listAllPersons.name}/${listAllPersons.country}'></c:url>">Save Edited Values</a></div>
                    <div><a href="<c:url value='/addEmployementHistoryDetails/${listAllPersons.id}/${listAllPersons.empHistId}'></c:url>">Add Detailed Employment History(Organization Wise)</a></div>

                    </div>
            </c:forEach>
        </div>
        <div>
            <div></div>
        </div>
    </body>
</html>
