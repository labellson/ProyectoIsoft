package pModelo;

import java.util.ArrayList;
/**
 * Clase Singleton que contiene todas las Biografias
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class ListaBiografia {
	private static ListaBiografia singelton;
	private ArrayList<Biografia> biografia;
	
	private ListaBiografia(){
		biografia = new ArrayList<Biografia>();
	}
	/**
	 * Devuelve la clase ListaBiografia
	 * @return
	 */
	public static ListaBiografia getSingelton(){
		if(singelton == null){
			singelton = new ListaBiografia();
		}
		return singelton;
	}
	/**
	 * Añade una biografia a la lista
	 * @param bio
	 */
	public void addBiografia(Biografia bio){
		biografia.add(bio);
	}
	/**
	 * Devuelve la lista de Biografias
	 * @return
	 */
	public ArrayList<Biografia> get(){
		return biografia;
	}
	/**
	 * Devuelve la biografia a la que le corresponda num
	 * @param num
	 * @return
	 */
	public Biografia getBiografia(int num){
		return biografia.get(num);
	}
	/**
	 * Devuelve el tamaño de la lista de las biografias
	 * @return
	 */
	public int getSize(){
		return biografia.size();
	}
}