<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>

    $(document).ready(function () {

    })

</script>
<body id="home">

<video autoplay muted loop id="home-video">
    <source src="${pageContext.request.contextPath}/content/media/avengers.mp4" type="video/mp4">
    Your browser does not support HTML5 video.
</video>

<div id="login-home">

    <div id="title-home">
        <h1>Cinefy</h1>
        <br>
        <label id="slogan">Tu taquilla online</label>
    </div>

    <div id="popcorn-home">
        <img src="${pageContext.request.contextPath}/content/img/popcorn.png" alt="popcorn">
    </div>

    <form id="form-home" action="login" method="post">
        <div class="form-group">
            <input type="user" class="form-control" id="user" name="usuario" placeholder="Usuario">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="pwd" name="password" placeholder="Contraseña">
        </div>
        <button type="submit" class="btn" id="btn-login-home">Iniciar sesion</button>
    </form>

</div>
</body>
</html>
