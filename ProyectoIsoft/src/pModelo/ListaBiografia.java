package pModelo;

import java.util.ArrayList;

public class ListaBiografia {
	private static ListaBiografia singelton;
	private ArrayList<Biografia> biografia;
	
	private ListaBiografia(){
		biografia = new ArrayList<Biografia>();
	}
	
	public static ListaBiografia getSingelton(){
		if(singelton == null){
			singelton = new ListaBiografia();
		}
		return singelton;
	}
	
	public void addBiografia(Biografia bio){
		biografia.add(bio);
	}
	
	public ArrayList<Biografia> get(){
		return biografia;
	}
	
	public Biografia getBiografia(int num){
		return biografia.get(num);
	}
	
	public int getSize(){
		return biografia.size();
	}
}