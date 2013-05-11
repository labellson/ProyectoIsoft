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
		pruebaFichero();
	}
	/**
	 * Prueba de lectura del fichero "datos.txt" 
	 */
	public static void pruebaFichero(){
	//1. Creacion de la clase Fichero y la clase ModeloFichero
		pModelo.Fichero f = new pModelo.Fichero("src/datos.txt", new pModelo.ModeloFichero(",", "\n}\n"));
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
	}
	
}
