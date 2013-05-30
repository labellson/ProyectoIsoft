package pModelo;

import java.util.ArrayList;

/**
 * Clase que almacena todas los integrantes de todos los grupos o solistas
 * @author Francisco , Daniel , Ruben , Iban
 */
public class ListaIntegrantes {
	private ArrayList<Integrante> lIntegrantes;
	public ListaIntegrantes(){
		lIntegrantes = new ArrayList<Integrante>();
	}
	
	/**
	 * La funcion permite anadir un nuevo integrante a la lista actual
	 * @param integrante
	 */
	public void addIntegrantes(Integrante integrante){
		lIntegrantes.add(integrante);
	}
	/**
	 * devuelve el integrante al que le corresponda indice
	 * @param indice
	 * @return
	 */
	public Integrante getIntegrantes(int indice){
		return lIntegrantes.get(indice);
	}
	/**
	 * Devuelve el tamaño de la lista de integrantes
	 * @return
	 */
	public int getSize(){
		return lIntegrantes.size();
	}
}