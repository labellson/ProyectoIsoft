package pModelo;

import java.util.ArrayList;
/**
 * Clase Singleton que contiene todos los Albumes de la aplicacion
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class ListaAlbum {
  private static ListaAlbum singelton;
	private ArrayList<Album> lAlbum;
	/**
	 * Constructor de ListaAlbum
	 */
	private ListaAlbum(){
		lAlbum = new ArrayList<Album>();
	}
	/**
	 * Devuelve la clase ListaAlbum
	 * @return singelton
	 */
	public static ListaAlbum getSingelton(){
		if(singelton == null){
			singelton = new ListaAlbum();
		}
		return singelton;
	}
	/**
	 * Añade un Album a la lista
	 * @param album
	 */
	public void addAlbum(Album album){
		lAlbum.add(album);
	}
	/**
	 * Devuelve el album que indique indice
	 * @param indice
	 * @return
	 */
	public Album get(int indice){
		return lAlbum.get(indice);
	}
	/**
	 * Devuelve todos albumes
	 * @return lAlbum
	 */
	public ArrayList<Album> get(){
		return lAlbum;
	}
	/**
	 * Elimina la clase ListaAlbum
	 */
	public void freeSingelton(){
		singelton = null;
	}
}