<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
			
			
			
		</head>
		
		<body>
			 <h1 align="center">Insertar Registros</h1>		
			 
			 <form name="form1" method="GET" action="ControladorProductos">
			 
			 <input type="hidden" name="instruccion" value="insertarBBDD"> <!-- input oculto con el parametro "instruccion" 
			 											   						el cual ser� reconocido en el metodo doGet 
			 											   					    del controlador "ControladorProductos.java" -->
			  
			  <table width="300">
			    <tbody>
			      <tr>
			        <td width="150">Codigo Art�culo </td>
			        <td width="150" align="center"><input type="text" name="codigo" id="codigo"></td>
			      </tr>
			      <tr>
			        <td>Secci�n</td>
			        <td align="center"><input type="text" name="seccion" id="seccion"></td>
			      </tr>
			      <tr>
			        <td>Nombre Art�culo</td>
			        <td align="center"><input type="text" name="nombre" id="nombre"></td>
			      </tr>
			      <tr>
			        <td>Fecha</td>
			        <td align="center"><input type="text" name="fecha" id="fecha"></td>
			      </tr>
			      <tr>
			        <td>Precio</td>
			        <td align="center"><input type="text" name="precio" id="precio"></td>
			      </tr>
			      <tr>
			        <td>Importado</td>
			        <td align="center"><input type="text" name="importado" id="importado"></td>
			      </tr>
			      <tr>
			        <td>Pa�s de Origen</td>
			        <td align="center"><input type="text" name="origen" id="origen"></td>
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