package pModelo;
import java.util.ArrayList;

/**
 * Clase encargada de almacenar todos los datos de su Artista asignado.
 * @author Francisco , Daniel , Ruben , Iban
 *
 */
public abstract class Artista {
	private String nombre;
	private Biografia bio;
	private ArrayList<Album> lAlbum;
	private String genero;
	
	public String getGenero() {
		return genero;
	}

	public Artista(String nombre, Biografia bio, ArrayList<Album> lAlbum){
		this.nombre = nombre;
		this.bio = bio;
		this.lAlbum = lAlbum;
	}
	
	/**
	 * Retorna el nombre del artista (solista o grupo)
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Modifica el nombre del artista.
	 * @param nombre el nuevo nombre del artista
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Biografia getBiografia() {
		return bio;
	}

	public void setBiografia(Biografia bio) {
		this.bio = bio;
	}
	
	
}
