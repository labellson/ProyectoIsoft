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
	private String[][][] variable;
	private String[][] bandera;
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
	
	public Fichero(String ruta, String finalVar, String finalClase, String finalBloque) throws IOException{		
		this.ruta=ruta;
		texto = new String();
		cargarTexto();
		cargarModelo(finalVar, finalClase, finalBloque);
		crearVariables();
		nombrarBloques();
	}
	
	private void cargarTexto() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader (new File (ruta)));
		String[] buffer;
		while(br.ready()){
			buffer = br.readLine().split("//");
			if(!buffer[0].equals("")){
				texto +=buffer[0]+"\n";
			}
		}
		br.close();	
	}
	
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
	
	private void nombrarBloques(){
		String buffer[] = texto.split(mf.getFinalBloque());
		for(int i=0; i<buffer.length; i++){
			buffer[i] = getVariable(i,0,0);
		}
		mf.setNombreBloque(buffer);
	}
	
	private void crearVariables(){
		variable = new String[mf.getSizeBloques()][mf.getBandera().length][];
		String buffer,buffer2;
		String[] buffer3;
		bandera = new String[mf.getSizeBloques()][];
		for(int i=0; i<mf.getSizeBloques();i++){
			buffer = texto.split(mf.getFinalBloque())[i];
			bandera[i] = new String[buffer.split(mf.getFinalClase()).length];
			for(int j=0; j<buffer.split(mf.getFinalClase()).length; j++){
				variable[i][j] = new String[mf.getFormato()[j].length];
				buffer2 = buffer.split(mf.getFinalClase())[j];
				for(int k=0; k<mf.; k++){	
					buffer3 = buffer2.split(":");
					System.out.println(i+":"+j+":"+k+"-->");
					variable[i][j][k] = buffer3[1].split(mf.getFinalVar())[k];
					if(bandera[i][j] == null)bandera[i][j] = buffer3[0];
				}
			}
		}
	}
	
	public String getVariable(String bloque, String tipo, String variable){
		for(int i=0; i<mf.getSizeBloques();i++){
			if(bloque.equalsIgnoreCase(mf.getNombreBloque()[i])){
				return getVariable(i,tipo,variable);
			}
		}
		Error.setError("No se ha podido cargar la variable:"+bloque+":"+tipo+":"+variable);
		return null;
	}
	
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
	
	public String getVariable(int bloque, int clase, int variable){
		return this.variable[bloque][clase][variable];
	}
	public String[] getBanderas(int bloque){
		return bandera[bloque];
	}
	public ModeloFichero getMF(){ 
		return mf; 
	}
	
	public String getRuta() {
		return ruta;
	}
}
