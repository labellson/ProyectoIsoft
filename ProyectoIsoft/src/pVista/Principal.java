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
	private JTextPane biografia;

	/**
	 * Launch the application.
	 */
	public Principal() {
		initGUI();
	}
	private void initGUI() {
		setBounds(100, 100, 505, 400);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(getLblNewLabel())
							.addGap(10)
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtnBuscar(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblIntegrantes())
								.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblPosicionEnEl()))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblCancionesDelDisco(), GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblDiscos(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(getLblBiografia()))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(getBiografia(), GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))))
					.addGap(593))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(3)
								.addComponent(getLblNewLabel()))
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(getBtnBuscar()))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getLblIntegrantes())
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblDiscos())
							.addComponent(getLblBiografia())))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblPosicionEnEl())
								.addComponent(getLblCancionesDelDisco()))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
						.addComponent(getBiografia()))
					.addGap(75))
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
			lblPosicionEnEl = new JLabel("Posicion");
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
			lblCancionesDelDisco = new JLabel("Canciones");
		}
		return lblCancionesDelDisco;
	}
	private JLabel getLblBiografia() {
		if (lblBiografia == null) {
			lblBiografia = new JLabel("Biografia");
		}
		return lblBiografia;
	}
	private JTextPane getBiografia() {
		if (biografia == null) {
			biografia = new JTextPane();
		}
		return biografia;
	}
}
