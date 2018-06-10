<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>

    $(document).ready(function () {

        $("#userPwDrop").click(function(){
                $("#changePw").slideToggle();
        });


        $(".fa-home").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/menu.jsp"
        })
    });

    function validate() {

        let olderPass = document.getElementById("olderPw");
        let newPw = document.getElementById("newPw");
        let newPwConfirm = document.getElementById("newPwConfirm");

        if (olderPass.value !== "") {
            if (newPw.value === newPwConfirm.value) {
                return true;
            }
        } else {
            return false;
        }
    }

</script>
<body id="profile">
<div class="container">
    <div class="row">
        <div id="profileHeader">
            <i class="fas fa-home"></i>
            <p>Cinefy</p>
        </div>
        <div id="profileTitle"><p>Perfil</p></div>
        <div id="profileAvatar"><img src="${pageContext.request.contextPath}/content/img/popcorn.png"></div>
        <button class="btn btn-warning" id="userPwDrop"><p>Cambiar Contraseña</p></button>

        <div id="changePw">
            <form id="changePwForm" action="passwordChange">
                <div class="form-group">
                    <input type="password" class="form-control" id="olderPw" name="olderPw" placeholder="Introduzca su antigua contraseña">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="newPw" name="newPw" placeholder="Nueva contraseña">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="newPwConfirm" name="newPwConfirm"
                           placeholder="Repita su nueva contraseña">
                </div>
                <button type="submit" class="btn btn-warning" id="pw-new-button" onclick="validate()">Aceptar</button>
            </form>
        </div>

        <div id="social-media">
            <i class="fab fa-facebook-square"></i>
            <i class="fab fa-instagram"></i>
            <i class="fab fa-twitter"></i>
        </div>
    </div>
</div>

</body>
</html>
