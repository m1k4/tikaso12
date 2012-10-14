<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Pelien hallinta</title>
    </head>
    <body>
        <h1>Pelien hallinta</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p> <br/>
        <p><a id="back" href="${pageContext.request.contextPath}/app/yllapito">Takaisin</a></p>

        <h2>Lisää uusi peli</h2>

        <div>
            Anna pelin nimi ja paina lisää:<br/>
            <form action="${pageContext.request.contextPath}/app/games/" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                <input type="submit" value="Lisää"/>            
            </form>
        </div>

        <h2>Nykyiset pelit</h2>

        <ol>
            <c:forEach var="game" items="${games}">
                <li>${game.name} <a href="${pageContext.request.contextPath}/app/games/${game.id}/update">[Muokkaa]</a>
                    <form:form method="DELETE" action="${pageContext.request.contextPath}/app/games/${game.id}">
                        <input type="submit" value="Poista" id="remove-${game.id}"/>
                    </form:form><br/>
                </li>
            </c:forEach>
        </ol>
        <div><a href="${pageContext.request.contextPath}/app/movies/">Leffojen hallinta</a></div> <br>
        <div><a href="${pageContext.request.contextPath}/app/users/">Käyttäjien hallinta</a></div>
    </body>
</html>
