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

        <p><a id="back" href="${pageContext.request.contextPath}/app/index">Takaisin leffahakuun</a></p>

        <h2>Katsotut leffat</h2>

        <div>
            <ul>
                <c:forEach var="movie" items="${user.movies}">
                    <li><a href="${pageContext.request.contextPath}/app/movies/${movie.id}">${movie.name}</a>
                        <form:form method="DELETE" action="${pageContext.request.contextPath}/app/users/${user.id}/movies/${movie.id}">
                            <input type="submit" value="Poista" id="remove-${movie.id}"/>
                        </form:form><br/>
                    </c:forEach>
            </ul>
        </div>

        <c:if test="${not empty movies}">
            <h3>Lisää katsottu</h3>

            <div>
                <form method="POST" action="${pageContext.request.contextPath}/app/users/${user.id}/movies">
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
