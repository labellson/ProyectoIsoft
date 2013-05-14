package pModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que mediante una ruta, un modelo de fichero(explicado en su propia clase) y opcionalmente una cadena de caracteres
 * la cual indicara en la lectura del fichero partes que se consideran comentarios y no se almacenan, por defecto es "//".
 * Es capaz de extraer inicialmente el texto completo del fichero elegido, posteriormente dividido en una matriz de String,
 * un ejemplo es verlo pensando que en el fichero se encuentras varias clases, con varias variables cada una.
 * ej. grafico String[posClase][posVariable]
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Fichero {
	private String ruta;
	private String texto;
	private String[][] variable;
	private String comentario;
	private ModeloFichero mf;
	
	/**
	 * Constructor que se encarga de la primera fase de la carga del fichero, ignora la parte de comentarios y las lineas
	 * vacias y extrae todo lo demas, dejando el texto aun sin separar en variables
	 * @param ruta Cadena de caracteres que menciona la ruta donde se encuentra el archivo a leer 
	 * @param mf Clase encargada de almacenar valores necesario para iniciar una lectura o escritura, determina el formato
	 * @param comentario Cadena de caracter que ignorara desde que es encontrada hasta un nuevo salto de linea el texto
	 * @throws IOException *
	 */
	public Fichero(String ruta, ModeloFichero mf, String comentario) throws IOException{		
		this.comentario = comentario;
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
	 * Constructor opcional en el cual el String comentario por defecto es "//"
	 * @param ruta
	 * @param mf
	 * @throws IOException
	 */
	public Fichero(String ruta, ModeloFichero mf) throws IOException{		
		this(ruta,mf,"//");
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
	
	/**
	 * Se usa para adquirir la ruta actual del fichero
	 * @return ruta
	 */
	public String getRuta() {
		return ruta;
	}
}
