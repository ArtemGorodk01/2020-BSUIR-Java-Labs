<%-- 
    Document   : getPriceByModel
    Created on : May 1, 2020, 8:08:32 PM
    Author     : gorod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get price by model.</title>
    </head>
    <body>
        <center><a href="main.htm">Main page</a></center>
        <br/>
        <br/>
        <center><h2>Get the price by model</h2></center>
        <br/>
        <center>
            <form action="getPriceByModel.htm" method="POST">
                <label>Model</label>
                <input name="model" id="serchmodel" type="String"/>
                <br/>
                <br/>
                <input type="Submit" value="Get price"/>
            </form>
            <br/>
            <hr/>
            <h3>${price}</h3>
        </center>
    </body>
</html>
