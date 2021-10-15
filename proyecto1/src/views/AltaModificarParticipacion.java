package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeportistaDAO;
import dao.EquipoDAO;
import dao.EventoDAO;
import dao.ParticipacionDAO;
import model.Deportista;
import model.Equipo;
import model.Evento;
import model.Participacion;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class AltaModificarParticipacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton okButton;
	private JLabel lblDeportista;
	private JLabel lblEvento;
	private JLabel lblEquipo;
	private JLabel lblEdad;
	private JLabel lblMedalla;
	private JComboBox<Deportista> comboBoxDeportistas;
	private JComboBox<Evento> comboBoxEventos;
	private JComboBox<Equipo> comboBoxEquipos;
	private JSpinner spinnerEdad;
	private JPanel panel;
	private JRadioButton rdbtnNan;
	private JRadioButton rdbtnBronce;
	private JRadioButton rdbtnPlata;
	private JRadioButton rdbtnOro;
	private Participacion participacion;

	public AltaModificarParticipacion() {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar participación");
		participacion = new Participacion();
		dibujar();
		setCombos();
		gestionarEventos();
		gestionarEventosAlta();
	}

	public AltaModificarParticipacion(String id) {
		setTitle("GESTIÓN DE OLIMPIADAS - Dar de alta/Modificar participación");
		String id_deportista = id.split("_")[0];
		String id_evento = id.split("_")[1];
		participacion = new ParticipacionDAO().getParticipacion(Integer.parseInt(id_deportista),
				Integer.parseInt(id_evento));
		dibujar();
		setCombos();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();
	}

	private void setCombos() {
		ArrayList<Deportista> deportistas = new DeportistaDAO().getDeportistas();
		for (Deportista deportista : deportistas) {
			comboBoxDeportistas.addItem(deportista);
		}
		ArrayList<Equipo> equipos = new EquipoDAO().getEquipos();
		for (Equipo equipo : equipos) {
			comboBoxEquipos.addItem(equipo);
		}
		ArrayList<Evento> eventos = new EventoDAO().getEventos();
		for (Evento evento : eventos) {
			comboBoxEventos.addItem(evento);
		}
	}

	private void fillForm() {
		comboBoxDeportistas.setSelectedItem(participacion.getDeportista());
		comboBoxEquipos.setSelectedItem(participacion.getEquipo());
		comboBoxEventos.setSelectedItem(participacion.getEvento());
		spinnerEdad.setValue(participacion.getEdad());
		if (participacion.getMedalla() == null) {
			rdbtnNan.setSelected(true);
		} else if (participacion.getMedalla().equals("Oro")) {
			rdbtnOro.setSelected(true);
		} else if (participacion.getMedalla().equals("Plata")) {
			rdbtnPlata.setSelected(true);
		} else if (participacion.getMedalla().equals("Bronce")) {
			rdbtnBronce.setSelected(true);
		}

	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblDeportista = new JLabel("Deportista:");
			GridBagConstraints gbc_lblDeportista = new GridBagConstraints();
			gbc_lblDeportista.anchor = GridBagConstraints.EAST;
			gbc_lblDeportista.insets = new Insets(0, 0, 5, 5);
			gbc_lblDeportista.gridx = 0;
			gbc_lblDeportista.gridy = 0;
			contentPanel.add(lblDeportista, gbc_lblDeportista);
		}
		{
			comboBoxDeportistas = new JComboBox<Deportista>();
			GridBagConstraints gbc_comboBoxDeportistas = new GridBagConstraints();
			gbc_comboBoxDeportistas.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxDeportistas.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxDeportistas.gridx = 1;
			gbc_comboBoxDeportistas.gridy = 0;
			contentPanel.add(comboBoxDeportistas, gbc_comboBoxDeportistas);
		}
		{
			lblEvento = new JLabel("Evento:");
			GridBagConstraints gbc_lblEvento = new GridBagConstraints();
			gbc_lblEvento.anchor = GridBagConstraints.EAST;
			gbc_lblEvento.insets = new Insets(0, 0, 5, 5);
			gbc_lblEvento.gridx = 0;
			gbc_lblEvento.gridy = 1;
			contentPanel.add(lblEvento, gbc_lblEvento);
		}
		{
			comboBoxEventos = new JComboBox<Evento>();
			GridBagConstraints gbc_comboBoxEventos = new GridBagConstraints();
			gbc_comboBoxEventos.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxEventos.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxEventos.gridx = 1;
			gbc_comboBoxEventos.gridy = 1;
			contentPanel.add(comboBoxEventos, gbc_comboBoxEventos);
		}
		{
			lblEquipo = new JLabel("Equipo:");
			GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
			gbc_lblEquipo.anchor = GridBagConstraints.EAST;
			gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
			gbc_lblEquipo.gridx = 0;
			gbc_lblEquipo.gridy = 2;
			contentPanel.add(lblEquipo, gbc_lblEquipo);
		}
		{
			comboBoxEquipos = new JComboBox<Equipo>();
			GridBagConstraints gbc_comboBoxEquipos = new GridBagConstraints();
			gbc_comboBoxEquipos.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxEquipos.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxEquipos.gridx = 1;
			gbc_comboBoxEquipos.gridy = 2;
			contentPanel.add(comboBoxEquipos, gbc_comboBoxEquipos);
		}
		{
			lblEdad = new JLabel("Edad:");
			GridBagConstraints gbc_lblEdad = new GridBagConstraints();
			gbc_lblEdad.anchor = GridBagConstraints.EAST;
			gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
			gbc_lblEdad.gridx = 0;
			gbc_lblEdad.gridy = 3;
			contentPanel.add(lblEdad, gbc_lblEdad);
		}
		{
			spinnerEdad = new JSpinner();
			GridBagConstraints gbc_spinnerEdad = new GridBagConstraints();
			gbc_spinnerEdad.anchor = GridBagConstraints.WEST;
			gbc_spinnerEdad.insets = new Insets(0, 0, 5, 0);
			gbc_spinnerEdad.gridx = 1;
			gbc_spinnerEdad.gridy = 3;
			contentPanel.add(spinnerEdad, gbc_spinnerEdad);
		}
		{
			lblMedalla = new JLabel("Medalla");
			GridBagConstraints gbc_lblMedalla = new GridBagConstraints();
			gbc_lblMedalla.insets = new Insets(0, 0, 0, 5);
			gbc_lblMedalla.anchor = GridBagConstraints.EAST;
			gbc_lblMedalla.gridx = 0;
			gbc_lblMedalla.gridy = 4;
			contentPanel.add(lblMedalla, gbc_lblMedalla);
		}
		{
			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 4;
			contentPanel.add(panel, gbc_panel);
			ButtonGroup bg = new ButtonGroup();
			{
				rdbtnNan = new JRadioButton("Nan");
				bg.add(rdbtnNan);
				panel.add(rdbtnNan);
			}
			{
				rdbtnBronce = new JRadioButton("Bronce");
				bg.add(rdbtnBronce);
				panel.add(rdbtnBronce);
			}
			{
				rdbtnPlata = new JRadioButton("Plata");
				bg.add(rdbtnPlata);
				panel.add(rdbtnPlata);
			}
			{
				rdbtnOro = new JRadioButton("Oro");
				bg.add(rdbtnOro);
				panel.add(rdbtnOro);
			}
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
				participacion.setDeportista((Deportista) comboBoxDeportistas.getSelectedItem());
				participacion.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
				participacion.setEquipo((Equipo) comboBoxEquipos.getSelectedItem());
				participacion.setEvento((Evento) comboBoxEventos.getSelectedItem());
				if (rdbtnBronce.isSelected()) {
					participacion.setMedalla("Bronce");
				} else if (rdbtnPlata.isSelected()) {
					participacion.setMedalla("Plata");
				} else if (rdbtnOro.isSelected()) {
					participacion.setMedalla("Oro");
				} else {
					participacion.setMedalla(null);
				}
				new ParticipacionDAO().insertParticipacion(participacion);
				dispose();
			}
		});
	}

	private void gestionarEventosModificar() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				participacion.setDeportista((Deportista) comboBoxDeportistas.getSelectedItem());
				participacion.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
				participacion.setEquipo((Equipo) comboBoxEquipos.getSelectedItem());
				participacion.setEvento((Evento) comboBoxEventos.getSelectedItem());
				if (rdbtnBronce.isSelected()) {
					participacion.setMedalla("Bronce");
				} else if (rdbtnPlata.isSelected()) {
					participacion.setMedalla("Plata");
				} else if (rdbtnOro.isSelected()) {
					participacion.setMedalla("Oro");
				} else {
					participacion.setMedalla(null);
				}
				new ParticipacionDAO().updateParticipacion(participacion);
				dispose();
			}
		});
	}

}
