package pModelo;

import java.util.Date;

/**
 * Clase Abstracta que deriva en BiografiaIntegrante y BiografiaGrupo
 * @author Francisco , Daniel , Ruben , Iban
 */
public abstract class Biografia{
	private String nombre;
	private String fechaNac;
	private String lugarNac;
	private String descripcion;
	
	public Biografia(String nombre, String fechaNac, String lugarNac, String descripcion){
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

	public String getFechaNac() {
		return fechaNac;
	}

	public String getLugarNac() {
		return lugarNac;
	}
	
	
}