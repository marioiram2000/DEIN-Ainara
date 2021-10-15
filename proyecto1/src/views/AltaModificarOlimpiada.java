package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OlimpiadaDAO;
import model.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class AltaModificarOlimpiada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblAnio;
	private JLabel lblTemporada;
	private JLabel lblCiudad;
	private JTextField textFieldCiudad;
	private JFormattedTextField textFieldAnio;
	private Olimpiada olimpiada;
	private JComboBox<String> comboBoxTemporada;

	public AltaModificarOlimpiada() {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar olimpiada");
		olimpiada = new Olimpiada();
		dibujar();
		gestionarEventos();
		gestionarEventosAlta();
	}

	public AltaModificarOlimpiada(String id) {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar olimpiada");
		olimpiada = new OlimpiadaDAO().getOlimpiada(Integer.parseInt(id));
		dibujar();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();
	}

	private void fillForm() {
		textFieldAnio.setText(olimpiada.getAnio() + "");
		textFieldCiudad.setText(olimpiada.getCiudad());
		comboBoxTemporada.setSelectedItem(olimpiada.getTemporada());
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblAnio = new JLabel("Año:");
			GridBagConstraints gbc_lblAnio = new GridBagConstraints();
			gbc_lblAnio.anchor = GridBagConstraints.EAST;
			gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnio.gridx = 0;
			gbc_lblAnio.gridy = 0;
			contentPanel.add(lblAnio, gbc_lblAnio);
		}
		{
			textFieldAnio = new JFormattedTextField(new SimpleDateFormat("yyyy"));
			textFieldAnio.setColumns(4);
			GridBagConstraints gbc_textFieldAnio = new GridBagConstraints();
			gbc_textFieldAnio.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldAnio.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAnio.gridx = 1;
			gbc_textFieldAnio.gridy = 0;
			contentPanel.add(textFieldAnio, gbc_textFieldAnio);
		}
		{
			lblTemporada = new JLabel("Temporada:");
			GridBagConstraints gbc_lblTemporada = new GridBagConstraints();
			gbc_lblTemporada.anchor = GridBagConstraints.EAST;
			gbc_lblTemporada.insets = new Insets(0, 0, 5, 5);
			gbc_lblTemporada.gridx = 0;
			gbc_lblTemporada.gridy = 1;
			contentPanel.add(lblTemporada, gbc_lblTemporada);
		}
		{
			comboBoxTemporada = new JComboBox<String>();
			comboBoxTemporada.addItem("Summer");
			comboBoxTemporada.addItem("Winter");
			GridBagConstraints gbc_comboBoxTemporada = new GridBagConstraints();
			gbc_comboBoxTemporada.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxTemporada.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxTemporada.gridx = 1;
			gbc_comboBoxTemporada.gridy = 1;
			contentPanel.add(comboBoxTemporada, gbc_comboBoxTemporada);
		}
		{
			lblCiudad = new JLabel("Ciudad:");
			GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
			gbc_lblCiudad.insets = new Insets(0, 0, 0, 5);
			gbc_lblCiudad.anchor = GridBagConstraints.EAST;
			gbc_lblCiudad.gridx = 0;
			gbc_lblCiudad.gridy = 2;
			contentPanel.add(lblCiudad, gbc_lblCiudad);
		}
		{
			textFieldCiudad = new JTextField();
			GridBagConstraints gbc_textFieldCiudad = new GridBagConstraints();
			gbc_textFieldCiudad.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCiudad.gridx = 1;
			gbc_textFieldCiudad.gridy = 2;
			contentPanel.add(textFieldCiudad, gbc_textFieldCiudad);
			textFieldCiudad.setColumns(10);
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
				olimpiada.setNombre(textFieldAnio.getText() + " " + (String) comboBoxTemporada.getSelectedItem());
				olimpiada.setCiudad(textFieldCiudad.getText());
				olimpiada.setAnio(Integer.parseInt(textFieldAnio.getText()));
				olimpiada.setTemporada((String) comboBoxTemporada.getSelectedItem());
				new OlimpiadaDAO().insertOlimpiada(olimpiada);
				dispose();
			}
		});
	}

	private void gestionarEventosModificar() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				olimpiada.setNombre(textFieldAnio.getText() + " " + (String) comboBoxTemporada.getSelectedItem());
				olimpiada.setCiudad(textFieldCiudad.getText());
				olimpiada.setAnio(Integer.parseInt(textFieldAnio.getText()));
				olimpiada.setTemporada((String) comboBoxTemporada.getSelectedItem());
				new OlimpiadaDAO().updateOlimpiada(olimpiada);
				dispose();
			}
		});
	}

}
