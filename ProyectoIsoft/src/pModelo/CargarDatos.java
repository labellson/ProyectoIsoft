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
}