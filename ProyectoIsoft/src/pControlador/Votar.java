package pControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class Votar implements ActionListener{
	private pVista.Votar vista;
	public Votar(pVista.Votar vista){
		this.vista = vista;
		updateCanciones();
		vista.getButton().addActionListener(this);
		vista.getButton_1().addActionListener(this);
		vista.getButton_2().addActionListener(this);
	}
	
	private void updateCanciones(){
		DefaultListModel<String> dListModelNombres = new DefaultListModel<String>();
		DefaultListModel<String> dListModelPuntuaciones = new DefaultListModel<String>();
		int top=10;
		if(pModelo.ListaCancion.getSingelton().get().size()<10) top = pModelo.ListaCancion.getSingelton().get().size();
		for(int i=0; i<top; i++){
			dListModelNombres.addElement(pModelo.ListaCancion.getSingelton().get().get(i).getNombre());
			dListModelPuntuaciones.addElement(String.valueOf(pModelo.ListaCancion.getSingelton().get().get(i).getPuntuacion()));
		}
		vista.getList().setModel(dListModelNombres);
		vista.getList_1().setModel(dListModelPuntuaciones);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getButton()){
			int index = vista.getList().getSelectedIndex();
			if(index != -1){
				pModelo.ListaCancion.getSingelton().meGusta(index);
				updateCanciones();
			}
		}else if(e.getSource() == vista.getButton_1()){
			int index = vista.getList().getSelectedIndex();
			if(index != -1){
				pModelo.ListaCancion.getSingelton().noMeGusta(index);
				updateCanciones();
			}
		}else if(e.getSource() == vista.getButton_2()){
			vista.dispose();
		}
		
	}
}
