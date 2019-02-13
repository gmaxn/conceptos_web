package productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos)
	{
		this.origenDatos = origenDatos;
	}
	
	public List<Producto> getProductos() 
			throws Exception 
	{	
		List<Producto> productos = new ArrayList<>();
		
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultset = null;
		
		// Establecer la conexion.
		miConexion = origenDatos.getConnection();
		
		// Crear sentencia SQL.
		String instruccionSQL = "SELECT * FROM PRODUCTOS";
		miStatement = miConexion.createStatement();
		
		// Ejecutar SQL.
		miResultset = miStatement.executeQuery(instruccionSQL);
		
		// Recorrer el ResultSet Obtenido.
		while(miResultset.next())
		{
			String codigo = miResultset.getString("CODIGOARTICULO");
			String seccion = miResultset.getString("SECCION");
			String nombre = miResultset.getString("NOMBREARTICULO");
			Double precio = miResultset.getDouble("PRECIO");
			Date fecha = miResultset.getDate("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String origen = miResultset.getString("PAISDEORIGEN");
			
			Producto aux = new Producto(codigo, seccion, nombre, precio, fecha, importado, origen);
			
			productos.add(aux);
		}
		
		return productos;
	}
	public void agregarBBDD(Producto p) throws Exception {
		
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		// OBTENER LA CONEXION A BBDD
		
		try {
			
			miConexion = origenDatos.getConnection();
			
			// CREAR INSTRUCCION SQL QUE INSERTE EL PRODUCTO (statement)
			String sql = "INSERT INTO PRODUCTOS (CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, FECHA, IMPORTADO, PAISDEORIGEN)" +
						 "VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			miStatement = miConexion.prepareStatement(sql);
			
			// ESTABLECER LOS PARAMETROS PARA EL PRODUCTO
			miStatement.setString(1, p.getCodigo()); // --> el primer parametro indica el indice
			miStatement.setString(2, p.getSeccion());//     a ser reemplazado en los signos de 
			miStatement.setString(3, p.getNombre()); //     interrogacion.
			miStatement.setDouble(4, p.getPrecio());	
			miStatement.setDate(5, new java.sql.Date(p.getFecha().getTime())); //--> conversion de java.util.date a java.sql.date
			miStatement.setString(6, p.getImportado());
			miStatement.setString(7, p.getOrigen());
			
			// EJECUTAR LA INSTRUCCION SQL
			miStatement.execute();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			miStatement.close();
			miConexion.close();
		}
	}
	public Producto getProducto(String codigoArticulo) {
		
		Producto aux = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultSet = null;
		
		try 
		{
			// ESTABLECER LA CONEXION
			miConexion = origenDatos.getConnection();
	
			// CREAR SQL QUE BUSQUE EL PRODUCTO
			String sql = "SELECT * FROM PRODUCTOS WHERE CODIGOARTICULO=?";
			
			// CREAR LA CONSULTA PREPARADA
			miStatement = miConexion.prepareStatement(sql);
				
			// ESTABLECER LOS PARAMETROS
			miStatement.setString(1, codigoArticulo);
			
			// EJECUTAR LA CONSULTA
			miResultSet = miStatement.executeQuery();

			// OBTENER LOS DATOS DE RESPUESTA
			if(miResultSet.next())
			{
				String codigo = miResultSet.getString("CODIGOARTICULO"); //--> entra por parametro
				String seccion = miResultSet.getString("SECCION");
				String nombre = miResultSet.getString("NOMBREARTICULO");
				Double precio = miResultSet.getDouble("PRECIO");
				Date fecha = miResultSet.getDate("FECHA");
				String importado = miResultSet.getString("IMPORTADO");
				String origen = miResultSet.getString("PAISDEORIGEN");
				
				aux = new Producto(codigo, seccion, nombre, precio, fecha, importado, origen);
			}
			else
			{
				throw new Exception("No hemos encontrado el producto con código artículo = " + codigoArticulo);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return aux;
	}
	public void actualizarBBDD(Producto p) 
			throws Exception {
		
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		//ResultSet miResultSet = null;
		
		try {
			// ESTABLECER LA CONEXION
			miConexion = origenDatos.getConnection();
	
			// CREAR SQL QUE BUSQUE EL PRODUCTO
			String sql = "UPDATE PRODUCTOS SET SECCION=?, NOMBREARTICULO=?, PRECIO=?, " +
						 "FECHA=?, IMPORTADO=?, PAISDEORIGEN=? WHERE CODIGOARTICULO=?";
			
			// CREAR LA CONSULTA PREPARADA
			miStatement = miConexion.prepareStatement(sql);
				
			// ESTABLECER LOS PARAMETROS			
			miStatement.setString(1, p.getSeccion()); 
			miStatement.setString(2, p.getNombre()); 
			miStatement.setDouble(3, p.getPrecio());	
			miStatement.setDate(4, new java.sql.Date(p.getFecha().getTime())); //--> conversion de java.util.date a java.sql.date
			miStatement.setString(5, p.getImportado());
			miStatement.setString(6, p.getOrigen());
			miStatement.setString(7, p.getCodigo()); 
			
			// EJECUTAR LA CONSULTA SQL
			miStatement.execute();
		}
		finally {
			
			miStatement.close();
			miConexion.close();
		}
	}

	public void eliminarProducto(String codigo) throws Exception {
		
		Connection miConexion = null;
		PreparedStatement miStatement = null;

		try {
			
			// ESTABLECER LA CONEXION CON BBDD
			miConexion = origenDatos.getConnection();
			
			// CREAR LA INSTRUCCION SQL DE ELIMINACION
			String sql = "DELETE FROM PRODUCTOS WHERE CODIGOARTICULO=?";
			
			// PREPARAR LA CONSULTA
			miStatement = miConexion.prepareStatement(sql);
			
			// ESTABLECER LOS PARAMETROS DE CONSULTA
			miStatement.setString(1, codigo);
			
			// EJECUTAR SENTENCIA SQL
			miStatement.execute();
		}
		finally {
			
			miStatement.close();
			miConexion.close();
		}
	}
}
