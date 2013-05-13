package pModelo;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Clase encargada de almacenar y realizar acciones con los artistas almacenados
 * @author francisco
 */
public class ListaArtista {
	private ArrayList<Artista> listaArtista;
	/**
	 * ListaArtista necesita una cadena de caracteres especificando la ruta de el fichero
	 * con la informacion de los artistas
	 * @param ruta
	 */
	public ListaArtista(String[] ruta){
		//Cuando se inicie listaArtista, cargara los datos de los artistas de la base de datos
		listaArtista = new ArrayList<Artista>();
		cargarArtistas(ruta);
	}
	/**
	 * Carga los datos de los artistas, posiblemente se modifique y se cree una clase propia*
	 * @param ruta Lista de rutas, donde se encuentran los ficheros a cargar los datos
	 */
	public void cargarArtistas(String ruta[]){
		try {
			Fichero fGrupo = new pModelo.Fichero(ruta[0], new pModelo.ModeloFichero(",", "\n"));
			Fichero fSolista = new pModelo.Fichero(ruta[1], new pModelo.ModeloFichero(",", "\n"));
			Fichero fArtista = new pModelo.Fichero(ruta[2], new pModelo.ModeloFichero(",", "\n"));
			for(int i=0; i<fArtista.getVariables().length; i++){
				if(fArtista.getVariables(i, 0).equals("solista")){
					for(int j=0; j<fSolista.getVariables().length; j++){
						if(fArtista.getVariables(i, 1).equals(fSolista.getVariables(j, 0))){
							listaArtista.add(new Solista(fArtista.getVariables(j, 1)));
							System.out.println(fArtista.getVariables(i, 2)+" se convierte en solista llamado "+fArtista.getVariables(i, 1));
						}
					}
				}else if(fArtista.getVariables(i, 0).equals("grupo")){
					for(int j=0; j<fGrupo.getVariables().length; j++){
						if(fArtista.getVariables(i, 1).equals(fGrupo.getVariables(j, 0))){
							//Se incluira o creara un nuevo grupo
							ArrayList<Grupo> grupo = getGrupos();
							boolean estaCreado = false;
							for(int k=0; k<grupo.size(); k++){
								if(fArtista.getVariables(i,1).equals(grupo.get(k).getNombre())){
									estaCreado = true;
									listaArtista.add(new Grupo(fArtista.getVariables(i, 1)));
									System.out.println(fArtista.getVariables(i, 2)+" se incorpora al grupo "+fArtista.getVariables(i, 1));
								}
							}
							if(estaCreado == false){ 
								Grupo buffer = new Grupo(fArtista.getVariables(i, 1));
								buffer.addIntegrantes(new Integrante(fArtista.getVariables(i, 2)));
								listaArtista.add(buffer);
								System.out.println(fArtista.getVariables(i, 2)+" crea el grupo "+fArtista.getVariables(i, 1));
							}
						}
					}
				}else{ /*Error*/ System.out.println("ERROR, artista: "+fArtista.getVariables(i, 2)+" no pertenece grupo ni a solista.");}
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Grupo> getGrupos(){
		ArrayList<Grupo> buffer = new ArrayList<Grupo>();
		for(int i=0; i<listaArtista.size(); i++){
			if(listaArtista.get(i).getClass() == Grupo.class) buffer.add((Grupo)listaArtista.get(i));
		}
		return buffer;
	}
}


