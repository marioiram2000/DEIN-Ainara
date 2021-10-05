package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JLabel;

public class index extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public index() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/images/logo.png")));
		dibujar();
		gestionarEventos();
	}
	
	private void dibujar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 451);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Monospaced", Font.BOLD, 20));
		menuBar.setForeground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmDeporte = new JMenuItem("Deporte");
		mnAltas.add(mntmDeporte);
		
		JMenuItem mntmDeportista = new JMenuItem("Deportista");
		mnAltas.add(mntmDeportista);
		
		JMenuItem mntmEquipo = new JMenuItem("Equipo");
		mnAltas.add(mntmEquipo);
		
		JMenuItem mntmEvento = new JMenuItem("Evento");
		mnAltas.add(mntmEvento);
		
		JMenuItem mntmOlimpiada = new JMenuItem("Olimpiada");
		mnAltas.add(mntmOlimpiada);
		
		JMenuItem mntmParticipacin = new JMenuItem("Participación");
		mnAltas.add(mntmParticipacin);
		
		JMenu mnBajas = new JMenu("Bajas");
		menuBar.add(mnBajas);
		
		JMenuItem mntmDeporte_1 = new JMenuItem("Deporte");
		mnBajas.add(mntmDeporte_1);
		
		JMenuItem mntmDeportista_1 = new JMenuItem("Deportista");
		mnBajas.add(mntmDeportista_1);
		
		JMenuItem mntmEquipo_1 = new JMenuItem("Equipo");
		mnBajas.add(mntmEquipo_1);
		
		JMenuItem mntmEvento_1 = new JMenuItem("Evento");
		mnBajas.add(mntmEvento_1);
		
		JMenuItem mntmOlimpiada_1 = new JMenuItem("Olimpiada");
		mnBajas.add(mntmOlimpiada_1);
		
		JMenuItem mntmParticipacin_1 = new JMenuItem("Participación");
		mnBajas.add(mntmParticipacin_1);
		
		JMenu mnModificaciones = new JMenu("Modificaciones");
		menuBar.add(mnModificaciones);
		
		JMenuItem mntmDeporte_2 = new JMenuItem("Deporte");
		mnModificaciones.add(mntmDeporte_2);
		
		JMenuItem mntmDeportista_2 = new JMenuItem("Deportista");
		mnModificaciones.add(mntmDeportista_2);
		
		JMenuItem mntmEquipo_2 = new JMenuItem("Equipo");
		mnModificaciones.add(mntmEquipo_2);
		
		JMenuItem mntmEvento_2 = new JMenuItem("Evento");
		mnModificaciones.add(mntmEvento_2);
		
		JMenuItem mntmOlimpiada_2 = new JMenuItem("Olimpiada");
		mnModificaciones.add(mntmOlimpiada_2);
		
		JMenuItem mntmParticipacin_2 = new JMenuItem("Participación");
		mnModificaciones.add(mntmParticipacin_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblqueDatosDesea = new JLabel("¿Que datos desea visualizar?");
		GridBagConstraints gbc_lblqueDatosDesea = new GridBagConstraints();
		gbc_lblqueDatosDesea.gridwidth = 6;
		gbc_lblqueDatosDesea.insets = new Insets(0, 0, 5, 5);
		gbc_lblqueDatosDesea.gridx = 0;
		gbc_lblqueDatosDesea.gridy = 0;
		contentPane.add(lblqueDatosDesea, gbc_lblqueDatosDesea);
		
		JRadioButton rdbtnDeportes = new JRadioButton("Deportes");
		GridBagConstraints gbc_rdbtnDeportes = new GridBagConstraints();
		gbc_rdbtnDeportes.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportes.gridx = 0;
		gbc_rdbtnDeportes.gridy = 1;
		contentPane.add(rdbtnDeportes, gbc_rdbtnDeportes);
		
		JRadioButton rdbtnDeportistas = new JRadioButton("Deportistas");
		GridBagConstraints gbc_rdbtnDeportistas = new GridBagConstraints();
		gbc_rdbtnDeportistas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDeportistas.gridx = 1;
		gbc_rdbtnDeportistas.gridy = 1;
		contentPane.add(rdbtnDeportistas, gbc_rdbtnDeportistas);
		
		JRadioButton rdbtnEquipos = new JRadioButton("Equipos");
		GridBagConstraints gbc_rdbtnEquipos = new GridBagConstraints();
		gbc_rdbtnEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEquipos.gridx = 2;
		gbc_rdbtnEquipos.gridy = 1;
		contentPane.add(rdbtnEquipos, gbc_rdbtnEquipos);
		
		JRadioButton rdbtnEventos = new JRadioButton("Eventos");
		GridBagConstraints gbc_rdbtnEventos = new GridBagConstraints();
		gbc_rdbtnEventos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEventos.gridx = 3;
		gbc_rdbtnEventos.gridy = 1;
		contentPane.add(rdbtnEventos, gbc_rdbtnEventos);
		
		JRadioButton rdbtnOlimpiadas = new JRadioButton("Olimpiadas");
		GridBagConstraints gbc_rdbtnOlimpiadas = new GridBagConstraints();
		gbc_rdbtnOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOlimpiadas.gridx = 4;
		gbc_rdbtnOlimpiadas.gridy = 1;
		contentPane.add(rdbtnOlimpiadas, gbc_rdbtnOlimpiadas);
		
		JRadioButton rdbtnParticipaciones = new JRadioButton("Participaciones");
		GridBagConstraints gbc_rdbtnParticipaciones = new GridBagConstraints();
		gbc_rdbtnParticipaciones.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnParticipaciones.gridx = 5;
		gbc_rdbtnParticipaciones.gridy = 1;
		contentPane.add(rdbtnParticipaciones, gbc_rdbtnParticipaciones);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 7;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
	}
	
	private void gestionarEventos() {
		
	}

}
