package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.EquipoDAO;
import model.Equipo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class AltaModificarEquipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblNombre;
	private JLabel lblIniciales;
	private JTextField textFieldNombre;
	private JTextField textFieldIniciales;
	private Equipo equipo;

	public AltaModificarEquipo() {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar equipo");
		this.equipo = new Equipo();
		dibujar();
		gestionarEventos();
		gestionarEventosAlta();
	}

	public AltaModificarEquipo(String id) {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar equipo");
		this.equipo = new EquipoDAO().getEquipo(Integer.parseInt(id));
		dibujar();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();
	}

	private void fillForm() {
		textFieldNombre.setText(equipo.getNombre());
		textFieldIniciales.setText(equipo.getIniciales());
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			textFieldNombre = new JTextField();
			GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
			gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNombre.gridx = 1;
			gbc_textFieldNombre.gridy = 0;
			contentPanel.add(textFieldNombre, gbc_textFieldNombre);
			textFieldNombre.setColumns(10);
		}
		{
			lblIniciales = new JLabel("Iniciales:");
			GridBagConstraints gbc_lblIniciales = new GridBagConstraints();
			gbc_lblIniciales.anchor = GridBagConstraints.EAST;
			gbc_lblIniciales.insets = new Insets(0, 0, 0, 5);
			gbc_lblIniciales.gridx = 0;
			gbc_lblIniciales.gridy = 1;
			contentPanel.add(lblIniciales, gbc_lblIniciales);
		}
		{
			textFieldIniciales = new JTextField();
			GridBagConstraints gbc_textFieldIniciales = new GridBagConstraints();
			gbc_textFieldIniciales.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIniciales.gridx = 1;
			gbc_textFieldIniciales.gridy = 1;
			contentPanel.add(textFieldIniciales, gbc_textFieldIniciales);
			textFieldIniciales.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void gestionarEventos() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	private void gestionarEventosAlta() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				equipo.setNombre(textFieldNombre.getText());
				equipo.setIniciales(textFieldIniciales.getText());
				new EquipoDAO().insertEquipo(equipo);
				dispose();
			}
		});

	}

	private void gestionarEventosModificar() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equipo.setNombre(textFieldNombre.getText());
				equipo.setIniciales(textFieldIniciales.getText());
				new EquipoDAO().updateEquipo(equipo);
				dispose();
			}
		});

	}

}
