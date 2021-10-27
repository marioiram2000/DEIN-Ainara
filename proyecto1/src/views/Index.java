package views;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class Index extends JFrame {

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
	private JLabel labelImage;

	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale(GetPropertyValues.getValor("language"), GetPropertyValues.getValor("country")));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		setTitle(Messages.getString("index.appTitle"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Index.class.getResource("/images/logo.png"))); //$NON-NLS-1$
		dibujar();
		gestionarEventos();
		rellenarTabla();
	}

	private void rellenarTabla() {
		modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modelo);
		String[] headers = new String[0];
		String tabla = rdbtnSeleccionado.getText();
		switch (tabla) {
		case "Deportes":
			headers = Deporte.campos();
			modelo.setColumnIdentifiers(headers);
			modelo.addRow(headers);
			ArrayList<Deporte> deportes = new DeporteDAO().getDeportes();
			for (Deporte deporte : deportes) {
				String[] row = deporte.getAll();
				modelo.addRow(row);
			}
			break;

		case "Deportistas":
			headers = Deportista.campos();
			modelo.setColumnIdentifiers(headers);
			modelo.addRow(headers);
			ArrayList<Deportista> deportistas = new DeportistaDAO().getDeportistas();
			for (Deportista deportista : deportistas) {
				String[] row = deportista.getAll();
				modelo.addRow(row);
			}
			break;
		case "Equipos":
			headers = Equipo.campos();
			modelo.setColumnIdentifiers(headers);
			modelo.addRow(headers);
			ArrayList<Equipo> equipos = new EquipoDAO().getEquipos();
			for (Equipo equipo : equipos) {
				String[] row = equipo.getAll();
				modelo.addRow(row);
			}
			break;
		case "Eventos":
			headers = Evento.campos();
			modelo.setColumnIdentifiers(headers);
			modelo.addRow(headers);
			ArrayList<Evento> eventos = new EventoDAO().getEventos();
			for (Evento evento : eventos) {
				String[] row = evento.getAll();
				modelo.addRow(row);
			}
			break;
		case "Olimpiadas":
			headers = Olimpiada.campos();
			modelo.setColumnIdentifiers(headers);
			modelo.addRow(headers);
			ArrayList<Olimpiada> olimpiadas = new OlimpiadaDAO().getOlimpiadas();
			for (Olimpiada olimpiada : olimpiadas) {
				String[] row = olimpiada.getAll();
				modelo.addRow(row);
			}
			break;
		case "Participaciones":
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
		for (int i = 0; i < headers.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(130);
		}

	}

	private void dibujar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		setMinimumSize(new Dimension(1000, 450));

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 40, 40, 40, 40, 40, 40, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblTitle = new JLabel(Messages.getString("index.title")); //$NON-NLS-1$
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 5;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		contentPane.add(lblTitle, gbc_lblTitle);

		labelImage = new JLabel(); // $NON-NLS-1$
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(Index.class.getResource("/images/logo.png")).getImage()
				.getScaledInstance(40, 20, Image.SCALE_DEFAULT));
		labelImage.setIcon(imageIcon);

		GridBagConstraints gbc_labelImage = new GridBagConstraints();
		gbc_labelImage.anchor = GridBagConstraints.WEST;
		gbc_labelImage.insets = new Insets(0, 0, 5, 5);
		gbc_labelImage.gridx = 0;
		gbc_labelImage.gridy = 0;
		contentPane.add(labelImage, gbc_labelImage);

		crateRadios();

		createTable();

		createButtons();
	}

	private void createTable() {
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 4;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.VERTICAL;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
	}

	private void crateRadios() {
		ButtonGroup bg = new ButtonGroup();

		rdbtnDeportes = new JRadioButton(Messages.getString("index.sports"));
		rdbtnDeportes.setSelected(true);
		GridBagConstraints gbc_rdbtnDeportes = new GridBagConstraints();
		gbc_rdbtnDeportes.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDeportes.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportes.gridx = 0;
		gbc_rdbtnDeportes.gridy = 1;
		contentPane.add(rdbtnDeportes, gbc_rdbtnDeportes);
		bg.add(rdbtnDeportes);
		rdbtnSeleccionado = rdbtnDeportes;

		rdbtnDeportistas = new JRadioButton(Messages.getString("index.athletes"));
		GridBagConstraints gbc_rdbtnDeportistas = new GridBagConstraints();
		gbc_rdbtnDeportistas.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDeportistas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportistas.gridx = 0;
		gbc_rdbtnDeportistas.gridy = 2;
		contentPane.add(rdbtnDeportistas, gbc_rdbtnDeportistas);
		bg.add(rdbtnDeportistas);
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		rdbtnEquipos = new JRadioButton(Messages.getString("index.teams"));
		GridBagConstraints gbc_rdbtnEquipos = new GridBagConstraints();
		gbc_rdbtnEquipos.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEquipos.gridx = 0;
		gbc_rdbtnEquipos.gridy = 3;
		contentPane.add(rdbtnEquipos, gbc_rdbtnEquipos);
		bg.add(rdbtnEquipos);

		rdbtnEventos = new JRadioButton(Messages.getString("index.events"));
		GridBagConstraints gbc_rdbtnEventos = new GridBagConstraints();
		gbc_rdbtnEventos.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEventos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEventos.gridx = 0;
		gbc_rdbtnEventos.gridy = 4;
		contentPane.add(rdbtnEventos, gbc_rdbtnEventos);
		bg.add(rdbtnEventos);

		rdbtnOlimpiadas = new JRadioButton(Messages.getString("index.olympics"));
		GridBagConstraints gbc_rdbtnOlimpiadas = new GridBagConstraints();
		gbc_rdbtnOlimpiadas.anchor = GridBagConstraints.WEST;
		gbc_rdbtnOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOlimpiadas.gridx = 0;
		gbc_rdbtnOlimpiadas.gridy = 5;
		contentPane.add(rdbtnOlimpiadas, gbc_rdbtnOlimpiadas);
		bg.add(rdbtnOlimpiadas);

		rdbtnParticipaciones = new JRadioButton(Messages.getString("index.participations"));
		GridBagConstraints gbc_rdbtnParticipaciones = new GridBagConstraints();
		gbc_rdbtnParticipaciones.anchor = GridBagConstraints.WEST;
		gbc_rdbtnParticipaciones.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnParticipaciones.gridx = 0;
		gbc_rdbtnParticipaciones.gridy = 6;
		contentPane.add(rdbtnParticipaciones, gbc_rdbtnParticipaciones);
		bg.add(rdbtnParticipaciones);
	}

	private void createButtons() {
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);

		btnDarDeAlta = new JButton(Messages.getString("index.alta"));
		panel.add(btnDarDeAlta);

		btnModificar = new JButton(Messages.getString("index.modificar"));
		panel.add(btnModificar);

		btnDarDeBaja = new JButton(Messages.getString("index.baja"));
		panel.add(btnDarDeBaja);

	}

	private void gestionarEventos() {
		rdbtnDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnDeportes;
				rellenarTabla();
			}
		});

		rdbtnDeportistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnDeportistas;
				rellenarTabla();
			}
		});

		rdbtnEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnEquipos;
				rellenarTabla();
			}
		});

		rdbtnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnEventos;
				rellenarTabla();
			}
		});

		rdbtnOlimpiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnOlimpiadas;
				rellenarTabla();
			}
		});

		rdbtnParticipaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSeleccionado = rdbtnParticipaciones;
				rellenarTabla();
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

		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String message = "¿Estás seguro de que deseas borrar el campo?";
					int input = JOptionPane.showConfirmDialog(null, message, "WARNING", JOptionPane.YES_NO_OPTION);
					if (input == JOptionPane.YES_OPTION) {
						int id = -1;
						try {
							id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						} catch (NumberFormatException e) {
						}

						String tabla = rdbtnSeleccionado.getText();
						switch (tabla) {
						case "Deportes":
							new DeporteDAO().deleteDeporte(id);
							break;

						case "Deportistas":
							new DeportistaDAO().deleteDeportista(id);
							break;
						case "Equipos":
							new EquipoDAO().deleteDEquipo(id);
							break;
						case "Eventos":
							new EventoDAO().deleteEvento(id);
							break;
						case "Olimpiadas":
							new OlimpiadaDAO().deleteOlimpiada(id);
							break;
						case "Participaciones":
							int id_deportista = Integer
									.parseInt(table.getModel().getValueAt(row, 0).toString().split("_")[0]);
							int id_evento = Integer
									.parseInt(table.getModel().getValueAt(row, 0).toString().split("_")[1]);
							new ParticipacionDAO().deleteParticipacion(id_deportista, id_evento);
							break;

						default:
							break;
						}
						rellenarTabla();
					}
				}
			}
		});
	}

	private void altaModificar(String modo) {
		String tabla = rdbtnSeleccionado.getText();
		switch (tabla) {
		case "Deportes":
			AltaModificarDeporte dialogDeporte = null;
			if (modo.equals("alta")) {
				dialogDeporte = new AltaModificarDeporte();
				dialogDeporte.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogDeporte.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogDeporte = new AltaModificarDeporte(id);
					dialogDeporte.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogDeporte.setVisible(true);
				}
			}
			if (dialogDeporte != null) {
				dialogDeporte.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}

			break;

		case "Deportistas":
			AltaModificarDeportista dialogDeportista = null;
			if (modo.equals("alta")) {
				dialogDeportista = new AltaModificarDeportista();
				dialogDeportista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogDeportista.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogDeportista = new AltaModificarDeportista(id);
					dialogDeportista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogDeportista.setVisible(true);
				}
			}
			if (dialogDeportista != null) {
				dialogDeportista.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}
			break;
		case "Equipos":
			AltaModificarEquipo dialogEquipo = null;
			if (modo.equals("alta")) {
				dialogEquipo = new AltaModificarEquipo();
				dialogEquipo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogEquipo.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogEquipo = new AltaModificarEquipo(id);
					dialogEquipo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogEquipo.setVisible(true);
				}
			}
			if (dialogEquipo != null) {
				dialogEquipo.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}
			break;
		case "Eventos":
			AltaModificarEvento dialogEvento = null;
			if (modo.equals("alta")) {
				dialogEvento = new AltaModificarEvento();
				dialogEvento.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogEvento.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogEvento = new AltaModificarEvento(id);
					dialogEvento.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogEvento.setVisible(true);
				}
			}
			if (dialogEvento != null) {
				dialogEvento.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}
			break;
		case "Olimpiadas":
			AltaModificarOlimpiada dialogOlimpiada = null;
			if (modo.equals("alta")) {
				dialogOlimpiada = new AltaModificarOlimpiada();
				dialogOlimpiada.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogOlimpiada.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogOlimpiada = new AltaModificarOlimpiada(id);
					dialogOlimpiada.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogOlimpiada.setVisible(true);
				}
			}
			if (dialogOlimpiada != null) {
				dialogOlimpiada.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}
			break;
		case "Participaciones":
			AltaModificarParticipacion dialogParticipacion = null;
			if (modo.equals("alta")) {
				dialogParticipacion = new AltaModificarParticipacion();
				dialogParticipacion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogParticipacion.setVisible(true);
			} else if (modo.equals("modificar")) {
				int row = table.getSelectedRow();
				if (row > 0) {
					String id = table.getModel().getValueAt(row, 0).toString();
					dialogParticipacion = new AltaModificarParticipacion(id);
					dialogParticipacion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogParticipacion.setVisible(true);
				}
			}
			if (dialogParticipacion != null) {
				dialogParticipacion.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						rellenarTabla();
					}
				});
			}
			break;

		default:
			break;
		}

	}
}
