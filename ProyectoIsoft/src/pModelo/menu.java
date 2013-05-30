package pModelo;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
	/**
	 * Clase inicial con funcion main, utilizada para iniciar el modelo MVC 
	 * (Tambien usada para hacer pruebas con todas las clases)
	 */
public class menu {
	/**
	 * Funcion Main, inicio del programa
	 * @param args
	 */
	public static void main(String[] args){
		String ruta = "ficheros/datos.txt";
		
		try {
			CargarDatos.getSingelton().cargar(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<Error.getSize(); i++){
			System.out.println(Error.extraerError());
		}
		
		pControlador.Principal controlador = new pControlador.Principal();
	}
	
	
}