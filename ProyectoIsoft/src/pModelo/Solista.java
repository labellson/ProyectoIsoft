package pModelo;

import java.util.ArrayList;

/**
 * Almacena todos los artistas de la lista listaArtistas que son un Solista (y no un Grupo)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Solista extends Integrante{
	private String nombreArtistico;
	public Solista(String nombre, String nombreArtistico, String[] posicion, Biografia bio, ArrayList<Album> lAlbum){
		super(nombre, posicion, bio, lAlbum);
		this.nombreArtistico = nombreArtistico;
	}
	/**
	 * Devuelve el nombre artistico del Artista
	 * @return nombreArtistico
	 */
	public String getNombreArtistico() {
		return nombreArtistico;
	}
}