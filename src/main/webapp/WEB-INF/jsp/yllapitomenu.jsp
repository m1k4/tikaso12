<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leffa-arkisto</title>
    </head>
    <body>
        <h1>Leffa-arkisto: Ylläpito</h1>

        <p><a id="logout" href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a></p>
        <br>
        <fieldset>
            <legend>Ylläpitotoimet</legend>
            <a href="${pageContext.request.contextPath}/app/users/">Käyttäjien hallinta</a><br/>
            <a href="${pageContext.request.contextPath}/app/movies/">Leffojen hallinta</a><br/>
        </fieldset>
    </body>
</html>
