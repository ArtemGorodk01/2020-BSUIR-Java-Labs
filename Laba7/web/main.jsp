<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>  
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Main page</title> 
    </head>  
    <body bgcolor="#aaffee">    
            <h2>
                <B><center>Car List</center></B>
            </h2>   
            <br/>
            <center>
                <c:forEach items="${carList}" var="car">  
                    ${car.model}: ${car.price}  
                    <br /> 
                </c:forEach>
            </center>
            <br/>
            <br/>
            <center>
                <a href="addCar.htm">Add new car</a>
                <br/>
                <a href="getPriceByModel.htm">Get price by model</a>
                <br/>
                <a href="getCarsLowerPrice.htm">Get cars lower than price</a>
            </center>
    </body> 
</html>