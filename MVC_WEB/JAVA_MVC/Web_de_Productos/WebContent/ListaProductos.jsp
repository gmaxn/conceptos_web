<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*, productos.*" %>    
    
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			
			<title>Insert title here</title>
				
			<style type="text/css">
				
				.cabecera {
					
					border-bottom:solid #F00 1px;		
						
				}		
			
			</style>
		</head>
		
		<%
					// OBTENER LOS PRODUCTOS DEL CONTROLADOR (Servlet)
					List<Producto> losProductos = (List<Producto>)request.getAttribute("LISTAPRODUCTOS");
				%>
		
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
				</tr>
				
				<%
									for(Producto aux : losProductos) {
								%>
								
					<tr> <!-- <tr> == ROW & <td> == each CELL in ROW -->
						<td><%= aux.getCodigo() %></td>
						<td><%= aux.getSeccion() %></td>
						<td><%= aux.getNombre() %></td>
						<td><%= aux.getFecha() %></td>
						<td><%= aux.getPrecio() %></td>
						<td><%= aux.getImportado() %></td>
						<td><%= aux.getOrigen() %></td>
					</tr>
					
				<% } %>
			</table>			
		</body>	
	</html>