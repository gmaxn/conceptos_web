<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Es necesario importar librerias para poder utilizar
    																	  jsp tags para que el codigo quede mas limpio,
    																	  para poder importar las librerias debemos pegar los archivos: 
    																	  javax.servlet.jsp.jstl-1.2.1.jar, javax.servlet.jsp.jstl-api-1.2.1.jar
    																	  en:  Nombre_del_Proyecto >> WebContent >> WEB-INF >> lib -->
    
    
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			
			<title>Insert title here</title>
			
			<style type="text/css">
				
					.cabecera {
						text-align: center;				
						font-size:1.2em;
						font-weight:bold;
						color:#FFFFFF;
						background-color: #08088A;							
					}

					.filas {
						text-align:center;
						background-color:#5882FA;

					}
					
					table {
						float:left;
					}
					
					#contenedorBoton {
						margin-left:500px;
					}
			
			</style>			
		</head>
		
		<!---------- BODY ---------->
		
		<body>	
			<table>
				<tr> <!-- <tr> == ROW & <td> == each CELL in ROW -->
					<td class="cabecera">Código Artículo</td>
					<td class="cabecera">Sección</td>
					<td class="cabecera">Nombre Artículo</td>
					<td class="cabecera">Fecha</td>
					<td class="cabecera">Precio</td>
					<td class="cabecera">Importado</td>
					<td class="cabecera">País de Origen</td>
					<td class="cabecera">Acción</td>
				</tr>

				<c:forEach var="aux" items="${LISTAPRODUCTOS}">	
				
					<!-- Link actualizar cada producto con su campo clave -->		
					<c:url var="linkActualizar" value="ControladorProductos">
						<c:param name="instruccion" value="cargarBBDD"></c:param>
						<c:param name="codigo" value="${aux.codigo}"></c:param>
					</c:url>
					
					<!-- Link eliminar cada producto con su campo clave -->		
					<c:url var="linkEliminar" value="ControladorProductos">
						<c:param name="instruccion" value="eliminarBBDD"></c:param>
						<c:param name="codigo" value="${aux.codigo}"></c:param>
					</c:url>
																			
					<tr> <!-- <tr> == ROW & <td> == each CELL in ROW -->
						<td class="filas">${aux.codigo}</td>
						<td class="filas">${aux.seccion}</td>
						<td class="filas">${aux.nombre}</td>
						<td class="filas">${aux.fecha}</td>
						<td class="filas">${aux.precio}</td>
						<td class="filas">${aux.importado}</td>
						<td class="filas">${aux.origen}</td>
						
						<td class="filas">
							<a href="${linkActualizar}"> Actualizar </a>
						    <a href="${linkEliminar}"> Eliminar </a>
						</td>					
					</tr>
					
				</c:forEach>				
			</table>
			
			<div id="contenedorBoton">		
				<input type="button" value="Insertar Refgistro" onclick="window.location.href='inserta_producto.jsp'"/>		
			</div>
						
		</body>	
	</html>