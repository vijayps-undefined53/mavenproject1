<%-- 
    Document   : newjsp
    Created on : Jan 3, 2017, 9:45:42 PM
    Author     : new
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! </h1>
        <div>

            <form:form action="view.html" method="post">
                <label>Add item</label>

                description   <form:input path="description" />
                price <form:input path="price" />

                <input type="submit" value ="Add">
                </input>
            </form:form>


        </div>
        <div>           </div>



    </body>
</html>
