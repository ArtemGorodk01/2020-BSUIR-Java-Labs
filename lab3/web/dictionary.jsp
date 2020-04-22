<!DOCTYPE html> 
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html> 
    <head> 
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
    </head> 
    <body bgcolor="#aaccff"> 
        <Font color="green" size="10"> Dictionary </Font>
        <br/> 
        <br/> 
        <form name="frm" method="Get" action="MyServlet" accept-charset="UTF-8">
            <Font color="blue" size="6"> Введите слово:</Font>
            <Input type="Text" name="word" accept-charset="UTF-8" value="${txt}"/> 
            <br/> 
            <br/> 
            <Font color="blue" size="6">Перевод </Font>
            <input type="text" name ="trans" value="${translation}"/>
            <br/> 
            <Input type="submit" value="Перевести"/> 
        </form>
    </body>
</html>