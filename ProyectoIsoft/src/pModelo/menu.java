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
		
		//pruebaFichero(ruta);
		//pruebaClases(ruta);  //Muestra los nombres de los solistas, los grupos y los integrantes de este
		
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
	/**
	 * Prueba de lectura del fichero "datos.txt" 
	 */
	public static void pruebaFichero(String ruta){
		try {
			Fichero f = new Fichero(ruta, ",", "\n", ";\n");
			System.out.println(f.getVariable("Michael Joseph Jackson", "Artista", "nombre"));
			System.out.println(f.getVariable("michael Joseph Jackson", "Artista", "Posicion"));
			System.out.println(f.getVariable(0, 3, 1));
			System.out.println(f.getVariable(0, "BiografiaGrupo", "fechaNacimiento"));
			System.out.println(f.getVariable(1, "Artista", "nombre"));
			System.out.println(f.getVariable(1, "Artista", "posicion"));
			System.out.println("fecha: "+f.getVariable("Ramon melendi espina", "BiografiaIntegrante", "fechaNacimiento"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void pruebaClases(String ruta){
		try {
			CargarDatos.getSingelton().cargar(ruta);
			System.out.println(ListaArtista.getSingelton().get(1).getlAlbum().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
