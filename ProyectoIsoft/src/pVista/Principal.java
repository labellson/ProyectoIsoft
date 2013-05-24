package pVista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

public class Principal extends JFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnBuscar;
	private JLabel lblIntegrantes;
	private JList list;
	private JLabel lblPosicionEnEl;
	private JTextField textField_1;
	private JList list_1;
	private JLabel lblDiscos;
	private JList list_2;
	private JLabel lblCancionesDelDisco;
	private JLabel lblBiografia;
	private JTextPane biografia;
	private SpringLayout springLayout;

	/**
	 * Launch the application.
	 */
	public Principal() {
		initGUI();
	}
	private void initGUI() {
		setBounds(100, 100, 505, 400);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		lblNewLabel = new JLabel("Artista");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 17, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 14, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 52, SpringLayout.WEST, getContentPane());
		textField.setColumns(10);
		getContentPane().add(textField);
		
		btnBuscar = new JButton("Buscar");
		springLayout.putConstraint(SpringLayout.NORTH, btnBuscar, 11, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnBuscar, 144, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBuscar, 272, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnBuscar);
		
		lblIntegrantes = new JLabel("Integrantes");
		springLayout.putConstraint(SpringLayout.NORTH, lblIntegrantes, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIntegrantes, 20, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblIntegrantes);
		
		list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 72, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, 190, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, 150, SpringLayout.WEST, getContentPane());
		getContentPane().add(list);
		
		lblPosicionEnEl = new JLabel("Posicion");
		springLayout.putConstraint(SpringLayout.NORTH, lblPosicionEnEl, 209, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPosicionEnEl, 20, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPosicionEnEl);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 229, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 20, SpringLayout.WEST, getContentPane());
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		lblCancionesDelDisco = new JLabel("Canciones");
		springLayout.putConstraint(SpringLayout.NORTH, lblCancionesDelDisco, 209, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCancionesDelDisco, 160, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCancionesDelDisco, 248, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblCancionesDelDisco);
		
		list_1 = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list_1, 72, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list_1, 160, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list_1, 190, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_1, 310, SpringLayout.WEST, getContentPane());
		getContentPane().add(list_1);
		
		lblDiscos = new JLabel("Discos");
		springLayout.putConstraint(SpringLayout.NORTH, lblDiscos, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDiscos, 160, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDiscos, 217, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblDiscos);
		
		list_2 = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list_2, 231, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list_2, 160, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list_2, 349, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_2, 312, SpringLayout.WEST, getContentPane());
		getContentPane().add(list_2);
		
		lblBiografia = new JLabel("Biografia");
		springLayout.putConstraint(SpringLayout.NORTH, lblBiografia, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBiografia, 334, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblBiografia);
		
		biografia = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, biografia, 72, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, biografia, 330, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, biografia, 349, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, biografia, 472, SpringLayout.WEST, getContentPane());
		getContentPane().add(biografia);
	}
}
