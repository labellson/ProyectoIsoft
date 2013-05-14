package pModelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Se encarga de cargar los artistas con todos sus datos, nombre, grupo/solista al que pertenecen, discografia etc..
 * @author Francisco , Daniel , Ruben , Iban
 *
 */
public class CargarArtistas {
	private static CargarArtistas cargarArtistas;
	private CargarArtistas(){
		
	}
	
	/**
	 * De los distintas clases hijas de Artista almacenadas en listaArtista, la clase busca y retorna los objetos Grupo
	 * @param listaArtista lista de grupos almacenados hasta el momento
	 * @return
	 */
	private ArrayList<Grupo> getGrupos(ArrayList<Artista> listaArtista){
		ArrayList<Grupo> buffer = new ArrayList<Grupo>();
		for(int i=0; i<listaArtista.size(); i++){
			if(listaArtista.get(i).getClass() == Grupo.class) buffer.add((Grupo)listaArtista.get(i));
		}
		return buffer;
	}
	
	/**
	 * Se encarga de crear y/o devolver el unico objeto de esta clase singelton
	 * @return
	 */
	public static CargarArtistas getSingelton(){
		if (cargarArtistas == null){
			cargarArtistas = new CargarArtistas();
		}
		return cargarArtistas;
	}
	
	/**
	 * Se encarga de cargar y registrar en las clases correspondenties los datos de todas las clases Artistas
	 * @param ruta lista de strings en la que se especificara la ruta de los ficheros correspondientes, en orden son discografia,cancion,biografia,grupo,solista,artista
	 * @return Todas los objetos pertenecientes y derivados de la clase Artista
	 * @throws IOException
	 */
	public ArrayList<Artista> getListaArtistas(String[] ruta) throws IOException{
		ArrayList<Artista> listaArtista = new ArrayList<Artista>();
		Fichero fDiscografia = new pModelo.Fichero(ruta[0], new pModelo.ModeloFichero(",", "\n"));
		Fichero fCancion = new pModelo.Fichero(ruta[1], new pModelo.ModeloFichero(",", "\n"));
		Fichero fBiografia = new pModelo.Fichero(ruta[2], new pModelo.ModeloFichero(",", "\n"));
		Fichero fGrupo = new pModelo.Fichero(ruta[3], new pModelo.ModeloFichero(",", "\n"));
		Fichero fSolista = new pModelo.Fichero(ruta[4], new pModelo.ModeloFichero(",", "\n"));
		Fichero fArtista = new pModelo.Fichero(ruta[5], new pModelo.ModeloFichero(",", "\n"));
		//Inicia el proceso de cargar las variables de los objetos con sus correspondientes ficheros
		for(int i=0; i<fArtista.getVariables().length; i++){
			if(fArtista.getVariables(i, 0).equals("solista")){
				for(int j=0; j<fSolista.getVariables().length; j++){
					if(fArtista.getVariables(i, 1).equals(fSolista.getVariables(j, 0))){
						listaArtista.add(new Solista(fArtista.getVariables(i, 2),fArtista.getVariables(i, 3)));
						buscarBiografia(listaArtista.get(listaArtista.size()-1), fBiografia);
					}
				}
			}else if(fArtista.getVariables(i, 0).equals("grupo")){
				for(int j=0; j<fGrupo.getVariables().length; j++){
					if(fArtista.getVariables(i, 1).equals(fGrupo.getVariables(j, 0))){
						//Se incluira o creara un nuevo grupo
						ArrayList<Grupo> grupo = getGrupos(listaArtista);
						boolean estaCreado = false;
						for(int k=0; k<grupo.size(); k++){
							if(fArtista.getVariables(i,1).equals(grupo.get(k).getNombre())){
								estaCreado = true;
								getGrupos(listaArtista).get(k).setNombre((fArtista.getVariables(i, 1)));
								buscarBiografia(listaArtista.get(k), fBiografia);
							}
						}
						if(estaCreado == false){ 
							Grupo buffer = new Grupo(fArtista.getVariables(i, 1));
							buffer.addIntegrantes(new Integrante(fArtista.getVariables(i, 2),fArtista.getVariables(i, 3)));
							listaArtista.add(buffer);
							buscarBiografia(listaArtista.get(listaArtista.size()-1), fBiografia);
						}
					}
				}
			}else{ throw new RuntimeException("Error en la carga de los artistas, "+fArtista.getVariables(i, 2)+" no es un solista ni pertenece a un grupo registrado: "+fArtista.getVariables(i, 0)+"???");}
			
		}
		comprobarNombresGrupos(fGrupo);
		return listaArtista;
	}
	
	/**
	 * Busca la biografia del artista seleccionado
	 * @param nombreArtista Nombre del artista al que debe buscar la biografia
	 * @param fBiografia Fichero donde se guardan todas las biografias
	 */
	private Biografia buscarBiografia(Artista artista, Fichero fBiografia){
		for(int i=0; i<fBiografia.getVariables().length; i++){
			if(fBiografia.getVariables(i, 0).equals(artista.getNombre())){
				if(artista.getClass() == Solista.class){
					return new BiografiaIntegrante(fBiografia.getVariables(i, 0), fBiografia.getVariables(i, 1), fBiografia.getVariables(i, 2), fBiografia.getVariables(i, 3));
				}else{
					return new BiografiaGrupo(fBiografia.getVariables(i, 0), fBiografia.getVariables(i, 1), fBiografia.getVariables(i, 2), fBiografia.getVariables(i, 3));
				}
			}
		}
		Error.setError("Error, artista "+artista.getNombre()+" no tiene biografia");
		return null;
	}
	/**
	 * Comprueba que no haya 2 grupos con el mismo nombre, si los hay, mandara una notificacion
	 * @param fGrupo Fichero donde se guarda la informacion de todos los grupos
	 */
	private void comprobarNombresGrupos(Fichero fGrupo){
		String buffer = new String();
		for(int i=0; i<fGrupo.getVariables().length; i++){
			buffer += fGrupo.getVariables(i, 0);
		}
		for(int i=0; i<fGrupo.getVariables().length; i++){
			buffer = buffer.replaceFirst(fGrupo.getVariables(i, 0), "");
			if(buffer.contains(fGrupo.getVariables(i, 0))){
				Error.setError("Error, 2 grupos con el mismo nombre: "+fGrupo.getVariables(i, 0));
			}
		}
	}
}
