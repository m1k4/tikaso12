<%-- 
    Document   : movies
    Created on : 24.9.2012, 18:29:33
    Author     : m1k4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kaikki leffat</title>
    </head>
    <body>
        <h1>Kaikki leffat</h1>
        
        <p><a id="back" href="${pageContext.request.contextPath}/index.jsp">Takaisin</a></p>

        <div>
            <ul>
                <c:forEach var="movie" items="${movies}">
                    <li><a href="${pageContext.request.contextPath}/app/movie/${movie.id}">${movie.name}</a>
                    </c:forEach>
            </ul>
        </div>
    </body>
</html>
