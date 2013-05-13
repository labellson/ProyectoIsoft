package pModelo;

import java.util.ArrayList;
import java.util.Date;

public class Album {
	
	private ArrayList<Cancion> Canciones;
	private String Nombre;
	private Date año;
	
	public Album(ArrayList<Cancion> pCanciones, String pNombre, Date pAño){
		Canciones = pCanciones;
		Nombre = pNombre;
		año = pAño;
	}
}
