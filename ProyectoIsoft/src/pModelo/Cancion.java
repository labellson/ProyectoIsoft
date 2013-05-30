package pModelo;

public class Cancion {
	private String nombre;
	private String duracion;
	private String letra;
	/**
	 * Constructor de Cancion
	 * @param pNombre Nombre de la Cancion
	 * @param pDuracion Duracion de la Cancion
	 * @param pLetra Letra de la Cancion
	 */
	public Cancion(String pNombre, String pDuracion, String pLetra){
		nombre = pNombre;
		duracion = pDuracion;
		letra = pLetra;
	}
	/**
	 * Devuelve el nombre de una cancion
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Devuelve la duracion de la cancion
	 * @return duracion
	 */
	public String getDuracion() {
		return duracion;
	}
	/**
	 * Devuelve la letra de la cancion
	 * @return letra
	 */
	public String getLetra() {
		return letra;
	}
	
}