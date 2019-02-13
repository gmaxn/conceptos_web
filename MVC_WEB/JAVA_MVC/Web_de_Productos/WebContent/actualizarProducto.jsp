<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
			
			
			
		</head>
		
		<body>
			 <h1 align="center">Actualizar Producto</h1>		
			 
			 <form name="form2" method="GET" action="ControladorProductos">
			 
			 <input type="hidden" name="instruccion" value="actualizarBBDD"> <!-- input oculto con el parametro "instruccion" 
			 											   						el cual será reconocido en el metodo doGet 
			 											   					    del controlador "ControladorProductos.java" -->
			  
			  <input type="hidden" name="codigo" value="${PRODUCTO_SELECCIONADO.codigo}">
			  
			  <table width="300">
			    <tbody>
			      <tr>
			        <td>Sección</td>
			        <td align="center"><input type="text" name="seccion" id="seccion" value="${PRODUCTO_SELECCIONADO.seccion}"></td>
			      </tr>
			      <tr>
			        <td>Nombre Artículo</td>
			        <td align="center"><input type="text" name="nombre" id="nombre" value="${PRODUCTO_SELECCIONADO.nombre}"></td>
			      </tr>
			      <tr>
			        <td>Fecha</td>
			        <td align="center"><input type="text" name="fecha" id="fecha" value="${PRODUCTO_SELECCIONADO.fecha}"></td>
			      </tr>
			      <tr>
			        <td>Precio</td>
			        <td align="center"><input type="text" name="precio" id="precio" value="${PRODUCTO_SELECCIONADO.precio}"></td>
			      </tr>
			      <tr>
			        <td>Importado</td>
			        <td align="center"><input type="text" name="importado" id="importado" value="${PRODUCTO_SELECCIONADO.importado}"></td>
			      </tr>
			      <tr>
			        <td>País de Origen</td>
			        <td align="center"><input type="text" name="origen" id="origen" value="${PRODUCTO_SELECCIONADO.origen}"></td>
			      </tr>
			      <tr>
			        <td align="center"><input type="submit" name="envio" id="btnEnviar" value="Enviar" onclick="ControladorProductos"></td>
			        <td align="center"><input type="reset" name="borrar" id="btnRestablecer" value="Restablecer"></td>
			      </tr>
			    </tbody>
			  </table>
			</form>
		</body>
	</html>