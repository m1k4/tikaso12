<%-- 
    Document   : leffanmuokkaus
    Created on : 24.9.2012, 17:01:31
    Author     : m1k4
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pelin muokkaus</title>
    </head>
    <body>
        <h1>Peli: ${game.name}</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
        <p><a id="back" href="${pageContext.request.contextPath}/app/games">Takaisin</a></p>

        <form:form action="${pageContext.request.contextPath}/app/games/${game.id}" method="PUT">
            <fieldset>
                <legend>Pelin tietojen muokkaus</legend>
                <label for="name">Pelin nimi:</label>
                <input id="name" name="name" type="text" value="${game.name}" /> <br>
                <label for="alusta">Alusta:</label>
                <input id="alusta" name="alusta" type="text" value="${game.alusta}" /> <br>
                <label for="Lajityyppi">Lajityyppi:</label>
                <input id="lajityyppi" name="lajityyppi" type="text" value="${game.lajityyppi}" /> <br>
                <label for="vuosi">Valmistumisvuosi:</label>
                <input id="vuosi" name="vuosi" type="text" value="${movie.vuosi}" /> <br>
                <input type="submit" value="Tallenna pelin muutokset" />
            </fieldset>
        </form:form>
    </body>
</html>
