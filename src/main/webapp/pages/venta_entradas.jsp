<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

Venta de entradas <br>

<form action="confirmacion_entradas">
    <input type="hidden" name="cineID" value=<%= request.getParameter("cineID") %> />
    <input type="hidden" name="peliculaID" value=<%= request.getParameter("peliculaID") %> />
    <label> Horario: </label> <br>
    <input type="texto" name="horario" required /> <br><br>
    <label> Numero entradas: </label> <br>
    <input type="number" name="numeroEntradas" required />
    <br>
    <br>
    <input type="submit" value="Comprar" />
</form>