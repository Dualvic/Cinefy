<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
¡Ha comprado sus entradas!

<s:property value="numeroEntradas"/> = <s:property value="precio"/> €

<ul>
<s:iterator value="pasesComprados" status="pasesCompradosStatus" var="pase">
  <li>
    <s:property value="#pase.horario"/> -- <s:property value="#pase.cine.nombre"/> - <s:property value="#pase.pelicula.titulo"/> -- <s:property value="#pase.usuario.usuario"/>
  </li>
</s:iterator>
</ul>

</body>
</html>