package pModelo;

/**
 * Clase encargada de almacenar todos los datos de su Artista asignado.
 * @author Francisco , Daniel , Ruben , Iban
 *
 */
public abstract class Artista {
	private String nombre;
	public Artista(String nombre){
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
