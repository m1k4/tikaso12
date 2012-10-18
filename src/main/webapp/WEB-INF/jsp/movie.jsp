<%-- 
    Document   : movie
    Created on : 23.9.2012, 18:43:09
    Author     : m1k4
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movie.name}</title>
    </head>
    <body>
        <h1>Leffa: ${movie.name}</h1>

        <c:if test="${not empty user}">
            <fieldset>
                Kirjautuneena: <a href="${pageContext.request.contextPath}/app/users/${user.id}">${user.name}</a>
                <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
            </fieldset>
        </c:if>

        <p><a id="back" href="${pageContext.request.contextPath}/app/index">Takaisin leffahakuun</a></p>
        <fieldset>
            Ohjaaja: ${movie.ohjaaja} <br>
            Genre: ${movie.genre} <br>
            Valmistumisvuosi: ${movie.vuosi} <br>
            Kesto: ${movie.lengthInMinutes} <br>
            <c:if test="${not empty rating}">
                Arvosana: ${rating.rating} 
                <form:form action="${pageContext.request.contextPath}/app/entertainments/${movie.id}/ratings/${rating.id}" method="DELETE">
                    <input type="submit" value="Poista arvosana"/>    
                </form:form>
            </c:if>

            <c:if test="${empty rating and not empty user}">
                <form action="${pageContext.request.contextPath}/app/entertainments/${movie.id}/ratings" method="POST">
                    Arvosana: <select id="rating" name="rating">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select><input type="submit" value="Arvostele"/>
                </form>
            </c:if>
        </fieldset>

    </body>
</html>
