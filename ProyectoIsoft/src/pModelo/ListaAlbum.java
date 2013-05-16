package pModelo;

import java.util.ArrayList;

public class ListaAlbum {
  private static ListaAlbum singelton;
	private ArrayList<Album> lAlbum;
	
	private ListaAlbum(){
		lAlbum = new ArrayList<Album>();
	}
	public static ListaAlbum getSingelton(){
		if(singelton == null){
			singelton = new ListaAlbum();
		}
		return singelton;
	}
	public void addAlbum(Album album){
		lAlbum.add(album);
	}
	public Album get(int indice){
		return lAlbum.get(indice);
	}
	
	public void freeSingelton(){
		singelton = null;
	}
}
