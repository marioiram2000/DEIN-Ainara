package proj1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ej3 extends JFrame {

	private JPanel contentPane;
	private JLabel label_logo;
	private JLabel label_coche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ej3 frame = new ej3();
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
	public ej3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 653);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		label_logo = new JLabel("");
		label_logo.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/images/cooperLogo.png")));
		panel.add(label_logo);
		
		JLabel lblConfiguraTuMini = new JLabel("CONFIGURA TU MINI COOPER");
		lblConfiguraTuMini.setForeground(Color.WHITE);
		panel.add(lblConfiguraTuMini);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{15, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblSeleccionaElColor = new JLabel("Selecciona el color del coche");
		lblSeleccionaElColor.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSeleccionaElColor = new GridBagConstraints();
		gbc_lblSeleccionaElColor.gridwidth = 8;
		gbc_lblSeleccionaElColor.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionaElColor.gridx = 0;
		gbc_lblSeleccionaElColor.gridy = 0;
		panel_1.add(lblSeleccionaElColor, gbc_lblSeleccionaElColor);
		
		JButton boton_rojo = new JButton("");
		boton_rojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniBlazingRed.png")));
			}
		});
		boton_rojo.setBorderPainted(false);
		boton_rojo.setBackground(Color.BLACK);
		boton_rojo.setForeground(Color.BLACK);
		boton_rojo.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorBlazingRed.jpg")));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_1.add(boton_rojo, gbc_button_1);
		
		JButton boton_azul = new JButton("");
		boton_azul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniElectricBlue.png")));
			}
		});
		boton_azul.setBackground(Color.BLACK);
		boton_azul.setBorderPainted(false);
		boton_azul.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorElectricBlue.jpg")));
		GridBagConstraints gbc_label_1_1 = new GridBagConstraints();
		gbc_label_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_1.gridx = 1;
		gbc_label_1_1.gridy = 1;
		panel_1.add(boton_azul, gbc_label_1_1);
		
		JButton boton_azulOscuro = new JButton("");
		boton_azulOscuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniLapisluxuryBlue.png")));
			}
		});
		boton_azulOscuro.setBorderPainted(false);
		boton_azulOscuro.setBackground(Color.BLACK);
		boton_azulOscuro.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorLapisluxuryBlue.jpg")));
		GridBagConstraints gbc_label_1_2 = new GridBagConstraints();
		gbc_label_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_2.gridx = 2;
		gbc_label_1_2.gridy = 1;
		panel_1.add(boton_azulOscuro, gbc_label_1_2);
		
		JButton boton_negro = new JButton("");
		boton_negro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniMidnightBlack.png")));
			}
		});
		boton_negro.setBackground(Color.BLACK);
		boton_negro.setBorderPainted(false);
		boton_negro.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorMidnightBlack.jpg")));
		GridBagConstraints gbc_label_1_3 = new GridBagConstraints();
		gbc_label_1_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_3.gridx = 3;
		gbc_label_1_3.gridy = 1;
		panel_1.add(boton_negro, gbc_label_1_3);
		
		JButton boton_plata = new JButton("");
		boton_plata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniMoonwalkGrey.png")));
			}
		});
		boton_plata.setBackground(Color.BLACK);
		boton_plata.setBorderPainted(false);
		boton_plata.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorMoonwalkGrey.jpg")));
		GridBagConstraints gbc_label_1_4 = new GridBagConstraints();
		gbc_label_1_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_4.gridx = 4;
		gbc_label_1_4.gridy = 1;
		panel_1.add(boton_plata, gbc_label_1_4);
		
		JButton boton_blanco = new JButton("");
		boton_blanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniPepperWhite.png")));
			}
		});
		boton_blanco.setBorderPainted(false);
		boton_blanco.setBackground(Color.BLACK);
		boton_blanco.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorPepperWhite.jpg")));
		GridBagConstraints gbc_label_1_5 = new GridBagConstraints();
		gbc_label_1_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_5.gridx = 5;
		gbc_label_1_5.gridy = 1;
		panel_1.add(boton_blanco, gbc_label_1_5);
		
		JButton boton_gris = new JButton("");
		boton_gris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniThunderGray.png")));
			}
		});
		boton_gris.setBorderPainted(false);
		boton_gris.setBackground(Color.BLACK);
		boton_gris.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorThunderGray.jpg")));
		GridBagConstraints gbc_label_1_6 = new GridBagConstraints();
		gbc_label_1_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_1_6.gridx = 6;
		gbc_label_1_6.gridy = 1;
		panel_1.add(boton_gris, gbc_label_1_6);
		
		JButton boton_dorado = new JButton("");
		boton_dorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniVolcaninOrange.png")));
			}
		});
		boton_dorado.setBorderPainted(false);
		boton_dorado.setBackground(Color.BLACK);
		boton_dorado.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/colores/colorVolcaninOrange.jpg")));
		GridBagConstraints gbc_label_1_7 = new GridBagConstraints();
		gbc_label_1_7.gridx = 7;
		gbc_label_1_7.gridy = 1;
		panel_1.add(boton_dorado, gbc_label_1_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(Color.BLACK);
		contentPane.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{640, 0};
		gbl_panel_4.rowHeights = new int[]{60, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton button = new JButton("");
		button.setBorderPainted(false);
		button.setBackground(Color.BLACK);
		button.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/images/lucesOn.png")));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_4.add(button, gbc_button);
		
		label_coche = new JLabel("");
		label_coche.setIcon(new ImageIcon(ej3.class.getResource("/proj1/resources/coches/miniBlazingRed.png")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel_4.add(label_coche, gbc_label);
	}

}
