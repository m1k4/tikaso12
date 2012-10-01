<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Käyttäjien hallinta</title>
    </head>
    <body>

        <h1>Käyttäjien hallinta</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/index.jsp">Kirjaudu ulos</a></p> <br>
        <p><a id="back" href="${pageContext.request.contextPath}/app/yllapito">Takaisin</a></p>
        
        <h2>Nykyiset käyttäjät</h2>
        <ol>
            <c:forEach var="user" items="${users}">
                <li><a>${user.name}</a>
                    <form method="POST" action="${pageContext.request.contextPath}/app/user/${user.id}/delete">
                        <input type="submit" value="Poista" id="remove-${user.id}"/>
                    </form><br/>
                </li>
            </c:forEach>
        </ol>

        <div><a href="${pageContext.request.contextPath}/app/movie/">Leffojen hallinta</a></div>
    </body>
</html>