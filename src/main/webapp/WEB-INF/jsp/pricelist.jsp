<%-- 
    Document   : pricelist
    Created on : Jan 12, 2017, 8:07:45 AM
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
        <script type="text/javascript"
                src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js">
        </script>

        <div>
            <div>  Name:${name}</div>
            <div>  Price: ${price}</div>
            <div><label id="productname" value="${name}"></label></div>
            <div><label id="price" value="${price}"></label></div>
            </input>
            <div>
                Select A Person
                <div>
                    <input type="text" value="" name= "id1" id="id1">
                    <input type="button" value="SelectPerson" onclick="ajaxCall()">
                    <div>

                        <form:form action="addEmpHist.html" modelAttribute= "personSO" method="post">

                            <table> 
                                <tr><td>Selected Person :</td></tr>
                                <tr><td>Selected Id:<form:input path="id" id="id" /></td></tr>
                                <tr><td>Selected Name:<form:input path="name" id="name" /></td></tr>
                                <tr><td>Selected Country:<form:input path="country" id="country" /></td></tr>

                                <tr><td>                        
                                        <input type="submit" value ="Add Employment History"></input></td></tr>
                            </table>
                        </form:form>


                    </div>



                    </form>
                </div>
            </div>
            <div>
                Add A Person
                <div>
                    <input type="text" value="" name= "name2Save" id="name2Save">
                    <input type="text" value="" name= "country2Save" id="country2Save">

                    <input type="button" value="Add a Person" onclick="ajaxSaveCall()">
                </div>
            </div>
            <div>
                <div>
               <a href="/WebApplication2/addPersonAndImage.html">Add a person and his image</a>
                </div>
                
            </div>
            <form action="listPersons.html" commandName="command"  method="post">
                <div> <label  id="tboxlabel" value="ListPersons">List All Persons</label></div>                
                <input type="submit" value ="listPersons">
                </input>
            </form>
            <a href="/WebApplication2/login.html">login</a>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                alert("ajax test document ready");
            }
            );
            function ajaxCall() {
                var personid = $("#id1").val();
                var personSO = {"id": personid.toString(), "name": "n", "country": "c"};
                $.ajax({

                    url: "selectPerson.html",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(personSO),
                    success: function (data) {
                        if (data.toString() !== "NoDataFound") {
                            alert("success");
                            var person = data.toString().split(":seperator:");
                            $("#id").val(person[0].toString());
                            $("#name").val(person[1].toString());
                            $("#country").val(person[2].toString());
                        } else {
                            alert("No Data Found In This ID ,click List All Persons to see valid IDs");
                        }

                    },
                    error: function (e) {
                        alert("error");
                    },
                    done: function (e) {
                        alert("done" + e);
                    }
                });
            }
            function ajaxSaveCall() {
                var personid = 0;
                var personname = $("#name2Save").val();
                var personcountry = $("#country2Save").val();

                var personSO = {"id": personid.toString(), "name": personname.toString(), "country": personcountry.toString()};
                $.ajax({

                    url: "addPerson.html",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(personSO),
                    success: function (data) {
                        alert(data + "save");
                    },
                    error: function (e) {
                        alert("error");
                    },
                    done: function (e) {
                        alert("done" + e);
                    }
                });
            }
        </script>
    </body>
</html>
