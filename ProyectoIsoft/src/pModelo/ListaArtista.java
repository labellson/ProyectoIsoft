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
	
}
