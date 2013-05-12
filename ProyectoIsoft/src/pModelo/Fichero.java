package pModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lectura y escritura de un archivo
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Fichero {
	private String ruta;
	private String texto;
	private String[][] variable;
	private ModeloFichero mf;
	
	/**
	 * @param ruta Cadena de caracteres que menciona la ruta donde se encuentra el archivo a leer 
	 * @param mf Clase encargada de almacenar valores necesario para iniciar una lectura o escritura, determina el formato
	 * @throws IOException *
	 */
	public Fichero(String ruta, ModeloFichero mf) throws IOException{		
		this.ruta=ruta;
		this.mf = mf;
		texto = new String();
		BufferedReader br;
		String[] buffer;

			br = new BufferedReader(new FileReader (new File (ruta)));
			while(br.ready()){
				buffer = br.readLine().split("//");
				if(!buffer[0].equals("")){
					texto +=buffer[0]+"\n";
				}
			}
			br.close();

	}
	
	/**
	 * Retorna el texto cargado del fichero sin modificar, el usuario necesitara gestionarlo 
	 * para recuperar las variables introducidas
	 * @return El texto del fichero elegido
	 */
	public String getText(){
		return texto;
	}
	
	/**
	 * Se encarga de cargar las variables del texto, si aun no han sido creadas y las
	 * retorna, facilitando al usuario su posterior gestion.
	 * @return las variables del texto separadas en una matriz de String[Clase][Variable]
	 */
	public String[][] getVariables(){
		String[] buffer;
		if(variable == null){
			buffer = texto.split(mf.getFinalClase());
			variable = new String[buffer.length][];
			for(int i=0; i < buffer.length; i++){
				variable[i] = buffer[i].split(mf.getFinalVar());
			}
		}
		return variable;
	}
	
	/**
	 * Se encarga de cargar y/o retornar la variable seleccionada del texto
	 * @param clase El conjunto al que pertenece la variable, vease la clase getVariables()
	 * @param variable El numero ordenado al que pertenece esa variable en la clase, vease la clase getVariables()
	 * @return la variable seleccionada del fichero
	 */
	public String getVariables(int clase, int variable){
		//Se llama a la funcion getVariables(), en vez de recoger la variable privada de la clase 
		//ya que esta puede no estar creada, y ahorramos codigo de la otra funcion
		return getVariables()[clase][variable];
	}

	public String getRuta() {
		return ruta;
	}
}
