<%-- 
    Document   : newjsp
    Created on : Jan 3, 2017, 9:45:42 PM
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
        <h1>Hello World! </h1>
        <c:out value="${now}"></c:out>
        <div>
        
            <form action="login.html" method="post">
                      <label  id="tboxlabel" value="Login">LOGIN</label>
                
            <input type="text" name ="username" >
        </input>  
                    <input type="password" name ="password" >
        </input> 
        <input type="submit" value ="Login">
        </input>
        </form>

       
        </div>

              
    
    </body>
</html>
