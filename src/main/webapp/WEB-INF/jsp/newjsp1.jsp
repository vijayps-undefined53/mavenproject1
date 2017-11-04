

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employment History</title>
    </head>
    <body>
        <h1>Add Employment History</h1>

        <form:form action="saveEmpHist.html" modelAttribute="personSO" method="post">
            <table>
                <tr><td> ID : </td>  <td><form:input path ="id" /></td></tr>
                <tr><td> Name : </td> <td> <form:input path ="name" /></td></tr>
                <tr><td> Country: </td>  <td> <form:input path ="country"  /></td></tr>
                <tr><td> Pan Number : </td> <td>  <form:input path ="panNumber"/></td></tr>
                <tr><td>                        
                        <input type="submit" value ="Add Employment History"></input></td></tr>

            </table>
        </form:form>

    </body>
</html>
