package productos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	
	private ModeloProductos gestorProductos;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try
		{
			gestorProductos = new ModeloProductos(miPool);
		}
		catch(Exception e)
		{
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		
		// LEER EL PARAMETRO DEL FORMULARIO
		
		String frmInsertaProducto = request.getParameter("instruccion");
		
		// SI NO SE ENVIA EL PARAMETRO LISTAR LOS PRODUCTOS
		
		if(frmInsertaProducto == null) {
			
			frmInsertaProducto = "listar";		
		}
		
		// REDIRIGIR EL FLUJO DE EJECUCION AL METODO ADECUADO
		
		switch(frmInsertaProducto) {
		
			case "listar":
				obtenerProductos(request, response);
				break;
				
			case "insertarBBDD":
				agregarProducto(request, response);
				break;
				
			case "cargarBBDD":
				try {
					
					cargarProducto(request, response);
				} 
				catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
				
			case "actualizarBBDD":
				try {
					
					actualizarProducto(request, response);
				} 
				catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
				
			case "eliminarBBDD":
				try {
					
					eliminarProducto(request, response);
				} 
				catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
				
			default: 
				obtenerProductos(request, response);
				break;
		}
		
		// OBTENER PRODUCTOS DE LA LISTA DE PRODUCTOS	
		obtenerProductos(request, response);
		
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// CAPTURAR EL CODIGO ARTICULO
		String codigo = request.getParameter("codigo");
		
		// BORRAR PRODUCTO DE LA BASE DE DATOS
		gestorProductos.eliminarProducto(codigo);
		
		// VOLVER AL LISTADO DE PRODUCTOS
		
		obtenerProductos(request, response);
		
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");

		
		
		// LEER LA INFORMACION DEL PRODUCTO QUE VIENE DEL FORMULARIO ACTUALIZAR
		String codigo = request.getParameter("codigo");
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");	
		Double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String origen = request.getParameter("origen");
		Date fecha = null;

		try {
			
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		 
		// CREAR UN OBJETO DE TIPO PRODUCTO CON LA INFO DEL FORMULARIO
		Producto aux = new Producto(codigo, seccion, nombre, precio, fecha, importado, origen);
		
		// ACTUALIZAR BBDD CON LA INFORMACION DEL OBJETO
		gestorProductos.actualizarBBDD(aux);
		
		// VOLVER AL LISTADO CON LA INFORMACION ACRUALIZADA
		obtenerProductos(request, response);
		
		
		
	}

	private void cargarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// LEER EL CODIGO ARTICULO QUE VIENE DEL LISTADO
		String codigoArticulo = request.getParameter("codigo");
		
		// ENVIAR EL CODIGO ARTICULO AL MODELO
		Producto aux = gestorProductos.getProducto(codigoArticulo);
		
		// COLOCAR ATRIBUTO CORRESPONDIENTE AL CODIGO ARTICULO
		request.setAttribute("PRODUCTO_SELECCIONADO", aux);
		
		// ENVIAR PRODUCTO AL FORMULARIO DE ACTUALIZAR (jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/actualizarProducto.jsp");
		rd.forward(request, response);
		
		
		
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
		
	
		// LEER LA INFORMACION DEL PRODUCTO QUE VIENE DEL FORMULARIO
		String codigo = request.getParameter("codigo");
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");	
		Double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String origen = request.getParameter("origen");
		Date fecha = null;

		try {
			
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		// CREAR UN OBJETO DEL TIPO PRODUCTO
		Producto aux = new Producto(codigo, seccion, nombre, precio, fecha, importado, origen);
		
		// ENVIAR EL OBJETO AL MODELO Y DESPUES INSERTAR EL OBJETO PRODUCTO EN LA BBDD		
		try {
			
			gestorProductos.agregarBBDD(aux);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		// VOLVER AL LISTADO DE PRODUCTOS
		obtenerProductos(request, response);
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		List<Producto> productos;
		
		try
		{
			// OBTENER LA LISTA DE PRODUCTOS DESDE EL MODELO
			productos = gestorProductos.getProductos();
			
			// AGREGAR LISTA DE PRODUCTOS AL REQUEST
			request.setAttribute("LISTAPRODUCTOS", productos);
				
			// ENVIAR EL REQUEST A LA PAGINA JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductosEstilosBibliotecas.jsp");
			miDispatcher.forward(request, response);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}		
	}
}
