package proj1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class ej2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ej2 frame = new ej2();
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
	public ej2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblRegistroDeAnimales = new JLabel("REGISTRO DE ANIMALES");
		panel.add(lblRegistroDeAnimales);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{211, 29, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.RED);
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_3.add(panel_5, gbc_panel_5);
		
		JLabel lblCodigoDelAnimal = new JLabel("Codigo del animal:");
		panel_5.add(lblCodigoDelAnimal);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_5.add(textField);
		
		JLabel lblNewLabel = new JLabel("Datos del animal");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.RED);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel_3.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNombreDelAnimal = new JLabel("Nombre del animal:");
		GridBagConstraints gbc_lblNombreDelAnimal = new GridBagConstraints();
		gbc_lblNombreDelAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelAnimal.gridx = 0;
		gbc_lblNombreDelAnimal.gridy = 0;
		panel_6.add(lblNombreDelAnimal, gbc_lblNombreDelAnimal);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_6.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombreDelAnimal_1 = new JLabel("Especie:");
		GridBagConstraints gbc_lblNombreDelAnimal_1 = new GridBagConstraints();
		gbc_lblNombreDelAnimal_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelAnimal_1.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelAnimal_1.gridx = 0;
		gbc_lblNombreDelAnimal_1.gridy = 1;
		panel_6.add(lblNombreDelAnimal_1, gbc_lblNombreDelAnimal_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_6.add(textField_2, gbc_textField_2);
		
		JLabel lblNombreDelAnimal_2 = new JLabel("Raza:");
		GridBagConstraints gbc_lblNombreDelAnimal_2 = new GridBagConstraints();
		gbc_lblNombreDelAnimal_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelAnimal_2.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelAnimal_2.gridx = 0;
		gbc_lblNombreDelAnimal_2.gridy = 2;
		panel_6.add(lblNombreDelAnimal_2, gbc_lblNombreDelAnimal_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		panel_6.add(textField_3, gbc_textField_3);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 3;
		panel_6.add(lblSexo, gbc_lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hembra", "Macho", "Otro"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel_6.add(comboBox, gbc_comboBox);
		
		JLabel lblEdadaprox = new JLabel("Edad(aprox.):");
		GridBagConstraints gbc_lblEdadaprox = new GridBagConstraints();
		gbc_lblEdadaprox.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdadaprox.anchor = GridBagConstraints.EAST;
		gbc_lblEdadaprox.gridx = 0;
		gbc_lblEdadaprox.gridy = 4;
		panel_6.add(lblEdadaprox, gbc_lblEdadaprox);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 4;
		panel_6.add(textField_5, gbc_textField_5);
		
		JLabel lblPeso = new JLabel("Peso:");
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.anchor = GridBagConstraints.EAST;
		gbc_lblPeso.gridx = 0;
		gbc_lblPeso.gridy = 5;
		panel_6.add(lblPeso, gbc_lblPeso);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 5;
		panel_6.add(textField_6, gbc_textField_6);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 6;
		panel_6.add(lblObservaciones, gbc_lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 2;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 6;
		panel_6.add(textPane, gbc_textPane);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso:");
		GridBagConstraints gbc_lblFechaDeIngreso = new GridBagConstraints();
		gbc_lblFechaDeIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeIngreso.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeIngreso.gridx = 0;
		gbc_lblFechaDeIngreso.gridy = 7;
		panel_6.add(lblFechaDeIngreso, gbc_lblFechaDeIngreso);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		panel_6.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_calendar_today_black_18dp.png")));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 7;
		panel_6.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{100, 44, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_4.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JTextPane textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.gridheight = 5;
		gbc_textPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 0;
		panel_7.add(textPane_1, gbc_textPane_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.gridheight = 3;
		gbc_panel_10.insets = new Insets(0, 0, 0, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 2;
		panel_7.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{117, 0};
		gbl_panel_10.rowHeights = new int[]{25, 25, 25, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_pets_black_18dp.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_10.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_save_black_18dp.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(2, 5, 5, 0);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 1;
		panel_10.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnNewButton_1 = new JButton("Cancelar\n");
		btnNewButton_1.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_close_black_18dp.png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(2, 5, 2, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		panel_10.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridheight = 2;
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 2;
		gbc_panel_11.gridy = 3;
		panel_7.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0};
		gbl_panel_11.rowHeights = new int[]{0, 0, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JButton btnNewButton_2 = new JButton("Seleccioar imagen");
		btnNewButton_2.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_image_black_18dp.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_11.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Guardar\n");
		btnNewButton_3.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_save_black_18dp.png")));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		panel_11.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.RED);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_4.add(panel_8, gbc_panel_8);
		
		JLabel lblBuscar = new JLabel("Buscar");
		panel_8.add(lblBuscar);
		
		textField_7 = new JTextField();
		panel_8.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_search_black_18dp.png")));
		panel_8.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_delete_black_18dp.png")));
		panel_8.add(btnEliminar);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setIcon(new ImageIcon(ej2.class.getResource("/images/outline_logout_black_18dp.png")));
		panel_8.add(btnNewButton_4);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 2;
		panel_4.add(panel_9, gbc_panel_9);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Especie", "Raza", "Sexo", "Edad", "Peso", "Observaciones", "Fecha"},
				{"Sua", "Perro", null, "Macho", "3", "50", "Observacion", "30/09/2000"},
			},
			new String[] {
				"Nombre", "Especie", "Raza", "Sexo", "Edad", "Peso", "Observaciones", "Fecha"
			}
		));
		panel_9.add(table);
	}

}
