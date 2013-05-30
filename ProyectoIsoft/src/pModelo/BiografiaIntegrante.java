package pModelo;

import java.util.ArrayList;

/**
 * Biografia de un integrante de un grupo o solista, esta aparte de los parametros de su super clase Biografia, 
 * contendra una lista de los grupos a los que a pertenecido y al grupo al que pertenece alcualmente
 * @author Francisco , Daniel , Ruben , Iban
 */
public class BiografiaIntegrante extends Biografia{
	ArrayList<Grupo> gruposPertenecidos;
	Grupo grupoPertenece;
	/**
	 * Constructor de BiografiaIntegrante
	 * @param nombre
	 * @param fechaNac
	 * @param lugarNac
	 * @param descripcion
	 */
	public BiografiaIntegrante(String nombre, String fechaNac, String lugarNac,String descripcion) {
		super(nombre, fechaNac, lugarNac, descripcion);
	}

}