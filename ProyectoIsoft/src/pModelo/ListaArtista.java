package pModelo;
import java.util.ArrayList;

public class ListaArtista {
	private static ListaArtista singelton;
	private ArrayList<Artista> listaArtista;
	private ListaArtista(){
		listaArtista = new ArrayList<Artista>();
	}
	public static ListaArtista getSingelton(){
		if(singelton == null){
			singelton = new ListaArtista();
		}
		return singelton;
	}
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public Artista compararNombre(String nombre){
		for(int i=0; i<listaArtista.size(); i++){
			if(nombre.equalsIgnoreCase(listaArtista.get(i).getNombre())) return listaArtista.get(i);
		}
		Error.setError("Error, Artista "+nombre+" no encontrado");
		return null;
	}
	
}
