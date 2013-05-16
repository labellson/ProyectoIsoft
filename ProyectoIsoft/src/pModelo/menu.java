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
		pruebaClases(ruta);  //Muestra los nombres de los solistas, los grupos y los integrantes de este
		
		try {
			CargarDatos.getSingelton().cargar(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<Error.getSize(); i++){
			System.out.println(Error.extraerError());
		}
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
			for(int i=0; i<ListaArtista.getSingelton().get().size();i++){
				Artista buffer = ListaArtista.getSingelton().get(i);
				if(buffer.getClass() == Grupo.class){
					System.out.println(ListaArtista.getSingelton().get(i).getNombre());
					for(int j=0; j<((Grupo)buffer).getSize(); j++){
						System.out.println("\t"+((Grupo)ListaArtista.getSingelton().get(i)).getIntentegrantes(j).getNombre());
					}
				}else{
					System.out.println(ListaArtista.getSingelton().get(i).getNombre());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
