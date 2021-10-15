package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeporteDAO;
import dao.EquipoDAO;
import dao.EventoDAO;
import dao.OlimpiadaDAO;
import model.Deporte;
import model.Evento;
import model.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JComboBox;

public class AltaModificarEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private Evento evento;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblOlimpiada;
	private JLabel lblDeporte;
	private JComboBox<Olimpiada> comboBoxOlimpiadas;
	private JComboBox<Deporte> comboBoxDeportes;

	public AltaModificarEvento() {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar evento");
		evento = new Evento();
		dibujar();
		setCombos();
		gestionarEventos();
		gestionarEventosAlta();
	}
	
	public AltaModificarEvento(String id) {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar evento");
		this.evento = new EventoDAO().getEvento(Integer.parseInt(id));
		dibujar();
		setCombos();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();
	}
	
	private void setCombos() {
		ArrayList<Olimpiada> olimpiadas = new OlimpiadaDAO().getOlimpiadas();
		for (Olimpiada olimpiada : olimpiadas) {
			comboBoxOlimpiadas.addItem(olimpiada);			
		}
		
		ArrayList<Deporte> deportes = new DeporteDAO().getDeportes();
		for (Deporte deporte : deportes) {
			comboBoxDeportes.addItem(deporte);
		}
	}
	
	private void fillForm() {
		textFieldNombre.setText(evento.getNombre());
		comboBoxOlimpiadas.setSelectedItem(evento.getOlimpiada());
		comboBoxDeportes.setSelectedItem(evento.getDeporte());
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
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
			lblOlimpiada = new JLabel("Olimpiada:");
			GridBagConstraints gbc_lblOlimpiada = new GridBagConstraints();
			gbc_lblOlimpiada.anchor = GridBagConstraints.EAST;
			gbc_lblOlimpiada.insets = new Insets(0, 0, 5, 5);
			gbc_lblOlimpiada.gridx = 0;
			gbc_lblOlimpiada.gridy = 1;
			contentPanel.add(lblOlimpiada, gbc_lblOlimpiada);
		}
		{
			comboBoxOlimpiadas = new JComboBox();
			GridBagConstraints gbc_comboBoxOlimpiadas = new GridBagConstraints();
			gbc_comboBoxOlimpiadas.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxOlimpiadas.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxOlimpiadas.gridx = 1;
			gbc_comboBoxOlimpiadas.gridy = 1;
			contentPanel.add(comboBoxOlimpiadas, gbc_comboBoxOlimpiadas);
		}
		{
			lblDeporte = new JLabel("Deporte:");
			GridBagConstraints gbc_lblDeporte = new GridBagConstraints();
			gbc_lblDeporte.anchor = GridBagConstraints.EAST;
			gbc_lblDeporte.insets = new Insets(0, 0, 0, 5);
			gbc_lblDeporte.gridx = 0;
			gbc_lblDeporte.gridy = 2;
			contentPanel.add(lblDeporte, gbc_lblDeporte);
		}
		{
			comboBoxDeportes = new JComboBox();
			GridBagConstraints gbc_comboBoxDeportes = new GridBagConstraints();
			gbc_comboBoxDeportes.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxDeportes.gridx = 1;
			gbc_comboBoxDeportes.gridy = 2;
			contentPanel.add(comboBoxDeportes, gbc_comboBoxDeportes);
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
				evento.setNombre(textFieldNombre.getText());
				evento.setDeporte((Deporte) comboBoxDeportes.getSelectedItem());
				evento.setOlimpiada((Olimpiada) comboBoxOlimpiadas.getSelectedItem());
				new EventoDAO().insertEvento(evento);
				dispose();	
			}
		});
	}

	private void gestionarEventosModificar() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evento.setNombre(textFieldNombre.getText());
				evento.setDeporte((Deporte) comboBoxDeportes.getSelectedItem());
				evento.setOlimpiada((Olimpiada) comboBoxOlimpiadas.getSelectedItem());
				new EventoDAO().updateEvento(evento);
				dispose();	
			}
		});
	}

}
