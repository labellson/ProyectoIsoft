package pControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import pModelo.Grupo;
import pModelo.ListaArtista;
import pModelo.ModeloComboBox;
import pModelo.Solista;


public class Principal implements ActionListener{
  pVista.Principal vista;
	public Principal(){
		vista = new pVista.Principal();
		new ModeloComboBox(vista.getComboBox());
		for(int i=0; i<pModelo.ListaArtista.getSingelton().get().size(); i++){
			vista.getComboBox().addItem(pModelo.ListaArtista.getSingelton().get(i).getNombre());
		}
		vista.getComboBox().addActionListener(this);
		
		
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
			
			//Discografias/Albumes
			DefaultListModel<String> dListModelDiscos = new DefaultListModel<String>();
			for(int i=0; i<pModelo.ListaArtista.getSingelton().get(indice).getlAlbum().size();i++){
				dListModelDiscos.addElement(pModelo.ListaArtista.getSingelton().get(indice).getlAlbum().get(i).getNombre());
			}
			vista.getList_1().setModel(dListModelDiscos);
			
			//Biografia
			vista.getBiografia().setText(pModelo.ListaArtista.getSingelton().get(indice).getBiografia().getDescripcion());
		}
	}
}
