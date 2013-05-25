package pModelo;

import java.util.ArrayList;

/**
 * Almacena todos los artistas de la lista listaArtistas que son un Solista (y no un Grupo)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Solista extends Integrante{
	
	public Solista(String nombre, String posicion, Biografia bio, ArrayList<Album> lAlbum){
		super(nombre, posicion, bio, lAlbum);
	}
}