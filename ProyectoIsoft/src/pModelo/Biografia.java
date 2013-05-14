package pModelo;

import java.util.Date;

public class Biografia {
	private String nombre;
	private Date fechaNac;
	private String lugarNac;
	private String descripcion;
	
	public Biografia(String nombre, Date fechaNac, String lugarNac, String descripcion){
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.lugarNac = lugarNac;
		if(descripcion == "") this.descripcion = "No disponible por el momento, disculpe las molestias"; else this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public String getLugarNac() {
		return lugarNac;
	}
	
	
}
