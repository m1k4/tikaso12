<%-- 
    Document   : rekisteroityminen
    Created on : 21.9.2012, 20:07:43
    Author     : m1k4
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekisteröityminen</title>
    </head>
    <body>
        <h1>Rekisteröityminen</h1>
        <h2>Luo uusi käyttäjä</h2>

        <div>
            <legend>Anna tarvittavat tiedot ja paina Lähetä:</legend>
            <fieldset>
                <form action="${pageContext.request.contextPath}/app/user/" method="POST">
                    Käyttäjätunnus: <input type="text" name="name" id="name"/><br/>
                    Salasana: <input type="password" name="password" id="password"/><br/>
                    <input type="submit" value="Lähetä"/>
                </form>
            </fieldset>
        </div>
    </body>
</html>
