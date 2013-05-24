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
	
	public void add(Artista artista){
		listaArtista.add(artista);
	}
	
	public Artista get(int indice){
		return listaArtista.get(indice);
	}
	
	public ArrayList<Artista> get(){
		return listaArtista;
	}
	
	public int compararNombre(String nombre){
		for(int i=0; i<listaArtista.size(); i++){
			if(listaArtista.get(i).getNombre().equalsIgnoreCase(nombre)) return i;
		}
		return -1;
	}
}
