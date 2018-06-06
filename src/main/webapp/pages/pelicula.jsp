<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>

    <h3>
    DETALLES DE LA PELICULA:
    </h3>

    <div>
        <s:property value="pelicula.titulo"/>
    </div>
    <ul>
        <s:iterator value="pelicula.valoraciones" status="peliculaValoracionesStatus" var="valoracion">
            <li>
                Rating: <s:property value="#valoracion.rating" />
            </li>
        </s:iterator>
    </ul>


    <h4>
    CINES QUE OFRECEN ESTA PELICULA:
    </h4>

    <ul>
        <s:iterator value="pelicula.cines" status="cinesStatus" var="cine">
            <s:url var="url_entradas" action="venta_entradas">
                <s:param name="cineID"><s:property value="#cine.id"/></s:param>
                <s:param name="peliculaID"><s:property value="pelicula.id"/></s:param>
            </s:url>
            <li>
                ID:<s:property value="#cine.id"/>
                <br>
                Nombre: <s:property value="#cine.nombre"/>
                <br>
                Direccion: <s:property value="#cine.direccion"/>
                <br>
                <a href="${url_entradas}">Comprar Entradas</a>
                <br>
                <br>
            </li>
        </s:iterator>
    </ul>

</body>
</html>