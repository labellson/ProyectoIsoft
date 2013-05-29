package pControlador;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import pModelo.Cancion;
import pModelo.Grupo;
import pModelo.ListaArtista;
import pModelo.ModeloComboBox;
import pModelo.Solista;


public class Principal implements ActionListener, ListSelectionListener{
  pVista.Principal vista;
	public Principal(){
		vista = new pVista.Principal();
		new ModeloComboBox(vista.getComboBox());
		for(int i=0; i<pModelo.ListaArtista.getSingelton().getlistaArtista().size(); i++){
			vista.getComboBox().addItem(pModelo.ListaArtista.getSingelton().get(i).getNombre());
		}
		vista.getComboBox().addActionListener(this);
		vista.getList_1().addListSelectionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getComboBox()){
			
			int indice = pModelo.ListaArtista.getSingelton().compararNombre((String) vista.getComboBox().getSelectedItem());
			if(indice == -1) return;
			DefaultListModel<String> dListModel = new DefaultListModel<String>();
			if(pModelo.Solista.class == pModelo.ListaArtista.getSingelton().get(indice).getClass()){
				dListModel.addElement(pModelo.ListaArtista.getSingelton().get(indice).getNombre());
			}else{
				for(int i=0; i<((pModelo.Grupo)pModelo.ListaArtista.getSingelton().get(indice)).getSize();i++){
					dListModel.addElement(((pModelo.Grupo)pModelo.ListaArtista.getSingelton().get(indice)).getIntentegrantes(i).getNombre());
				}
			}
			vista.getList().setModel(dListModel);
			
			//Discografias/Albumeso
			DefaultListModel<String> dListModelDiscos = new DefaultListModel<String>();
			for(int i=0; i<pModelo.ListaArtista.getSingelton().get(indice).getlAlbum().size();i++){
				dListModelDiscos.addElement(pModelo.ListaArtista.getSingelton().get(indice).getlAlbum().get(i).getNombre());
			}
			vista.getList_1().setModel(dListModelDiscos);
			
			//Biografia
			vista.getBiografia().setText(pModelo.ListaArtista.getSingelton().get(indice).getBiografia().getDescripcion());
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == vista.getList_1()){
			int indiceDisco = (int) vista.getList_1().getSelectedIndex();
			String artistaN = (String) vista.getComboBox().getSelectedItem();
			DefaultListModel<String> dListModel = new DefaultListModel<String>();
			System.out.println(pModelo.ListaArtista.getSingelton().get(pModelo.ListaArtista.getSingelton().compararNombre(artistaN)).getlAlbum().get(0).getCanciones().size());
			ArrayList<Cancion> cancionD = pModelo.ListaArtista.getSingelton().get(pModelo.ListaArtista.getSingelton().compararNombre(artistaN)).getlAlbum().get(indiceDisco).getCanciones();
			for(Cancion cancion : cancionD){
				dListModel.addElement(cancion.getNombre());
			}
			vista.getList_2().setModel(dListModel);
		}
		
	}
}