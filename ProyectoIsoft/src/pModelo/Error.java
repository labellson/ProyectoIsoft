package pModelo;
import java.util.ArrayList;

public class Error {
	private static ArrayList<String> error;
	Error(){
		error = new ArrayList<String>();
	}
	
	private static void iniciar(){
		if(error == null) error = new ArrayList<String>();
	}
	
	public static String[] getError(){
		iniciar();
		String[] buffer = new String[error.size()];
		for(int i=0; i<error.size(); i++){
			buffer[i] = error.get(i);
		}
		return buffer;
	}
	
	public static void setError(String pError){
		iniciar();
		error.add(pError);
	}
	
	public static int getSize(){ 
		iniciar();
		return error.size(); 
	}
	
	public static String extraerError(){
		iniciar();
		return error.remove(0);
	}
}
