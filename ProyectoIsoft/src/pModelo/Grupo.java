package pModelo;

public class Grupo extends Artista{
	private ListaIntegrantes lIntegrantes;
	public Grupo(String nombre) {
		super(nombre);
		lIntegrantes = new ListaIntegrantes();
	}
	
	void addIntegrantes(Integrante integrante){
		lIntegrantes.addIntegrantes(integrante);
	}

}
