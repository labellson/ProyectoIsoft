package pModelo;

import java.util.ArrayList;

public class ListaCancion {
  private static ListaCancion singelton;
	private ArrayList<Cancion> lCancion;
	private int indice;
	private int maxIndice;
	
	private ListaCancion(){
		lCancion = new ArrayList<Cancion>();
		indice = 0;
		maxIndice = 0;
	}
	
	public static ListaCancion getSingelton(){
		if(singelton == null){
			singelton = new ListaCancion();
		}
		return singelton;
	}
	
	public void add(Cancion cancion){
		lCancion.add(cancion);
		maxIndice++;
	}
	
	public Cancion get(int indice){
		return lCancion.get(indice);
	}
	
	public ArrayList<Cancion> getDeAlbum(){
		ArrayList<Cancion> cancionesDeAlbum = new ArrayList<Cancion>();
		for(int i=indice; i<maxIndice; i++){
			cancionesDeAlbum.add(lCancion.get(i));
		}
		return cancionesDeAlbum;
	}
	
	public ArrayList<Cancion> get(){
		return lCancion;
	}
	
	public void finAlbum(){
		indice = maxIndice;
	}
}