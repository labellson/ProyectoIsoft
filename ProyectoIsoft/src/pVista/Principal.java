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
import java.awt.Color;
import java.awt.Font;

public class Principal extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblIntegrantes;
	private JList list;
	private JList list_1;
	private JLabel lblDiscos;
	private JList list_2;
	private JLabel lblCancionesDelDisco;
	private JLabel lblBiografia;
	private JTextPane biografia;
	private JComboBox comboBox;
	private JScrollBar scrollBar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_5;
	private JList list_3;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JList list_4;

	/**
	 * Launch the application.
	 */
	public Principal() {
		initGUI();
	}
	private void initGUI() {
		setVisible(true);
		setResizable(false);
		setTitle("TicketMaster");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		lblNewLabel = new JLabel("Artista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 522, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, contentPane);
		getContentPane().add(lblNewLabel);
		
		lblIntegrantes = new JLabel("Integrantes");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIntegrantes, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIntegrantes, 20, SpringLayout.WEST, contentPane);
		getContentPane().add(lblIntegrantes);
		
		lblCancionesDelDisco = new JLabel("Canciones");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCancionesDelDisco, 297, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCancionesDelDisco, 170, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCancionesDelDisco, 258, SpringLayout.WEST, contentPane);
		getContentPane().add(lblCancionesDelDisco);
		
		lblDiscos = new JLabel("Discos");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDiscos, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDiscos, 170, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDiscos, 227, SpringLayout.WEST, contentPane);
		getContentPane().add(lblDiscos);
		
		lblBiografia = new JLabel("Biografia");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBiografia, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBiografia, 383, SpringLayout.WEST, contentPane);
		getContentPane().add(lblBiografia);
		
		comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 519, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 82, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 367, SpringLayout.WEST, contentPane);
		comboBox.setEditable(true);
		getContentPane().add(comboBox);
		
		scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 77, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 283, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 154, SpringLayout.WEST, contentPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 77, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, 383, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, 336, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, 566, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_1);
		
		biografia = new JTextPane();
		biografia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		biografia.setEditable(false);
		scrollPane_1.setViewportView(biografia);
		
		scrollPane_2 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_2, 77, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_2, 170, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_2, 283, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_2, 362, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_2);
		
		list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		JLabel lblBiografiaArtista = new JLabel("Biografia Integrante");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBiografiaArtista, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBiografiaArtista, 588, SpringLayout.WEST, contentPane);
		contentPane.add(lblBiografiaArtista);
		
		scrollPane_3 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_3, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_3, 170, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_3, 491, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_3, 362, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_3);
		
		list_2 = new JList();
		scrollPane_3.setViewportView(list_2);
		
		scrollPane_4 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_4, 77, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_4, 588, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_4, 336, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_4, 774, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_4);
		
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setEditable(false);
		scrollPane_4.setViewportView(textPane_1);
		
		lblNewLabel_1 = new JLabel("Posicion");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 297, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		scrollPane_5 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_5, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_5, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_5, 491, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_5, 154, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_5);
		
		list_3 = new JList();
		scrollPane_5.setViewportView(list_3);
		
		JLabel lblLetra = new JLabel("Letra");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLetra, 342, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLetra, 383, SpringLayout.WEST, contentPane);
		contentPane.add(lblLetra);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_6, 362, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_6, 383, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_6, 536, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_6, 566, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_6);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setEditable(false);
		scrollPane_6.setViewportView(textPane);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_7, 362, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_7, 588, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_7, 499, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_7, 774, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane_7);
		
		list_4 = new JList();
		scrollPane_7.setViewportView(list_4);
		
		JLabel lblCancionesPopulares = new JLabel("Canciones Populares");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCancionesPopulares, 342, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCancionesPopulares, 588, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCancionesPopulares, 732, SpringLayout.WEST, contentPane);
		contentPane.add(lblCancionesPopulares);
		
		JButton btnSalir = new JButton("Salir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSalir, 518, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSalir, 685, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, 774, SpringLayout.WEST, contentPane);
		contentPane.add(btnSalir);
		
		JButton btnVotar = new JButton("Votar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVotar, 518, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVotar, 588, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVotar, 677, SpringLayout.WEST, contentPane);
		contentPane.add(btnVotar);
		

		
		contentPane.updateUI();
		
		
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
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
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JList getList_3() {
		return list_3;
	}
	public JTextPane getTextPane(){
		return textPane;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JTextPane getTextPane_1() {
		return textPane_1;
	}
}
