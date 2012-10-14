<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Leffojen hallinta</title>
    </head>
    <body>
        <h1>Leffojen hallinta</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p> <br/>
        <p><a id="back" href="${pageContext.request.contextPath}/app/yllapito">Takaisin</a></p>

        <h2>Lisää uusi leffa</h2>

        <div>
            Anna leffan nimi ja paina lisää:<br/>
            <form action="${pageContext.request.contextPath}/app/movies/" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                <input type="submit" value="Lisää"/>            
            </form>
        </div>

        <h2>Nykyiset leffat</h2>

        <ol>
            <c:forEach var="movie" items="${movies}">
                <li>${movie.name} <a href="${pageContext.request.contextPath}/app/movies/${movie.id}/update">[Muokkaa]</a>
                    <form method="POST" action="${pageContext.request.contextPath}/app/movies/${movie.id}/delete">
                        <input type="submit" value="Poista" id="remove-${movie.id}"/>
                    </form><br/>
                </li>
            </c:forEach>
        </ol>

        <div><a href="${pageContext.request.contextPath}/app/users/">Käyttäjien hallinta</a></div>
    </body>
</html>
