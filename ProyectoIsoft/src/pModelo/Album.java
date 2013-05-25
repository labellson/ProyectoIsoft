package pModelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que almacena una lista de canciones, cada Grupo o solista tendra una lista de albumes
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Album {
	
	private ArrayList<Cancion> Canciones;
	private String Nombre;
	private String fecha;
	
	public Album(ArrayList<Cancion> pCanciones, String pNombre, String pfecha){
		Canciones = pCanciones;
		Nombre = pNombre;
		fecha = pfecha;
	}

	public ArrayList<Cancion> getCanciones() {
		return Canciones;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getFecha() {
		return fecha;
	}
}