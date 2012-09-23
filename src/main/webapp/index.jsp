<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leffa-arkisto</title>
    </head>
    <body>
        <h1>Leffa-arkisto</h1>    
        <a href="app/yllapito">Ylläpito</a><br/>
        <br>
        <fieldset>
            <form action="app/login" method="POST">

                <legend>Kirjaudu sisään</legend>
                <label for="tunnus">Käyttäjätunnus:</label>
                <input type="text" name="name" id="name" />
                <label for="salasana">Salasana:</label>
                <input type="password" name="password" id="password" />
                <input type="submit" value="Kirjaudu" />

            </form>
            <a href="app/rekisteroityminen">Rekisteröityminen</a><br/>
        </fieldset>

    </body>
</html>