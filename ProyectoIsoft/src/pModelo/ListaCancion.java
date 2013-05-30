package pModelo;

import java.util.ArrayList;
/**
 * Clase Singleton que contiene todas las canciones de la aplicacion
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class ListaCancion {
  private static ListaCancion singelton;
	private ArrayList<Cancion> lCancion;
	private int indice;
	private int maxIndice;

	private ListaCancion(){
		lCancion = new ArrayList<Cancion>();
		indice = 0;
		maxIndice = 0;
	}
	/**
	 * Devuelve la clase ListaCancion
	 * @return
	 */
	public static ListaCancion getSingelton(){
		if(singelton == null){
			singelton = new ListaCancion();
		}
		return singelton;
	}
	/**
	 * Añade una cancion a la lista de canciones
	 * @param cancion
	 */
	public void add(Cancion cancion){
		lCancion.add(cancion);
		maxIndice++;
	}
	/**
	 * Devuelve la cancion a la que le corresponde el indice
	 * @param indice
	 * @return
	 */
	public Cancion get(int indice){
		return lCancion.get(indice);
	}
	
	public ArrayList<Cancion> getDeAlbum(){
		ArrayList<Cancion> cancionesDeAlbum = new ArrayList<Cancion>();
		for(int i=indice; i<maxIndice; i++){
			cancionesDeAlbum.add(lCancion.get(i));
		}
		return cancionesDeAlbum;
	}
	/**
	 * Devuelve la lista de canciones
	 * @return lCancion
	 */
	public ArrayList<Cancion> get(){
		return lCancion;
	}
	
	public void finAlbum(){
		indice = maxIndice;
	}
}