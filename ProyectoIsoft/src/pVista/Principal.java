package pVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Principal extends JDialog {
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
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		initGUI();
	}
	private void initGUI() {
		setBounds(100, 100, 570, 470);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(getLblNewLabel())
							.addGap(10)
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(getBtnBuscar(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(40)
									.addComponent(getLblIntegrantes())
									.addGap(61)
									.addComponent(getLblDiscos(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(161)
									.addComponent(getLblCancionesDelDisco(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(getLblPosicionEnEl()))
									.addGap(35)
									.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getTextPane(), GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblBiografia()))))
					.addGap(437))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(getLblNewLabel()))
						.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(getBtnBuscar())
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(getLblIntegrantes()))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblDiscos())
							.addComponent(getLblBiografia())))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(getLblCancionesDelDisco())
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(getLblPosicionEnEl())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
						.addComponent(getTextPane())))
		);
		getContentPane().setLayout(groupLayout);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Artista");
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
		}
		return btnBuscar;
	}
	private JLabel getLblIntegrantes() {
		if (lblIntegrantes == null) {
			lblIntegrantes = new JLabel("Integrantes");
		}
		return lblIntegrantes;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	private JLabel getLblPosicionEnEl() {
		if (lblPosicionEnEl == null) {
			lblPosicionEnEl = new JLabel("Posicion en el grupo");
		}
		return lblPosicionEnEl;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JList getList_1() {
		if (list_1 == null) {
			list_1 = new JList();
		}
		return list_1;
	}
	private JLabel getLblDiscos() {
		if (lblDiscos == null) {
			lblDiscos = new JLabel("Discos");
		}
		return lblDiscos;
	}
	private JList getList_2() {
		if (list_2 == null) {
			list_2 = new JList();
		}
		return list_2;
	}
	private JLabel getLblCancionesDelDisco() {
		if (lblCancionesDelDisco == null) {
			lblCancionesDelDisco = new JLabel("Canciones del disco:");
		}
		return lblCancionesDelDisco;
	}
	private JLabel getLblBiografia() {
		if (lblBiografia == null) {
			lblBiografia = new JLabel("Biografia");
		}
		return lblBiografia;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
}
