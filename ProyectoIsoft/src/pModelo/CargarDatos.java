package pModelo;

import java.io.IOException;
import java.util.ArrayList;

public class CargarDatos{
	private static CargarDatos cargarArtistas;
	private CargarDatos(){

	}

	public static CargarDatos getSingelton(){
		if (cargarArtistas == null){
			cargarArtistas = new CargarDatos();
		}
		return cargarArtistas;
	}
	
	public void cargar(String ruta) throws IOException{
		Fichero f = new Fichero(ruta, "'", "\n", ";\n");
		for(int i=0; i<f.getMF().getSizeBloques(); i++){
			cargarBiografia(f,i);
			cargarAlbum(f, i, 0);
			cargarArtista(f,i);
		}
	}
	
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
	 * Este metodo devolvera un ArrayList<Cancion> que cargara de el fichero datos
	 * @param f de la clase fichero
	 * @param numArtista el artista en el que nos encontramos en el array
	 * @param i indica el offset en el que nos encontramos en el array justo despues de un album
	 * @return ArrayList <Cancion>
	 */
	private void cargarCancion(Fichero f, int numArtista, int i){
		while(i < f.getBanderas(numArtista).length && f.getBanderas(numArtista)[i].equalsIgnoreCase("Cancion")){ //esCancion
			ListaCancion.getSingelton().add(new Cancion(f.getVariable(numArtista, i, 0), f.getVariable(numArtista, i, 1), f.getVariable(numArtista, i, 2)));
			i++;
		}
	}
	/**
	 * Este metodo devuelve un ArrayList<Album> con los albumes del artista y cada uno con sus canciones
	 * @param f Fichero
	 * @param numArtista el artista en el que nos encontramos en el array
	 * * @param i indica el offset en el que nos encontramos en el array
	 * @return ArrayList<Album>
	 */
	private void cargarAlbum(Fichero f, int numArtista, int i){
		ArrayList<Cancion> listaCancion = new ArrayList<Cancion>();
		while(i < f.getBanderas(numArtista).length){
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("Album")){
				cargarCancion(f,numArtista,i+1);
				ListaAlbum.getSingelton().addAlbum(new Album(ListaCancion.getSingelton().get(), f.getVariable(numArtista, i, 0), f.getVariable(numArtista, i, 1)));
				i += listaCancion.size() +1;
			}else{
				i++;
				
			}
		}
	}
	
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
			ListaArtista.getSingelton().add(new Solista(f.getVariable(numArtista, "solista", "nombre"),f.getVariable(numArtista, "solista", "posicion"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else if(grupo){
			ListaArtista.getSingelton().add(new Grupo(f.getVariable(numArtista, "grupo", "nombre"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else if(integrante){
			((Grupo)ListaArtista.getSingelton().get(ListaArtista.getSingelton().compararNombre(f.getVariable(numArtista, "integrante", "grupo")))).addIntegrantes(new Integrante(f.getVariable(numArtista, "integrante", "nombre"),f.getVariable(numArtista, "integrante", "posicion"),ListaBiografia.getSingelton().getBiografia(numArtista),ListaAlbum.getSingelton().get()));
		}else{
			Error.setError("Integrante "+f.getVariable(numArtista, "artista", "nombre")+" no es solista ni pertenece a un grupo");
		}
		ListaAlbum.getSingelton().get().clear();
	}
}