<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.name}</title>
    </head>
    <body>
        <h1>Käyttäjätunnus: ${user.name}</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/index.jsp">Kirjaudu ulos</a></p>

        <h2>Katsotut leffat</h2>

        <div>
            <ul>
                <c:forEach var="movie" items="${user.movies}">
                    <li><a href="${pageContext.request.contextPath}/app/movie/${movie.id}">${movie.name}</a>
                    </c:forEach>
            </ul>
        </div>

        <c:if test="${not empty movies}">
            <h3>Lisää katsottu</h3>

            <div>
                <form method="POST" action="${pageContext.request.contextPath}/app/user/${user.id}/movie">
                    <select name="movieId">
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.id}">${movie.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Lisää" id="add-to-movie"/>
                </form>
            </div>
        </c:if>
    </body>
</html>
