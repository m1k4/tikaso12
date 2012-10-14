<%-- 
    Document   : rekisteroityminen
    Created on : 21.9.2012, 20:07:43
    Author     : m1k4
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Rekisteröityminen</title>
    </head>
    <body>
        
        <h1>Rekisteröityminen</h1>
        
        <p><a id="back" href="${pageContext.request.contextPath}/app/index">Takaisin</a></p>
        
        <h2>Luo uusi käyttäjä</h2>

        <div>
            Anna tarvittavat tiedot ja paina lähetä: 
                <form action="${pageContext.request.contextPath}/app/users/" method="POST">
                    Käyttäjätunnus: <input type="text" name="name" id="name"/><br/>
                    Salasana: <input type="password" name="password" id="password"/><br/>
                    <input type="submit" value="Lähetä"/>
                </form>
        </div>
    </body>
</html>
