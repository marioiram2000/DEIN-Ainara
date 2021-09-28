package ej5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ej5.DAO.DAO;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionAeropuertos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JRadioButton rdbtnPublicos;
	private static DAO dao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dao = new DAO();
					GestionAeropuertos frame = new GestionAeropuertos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void changeTable(String config) throws SQLException {
		ResultSet rs;
		if(config.equals("publico")) {
			
		}else {
			
			
		}
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GestionAeropuertos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAeropuetos = new JMenu("Aeropuetos");
		menuBar.add(mnAeropuetos);
		
		JMenuItem mntmAadir = new JMenuItem("Añadir");
		mnAeropuetos.add(mntmAadir);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnAeropuetos.add(mntmEditar);
		
		JMenu mnVuelos = new JMenu("Vuelos");
		menuBar.add(mnVuelos);
		
		JMenuItem mntmAadir_1 = new JMenuItem("Añadir");
		mnVuelos.add(mntmAadir_1);
		
		JMenuItem mntmActivar = new JMenuItem("Activar");
		mnVuelos.add(mntmActivar);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mnVuelos.add(mntmBorrar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblListadoDeAeropuertos = new JLabel("LISTADO DE AEROPUERTOS");
		GridBagConstraints gbc_lblListadoDeAeropuertos = new GridBagConstraints();
		gbc_lblListadoDeAeropuertos.gridwidth = 2;
		gbc_lblListadoDeAeropuertos.insets = new Insets(0, 0, 5, 5);
		gbc_lblListadoDeAeropuertos.gridx = 0;
		gbc_lblListadoDeAeropuertos.gridy = 0;
		contentPane.add(lblListadoDeAeropuertos, gbc_lblListadoDeAeropuertos);
		
		JRadioButton rdbtnPrivados = new JRadioButton("Privados");
		rdbtnPrivados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					changeTable("privado");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonGroup.add(rdbtnPrivados);
		GridBagConstraints gbc_rdbtnPrivados = new GridBagConstraints();
		gbc_rdbtnPrivados.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPrivados.gridx = 0;
		gbc_rdbtnPrivados.gridy = 1;
		contentPane.add(rdbtnPrivados, gbc_rdbtnPrivados);
		
		rdbtnPublicos = new JRadioButton("Publicos");
		rdbtnPublicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					changeTable("publico");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonGroup.add(rdbtnPublicos);
		GridBagConstraints gbc_rdbtnPublicos = new GridBagConstraints();
		gbc_rdbtnPublicos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPublicos.gridx = 1;
		gbc_rdbtnPublicos.gridy = 1;
		contentPane.add(rdbtnPublicos, gbc_rdbtnPublicos);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
		
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		
	}

}
