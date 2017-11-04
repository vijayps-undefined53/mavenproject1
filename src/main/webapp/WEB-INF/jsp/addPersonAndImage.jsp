<%-- 
    Document   : addPersonAndImage
    Created on : Feb 28, 2017, 9:26:58 PM
    Author     : new
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Person With Image</title>
    </head>
    <body>
        <form action="uploadPersonAndImage" method="post" enctype="multipart/form-data" >
            Name : <input type="text" name="nameOfPerson"/>
            Country : <input type="text" name="countryOfPerson"/>
            Image :  <input type="file" name="personimage"/>
  

            <input type="submit" value ="Add Person">
            </input>
        </form>
    </body>
</html>
