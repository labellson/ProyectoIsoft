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
	 * La funcion permite añadir un nuevo integrante a la lista actual
	 * @param integrante
	 */
	public void addIntegrantes(Integrante integrante){
		lIntegrantes.add(integrante);
	}
	
	public Integrante getIntegrantes(int indice){
		return lIntegrantes.get(indice);
	}
	
	public int getSize(){
		return lIntegrantes.size();
	}
}
