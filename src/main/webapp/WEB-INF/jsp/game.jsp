<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${game.name}</title>
    </head>
    <body>
        <h1>Game: ${game.name}</h1>

        <c:if test="${not empty user}">
            <fieldset>
                Kirjautuneena: <a href="${pageContext.request.contextPath}/app/users/${user.id}">${user.name}</a>
                <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
            </fieldset>
        </c:if>

        <p><a id="back" href="${pageContext.request.contextPath}/app/index">Takaisin pääsivulle</a></p>
        <fieldset>
            Alusta: ${game.alusta} <br>
            Lajityyppi: ${game.lajityyppi} <br>
            Valmistumisvuosi: ${game.vuosi} <br>
        </fieldset>

    </body>
</html>
