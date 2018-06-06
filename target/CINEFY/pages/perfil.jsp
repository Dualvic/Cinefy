<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

    <div>
        <s:property value="usuario.usuario"/>
    </div>

    PASES DEL USUARIO
    <ul>
        <s:iterator value="usuario.pases" status="pasesStatus" var="pase">
            <li>
                Horario: <s:property value="#pase.horario"/>
                <br>
                Cine: <s:property value="#pase.cine.nombre"/>
                <br>
                Pelicula: <s:property value="#pase.pelicula.titulo"/>
                <br>
            </li>
            <br>
        </s:iterator>
    </ul>

</html>