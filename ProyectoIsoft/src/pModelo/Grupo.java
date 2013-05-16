package pModelo;

/**
 * Almacena todos los artistas de la lista listaArtistas que son un grupo (y no un Solista)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Grupo extends Artista{
	private ListaIntegrantes lIntegrantes;
	public Grupo(String nombre, Biografia bio, ListaAlbum lAlbum) {
		super(nombre,bio,lAlbum);
		lIntegrantes = new ListaIntegrantes();
	}
	
	/**
	 * Añade un integrante al grupo
	 * @param integrante Nuevo integrante en el grupo
	 */
	void addIntegrantes(Integrante integrante){
		lIntegrantes.addIntegrantes(integrante);
	}

}
