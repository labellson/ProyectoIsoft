package pControlador;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import pModelo.Artista;
import pModelo.Cancion;
import pModelo.Grupo;
import pModelo.ListaArtista;
import pModelo.ModeloComboBox;
import pModelo.Solista;


public class Principal implements ActionListener, ListSelectionListener{
  pVista.Principal vista;
  Artista artistActual;
	public Principal(){
		vista = new pVista.Principal();
		new ModeloComboBox(vista.getComboBox());
		for(int i=0; i<pModelo.ListaArtista.getSingelton().getlistaArtista().size(); i++){
			vista.getComboBox().addItem(pModelo.ListaArtista.getSingelton().get(i).getNombre());
		}
		vista.getComboBox().addActionListener(this);
		vista.getList_1().addListSelectionListener(this);
		vista.getComboBox().setSelectedIndex(0);
		vista.getList_1().setSelectedIndex(0);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getComboBox()){
			vista.getList_1().removeListSelectionListener(this);
			int indice = pModelo.ListaArtista.getSingelton().compararNombre((String) vista.getComboBox().getSelectedItem());
			artistActual = pModelo.ListaArtista.getSingelton().get(indice);
			if(indice == -1) return;
			DefaultListModel<String> dListModel = new DefaultListModel<String>();
			if(pModelo.Solista.class == artistActual.getClass()){
				dListModel.addElement(artistActual.getNombre());
			}else{
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
			vista.getList_1().setSelectedIndex(0);
			
			//Biografia
			vista.getBiografia().setText(artistActual.getBiografia().getDescripcion());
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		try{
			if(e.getSource() == vista.getList_1()){
				int indiceDisco = (int) vista.getList_1().getSelectedIndex();
				DefaultListModel<String> dListModel = new DefaultListModel<String>();
				ArrayList<Cancion> cancionD = artistActual.getlAlbum().get(indiceDisco).getCanciones();
				for(Cancion cancion : cancionD){
					dListModel.addElement(cancion.getNombre());
				}
				vista.getList_2().setModel(dListModel);
			}	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}