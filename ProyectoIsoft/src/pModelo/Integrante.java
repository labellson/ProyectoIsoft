package pModelo;

/**
 * La clase que almacena todos los integrantes de grupos o los integrantes unicos del suyo propio(Solista)
 * @author Francisco , Daniel , Ruben , Iban
 */
public class Integrante extends Artista{
	private String posicion;
	public Integrante(String nombre, String posicion, Biografia bio, ListaAlbum lAlbum){
		super(nombre,bio,lAlbum);
		this.posicion = posicion;
	}
}
