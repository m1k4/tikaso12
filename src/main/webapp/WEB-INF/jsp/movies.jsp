<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leffojen hallinta</title>
    </head>
    <body>
        <h1>Leffojen hallinta</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/index.jsp">Kirjaudu ulos</a></p> <br/>
        <p><a id="back" href="${pageContext.request.contextPath}/app/yllapito">Takaisin</a></p>

        <h2>Lisää uusi leffa</h2>

        <div>
            Enter name and and press Submit:<br/>
            <form action="${pageContext.request.contextPath}/app/movie/" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                <input type="submit" value="Lisää"/>            
            </form>
        </div>

        <h2>Nykyiset leffat</h2>

        <ol>
            <c:forEach var="movie" items="${movies}">
                <li><a href="${movie.id}">${movie.name}</a>
                    <form method="POST" action="${pageContext.request.contextPath}/app/movie/${movie.id}/delete">
                        <input type="submit" value="Poista" id="remove-${movie.id}"/>
                    </form><br/>
                </li>
            </c:forEach>
        </ol>

        <div><a href="${pageContext.request.contextPath}/app/user/">Käyttäjien hallinta</a></div>
    </body>
</html>
