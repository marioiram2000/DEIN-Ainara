package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import dao.DAOProducto;
import model.Producto;

import java.awt.Color;

public class index extends JFrame {


	private static final long serialVersionUID = 1L;
	private final String MSG_REQUIRED = "TODOS LOS CAMPOS SON REQUERIDOS";
	//private final String MSG_REPEATED_CODE = "YA EXISTE UN PRODUCTO CON ESE CÓDIGO EN LA BASE DE DATOS";
	private final String MSG_CODE_FORMAT = "El código debe tener al menos 5 caracteres";
	private final String MSG_PRICE_FORMAT = "Debes introducir un precio válido";
	private final String MSG_DB_ERROR = "HEMOS TENID UN ERROR EN LA BASE DE DATOS";
	private final String MSG_INSERTED = "El producto se ha insertado correctamente";
	private final String MSG_DATA_CORRECT = "Los datos son válidos, procederemos a actualizarlos";
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldFiltro;
	private JCheckBox chckbxDisponible;
	private JTable table;
	private JButton btnCrear;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnBuscar;
	private DefaultTableModel modelo;

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

	public index() {
		dibujar();
		rellenarTabla();
		gestionarEventos();
	}
	
	private void dibujar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 383);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new TitledBorder(null, "Detalles del producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCdigo = new JLabel("Código: ");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 1;
		gbc_lblCdigo.gridy = 0;
		panel.add(lblCdigo, gbc_lblCdigo);
		
		textFieldCodigo = new JTextField();
		GridBagConstraints gbc_textFieldCodigo = new GridBagConstraints();
		gbc_textFieldCodigo.anchor = GridBagConstraints.WEST;
		gbc_textFieldCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCodigo.gridx = 2;
		gbc_textFieldCodigo.gridy = 0;
		panel.add(textFieldCodigo, gbc_textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 1;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 2;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		textFieldPrecio = new JTextField();
		GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
		gbc_textFieldPrecio.anchor = GridBagConstraints.WEST;
		gbc_textFieldPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrecio.gridx = 2;
		gbc_textFieldPrecio.gridy = 2;
		panel.add(textFieldPrecio, gbc_textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setBackground(Color.CYAN);
		GridBagConstraints gbc_chckbxDisponible = new GridBagConstraints();
		gbc_chckbxDisponible.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDisponible.anchor = GridBagConstraints.WEST;
		gbc_chckbxDisponible.gridx = 2;
		gbc_chckbxDisponible.gridy = 3;
		panel.add(chckbxDisponible, gbc_chckbxDisponible);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 4;
		panel.add(panel_3, gbc_panel_3);
		
		btnCrear = new JButton("Crear");
		panel_3.add(btnCrear);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		panel_3.add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		panel_3.add(btnLimpiar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{42, 114, 82, 0};
		gbl_panel_1.rowHeights = new int[]{25, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.anchor = GridBagConstraints.WEST;
		gbc_lblFiltro.insets = new Insets(0, 0, 0, 5);
		gbc_lblFiltro.gridx = 0;
		gbc_lblFiltro.gridy = 0;
		panel_1.add(lblFiltro, gbc_lblFiltro);
		
		textFieldFiltro = new JTextField();
		GridBagConstraints gbc_textFieldFiltro = new GridBagConstraints();
		gbc_textFieldFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFiltro.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldFiltro.gridx = 1;
		gbc_textFieldFiltro.gridy = 0;
		panel_1.add(textFieldFiltro, gbc_textFieldFiltro);
		textFieldFiltro.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panel_1.add(btnBuscar, gbc_btnBuscar);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel_2.add(table, gbc_table);
		table.setShowGrid(false);
	}
	
	private void gestionarEventos() {
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}
		});
		
		table.addMouseListener((MouseListener) new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            cargarFormularioDesdeTabla(row);
		        }
		    }
		});
		
		final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Text", "Title", JOptionPane.YES_NO_OPTION);
        		if(dialogResult == JOptionPane.YES_OPTION){
        		  	//System.out.println("BORRAR"+table.getSelectedRow());
        		  	borrar();
    				limpiarFormulario();
    				rellenarTabla();
        		}	
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
        
        popupMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table));
                        if (rowAtPoint > -1) {
                            table.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }
                    }
                });
            }
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
	}

	private void crear() {
		Producto producto = comprobarFormulario();
		if(producto!=null) {
			boolean inserted =new DAOProducto().insertProducto(producto);
			if(!inserted) {
				alert(MSG_DB_ERROR);
			}else {
				alert(MSG_INSERTED);
				limpiarFormulario();
				rellenarTabla();
			}
		}
	}
	
	private void actualizar() {
		Producto producto = comprobarFormulario();
		if(producto!=null) {
			boolean inserted =new DAOProducto().updateProducto(producto);
			if(!inserted) {
				alert(MSG_DB_ERROR);
			}else {
				alert(MSG_DATA_CORRECT);
				alert(MSG_INSERTED);
				limpiarFormulario();
				rellenarTabla();
			}
		}
	}
	
	private void limpiar() {
		limpiarFormulario();
	}
	
	private void buscar() {
		String filter = textFieldFiltro.getText();
		ArrayList<Producto> productos = new DAOProducto().selectProductos(filter);
		modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modelo);
		String[] headers = new String[] {"CÓDIGO", "NOMBRE", "","PRECIO", "DISPONIBLE"};
		
		modelo.setColumnIdentifiers(headers);
		modelo.addRow(headers);
		for (Producto p : productos) {
			String[] row = p.getAll();
			modelo.addRow(row);
		}
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
	}
	
	private void rellenarTabla() {
		modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modelo);
		String[] headers = new String[] {"CÓDIGO", "NOMBRE", "","PRECIO", "DISPONIBLE"};
		
		modelo.setColumnIdentifiers(headers);
		modelo.addRow(headers);
		ArrayList<Producto> productos = new DAOProducto().selectProductos();
		for (Producto p : productos) {
			String[] row = p.getAll();
			modelo.addRow(row);
		}
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
	}

	private void alert(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private Producto comprobarFormulario() {
		String error = "";
		String codigo = textFieldCodigo.getText();
		String nombre = textFieldNombre.getText();
		String precioStr = textFieldPrecio.getText();
		float precio = -1;
		
		if (codigo.equals("") || nombre.equals("") || precioStr.equals("")) {
			error += MSG_REQUIRED+"\n";
		}
		
		if(codigo.length()!=5) {
			error += MSG_CODE_FORMAT+" \n";
		}
		
		try {
			if(precioStr.indexOf('.')<0) {
				precioStr+=".00";
			}
			precio = Float.parseFloat(precioStr);
		}catch (NumberFormatException e) {
			error += MSG_PRICE_FORMAT+"\n";
		}
		
		if(!error.equals("")) {
			alert(error);
			return null;			
		}
		
		int disponible;
		if(chckbxDisponible.isSelected()) {
			disponible = 1;
		}else {
			disponible = 0;
		}
		
		Producto producto = new Producto(codigo, nombre, precio, disponible);
		return producto;
	}
	
	private void limpiarFormulario() {
		textFieldCodigo.setText("");
		textFieldNombre.setText("");
		textFieldPrecio.setText("");
		textFieldFiltro.setText("");
		chckbxDisponible.setSelected(false);
		textFieldCodigo.setEnabled(true);
		btnCrear.setEnabled(true);
		btnActualizar.setEnabled(false);
	}
	
	private void cargarFormularioDesdeTabla(int row) {
		String codigo = table.getModel().getValueAt(row, 0).toString();
		String nombre = table.getModel().getValueAt(row, 1).toString();
		String precioStr = table.getModel().getValueAt(row, 3).toString();
		String dispoStr = table.getModel().getValueAt(row, 4).toString();
		
		textFieldCodigo.setText(codigo);
		textFieldNombre.setText(nombre);
		textFieldPrecio.setText(precioStr);
		if(dispoStr.equals("0")) {
			chckbxDisponible.setSelected(false);			
		}else {
			chckbxDisponible.setSelected(true);
		}
		
		textFieldCodigo.setEnabled(false);
		btnCrear.setEnabled(false);
		btnActualizar.setEnabled(true);
		
	}
	
	private void borrar() {
		int row = table.getSelectedRow();
		String codigo = table.getModel().getValueAt(row, 0).toString();
		if(!new DAOProducto().deleteProducto(codigo)) {
			alert(MSG_DB_ERROR);
		}		
	}
}
