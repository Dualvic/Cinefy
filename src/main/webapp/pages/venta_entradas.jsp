<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


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

        $("#back-cartelera").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/cine.action?cineID=1"
        });

        // Nº Entradas
        
        $(".fa-plus-square").on("click", function () {
            let entradasValue = $("#n-entradas").val();
            if(parseInt(entradasValue) < 0) {
                $("#n-entradas").val(0)
            } else {
                $("#n-entradas").val(parseInt(entradasValue) + 1)
            }
        });

        // Comprobamos que el usuario no puede meter entradas negativas
        $(".fa-minus-square").on("click", function () {
            let entradasValue = $("#n-entradas").val();
            if(parseInt(entradasValue) < 0) {
                $("#n-entradas").val(0)

            } else {
                let result = parseInt(entradasValue) - 1;
                if (result < 0) {
                    $("#n-entradas").val(0)
                } else {
                    $("#n-entradas").val(parseInt(entradasValue) - 1)
                }
            }
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
        Venta de entradas
    </div>

    <div id="cines-venta">
        <form id="form-entradas" action="confirmacion_entradas">
            <input type="hidden" name="cineID" value=<%= request.getParameter("cineID") %> />
            <input type="hidden" name="peliculaID" value=<%= request.getParameter("peliculaID") %> />
            <br>
            <select class="form-control" name="horario">
                <option>12:00</option>
                <option>14:00</option>
                <option>17:00</option>
                <option>18:00</option>
                <option>22:00</option>
            </select>
            <br>
            <div id="n-entradas-sel">
                <div id="more-n">
                    <i class="fas fa-plus-square"></i>
                </div>
            <input id="n-entradas" type="number" name="numeroEntradas" value="1" required />
                <div id="less-n">
                    <i class="fas fa-minus-square"></i>
                </div>
            </div>
            <button type="submit" id="submit-entradas" class="circleBase type1"><img src="${pageContext.request.contextPath}/content/img/popcornCoke.png"></button>
        </form>
    </div>

    <div id="back-cartelera" class="circleBase type1">
        <i class="fas fa-chevron-circle-left"></i>
    </div>
</div>

</body>
</html>