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
	
	public ArrayList<Artista> getListaArtistas(String[] ruta) throws IOException{
		ArrayList<Artista> listaArtista = new ArrayList<Artista>();
		Fichero fDiscografia = new pModelo.Fichero(ruta[0], new pModelo.ModeloFichero(",", "\n"));
		Fichero fCancion = new pModelo.Fichero(ruta[1], new pModelo.ModeloFichero(",", "\n"));
		Fichero fBiografia = new pModelo.Fichero(ruta[2], new pModelo.ModeloFichero(",", "\n"));
		Fichero fGrupo = new pModelo.Fichero(ruta[3], new pModelo.ModeloFichero(",", "\n"));
		Fichero fSolista = new pModelo.Fichero(ruta[4], new pModelo.ModeloFichero(",", "\n"));
		Fichero fArtista = new pModelo.Fichero(ruta[5], new pModelo.ModeloFichero(",", "\n"));
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
						ArrayList<Grupo> grupo = getGrupos(listaArtista);
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
		return listaArtista;
	}
}
