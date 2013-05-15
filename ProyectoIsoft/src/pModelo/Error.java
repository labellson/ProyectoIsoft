package pModelo;
import java.util.ArrayList;

/**
 * Clase estatica experimental que permite almacenar, y poder gestionar los distintos mensajes de error que puedan
 * ocurrir en todo el programa, no confundir con las excepciones de java.
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Error {
	private static ArrayList<String> error;
	Error(){
		error = new ArrayList<String>();
	}
	
	/**
	 * La funcion se encarga de iniciar la lista de Strings llamada error si no esta iniciada, esta se ejecuta en todas 
	 * las funciones de la clase, por falta de poder iniciarla en el constructor
	 */
	private static void iniciar(){
		if(error == null) error = new ArrayList<String>();
	}
	
	/**
	 * Retorna una lista de String con los errores que todavia no han sido gestionados, con la funcion extraerError()
	 * @return
	 */
	public static String[] getError(){
		iniciar();
		String[] buffer = new String[error.size()];
		for(int i=0; i<error.size(); i++){
			buffer[i] = error.get(i);
		}
		return buffer;
	}
	
	/**
	 * Añade un error mas a la lista de errores a la espera de ser gestionado con la funcion extraerError()
	 * @param pError la frase que va ha mandar el error
	 */
	public static void setError(String pError){
		iniciar();
		error.add(pError);
	}
	
	/**
	 * Retorna el tamaño de la lista de errores
	 * @return
	 */
	public static int getSize(){ 
		iniciar();
		return error.size(); 
	}
	
	/**
	 * En vez de retornar una lista de String con todos los errores almacenados en la lista, esta funcion retorna un unico string
	 * empezando desde el error mas antiguo, hasta el mas reciente y borrandolo de la lista, dando por hecho que ya ha sido gestionado
	 * @return La frase del error mas antigua sin gestionar
	 */
	public static String extraerError(){
		iniciar();
		return error.remove(0);
	}
}
