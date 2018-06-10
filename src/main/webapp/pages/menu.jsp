<%--
  Created by IntelliJ IDEA.
  User: viC
  Date: 29/04/2018
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cinefy</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>
    $(document).ready(function () {

        // Redirecciones
        $("#logout").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        });

        $("#profileIcon").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/profile.jsp"
        });

        $("#title-cines").on("click", function () {
            window.location.replace("${pageContext.request.contextPath}/pages/menu.jsp");
        });

        $("#salas").on("click", function () {
            window.location.replace("${pageContext.request.contextPath}/cines");
        });

        $("#films").on("click", function () {
            window.location.replace("${pageContext.request.contextPath}/peliculas");
        });

        // Spoily hidden

        $("#spoily-btn").on("click", function () {
            $("#spoily").hide();
        });

        // TODO Carousel
        $('#myCarousel').carousel({
            pause: 'none',
            interval: 1200
        });
    });

</script>
<body style="background-color: #333333">

<div id="spoily">

    <div id="spoily-conver">
        <h2>¡Hola, me llamo Spoily y sere tu ayudante en tu compra de entradas!</h2>
    </div>

    <div id="popcorn-spoily">
        <img src="${pageContext.request.contextPath}/content/img/popcorn.png" alt="popcorn">
    </div>
    <button id="spoily-btn" class="btn btn-danger"> Continuar</button>
</div>
<div class="container">
<div class="row header" id="header">
    <div id="profileIcon" class="col">
        <i class="fas fa-user-circle"></i>
    </div>
    <div id="title-cines" class="col">
        <h1>Cinefy</h1>
    </div>
    <div id="logout" class="col">
        <i class="fas fa-sign-out-alt"></i>
    </div>
</div>
<div class="row" id="pan">

</div>
    <%--<video autoplay muted loop id="home-video">--%>
        <%--<source src="${pageContext.request.contextPath}/content/media/home.mp4" type="video/mp4">--%>
        <%--Your browser does not support HTML5 video.--%>
    <%--</video>--%>
    <div class="row">
        <div id="films">
            <img src="${pageContext.request.contextPath}/content/img/verPeliculas.png" alt="films">
        </div>

        <div id="salas">
            <img src="${pageContext.request.contextPath}/content/img/verSalas.png" alt="salas">
        </div>
    </div>
</div>

</body>
</html>
