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
        <title>Leffan muokkaus</title>
    </head>
    <body>
        <h1>Leffa: ${movie.name}</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
        <p><a id="back" href="${pageContext.request.contextPath}/app/movies">Takaisin</a></p>

        <form:form action="${pageContext.request.contextPath}/app/movies/${movie.id}" method="PUT">
            <fieldset>
                <legend>Leffan tietojen muokkaus</legend>
                <label for="name">Leffan nimi:</label>
                <input id="name" name="name" type="text" value="${movie.name}" /> <br>
                <label for="ohjaaja">Ohjaaja:</label>
                <input id="ohjaaja" name="ohjaaja" type="text" value="${movie.ohjaaja}" /> <br>
                <label for="genre">Genre:</label>
                <input id="genre" name="genre" type="text" value="${movie.genre}" /> <br>
                <label for="vuosi">Valmistumisvuosi:</label>
                <input id="vuosi" name="vuosi" type="text" value="${movie.vuosi}" /> <br>
                <label for="kesto">Kesto (min):</label>
                <input id="lengthInMinutes" name="lengthInMinutes" type="text" value="${movie.lengthInMinutes}" /> <br>
                <br>
                <input type="submit" value="Tallenna leffan muutokset" />
            </fieldset>
        </form:form>
    </body>
</html>
