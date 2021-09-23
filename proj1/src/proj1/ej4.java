package proj1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Label;

public class ej4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ej4 frame = new ej4();
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
	public ej4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel n1 = new JLabel("New label");
		n1.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n1.setBounds(53, 175, 56, 90);
		contentPane.add(n1);
		
		Label n2 = new Label("");
		n2.setBounds(115, 175, 68, 21);
		contentPane.add(n2);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 480, 412);
		contentPane.add(fondo);
		fondo.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/fondoReloj.png")));
	}
}
