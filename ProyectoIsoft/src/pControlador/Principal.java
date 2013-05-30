package pControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import pModelo.BiografiaIntegrante;
import pModelo.Integrante;
import pModelo.Artista;
import pModelo.Cancion;
import pModelo.Grupo;
import pModelo.ListaArtista;
import pModelo.ModeloComboBox;
import pModelo.Solista;

/**
 * En esta clase se encuentran todos los Handlers de eventos que ocurran en la interfaz grafica y modificarla con los datos del modelo.
 * @author Daniel, Francisco, Iban, Ruben
 *
 */
public class Principal implements ActionListener, ListSelectionListener{
  pVista.Principal vista;
  Artista artistActual; //Artista actual cargado en la aplicacionx
	public Principal(){
		vista = new pVista.Principal();
		new ModeloComboBox(vista.getComboBox());
		for(int i=0; i<pModelo.ListaArtista.getSingelton().getlistaArtista().size(); i++){
			vista.getComboBox().addItem(pModelo.ListaArtista.getSingelton().get(i).getNombre());
		}
		vista.getComboBox().addActionListener(this);
		vista.getList_1().addListSelectionListener(this);
		vista.getList().addListSelectionListener(this);
		vista.getList_2().addListSelectionListener(this);
		vista.getBtnSalir().addActionListener(this);
		vista.getBtnVotar().addActionListener(this);
		vista.getComboBox().setSelectedIndex(0);
		vista.getList_1().setSelectedIndex(0);
		vista.getList().setSelectedIndex(0);
		vista.getList_2().setSelectedIndex(0);
	}
	/**
	 * Cuando se escribe o se selecciona el nombre de un artista el evento cambiara en la aplicacion el artista.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getComboBox()){
			vista.getList_1().removeListSelectionListener(this);
			vista.getList().removeListSelectionListener(this);
			vista.getList_2().removeListSelectionListener(this);
			int indice = pModelo.ListaArtista.getSingelton().compararNombre((String) vista.getComboBox().getSelectedItem());
			artistActual = pModelo.ListaArtista.getSingelton().get(indice);
			if(indice == -1) return;
			DefaultListModel<String> dListModel = new DefaultListModel<String>();
			if(pModelo.Solista.class == artistActual.getClass()){
				dListModel.addElement(artistActual.getNombre());
				vista.getTextPane_1().setBackground(Color.lightGray);
			}else{
				vista.getTextPane_1().setBackground(Color.white);
				for(int i=0; i<((pModelo.Grupo)artistActual).getSize();i++){
					dListModel.addElement(((pModelo.Grupo)artistActual).getIntentegrantes(i).getNombre());
				}
			}
			vista.getList().setModel(dListModel);
			
			//Discografias/Albumeso
			DefaultListModel<String> dListModelDiscos = new DefaultListModel<String>();
			for(int i=0; i<artistActual.getlAlbum().size();i++){
				dListModelDiscos.addElement(artistActual.getlAlbum().get(i).getNombre());
			}
			vista.getList_1().setModel(dListModelDiscos);
			vista.getList_1().addListSelectionListener(this);
			vista.getList_2().addListSelectionListener(this);
			vista.getList_1().setSelectedIndex(0);
			vista.getList_2().setSelectedIndex(0);
			vista.getList().addListSelectionListener(this);
			
			vista.getList().setSelectedIndex(0);
			//Biografia
			vista.getBiografia().setText("Nombre:\n"+artistActual.getNombre()+"\n\nLugar de Nacimiento:\n"+artistActual.getBio().getLugarNac()+"\n\nFecha de Nacimiento:\n"+artistActual.getBio().getFechaNac()+"\n\nDescripcion:\n"+artistActual.getBio().getDescripcion());
		}else if(e.getSource() == vista.getBtnSalir()){
			vista.dispose();
		}else if(e.getSource() == vista.getBtnVotar()){
			
		}
	}
	/**
	 * Se encarga de tratar los eventos que ocurren al seleccionar un disco, una cancion o un integrante.
	 * Si se selecciona un disco apareceran sus canciones.
	 * Si se selecciona una cancion apareceran su duracion y su letra.
	 * Si se selecciona un Integrante aparecera su Posicion y su biografia de Integrante.
	 */
	public void valueChanged(ListSelectionEvent e) {
		try{
			if(e.getSource() == vista.getList_1()){
				vista.getList_2().removeListSelectionListener(this); //hacer esto para que no de problemas el listener de letra
				int indiceDisco = (int) vista.getList_1().getSelectedIndex();
				DefaultListModel<String> dListModel = new DefaultListModel<String>();
				ArrayList<Cancion> cancionD = artistActual.getlAlbum().get(indiceDisco).getCanciones();
				for(Cancion cancion : cancionD){
					dListModel.addElement(cancion.getNombre());
				}
				vista.getList_2().setModel(dListModel);
				vista.getList_2().addListSelectionListener(this); //volver a añadir el listener
			}else if(e.getSource() == vista.getList()){
				DefaultListModel<String> dListModel = new DefaultListModel<String>();
				if(artistActual instanceof Grupo){
					int index = vista.getList().getSelectedIndex();
					ArrayList <String> posiciones = ((Grupo) artistActual).getIntentegrantes(index).getlPosicion();
					for(String posicion : posiciones){
						dListModel.addElement(posicion);
					}
					BiografiaIntegrante bioInt = (BiografiaIntegrante) ((Grupo)artistActual).getIntentegrantes(index).getBio();
					vista.getTextPane_1().setText("Nombre:\n"+bioInt.getNombre()+"\n\nLugar de Nacimiento:\n"+bioInt.getLugarNac()+"\n\nFecha de Nacimiento:\n"+bioInt.getFechaNac()+"\n\nDescripcion:\n"+bioInt.getDescripcion());
					vista.getList_3().setModel(dListModel);
				}else{
					ArrayList <String> posiciones = ((Integrante) artistActual).getlPosicion();
					for(String posicion : posiciones){
						dListModel.addElement(posicion);
					}
					vista.getList_3().setModel(dListModel);
				}
			}else if(e.getSource() == vista.getList_2()){
				vista.getTextPane().setText("Duracion:\n"+artistActual.getlAlbum().get(vista.getList_1().getSelectedIndex()).getCanciones().get(vista.getList_2().getSelectedIndex()).getDuracion()+" minutos\n\nLetra:\n"+artistActual.getlAlbum().get(vista.getList_1().getSelectedIndex()).getCanciones().get(vista.getList_2().getSelectedIndex()).getLetra());
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}