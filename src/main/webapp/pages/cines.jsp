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

        $("#salas").on("click", function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/pages/cines",
                type: "POST"
            });
        });

        $("#films").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/peliculas.jsp"
        });


        // TODO Carousel
        $('#myCarousel').carousel({
            pause: 'none',
            interval: 1200
        });
    });

</script>
<body style="background-color: #333333">
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
        Cines disponibles
    </div>

    <div id="cines-cines">
        <s:iterator value="lista" status="listaStatus" var="cine">

            <div class="card cine-card w-100" style="width: 20rem;">
                <img class="card-img-top" src="<s:property value="#cine.foto"/>">
                <div class="card-body">
                    <h5 class="card-title"><s:property value="#cine.nombre"/></h5>
                    <p class="card-text"><s:property value="#cine.direccion"/></p>
                    <s:url var="url_cine" action="cine">
                        <s:param name="cineID"><s:property value="#cine.id"/></s:param>
                    </s:url>
                    <a class="btn btn-success" href="${url_cine}">Comprar entradas</a>
                </div>
            </div>
        </s:iterator>
    </div>

</div>

</body>
</html>
