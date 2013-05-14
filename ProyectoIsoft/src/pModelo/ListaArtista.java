package pModelo;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Clase encargada de almacenar y realizar acciones con los artistas almacenados
 * @author francisco
 */
public class ListaArtista {
	private ArrayList<Artista> listaArtista;
	
	/**
	 * ListaArtista necesita una cadena de caracteres especificando la ruta de el fichero
	 * con la informacion de los artistas
	 * @param ruta
	 */
	public ListaArtista(String[] ruta){
		listaArtista = new ArrayList<Artista>();
	}
	
	/**
	 * Carga los datos de los artistas, posiblemente se modifique y se cree una clase propia*
	 * @param ruta Lista de rutas, donde se encuentran los ficheros a cargar los datos
	 * @throws IOException 
	 */
	public void cargarArtistas(String ruta[]) throws IOException{
		listaArtista = CargarArtistas.getSingelton().getListaArtistas(ruta);
	}
	
	/**
	 * Devuelve la lista de artistas
	 * @return
	 */
	public ArrayList<Artista> getArtistas(){
		return listaArtista;
	}
}


