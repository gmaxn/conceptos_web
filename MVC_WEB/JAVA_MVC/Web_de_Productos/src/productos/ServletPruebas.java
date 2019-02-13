package productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Definir o establecer el DataSource
	@Resource(name="jdbc/Productos") //--> pool de conecciones declarado en context.xml
	private DataSource miPool;
	
	
    public ServletPruebas() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		// Crear el obj PrintWritter
		PrintWriter salida = response.getWriter();	
		response.setContentType("text/plain");
		
		// Crear conexion con BBDD
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultSet = null;
		
		try 
		{
			
			miConexion = miPool.getConnection();
			String miSql = "SELECT * FROM PRODUCTOS";
			
			miStatement = miConexion.createStatement();
			
			miResultSet = miStatement.executeQuery(miSql);
			
			while(miResultSet.next())
			{
				String nombreArticulo = miResultSet.getString(3);
				
				salida.println(nombreArticulo);
				
			}	
		}
		catch(Exception e) 
		{
			
			e.printStackTrace();		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

	}
}
