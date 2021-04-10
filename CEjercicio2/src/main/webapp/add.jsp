<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String Id = request.getParameter("Id");
String Usuario = request.getParameter("Usuario");
String Pass = request.getParameter("Pass");

if(Id==null){
	
	Id="";
	Usuario="";
	Pass="";
}
%>


<form action="ControllerMostrarInformacion" method="get">

<input type="hidden" name="IdUsuario" value=<%=Id%>>

<label>Usuario</label>
<input type="text" value="<%=Usuario%>" name="usuario"> 

<label>Password</label>
<input type="text" value="<%=Pass%>" name="Pass"> 

<button name="Guardar" value="btna">Guardar</button>
</form>
</body>
</html>