package pModelo;

import java.util.ArrayList;

/**
 * La clase que almacena todos los integrantes de grupos o los integrantes unicos del suyo propio(Solista)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Integrante extends Artista{
	private ArrayList<String> lPosicion;
	public Integrante(String nombre, String[] posicion, Biografia bio, ArrayList<Album> lAlbum){
		super(nombre,bio,lAlbum);
		this.lPosicion = new ArrayList<String>();
		for(int i=0; i<posicion.length; i++){
			this.lPosicion.add(posicion[i]);
		}
	}
}