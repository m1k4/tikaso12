<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Viihdearkisto</title>
    </head>
    <body>
        <div id="profile">${profile.name}</div>

        <h1>Viihdearkisto</h1>   

        <a href="yllapito">Ylläpito</a><br/>
        <br>

        <c:if test="${not empty user}">
            <fieldset>
                Kirjautuneena: <a href="${pageContext.request.contextPath}/app/users/${user.id}">${user.name}</a>
                <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
            </fieldset>
        </c:if>

        <c:if test="${empty user}">
            <fieldset>
                <legend>Kirjaudu sisään</legend>
                <form action="login" method="POST">
                    <label for="tunnus">Käyttäjätunnus:</label>
                    <input type="text" name="name" id="name" />
                    <label for="salasana">Salasana:</label>
                    <input type="password" name="password" id="password" />
                    <input type="submit" value="Kirjaudu" />

                </form>

                <br>
                <a href="rekisteroityminen">Rekisteröityminen</a><br/>
            </fieldset>
        </c:if>

        <h2>Arkiston sisältö</h2>

        <fieldset>
            <legend>Leffat</legend>
            <c:if test="${not empty movies}">
                <div>
                    <c:forEach var="movie" items="${movies}">
                        <li><a href="${pageContext.request.contextPath}/app/movies/${movie.id}">${movie.name}</a>
                        </c:forEach>
                </div>
            </c:if>
            <form action="movies/leffat" method="GET">
                <input type="submit" value="Kaikki leffat" />
            </form>
        </fieldset>

        <fieldset>
            <legend>Pelit</legend>
            <c:if test="${not empty games}">
                <div>
                    <c:forEach var="game" items="${games}">
                        <li><a href="${pageContext.request.contextPath}/app/games/${game.id}">${game.name}</a>
                        </c:forEach>
                </div>
            </c:if>
            <form action="games/pelit" method="GET">
                <input type="submit" value="Kaikki pelit" />
            </form>
        </fieldset>
    </body>
</html>