package pModelo;

import java.util.ArrayList;

public class ListaIntegrantes {
	private ArrayList<Integrante> lIntegrantes;
	public ListaIntegrantes(){
		lIntegrantes = new ArrayList<Integrante>();
	}
	
	public void addIntegrantes(Integrante integrante){
		lIntegrantes.add(integrante);
	}
}
