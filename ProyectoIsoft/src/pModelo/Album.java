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
	/**
	 * Constructor de Album
	 * @param pCanciones Lista de canciones
	 * @param pNombre Nombre del album
	 * @param pfecha fecha del Album
	 */
	public Album(ArrayList<Cancion> pCanciones, String pNombre, String pfecha){
		Canciones = new ArrayList<Cancion>();
		Canciones.addAll(pCanciones);
		Nombre = pNombre;
		fecha = pfecha;
	}
	/**
	 * Devuelve las canciones del album
	 * @return Canciones
	 */
	public ArrayList<Cancion> getCanciones() {
		return Canciones;
	}
	/**
	 * Devuelve el nombre del Album
	 * @return Nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * Devuelve la Fecha del Album
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}
}