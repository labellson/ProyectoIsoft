//Obsoleto
package pModelo;

/**
 * Clase encargada de almacenar valores necesario para iniciar una lectura o escritura de la clase Fichero
 * @author Francisco , Daniel , Ruben , Iban
 */
public class ModeloFichero {
	private String finalVar;
	private String finalClase;
	private String finalBloque;
	private String[][] formato;
	private String[] bandera;
	private int sizeBloques;
	private String nombreBloque[];
	 
	/**
	 * Constructor de la clase ModeloFichero, solo almacena datos
	 * @param finalVar Cadena de caracteres que separaran una variable de otra en la misma clase
	 * @param finalClase Cadena de caracteres que separara una clase de otra en el mismo fichero
	 */
	public ModeloFichero(String finalVar, String finalClase, String finalBloque, String[][] formato, String[] bandera, int sizeBloques){
		this.finalVar = finalVar;
		this.finalClase = finalClase;
		this.finalBloque = finalBloque;
		this.formato = formato;
		this.bandera = bandera;
		this.sizeBloques = sizeBloques;
	}
	
	public String getFinalVar(){
		return finalVar;
	}
	public String getFinalClase(){
		return finalClase;
	}
	public String getFinalBloque() {
		return finalBloque;
	}

	public String[][] getFormato() {
		return formato;
	}

	public String[] getBandera() {
		return bandera;
	}

	public String[][] getformato(){
		return formato;
	}

	public int getSizeBloques() {
		return sizeBloques;
	}

	public String[] getNombreBloque() {
		return nombreBloque;
	}

	public void setNombreBloque(String[] nombreBloque) {
		this.nombreBloque = nombreBloque;
	}
	
	
}