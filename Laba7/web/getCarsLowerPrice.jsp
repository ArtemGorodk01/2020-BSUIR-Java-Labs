<%-- 
    Document   : getCarsLowerPrice
    Created on : May 1, 2020, 8:39:24 PM
    Author     : gorod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get cars lower price</title>
    </head>
    <body>
        <center><a href="main.htm">Main page</a></center>
        <br/>
        <br/>
        <center>
        <h2>Get cars with price lower than </h2>
        <form action="getCarsLowerPrice.htm" method="POST">
            <input type="Integer" name="price" id="price"/>
            <br/>
            <br/>
            <input type="submit" value="Get cars">
        </form>
        <br/>
        <br/>
        <hr/>
        <h3>${info}</h3>
        <br/>
        <c:forEach items="${carList}" var="car">  
                    ${car.model}: ${car.price}  
        <br /> 
        </c:forEach>
        </center>
    </body>
</html>
