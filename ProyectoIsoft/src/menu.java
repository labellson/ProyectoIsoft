import java.io.IOException;

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
		//pruebaFichero();
		String ruta[] = new String[3];
		ruta[0] = "ficheros/grupos.txt";
		ruta[1] = "ficheros/solistas.txt";
		ruta[2] = "ficheros/artistas.txt";
		pModelo.ListaArtista lArtista = new pModelo.ListaArtista(ruta);
	}
	/**
	 * Prueba de lectura del fichero "datos.txt" 
	 */
	public static void pruebaFichero(){
	//1. Creacion de la clase Fichero y la clase ModeloFichero
		pModelo.Fichero f;
		try {
			f = new pModelo.Fichero("ficheros/artistas.txt", new pModelo.ModeloFichero(",", "\n"));
		//2. Muestra el texto sin modificar
			System.out.println("######Texto#######");
			System.out.print(f.getText());
			System.out.println("##################\n");
		//3. Accede a cada variable por separado, teniendo control total de cada una de ellas
			for(int i=0; i<f.getVariables().length; i++){
				System.out.println("clase"+i+":");
				for(int j=0; j<f.getVariables()[i].length; j++){
					System.out.print("var"+j+": ");
					System.out.print(f.getVariables()[i][j]);
					System.out.print("\t");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
