package pModelo;

import java.util.ArrayList;

/**
 * Biografia de un grupo, esta aparte de los parametros de su super clase Biografia, contendra una lista de la biografia
 * de los actuales integrantes del grupo
 * @author Francisco , Daniel , Ruben , Iban
 */
public class BiografiaGrupo extends Biografia{
	private ArrayList<BiografiaIntegrante> bioIntegrantes;
	public BiografiaGrupo(String nombre, String fechaNac, String lugarNac,String descripcion) {
		super(nombre, fechaNac, lugarNac, descripcion);

	}

}
