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
	 * Anade un integrante al grupo
	 * @param integrante Nuevo integrante en el grupo
	 */
	public void addIntegrantes(Integrante integrante){
		lIntegrantes.addIntegrantes(integrante);
	}
	/**
	 * Devuelve el integrante de la lista al que le correspondael indice
	 * @param indice
	 * @return El integrante de lIntegrante de la posicion indice
	 */
	public Integrante getIntentegrantes(int indice){
		return lIntegrantes.getIntegrantes(indice);
	}
	/**
	 * Devuelve el tamaño de la lista de Integrantes
	 * @return
	 */
	public int getSize(){
		return lIntegrantes.getSize();
	}

}