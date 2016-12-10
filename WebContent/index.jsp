<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Crud Proyect</title>
</head>
<body>
<h1>CRUD</h1>

<div style="margin: 20px">
	<form action="./ServletInsert" method="post"  name="formInsert">
		<div><h2>Insert</h2></div>
		<div>
			<label>Nombre: </label>
				<input id="nombreI" name="nombreI" type="text" >
			<label>Empresa: </label>
				<input id="empresaI" name="empresaI" type="text" >
		</div>
		<div>
			<input id="insert" name="insert" type="submit" value="Insertar">
		</div>
		<div>
			<c:if test="${!empty status}">
				<%=request.getAttribute("status")%>
			</c:if>
		</div>
	</form>
</div>
<div style="margin: 20px">
	<form action="./ServletReload" method="post"  name="formReload">
	<div><h2>Cargar</h2></div>
	<div>
	<table border="1" id="tablaReload">
	<thead><tr><td>Personaje</td><td>Empresa</td></tr></thead>
	<c:if test="${!empty lista}">
		<%=request.getAttribute("lista")%>
	</c:if>
   	</table>
	</div>
		<div>
			<input id="show" name="show" type="submit" value="Mostrar">
		</div>
	</form>
</div>

<div style="margin: 20px">
	<form action="./ServletUpdate" method="post"  name="formUpdate">	
		<div><h2>Update</h2></div>
		<div>	
			<label>Registro</label>
				<select name="listU" id="listU">
			
				</select>
		</div>
		<div>
			<label>Nombre: </label>
				<input id="nombreU" name="nombreU" type="text" >
			<label>Empresa: </label>
				<input id="empresaU" name="empresaU" type="text" >
		</div>
		<div>
			<input id="update" name="update" type="submit" value="Actualizar">
		</div>
		<div>
			<c:if test="${!empty stts}">
				<%=request.getAttribute("stts")%>
			</c:if>
		</div>		
	</form>
</div>

<div style="margin: 20px">
	<form action="./ServletDelete" method="post"  name="formDelete">
	<div><h2>Delete</h2></div>
	<div>
	<label>Registro</label>
				<select name="delU" id="delU">
			
				</select>
	</div>
		<div>
			<input id="delete" name="delete" type="submit" value="Eliminar">
		</div>
		<div>
			<c:if test="${!empty stat}">
				<%=request.getAttribute("stat")%>
			</c:if>
		</div>
	</form>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
	$.ajax({
	url:'http://localhost:8082/FrontWS/loadCombos',	
	success:function(response){
		$("#listU").html(response);
		$("#delU").html(response);
		}
	});
	});		
</script>
</html>