<%-- 
    Document   : movie
    Created on : 23.9.2012, 18:43:09
    Author     : m1k4
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movie.name}</title>
    </head>
    <body>
        <h1>Leffa: ${movie.name}</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
        <p><a id="back" href="${pageContext.request.contextPath}/">Takaisin</a></p>
        <fieldset>
            Ohjaaja: ${movie.ohjaaja} <br>
            Genre: ${movie.genre} <br>
            Valmistumisvuosi: ${movie.vuosi} <br>
            Kesto: ${movie.lengthInMinutes} <br>
        </fieldset>
    </body>
</html>
