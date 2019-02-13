package productos;

import java.util.Date;

public class Producto {
	
	// FIELDS
	private String codigo;
	private String seccion;
	private String nombre;
	private double precio;
	private Date fecha;
	private String importado;
	private String origen;
	
	
	// GETTERS / SETTERS
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	// CONSTRUCTORS
	public Producto(String codigo, String seccion, String nombre, double precio, Date fecha, String importado, String origen) {
		this.codigo = codigo;
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.origen = origen;
	}
	public Producto(String seccion, String nombre, double precio, Date fecha, String importado, String origen) {
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.origen = origen;
	}
	
	
	@Override
	public String toString() {
		
		//String.format("Productos [codigo=%d, seccion=%s, nombre=%s, precio=%f, fecha=%t, importado=%b, origen=%s]", this.codigo, 
		//		this.seccion, this.nombre, this.precio, this.fecha, this.importado, this.origen));
				
				
				
		return "Productos [codigo=" + codigo + ", seccion=" + seccion + ", nombre=" + nombre + ", precio=" + precio
				+ ", fecha=" + fecha + ", importado=" + importado + ", origen=" + origen + "]";
	}
}
