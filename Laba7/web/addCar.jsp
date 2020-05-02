<%-- 
    Document   : addCar
    Created on : May 1, 2020, 7:23:24 PM
    Author     : gorod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add car</title>
    </head>
    <body>
        <center><a href="main.htm">Main page</a></center>
        <br/>
        <center>
            <h2>Add new car</h2>
            <form action="addCar.htm" method="POST">
                <label>Model</label>
                <input name="model" id="model" type="String"/>
                <br/>
                <br/>
                <label>Price</label>
                <input name="price" id="price" type="Integer"/>  
                <br/>
                <br/>
                <input type="submit" value="Add car"/>
            </form>
        </center>
        <hr/>
        <center>
            <h3>${addInfo}</h3>
        </center>
    </body>
</html>
