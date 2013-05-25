package pModelo;

public class Cancion {
	private String nombre;
	private String duracion;
	private String letra;

	public Cancion(String pNombre, String pDuracion, String pLetra){
		nombre = pNombre;
		duracion = pDuracion;
		letra = pLetra;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public String getLetra() {
		return letra;
	}
	
}