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
            <legend>Kirjaudu sisään</legend>
            <form action="app/login" method="POST">
                <label for="tunnus">Käyttäjätunnus:</label>
                <input type="text" name="name" id="name" />
                <label for="salasana">Salasana:</label>
                <input type="password" name="password" id="password" />
                <input type="submit" value="Kirjaudu" />

            </form>
            <br>
            <a href="app/rekisteroityminen">Rekisteröityminen</a><br/>
        </fieldset>

        <br>

        <fieldset>
            <legend>Leffahaku</legend>
            <form action="app/movie/find" method="GET">
                <label for="hakusana">Hakusana:</label>
                <input type="text" name="hakusana" id="hakusana"/>
                <input type="submit" value="Hae" />
            </form>
        </fieldset>

        <br>

        <fieldset>
            <legend>Hakutulokset</legend>

            <form action="app/movie/movies" method="GET">
                <input type="submit" value="Kaikki leffat" />
            </form>
        </fieldset>

    </body>
</html>