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
	private Date fecha;
	
	public Album(ArrayList<Cancion> pCanciones, String pNombre, Date pfecha){
		Canciones = pCanciones;
		Nombre = pNombre;
		fecha = pfecha;
	}
}
