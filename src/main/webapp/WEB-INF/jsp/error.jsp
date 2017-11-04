<%-- 
    Document   : error
    Created on : Feb 19, 2017, 3:47:43 PM
    Author     : new
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Occurred </title>
    </head>
    <body>
        <h3>Debug Information:</h3>

        <table>
            <tr>



                <td>Exception= ${exception.message}<br><br></td>

                <td><strong>Exception Stack Trace</strong><br></td>
                <td><a href="/WebApplication2/view.html">Retry</a></td>
            </tr>
        </table>
    </body>
</html>
