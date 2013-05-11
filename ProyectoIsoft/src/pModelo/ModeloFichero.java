package pModelo;

/**
 * Clase encargada de almacenar valores necesario para iniciar una lectura o escritura de la clase Fichero
 * @author Francisco , Daniel , Ruben , Iban
 */
public class ModeloFichero {
	private String finalVar;
	private String finalClase;
	
	/**
	 * Constructor de la clase ModeloFichero, solo almacena datos
	 * @param finalVar Cadena de caracteres que separaran una variable de otra en la misma clase
	 * @param finalClase Cadena de caracteres que separara una clase de otra en el mismo fichero
	 */
	public ModeloFichero(String finalVar, String finalClase){
		this.finalVar = finalVar;
		this.finalClase = finalClase;
	}

	public String getFinalVar() {
		return finalVar;
	}
	public String getFinalClase() {
		return finalClase;
	}
}
