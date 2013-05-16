import java.util.ArrayList;

public class ListaCancion {
  private static ListaCancion singelton;
	private ArrayList<Cancion> lCancion;
	
	private ListaCancion(){
		lCancion = new ArrayList<Cancion>();
	}
	
	public static ListaCancion getSingelton(){
		if(singelton == null){
			singelton = new ListaCancion();
		}
		return singelton;
	}
	
	public void add(Cancion cancion){
		lCancion.add(cancion);
	}
	
	public Cancion get(int indice){
		return lCancion.get(indice);
	}
	
	public ArrayList<Cancion> get(){
		return lCancion;
	}
	
	public void freeSingelton(){
		singelton = null;
	}
}
