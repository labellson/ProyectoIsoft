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
	private ArrayList<Integer> lIndex;

	private ListaCancion(){
		lCancion = new ArrayList<Cancion>();
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
	 * AÃ±ade una cancion a la lista de canciones y ordena la lista
	 * @param cancion
	 */
	public void add(Cancion cancion){
		int index = ordenar(cancion);
		if(index == -1){
			index = lCancion.size();
			lCancion.add(cancion);
		}else{
			lCancion.add(index, cancion);
		}
		if(lIndex == null) lIndex = new ArrayList(); 
		for(int i=0; i<lIndex.size(); i++){
			if(index <= lIndex.get(i)) lIndex.set(0, lIndex.get(i)+1);
		}
		lIndex.add(index);
	}
	
	/**
	 * retorna las canciondes de ese album
	 * @return canciones del album
	 */
	public ArrayList<Cancion> getDeAlbum(){
		ArrayList<Cancion> cancionesDeAlbum = new ArrayList<Cancion>();
		for(int i=0; i<lIndex.size(); i++){
			cancionesDeAlbum.add(lCancion.get(lIndex.get(i)));
		}
		lIndex = null;
		return cancionesDeAlbum;
	}
	/**
	 * Devuelve la cancion a la que le corresponde el indice
	 * @param indice
	 * @return
	 */
	public Cancion get(int indice){
		return lCancion.get(indice);
	}

	/**
	 * Devuelve la lista de canciones
	 * @return lCancion
	 */
	public ArrayList<Cancion> get(){
		return lCancion;
	}
	
	/**
	 * Ordena la lista de canciones mas valorada, respecto a la ultima cancion añadida, retorna el indice donde se almacena
	 * @param cancion
	 * @return indice
	 */
	private int ordenar(Cancion cancion){
		int index = -1;
		for(int i=0; i<lCancion.size(); i++){
			if(cancion.getPuntuacion() > lCancion.get(i).getPuntuacion()){
				index = i;
				break;
			}
		}
		return index;
	}
}