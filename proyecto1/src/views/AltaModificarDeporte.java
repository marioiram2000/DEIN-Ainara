package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.Messages;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AltaModificarDeporte extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<String> selectedTableValues;
	private JTextField txtNombre;
	private JButton okButton;

	public AltaModificarDeporte() {
		this.selectedTableValues = selectedTableValues;
		setTitle(Messages.getString("index.appTitle") + " - " + Messages.getString("deporte.title"));
		dibujar();
		gestionarEventos1();
	}

	public AltaModificarDeporte(ArrayList<String> selectedTableValues) {
		this.selectedTableValues = selectedTableValues;
		setTitle(Messages.getString("index.appTitle") + " - " + Messages.getString("deporte.title"));
		dibujar();
		fillForm();
		gestionarEventos2();
	}

	private void fillForm() {
		txtNombre.setText(selectedTableValues.get(1));
	}

	private void dibujar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNombreDelDeporte = new JLabel(Messages.getString("deporte.label"));
		GridBagConstraints gbc_lblNombreDelDeporte = new GridBagConstraints();
		gbc_lblNombreDelDeporte.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombreDelDeporte.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelDeporte.gridx = 0;
		gbc_lblNombreDelDeporte.gridy = 0;
		contentPanel.add(lblNombreDelDeporte, gbc_lblNombreDelDeporte);

		{
			txtNombre = new JTextField();
			System.out.println(selectedTableValues.size());
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 1;
			gbc_txtNombre.gridy = 0;
			contentPanel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void gestionarEventos1() {
		
	}

	private void gestionarEventos2() {

	}

}
