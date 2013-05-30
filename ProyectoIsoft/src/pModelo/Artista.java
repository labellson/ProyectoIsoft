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
	/**
	 * Constructor de Artista
	 * @param nombre Nombre del Artista
	 * @param bio Biografia del artista
	 * @param lAlbum Albumes del Artista
	 */
	public Artista(String nombre, Biografia bio, ArrayList<Album> lAlbum){
		this.nombre = nombre;
		this.bio = bio;
		this.lAlbum = new ArrayList<Album>();
		this.lAlbum.addAll(lAlbum);
	}
	
	/**
	 * Retorna el nombre del artista (solista o grupo)
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Modifica el nombre del artista.
	 * @param nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Añade una biografia al Artista
	 * @param bio
	 */
	public void setBiografia(Biografia bio) {
		this.bio = bio;
	}
	/**
	 * Devuelve la biografia del Artista
	 * @return bio
	 */
	public Biografia getBio() {
		return bio;
	}
	/**
	 * Devuelve los Albumes del Artista
	 * @return lAlbum
	 */
	public ArrayList<Album> getlAlbum() {
		return lAlbum;
	}
	
	
	
}