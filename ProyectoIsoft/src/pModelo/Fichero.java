package pModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	private String rawTexto;
	private String[][][] variable;
	private String[][] bandera;
	private String comentario;
	private ModeloFichero mf;
	
	/**
	 * Constructor que se encarga de gestionar las diferentes fases por las que pasan los datos del fichero, desde la carga
	 * del texto sin cambios, hasta su conversion en variables.
	 * @param ruta Cadena de caracteres que menciona la ruta donde se encuentra el archivo a leer 
	 * @param mf Clase encargada de almacenar valores necesario para iniciar una lectura o escritura, determina el formato
	 * @param comentario Cadena de caracter que ignorara desde que es encontrada hasta un nuevo salto de linea el texto
	 * @throws IOException *
	 */
	
	public Fichero(String ruta, String finalVar, String finalClase, String finalBloque) throws IOException{		
		this.ruta=ruta;
		texto = new String();
		cargarTexto();
		cargarModelo(finalVar, finalClase, finalBloque);
		crearVariables();
		nombrarBloques();
	}
	
	/**
	 * Carga el texto del fichero, y lo deja preparado para posteriormente recoger los datos, ignora los comentarios y
	 * las lineas vacias
	 * @throws IOException La excepcion es lanzada si el fichero no existe en la ruta expecificada
	 */
	private void cargarTexto() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader (new File (ruta)));
		String[] buffer;
		rawTexto = "";
		String buffer3;
		while(br.ready()){
			buffer3 = br.readLine();
			rawTexto += buffer3+"\n";
			buffer = buffer3.split("//");
			if(!buffer[0].equals("")){
				texto +=buffer[0]+"\n";
			}
		}
		br.close();	
	}
	
	/**
	 * Se encarga de cargar el encabezado del fichero, el cual sirve para saber como tratar la informacion 
	 * posterior del fichero, esta informacion sera almacenada en otra clase llamada ModeloFichero
	 * @param finalVar String que separa las diferentes variables de una clase
	 * @param finalClase String que separa las diferentes clases de un bloque
	 * @param finalBloque String que separa los diferentes bloques
	 * @throws IOException La excepcion es lanzada si no se encuentra un modelo en el fichero
	 */
	private void cargarModelo(String finalVar, String finalClase, String finalBloque) throws IOException{
		if(!texto.contains("}")){
			throw new RuntimeException("No se encuentra un modelo en los parametros de Fichero ni en el fichero");
		}else{
			String modelo = texto.split("}")[0];
			String lineas[] = modelo.split("\n");
			String formatoBanderas[];
			String variables[];
			
			String formato[][] = new String[lineas.length][];
			String bandera[] = new String[lineas.length];
			for(int i=0; i<lineas.length; i++){
				bandera[i] = lineas[i].split(":")[0];
				formatoBanderas = lineas[i].split(":");
				variables = formatoBanderas[1].split(",");
				formato[i] = variables;
				for(int j=0; j<variables.length; j++){
					formato[i][j] = variables[j];
				}
			}
			texto = texto.split("}")[1];
			texto = texto.replaceFirst("\n", "");
			mf = new ModeloFichero(finalVar, finalClase, finalBloque, formato, bandera,texto.split(finalBloque).length);
			
		}
	}
	
	/**
	 * Se encarga de nombrar cada bloque del fichero
	 */
	private void nombrarBloques(){
		String buffer[] = texto.split(mf.getFinalBloque());
		for(int i=0; i<buffer.length; i++){
			buffer[i] = getVariable(i,0,0);
		}
		mf.setNombreBloque(buffer);
	}
	
	/**
	 * Se encarga de mandar almacenar correctamente cada variable del fichero en su clase correspondiente y esta en
	 * su bloque correspondiente mediante el uso de una matriz en 3 dimensiones
	 * variable[bloque][clase][variable]
	 */
	private void crearVariables(){
		variable = new String[mf.getSizeBloques()][][];
		String buffer,buffer2;
		String[] buffer3;
		bandera = new String[mf.getSizeBloques()][];
		for(int i=0; i<mf.getSizeBloques();i++){
			buffer = texto.split(mf.getFinalBloque())[i];
			variable[i] = new String[buffer.split(mf.getFinalVar()).length][];
			bandera[i] = new String[buffer.split(mf.getFinalClase()).length];
			for(int j=0; j<buffer.split(mf.getFinalClase()).length; j++){
				buffer2 = buffer.split(mf.getFinalClase())[j];
				variable[i][j] = new String[buffer2.split(mf.getFinalVar()).length];
				for(int k=0; k<buffer2.split(mf.getFinalVar()).length; k++){	
					buffer3 = buffer2.split(":");
					variable[i][j][k] = buffer3[1].split(mf.getFinalVar())[k];
					if(bandera[i][j] == null)bandera[i][j] = buffer3[0];
				}
			}
		}
	}
	
	/**
	 * Se encarga de recoger una variable en el bloque y clase o tipo seleccionada.
	 * @param bloque Bloque donde se encuentra la variable
	 * @param tipo Tipo o clase donde se encuentra la variable
	 * @param variable La variable que se quiere recoger
	 * @return Se retorna la variable seleccionada, si no es encontrada, retorna null y se mostrara un error
	 */
	public String getVariable(String bloque, String tipo, String variable){
		for(int i=0; i<mf.getSizeBloques();i++){
			if(bloque.equalsIgnoreCase(mf.getNombreBloque()[i])){
				return getVariable(i,tipo,variable);
			}
		}
		Error.setError("No se ha podido cargar la variable:"+bloque+":"+tipo+":"+variable);
		return null;
	}
	
	/**
	 * Se encarga de recoger una variable en el bloque y clase o tipo seleccionada.
	 * @param bloque Bloque donde se encuentra la variable
	 * @param tipo Tipo o clase donde se encuentra la variable
	 * @param variable La variable que se quiere recoger
	 * @return Se retorna la variable seleccionada, si no es encontrada, retorna null y se mostrara un error
	 */
	public String getVariable(int bloque, String tipo, String variable){
		for(int i=0; i<bandera[bloque].length;i++){
			if(tipo.equalsIgnoreCase(bandera[bloque][i])){
				for(int j=0; j<mf.getBandera().length; j++){
					if(bandera[bloque][i].equalsIgnoreCase(mf.getBandera()[j])){
						for(int k=0; k<mf.getFormato()[j].length; k++){
							if(variable.equalsIgnoreCase(mf.getFormato()[j][k])){
								return getVariable(bloque,i,k);
							}
						}
					}
				}
				
			}
		}
		Error.setError("No se ha podido cargar la variable:"+bloque+":"+tipo+":"+variable);
		return null;
	}
	
	/**
	 * Se encarga de recoger una variable en el bloque y clase o tipo seleccionada.
	 * @param bloque Bloque donde se encuentra la variable
	 * @param tipo Tipo o clase donde se encuentra la variable
	 * @param variable La variable que se quiere recoger
	 * @return Se retorna la variable seleccionada
	 */
	public String getVariable(int bloque, int clase, int variable){
		return this.variable[bloque][clase][variable];
	}
	
	public void setVariable(String clase, String variable, String valor){
		String[] buffer = rawTexto.split("\n");
		for(int i=0; i<texto.split("\n").length; i++){
			String[] buffer2 = buffer[i].split(mf.getFinalVar());
			String buffer3 = "";
			for(int j=0; j<buffer2.length-1; j++){
				buffer3 += buffer2[j]+mf.getFinalVar();
			}
			if(buffer3.equalsIgnoreCase((clase+":"+variable))){
				rawTexto = rawTexto.replace(buffer3+buffer2[buffer2.length-1], buffer3+valor);
		        try
		        {
		        	PrintWriter pw = new PrintWriter(new FileWriter(ruta));
		        	pw.write(rawTexto);
		        	pw.close();
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
		}
	}
	
	/**
	 * Retorna la lista de clases o tipos que contiene el bloque seleccionado, ej "Artista":, "Cancion":
	 * @param bloque Bloque donde se encuentran las clases o tipos que se quieren recoger
	 * @return Se retorna la lista de clases o tipos
	 */
	public String[] getBanderas(int bloque){
		return bandera[bloque];
	}
	/**
	 * Retorna el modelo del fichero
	 * @return Modelo del Fichero
	 */
	public ModeloFichero getMF(){ 
		return mf; 
	}
	
	/**
	 * Retorna la ruta del fichero
	 * @return ruta
	 */
	public String getRuta() {
		return ruta;
	}
}