<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>${user.name}</title>
    </head>
    <body>
        <h1>Käyttäjätunnus: ${user.name}</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>

        <p><a id="back" href="${pageContext.request.contextPath}/app/index">Takaisin pääsivulle</a></p>

        <h2>Katsotut leffat</h2>

        <div>
            <ul>
                <c:forEach var="movie" items="${user.movies}">
                    <li><a href="${pageContext.request.contextPath}/app/movies/${movie.id}">${movie.name}</a>
                        <form:form method="DELETE" action="${pageContext.request.contextPath}/app/users/${user.id}/entertainments/${movie.id}">
                            <input type="submit" value="Poista" id="remove-${movie.id}"/>
                        </form:form><br/>
                    </c:forEach>
            </ul>
        </div>

        <c:if test="${not empty movies}">
            <h3>Lisää katsottu</h3>

            <div>
                <ul>
                    <c:forEach var="movie" items="${movies}">
                        <li><a href="${pageContext.request.contextPath}/app/movies/${movie.id}">${movie.name}</a>
                            <form method="POST" action="${pageContext.request.contextPath}/app/users/${user.id}/entertainments/${movie.id}">
                                <input type="submit" value="Lisää" id="add-to-movie"/>
                            </form>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
            
        <h2>Pelatut pelit</h2>

        <div>
            <ul>
                <c:forEach var="game" items="${user.games}">
                    <li><a href="${pageContext.request.contextPath}/app/games/${game.id}">${game.name}</a>
                        <form:form method="DELETE" action="${pageContext.request.contextPath}/app/users/${user.id}/entertainments/${game.id}">
                            <input type="submit" value="Poista" id="remove-${game.id}"/>
                        </form:form><br/>
                    </c:forEach>
            </ul>
        </div>

        <c:if test="${not empty games}">
            <h3>Lisää pelattu</h3>

            <div>
                <ul>
                    <c:forEach var="game" items="${games}">
                        <li><a href="${pageContext.request.contextPath}/app/games/${game.id}">${game.name}</a>
                            <form method="POST" action="${pageContext.request.contextPath}/app/users/${user.id}/entertainments/${game.id}">
                                <input type="submit" value="Lisää" id="add-to-game"/>
                            </form>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
    </body>
</html>
