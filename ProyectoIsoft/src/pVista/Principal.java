package pVista;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Principal extends JFrame {
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JLabel lblIntegrantes;
	private JList list;
	private JList list_1;
	private JLabel lblDiscos;
	private JList list_2;
	private JLabel lblCancionesDelDisco;
	private JLabel lblBiografia;
	private JTextPane biografia;
	private SpringLayout springLayout;
	private JComboBox comboBox;
	private JScrollBar scrollBar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public Principal() {
		initGUI();
	}
	private void initGUI() {
		setVisible(true);
		setBounds(100, 100, 505, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		JPanel contentPane = new JPanel();
		
		setContentPane(contentPane);
		getContentPane().setLayout(springLayout);
		
		lblNewLabel = new JLabel("Artista");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 17, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		btnBuscar = new JButton("Buscar");
		springLayout.putConstraint(SpringLayout.NORTH, btnBuscar, -4, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, btnBuscar, 226, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnBuscar, -93, SpringLayout.EAST, contentPane);
		getContentPane().add(btnBuscar);
		
		lblIntegrantes = new JLabel("Integrantes");
		springLayout.putConstraint(SpringLayout.NORTH, lblIntegrantes, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIntegrantes, 20, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblIntegrantes);
		
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
		springLayout.putConstraint(SpringLayout.NORTH, list_2, 8, SpringLayout.SOUTH, lblCancionesDelDisco);
		springLayout.putConstraint(SpringLayout.WEST, list_2, 160, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, list_2, 283, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, list_2, -177, SpringLayout.EAST, contentPane);
		getContentPane().add(list_2);
		
		lblBiografia = new JLabel("Biografia");
		springLayout.putConstraint(SpringLayout.NORTH, lblBiografia, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBiografia, 334, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblBiografia);
		
		comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, lblIntegrantes);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -26, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -279, SpringLayout.EAST, contentPane);
		comboBox.setEditable(true);
		getContentPane().add(comboBox);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 11, SpringLayout.SOUTH, lblIntegrantes);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -159, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.WEST, list_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		springLayout.putConstraint(SpringLayout.WEST, list, 24, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, list, 317, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, list, 0, SpringLayout.EAST, lblIntegrantes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 22, SpringLayout.EAST, list_2);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 462, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_1);
		
		biografia = new JTextPane();
		scrollPane_1.setViewportView(biografia);
		springLayout.putConstraint(SpringLayout.NORTH, biografia, 0, SpringLayout.NORTH, list_1);
		springLayout.putConstraint(SpringLayout.WEST, biografia, 22, SpringLayout.EAST, list_2);
		springLayout.putConstraint(SpringLayout.SOUTH, biografia, 407, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, biografia, 462, SpringLayout.WEST, contentPane);
		

		
		contentPane.updateUI();
		
		
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JLabel getLblIntegrantes() {
		return lblIntegrantes;
	}
	public JList getList() {
		return list;
	}
	public JList getList_1() {
		return list_1;
	}
	public JLabel getLblDiscos() {
		return lblDiscos;
	}
	public JList getList_2() {
		return list_2;
	}
	public JLabel getLblCancionesDelDisco() {
		return lblCancionesDelDisco;
	}
	public JLabel getLblBiografia() {
		return lblBiografia;
	}
	public JTextPane getBiografia() {
		return biografia;
	}
	public SpringLayout getSpringLayout() {
		return springLayout;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}