package pModelo;

public class Cancion {
	private String nombre;
	private String duracion;
	private String letra;
	private int puntuacion;
	/**
	 * Constructor de Cancion
	 * @param pNombre Nombre de la Cancion
	 * @param pDuracion Duracion de la Cancion
	 * @param pLetra Letra de la Cancion
	 * @param puntuacion Puntuacion de la cancion
	 */
	public Cancion(String pNombre, String pDuracion, String pLetra, int puntuacion){
		nombre = pNombre;
		duracion = pDuracion;
		letra = pLetra;
		this.puntuacion = puntuacion;
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
	
	/**
	 * Devuelve la puntuacion de la cancion
	 * @return puntuacion
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	
}