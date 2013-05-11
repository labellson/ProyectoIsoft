package pModelo;

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
	ListaArtista(String ruta){
		//Cuando se inicie listaArtista, cargara los datos de los artistas de la base de datos
		cargarArtistas(ruta);
	}
	public void cargarArtistas(String ruta){
		//Implementar clase cargarArchivo
	}
}


