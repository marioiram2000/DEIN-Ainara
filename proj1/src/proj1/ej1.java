package proj1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class ej1 extends JFrame {

	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner spinner;
	private JComboBox comboBox;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JCheckBox chckbxPracticaAlgnDeporte;
	private JList list;
	private JSlider slider_1;
	private GridBagConstraints gbc_slider_1;
	private JSlider slider;
	private GridBagConstraints gbc_slider;
	private JSlider slider_2;
	private GridBagConstraints gbc_slider_2;
	private GridBagConstraints gbc_panel_3;
	private JButton btnAceptar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ej1 frame = new ej1();
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
	public ej1() {
		gestionarEventos();
		dibujar();
	}

	private void gestionarEventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void dibujar() {
		setBounds(100, 100, 568, 483);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 128, 128, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 74, 72, 0, 150, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Profesión:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNhermanos = new JLabel("NºHermanos:");
		GridBagConstraints gbc_lblNhermanos = new GridBagConstraints();
		gbc_lblNhermanos.anchor = GridBagConstraints.WEST;
		gbc_lblNhermanos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhermanos.gridx = 0;
		gbc_lblNhermanos.gridy = 1;
		contentPane.add(lblNhermanos, gbc_lblNhermanos);
		
		spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		contentPane.add(spinner, gbc_spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"}));
		comboBox.setSelectedIndex(1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		rdbtnHombre = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnHombre);
		panel.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		panel.add(rdbtnMujer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		chckbxPracticaAlgnDeporte = new JCheckBox("Practica algún deporte?");
		panel_1.add(chckbxPracticaAlgnDeporte, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tenis ", "Fútbol ", "Baloncesto ", "Natación ", "Ciclismo ", "Otro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setVisibleRowCount(2);
		list.setBorder(new TitledBorder(null, "\u00BFCual?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(list);
		
		JLabel lblMarqueDel = new JLabel("Marque del 1 al 10 su grado de afición a:");
		GridBagConstraints gbc_lblMarqueDel = new GridBagConstraints();
		gbc_lblMarqueDel.gridwidth = 3;
		gbc_lblMarqueDel.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarqueDel.gridx = 1;
		gbc_lblMarqueDel.gridy = 4;
		contentPane.add(lblMarqueDel, gbc_lblMarqueDel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{108, 373, 0};
		gbl_panel_2.rowHeights = new int[]{43, 40, 37, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblVerTele = new JLabel("Compras");
		GridBagConstraints gbc_lblVerTele = new GridBagConstraints();
		gbc_lblVerTele.insets = new Insets(0, 0, 5, 5);
		gbc_lblVerTele.gridx = 0;
		gbc_lblVerTele.gridy = 0;
		panel_2.add(lblVerTele, gbc_lblVerTele);
		
		slider_1 = new JSlider();
		slider_1.setSnapToTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMaximum(10);
		slider_1.setValue(5);
		
		gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.insets = new Insets(0, 0, 5, 0);
		gbc_slider_1.gridx = 1;
		gbc_slider_1.gridy = 0;
		panel_2.add(slider_1, gbc_slider_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ver televisión");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(5);
		slider.setMaximum(10);
		gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 1;
		panel_2.add(slider, gbc_slider);
		
		JLabel lblIrAlCine = new JLabel("Ir al cine");
		GridBagConstraints gbc_lblIrAlCine = new GridBagConstraints();
		gbc_lblIrAlCine.insets = new Insets(0, 0, 0, 5);
		gbc_lblIrAlCine.gridx = 0;
		gbc_lblIrAlCine.gridy = 2;
		panel_2.add(lblIrAlCine, gbc_lblIrAlCine);
		
		slider_2 = new JSlider();
		slider_2.setValue(5);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(1);
		slider_2.setMaximum(10);
		
		gbc_slider_2 = new GridBagConstraints();
		gbc_slider_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_2.gridx = 1;
		gbc_slider_2.gridy = 2;
		panel_2.add(slider_2, gbc_slider_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 5;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		contentPane.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAceptar = new JButton("Aceptar");
		panel_3.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		panel_3.add(btnCerrar);
	}

}
