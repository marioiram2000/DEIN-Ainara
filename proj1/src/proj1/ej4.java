package proj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class ej4 extends JFrame {

	private JPanel contentPane;
	public JLabel n1;
	public JLabel n2;
	public JLabel n3;
	public JLabel n4;
	public JLabel n5;
	public JLabel n6;
	
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
		
		n1 = new JLabel("");
		n1.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n1.setBounds(26, 175, 56, 90);
		contentPane.add(n1);
		
		n2 = new JLabel("");
		n2.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n2.setBounds(83, 175, 56, 90);
		contentPane.add(n2);
		
		JLabel dp1 = new JLabel(":");
		dp1.setFont(new Font("Dialog", Font.BOLD, 99));
		dp1.setForeground(Color.RED);
		dp1.setBounds(134, 175, 40, 90);
		contentPane.add(dp1);
		
		n3 = new JLabel("");
		n3.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n3.setBounds(172, 175, 56, 90);
		contentPane.add(n3);
		
		n4 = new JLabel("");
		n4.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n4.setBounds(231, 175, 56, 90);
		contentPane.add(n4);
		
		JLabel dp2 = new JLabel(":");
		dp2.setForeground(Color.RED);
		dp2.setFont(new Font("Dialog", Font.BOLD, 99));
		dp2.setBounds(286, 175, 40, 90);
		contentPane.add(dp2);
		
		n5 = new JLabel("");
		n5.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n5.setBounds(322, 175, 56, 90);
		contentPane.add(n5);
		
		n6 = new JLabel("");
		n6.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/ZERO.png")));
		n6.setBounds(390, 175, 56, 90);
		contentPane.add(n6);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 480, 412);
		contentPane.add(fondo);
		fondo.setIcon(new ImageIcon(ej4.class.getResource("/images/ej4/fondoReloj.png")));

		TimerTask timerTask = new TimerTask()
		{
		     public void run() 
		     {
		         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		         String hora = dtf.format(LocalDateTime.now());
		         n1.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(0)+""))));
		         n2.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(1)+""))));
		         n3.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(3)+""))));
		         n4.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(4)+""))));
		         n5.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(6)+""))));
		         n6.setIcon(new ImageIcon(ej4.class.getResource(obtenerImg(hora.charAt(7)+""))));
		     }
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1);
	}
	
	private String obtenerImg(String n) {
		switch (n) {
			case ("0"):
				return "/images/ej4/ZERO.png";
			case ("1"):
				return "/images/ej4/ONE.png";
			case ("2"):
				return "/images/ej4/TWO.png";
			case ("3"):
				return "/images/ej4/THREE.png";
			case ("4"):
				return "/images/ej4/FOUR.png";
			case ("5"):
				return "/images/ej4/FIVE.png";
			case ("6"):
				return "/images/ej4/SIX.png";
			case ("7"):
				return "/images/ej4/SEVEN.png";
			case ("8"):
				return "/images/ej4/EIGHT.png";
			case ("9"):
				return "/images/ej4/NINE.png";
		}
		return "";
	}
}
