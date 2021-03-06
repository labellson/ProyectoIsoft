package pModelo;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Esta clase se encarga de cargar todos los datos en las clases del diseño. Clase singleton
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class CargarDatos{
	private static CargarDatos cargarArtistas;
	/**
	 * Devuelve el objeto cargarArtistas
	 * @return cargarArtistas
	 */
	public static CargarDatos getSingelton(){
		if (cargarArtistas == null){
			cargarArtistas = new CargarDatos();
		}
		return cargarArtistas;
	}
	/**
	 * Se encarga de cargar los datos leidos del fichero datos.txt
	 * @param ruta
	 * @throws IOException
	 */
	public void cargar(String ruta) throws IOException{
		Fichero f = new Fichero(ruta, "'", "\n", ";\n");
		ListaArtista.getSingelton().setFichero(f);
		for(int i=0; i<f.getMF().getSizeBloques(); i++){
			cargarBiografia(f,i);
			cargarAlbum(f, i, 0);
			cargarArtista(f,i);
		}
	}
	/**
	 * Carga la Biografia
	 * @param f
	 * @param numArtista
	 * @throws IOException
	 */
	private void cargarBiografia(Fichero f, int numArtista) throws IOException{
		//Creamos biografia
		//Comprobamos si es biografia interna o biografia grupo y crearla
		boolean bioIntegrante=false;
		boolean bioGrupo=false;
		boolean bioSolista=false;
		for(int i=0; i<f.getBanderas(numArtista).length; i++){
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("BiografiaIntegrante")) bioIntegrante = true;
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("BiografiaGrupo")) bioGrupo = true;
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("BiografiaSolista")) bioSolista = true;
		}
		if(bioIntegrante){
			ListaBiografia.getSingelton().addBiografia(new BiografiaIntegrante(f.getVariable(numArtista, "integrante", "nombre"), f.getVariable(numArtista, "biografiaIntegrante", "fechaNacimiento"), f.getVariable(numArtista, "biografiaIntegrante", "lugarNacimiento"), f.getVariable(numArtista, "biografiaIntegrante", "descripcion")));
		}else if(bioSolista){
			ListaBiografia.getSingelton().addBiografia(new BiografiaIntegrante(f.getVariable(numArtista, "solista", "nombre"), f.getVariable(numArtista, "biografiaSolista", "fechaNacimiento"), f.getVariable(numArtista, "biografiaSolista", "lugarNacimiento"), f.getVariable(numArtista, "biografiaSolista", "descripcion")));
		}else if(bioGrupo){
			ListaBiografia.getSingelton().addBiografia(new BiografiaGrupo(f.getVariable(numArtista, "grupo", "nombre"), f.getVariable(numArtista, "biografiaGrupo", "fechaNacimiento"), f.getVariable(numArtista, "biografiaGrupo", "lugarNacimiento"), f.getVariable(numArtista, "biografiaGrupo", "descripcion")));
		}else{
			Error.setError("Integrante "+f.getVariable(numArtista, "artista", "nombre")+" no es solista ni pertenece a un grupo");
		}
		
	}
	/**
	 * Este metodo cargara un ArrayList<Cancion> que cargara de el fichero datos.txt
	 * @param f de la clase fichero
	 * @param numArtista el artista en el que nos encontramos en el array
	 * @param i indica el offset en el que nos encontramos en el array justo despues de un album
	 */
	private void cargarCancion(Fichero f, int numArtista, int i){
		while(i < f.getBanderas(numArtista).length && f.getBanderas(numArtista)[i].equalsIgnoreCase("Cancion")){ //esCancion
			ListaCancion.getSingelton().add(new Cancion(f.getVariable(numArtista, i, 0), f.getVariable(numArtista, i, 1), f.getVariable(numArtista, i, 2), Integer.parseInt(f.getVariable(numArtista, i, 3))));
			i++;
		}
	}
	/**
	 * Este metodo cargara un ArrayList<Album> con los albumes del artista y cada uno con sus canciones
	 * @param f Fichero
	 * @param numArtista el artista en el que nos encontramos en el array
	 * @param i indica el offset en el que nos encontramos en el array
	 */
	private void cargarAlbum(Fichero f, int numArtista, int i){
		ArrayList<Cancion> listaCancion = new ArrayList<Cancion>();
		while(i < f.getBanderas(numArtista).length){
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("Album")){
				cargarCancion(f,numArtista,i+1);
				ListaAlbum.getSingelton().addAlbum(new Album(ListaCancion.getSingelton().getDeAlbum(), f.getVariable(numArtista, i, 0), f.getVariable(numArtista, i, 1)));
				i += listaCancion.size() +1;
			}else{
				i++;
				
			}
			//ListaCancion.getSingelton().finAlbum();
			//ListaCancion.getSingelton().get().clear();
		}
	}
	/**
	 * Carga el Artista con todos sus datos (Biografia y Discografia)
	 * @param f
	 * @param numArtista
	 */
	private void cargarArtista(Fichero f, int numArtista){
		boolean solista=false;
		boolean grupo=false;
		boolean integrante=false;
		for(int i=0; i<f.getBanderas(numArtista).length; i++){
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("Solista")) solista = true;
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("Grupo")) grupo = true;
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("Integrante")) integrante = true;
		}
		if(solista){
			ListaArtista.getSingelton().add(new Solista(f.getVariable(numArtista, "solista", "nombre"), f.getVariable(numArtista, "solista", "artistico"),f.getVariable(numArtista, "solista", "posicion").split("/"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else if(grupo){
			ListaArtista.getSingelton().add(new Grupo(f.getVariable(numArtista, "grupo", "nombre"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else if(integrante){
			((Grupo)ListaArtista.getSingelton().get(ListaArtista.getSingelton().compararNombre(f.getVariable(numArtista, "integrante", "grupo")))).addIntegrantes(new Integrante(f.getVariable(numArtista, "integrante", "nombre"),f.getVariable(numArtista, "integrante", "posicion").split("/"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else{
			Error.setError("Integrante "+f.getVariable(numArtista, "artista", "nombre")+" no es solista ni pertenece a un grupo");
		}
		ListaAlbum.getSingelton().get().clear();
	}
}