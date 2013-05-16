package pModelo;

import java.util.ArrayList;

/**
 * Almacena todos los artistas de la lista listaArtistas que son un grupo (y no un Solista)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Grupo extends Artista{
	private ListaIntegrantes lIntegrantes;
	public Grupo(String nombre, Biografia bio, ArrayList<Album> lAlbum) {
		super(nombre,bio,lAlbum);
		lIntegrantes = new ListaIntegrantes();
	}
	
	/**
	 * Añade un integrante al grupo
	 * @param integrante Nuevo integrante en el grupo
	 */
	public void addIntegrantes(Integrante integrante){
		lIntegrantes.addIntegrantes(integrante);
	}
	
	public Integrante getIntentegrantes(int indice){
		return lIntegrantes.getIntegrantes(indice);
	}
	
	public int getSize(){
		return lIntegrantes.getSize();
	}

}
