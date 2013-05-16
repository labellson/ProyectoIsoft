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
		Fichero f = new Fichero(ruta, ",", "\n", ";\n");
		for(int i=0; i<f.getMF().getSizeBloques(); i++){
			cargarArtista(f,i);
		}
		ArrayList<Cancion> can = cargarCancion(f, 0, 2);
		System.out.println(can.size());
		System.out.println("Nombre: "+can.get(0).getNombre()+" Letra: "+can.get(0).getLetra()+" Duracion: "+can.get(0).getDuracion());
		System.out.println("Nombre: "+can.get(1).getNombre()+" Letra: "+can.get(1).getLetra()+" Duracion: "+can.get(1).getDuracion());
	}
	
	private void cargarArtista(Fichero f, int numArtista) throws IOException{
		//Creamos biografia
		//Comprobamos si es biografia interna o biografia grupo y crearla
		boolean bioIntegrante=false;
		boolean bioGrupo=false;
		for(int i=0; i<f.getBanderas(numArtista).length; i++){
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("BiografiaIntegrante")) bioIntegrante = true;
			if(f.getBanderas(numArtista)[i].equalsIgnoreCase("BiografiaGrupo")) bioGrupo = true;
		}
		if(bioIntegrante){
			Biografia bio = new BiografiaIntegrante(f.getVariable(numArtista, "artista", "nombre"), f.getVariable(numArtista, "biografiaIntegrante", "fechaNacimiento"), f.getVariable(numArtista, "biografiaIntegrante", "lugarNacimiento"), f.getVariable(numArtista, "biografiaIntegrante", "descripcion"));
		}else if(bioGrupo){
			Biografia bio = new BiografiaGrupo(f.getVariable(numArtista, "artista", "nombre"), f.getVariable(numArtista, "biografiaGrupo", "fechaNacimiento"), f.getVariable(numArtista, "biografiaGrupo", "lugarNacimiento"), f.getVariable(numArtista, "biografiaGrupo", "descripcion"));
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
	public ArrayList<Cancion> cargarCancion(Fichero f, int numArtista, int i){
		ArrayList<Cancion> listaCancion = new ArrayList<Cancion>();
		while(i < f.getBanderas(numArtista).length && f.getBanderas(numArtista)[i].equalsIgnoreCase("Cancion")){ //esCancion
			listaCancion.add(new Cancion(f.getVariable(numArtista, i, 0), f.getVariable(numArtista, i, 1), f.getVariable(numArtista, i, 2)));
			i++;
		}
		return listaCancion;
	}

	//Cambio mio oooouuu yeah baby
	
	/**
	 * Este metodo devuelve un ArrayList<Album> con los albumes del artista y cada uno con sus canciones
	 * @param f Fichero
	 * @param numArtista el artista en el que nos encontramos en el array
	 * * @param i indica el offset en el que nos encontramos en el array
	 * @return ArrayList<Album>
	 */
	private ArrayList<Album> cargarAlbum(Fichero f, int numArtista, int i){
		ArrayList<Album> listaAlbum = new ArrayList<Album>();
		while(i < f.getBanderas(numArtista).length){
			
		}
	}
}
>>>>>>> branch 'master' of https://github.com/labellson/ProyectoIsoft.git
