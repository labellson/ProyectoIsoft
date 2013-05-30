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
	/**
	 * Constructor de biografia
	 * @param nombre
	 * @param fechaNac
	 * @param lugarNac
	 * @param descripcion
	 */
	public Biografia(String nombre, String fechaNac, String lugarNac, String descripcion){
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.lugarNac = lugarNac;
		if(descripcion == "") this.descripcion = "No disponible por el momento, disculpe las molestias"; else this.descripcion = descripcion;
	}
	/**
	 * Devuelve la descripcion de la biografia
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Añade una Descripcion a la biografia
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuelve el nombre de el artista
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Devuelve la Fecha de nacimiento del Artista
	 * @return fechaNac
	 */
	public String getFechaNac() {
		return fechaNac;
	}
	/**
	 * Devuelve el lugar de nacimiento del Artista
	 * @return lugarNac
	 */
	public String getLugarNac() {
		return lugarNac;
	}
	
	
}