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

        <a href="yllapito">Ylläpito</a><br/>
        <br>

        <c:if test="${not empty user}">
            Kirjautuneena: ${user}
            <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
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

        <br>

        <fieldset>
            <legend>Leffahaku</legend>
            <form action="movie/find" method="GET">
                <label for="hakusana">Hakusana:</label>
                <input type="text" name="hakusana" id="hakusana"/>
                <input type="submit" value="Hae" />
            </form>
        </fieldset>

        <br>

        <fieldset>
            <legend>Hakutulokset</legend>

            <c:if test="${not empty movies}">
                <div>
                    <c:forEach var="movie" items="${movies}">
                        <li><a href="${pageContext.request.contextPath}/app/movie/${movie.id}">${movie.name}</a>
                        </c:forEach>
                </div>
            </c:if>

            <br>

            <form action="movie/movies" method="GET">
                <input type="submit" value="Kaikki leffat" />
            </form>
        </fieldset>

    </body>
</html>