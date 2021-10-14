package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeportistaDAO;
import model.Deportista;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class AltaModificarDeportista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner spinnerPeso;
	private JSpinner spinnerAltura;
	private Deportista deportista;

	public AltaModificarDeportista() {
		dibujar();
		gestionarEventos();
		gestionarEventosAlta();
	}

	public AltaModificarDeportista(String id) {
		deportista = new DeportistaDAO().getDeportista(Integer.parseInt(id));
		dibujar();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();
	}

	private void fillForm() {
		textFieldNombre.setText(deportista.getNombre());
		if (deportista.getSexo().equals("M")) {
			rdbtnMujer.setSelected(true);
		} else {
			rdbtnHombre.setSelected(true);
		}
		spinnerAltura.setValue(deportista.getAltura());
		spinnerPeso.setValue(deportista.getPeso());
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			textFieldNombre = new JTextField();
			GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
			gbc_textFieldNombre.gridwidth = 2;
			gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNombre.gridx = 1;
			gbc_textFieldNombre.gridy = 0;
			contentPanel.add(textFieldNombre, gbc_textFieldNombre);
			textFieldNombre.setColumns(10);
		}
		{
			JLabel lblSexo = new JLabel("Sexo");
			GridBagConstraints gbc_lblSexo = new GridBagConstraints();
			gbc_lblSexo.anchor = GridBagConstraints.EAST;
			gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSexo.gridx = 0;
			gbc_lblSexo.gridy = 1;
			contentPanel.add(lblSexo, gbc_lblSexo);
		}
		{
			rdbtnMujer = new JRadioButton("Mujer");
			GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
			gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMujer.gridx = 1;
			gbc_rdbtnMujer.gridy = 1;
			contentPanel.add(rdbtnMujer, gbc_rdbtnMujer);
		}
		{
			rdbtnHombre = new JRadioButton("Hombre");
			GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
			gbc_rdbtnHombre.anchor = GridBagConstraints.WEST;
			gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnHombre.gridx = 2;
			gbc_rdbtnHombre.gridy = 1;
			contentPanel.add(rdbtnHombre, gbc_rdbtnHombre);
		}
		{
			JLabel lblPeso = new JLabel("Peso");
			GridBagConstraints gbc_lblPeso = new GridBagConstraints();
			gbc_lblPeso.anchor = GridBagConstraints.EAST;
			gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
			gbc_lblPeso.gridx = 0;
			gbc_lblPeso.gridy = 2;
			contentPanel.add(lblPeso, gbc_lblPeso);
		}
		{
			spinnerPeso = new JSpinner(new SpinnerNumberModel(0, 0, 400, 1));
			GridBagConstraints gbc_spinnerPeso = new GridBagConstraints();
			gbc_spinnerPeso.insets = new Insets(0, 0, 5, 5);
			gbc_spinnerPeso.gridx = 1;
			gbc_spinnerPeso.gridy = 2;
			contentPanel.add(spinnerPeso, gbc_spinnerPeso);
		}
		{
			JLabel lblKg = new JLabel("Kg");
			GridBagConstraints gbc_lblKg = new GridBagConstraints();
			gbc_lblKg.anchor = GridBagConstraints.WEST;
			gbc_lblKg.insets = new Insets(0, 0, 5, 0);
			gbc_lblKg.gridx = 2;
			gbc_lblKg.gridy = 2;
			contentPanel.add(lblKg, gbc_lblKg);
		}
		{
			JLabel lblAltura = new JLabel("Altura");
			GridBagConstraints gbc_lblAltura = new GridBagConstraints();
			gbc_lblAltura.anchor = GridBagConstraints.EAST;
			gbc_lblAltura.insets = new Insets(0, 0, 0, 5);
			gbc_lblAltura.gridx = 0;
			gbc_lblAltura.gridy = 3;
			contentPanel.add(lblAltura, gbc_lblAltura);
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
		{
			ButtonGroup bg = new ButtonGroup();
			bg.add(rdbtnMujer);
			bg.add(rdbtnHombre);
		}
		{
			spinnerAltura = new JSpinner(new SpinnerNumberModel(0, 0, 300, 1));

			GridBagConstraints gbc_spinnerAltura = new GridBagConstraints();
			gbc_spinnerAltura.insets = new Insets(0, 0, 0, 5);
			gbc_spinnerAltura.gridx = 1;
			gbc_spinnerAltura.gridy = 3;
			contentPanel.add(spinnerAltura, gbc_spinnerAltura);
		}
		{
			JLabel lblCm = new JLabel("Cm");
			GridBagConstraints gbc_lblCm = new GridBagConstraints();
			gbc_lblCm.anchor = GridBagConstraints.WEST;
			gbc_lblCm.gridx = 2;
			gbc_lblCm.gridy = 3;
			contentPanel.add(lblCm, gbc_lblCm);
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
				Deportista d = new Deportista();
				d.setNombre(textFieldNombre.getText());
				if (rdbtnHombre.isSelected()) {
					d.setSexo("M");
				} else {
					d.setSexo("F");
				}
				d.setAltura(Integer.parseInt(spinnerAltura.getValue().toString()));
				d.setPeso(Integer.parseInt(spinnerPeso.getValue().toString()));
				new DeportistaDAO().insertDeportista(d);
				
				dispose();	
			}
		});

	}

	private void gestionarEventosModificar() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deportista.setNombre(textFieldNombre.getText());
				if (rdbtnHombre.isSelected()) {
					deportista.setSexo("M");
				} else {
					deportista.setSexo("F");
				}
				deportista.setAltura(Integer.parseInt(spinnerAltura.getValue().toString()));
				deportista.setPeso(Integer.parseInt(spinnerPeso.getValue().toString()));
				new DeportistaDAO().updateDeportista(deportista);
				
				dispose();	
			}
		});

	}

}
