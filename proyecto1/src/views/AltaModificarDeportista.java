package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class AltaModificarDeportista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;


	public AltaModificarDeportista() {
		dibujar();
		gestionarEventos();
		gestionarEventosAlta();
	}


	public AltaModificarDeportista(String id) {
		dibujar();
		fillForm();
		gestionarEventos();
		gestionarEventosModificar();

	}

	

	private void fillForm() {
		
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.gridwidth = 2;
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
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
			textField_3 = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.gridwidth = 2;
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 1;
			gbc_textField_3.gridy = 3;
			contentPanel.add(textField_3, gbc_textField_3);
			textField_3.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			ButtonGroup bg = new ButtonGroup();
			bg.add(rdbtnMujer);
			bg.add(rdbtnHombre);
		}
	}
	

	private void gestionarEventos() {
		// TODO Auto-generated method stub
		
	}
	
	private void gestionarEventosAlta() {
		// TODO Auto-generated method stub
		
	}
	
	private void gestionarEventosModificar() {
		// TODO Auto-generated method stub
		
	}

}
