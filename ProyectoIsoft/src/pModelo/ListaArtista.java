package pModelo;
import java.util.ArrayList;
/**
 * Clase Singleton que contendra todos los Artistas de la aplicacion
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class ListaArtista {
	private static ListaArtista singelton;
	private ArrayList<Artista> listaArtista;
	private ListaArtista(){
		listaArtista = new ArrayList<Artista>();
	}
	/**
	 * Devuelve la clase ListaArtista
	 * @return singelton
	 */
	public static ListaArtista getSingelton(){
		if(singelton == null){
			singelton = new ListaArtista();
		}
		return singelton;
	}
	/**
	 * Añade un artista a la lista
	 * @param artista
	 */
	public void add(Artista artista){
		listaArtista.add(artista);
	}
	/**
	 * Devuelve el artista al que le corresponda indice dentro de la lista
	 * @param indice
	 * @return
	 */
	public Artista get(int indice){
		return listaArtista.get(indice);
	}
	/**
	 * Devuelve la lista de Artistas
	 * @return
	 */
	public ArrayList<Artista> getlistaArtista(){
		return listaArtista;
	}
	/**
	 * Busca el indice del artista al que le corresponda el nombre
	 * @param nombre
	 * @return
	 */
	public int compararNombre(String nombre){
		for(int i=0; i<listaArtista.size(); i++){
			if(listaArtista.get(i).getNombre().equalsIgnoreCase(nombre)) return i;
		}
		return -1;
	}
}