package views;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.GetPropertyValues;
import config.Messages;
import dao.DeporteDAO;
import dao.DeportistaDAO;
import dao.EquipoDAO;
import dao.EventoDAO;
import dao.OlimpiadaDAO;
import dao.ParticipacionDAO;
import model.Deporte;
import model.Deportista;
import model.Equipo;
import model.Evento;
import model.Olimpiada;
import model.Participacion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JRadioButton rdbtnDeportes;
	private JRadioButton rdbtnDeportistas;
	private JRadioButton rdbtnEquipos;
	private JRadioButton rdbtnEventos;
	private JRadioButton rdbtnOlimpiadas;
	private JRadioButton rdbtnParticipaciones;
	private JRadioButton rdbtnSeleccionado;
	private JButton btnDarDeAlta;
	private JButton btnModificar;
	private JButton btnDarDeBaja;

	public static void main(String[] args) throws IOException {
		GetPropertyValues pv = new GetPropertyValues();
		Locale.setDefault(pv.getLocale());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public index() {
		setTitle(Messages.getString("index.appTitle"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/images/logo.png"))); //$NON-NLS-1$
		dibujar();
		gestionarEventos();
		rellenarTabla("Deporte");
	}

	private void rellenarTabla(String tabla) {
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modelo);
		String[] headers;
		switch (tabla) {
			case "Deporte":
				headers = Deporte.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Deporte> deportes = new DeporteDAO().getDeportes();
				for (Deporte deporte : deportes) {
					String[] row = deporte.getAll();
					modelo.addRow(row);
				}
				break;
	
			case "Deportista":
				headers = Deportista.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Deportista> deportistas = new DeportistaDAO().getDeportistas();
				for (Deportista deportista : deportistas) {
					String[] row = deportista.getAll();
					modelo.addRow(row);
				}
				break;
			case "Equipo":
				headers = Equipo.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Equipo> equipos = new EquipoDAO().getEquipos();
				for (Equipo equipo : equipos) {
					String[] row = equipo.getAll();
					modelo.addRow(row);
				}
				break;
			case "Evento":
				headers = Evento.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Evento> eventos = new EventoDAO().getEventos();
				for (Evento evento : eventos) {
					String[] row = evento.getAll();
					modelo.addRow(row);
				}
				break;
			case "Olimpiada":
				headers = Olimpiada.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Olimpiada> olimpiadas = new OlimpiadaDAO().getOlimpiadas();
				for (Olimpiada olimpiada : olimpiadas) {
					String[] row = olimpiada.getAll();
					modelo.addRow(row);
				}
				break;
			case "Participacion":
				headers = Participacion.campos();
				modelo.setColumnIdentifiers(headers);
				modelo.addRow(headers);
				ArrayList<Participacion> participaciones = new ParticipacionDAO().getParticipaciones();
				for (Participacion participacion : participaciones) {
					String[] row = participacion.getAll();
					modelo.addRow(row);
				}
				break;
	
			default:
				break;
		}

	}

	private void dibujar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 504);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblqueDatosDesea = new JLabel(Messages.getString("index.title")); //$NON-NLS-1$
		GridBagConstraints gbc_lblqueDatosDesea = new GridBagConstraints();
		gbc_lblqueDatosDesea.gridwidth = 6;
		gbc_lblqueDatosDesea.insets = new Insets(0, 0, 5, 5);
		gbc_lblqueDatosDesea.gridx = 0;
		gbc_lblqueDatosDesea.gridy = 0;
		contentPane.add(lblqueDatosDesea, gbc_lblqueDatosDesea);

		crateRadios();

		createTable();
		
		createButtons();
	}

	private void createTable() {
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.gridwidth = 6;
		gbc_table.fill = GridBagConstraints.VERTICAL;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
	}

	private void crateRadios() {
		ButtonGroup bg = new ButtonGroup();

		rdbtnDeportes = new JRadioButton(Messages.getString("index.sports"));
		rdbtnDeportes.setSelected(true);
		GridBagConstraints gbc_rdbtnDeportes = new GridBagConstraints();
		gbc_rdbtnDeportes.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportes.gridx = 0;
		gbc_rdbtnDeportes.gridy = 1;
		contentPane.add(rdbtnDeportes, gbc_rdbtnDeportes);
		bg.add(rdbtnDeportes);

		rdbtnDeportistas = new JRadioButton(Messages.getString("index.athletes"));
		GridBagConstraints gbc_rdbtnDeportistas = new GridBagConstraints();
		gbc_rdbtnDeportistas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportistas.gridx = 1;
		gbc_rdbtnDeportistas.gridy = 1;
		contentPane.add(rdbtnDeportistas, gbc_rdbtnDeportistas);
		bg.add(rdbtnDeportistas);

		rdbtnEquipos = new JRadioButton(Messages.getString("index.teams"));
		GridBagConstraints gbc_rdbtnEquipos = new GridBagConstraints();
		gbc_rdbtnEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEquipos.gridx = 2;
		gbc_rdbtnEquipos.gridy = 1;
		contentPane.add(rdbtnEquipos, gbc_rdbtnEquipos);
		bg.add(rdbtnEquipos);

		rdbtnEventos = new JRadioButton(Messages.getString("index.events"));
		GridBagConstraints gbc_rdbtnEventos = new GridBagConstraints();
		gbc_rdbtnEventos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEventos.gridx = 3;
		gbc_rdbtnEventos.gridy = 1;
		contentPane.add(rdbtnEventos, gbc_rdbtnEventos);
		bg.add(rdbtnEventos);

		rdbtnOlimpiadas = new JRadioButton(Messages.getString("index.olympics"));
		GridBagConstraints gbc_rdbtnOlimpiadas = new GridBagConstraints();
		gbc_rdbtnOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOlimpiadas.gridx = 4;
		gbc_rdbtnOlimpiadas.gridy = 1;
		contentPane.add(rdbtnOlimpiadas, gbc_rdbtnOlimpiadas);
		bg.add(rdbtnOlimpiadas);
		
		rdbtnParticipaciones = new JRadioButton(Messages.getString("index.participations"));
		GridBagConstraints gbc_rdbtnParticipaciones = new GridBagConstraints();
		gbc_rdbtnParticipaciones.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnParticipaciones.gridx = 5;
		gbc_rdbtnParticipaciones.gridy = 1;
		contentPane.add(rdbtnParticipaciones, gbc_rdbtnParticipaciones);
		bg.add(rdbtnParticipaciones);
		
		rdbtnSeleccionado = rdbtnDeportes;
	}

	private void createButtons() {
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);

		btnDarDeAlta = new JButton(Messages.getString("index.alta"));
		panel.add(btnDarDeAlta);

		btnModificar = new JButton(Messages.getString("index.modificar"));
		panel.add(btnModificar);

		btnDarDeBaja = new JButton(Messages.getString("index.baja"));
		panel.add(btnDarDeBaja);
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	
	private void gestionarEventos() {
		rdbtnDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Deporte");
				rdbtnSeleccionado = rdbtnDeportes;
			}
		});

		rdbtnDeportistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Deportista");
				rdbtnSeleccionado = rdbtnDeportistas;
			}
		});

		rdbtnEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Equipo");
				rdbtnSeleccionado = rdbtnEquipos;
			}
		});

		rdbtnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Evento");
				rdbtnSeleccionado = rdbtnEventos;
			}
		});

		rdbtnOlimpiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Olimpiada");
				rdbtnSeleccionado = rdbtnOlimpiadas;
			}
		});

		rdbtnParticipaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("Participacion");
				rdbtnSeleccionado = rdbtnParticipaciones;
			}
		});
	
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaModificar("alta");
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaModificar("modificar");
			}
		});
	}

	private void altaModificar(String modo) {
		ArrayList<String> selectedTableValues = new ArrayList<String>();
		String tabla = rdbtnSeleccionado.getText();
		switch (tabla) {
		case "Deportes":
			if(modo.equals("alta")) {	
				AltaModificarDeporte dialog = new AltaModificarDeporte();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}else if(modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if(row>0) {
					for (int i = 0; i < table.getColumnCount(); i++) {
						int column = i;
						String value = table.getModel().getValueAt(row, column).toString();
						selectedTableValues.add(value);
					}
					AltaModificarDeporte dialog = new AltaModificarDeporte(selectedTableValues);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
			break;

		case "Deportistas":
			
			break;
		case "Equipos":
			
			break;
		case "Eventos":
			
			break;
		case "Olimpiadas":
			
			break;
		case "Participaciones":
			
			break;

		default:
			break;
	}
		
		
	}
}
