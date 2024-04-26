import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class App1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App2 frame = new App2();
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
	public App1() {

		contentPane = new JPanel();
		setResizable(false);
		setTitle("Conversor de Monedas y Temperatura");
		setSize(350, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel Label = new JLabel("Seleccione una opción:");
		Label.setBounds(84, 82, 169, 17);
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("Poppins", Font.BOLD, 11));
		getContentPane().add(Label);

		JButton boton1 = new JButton("Conversor de MXN a Otra Moneda");
		boton1.setLocation(24, 110);
		boton1.setBackground(new Color(255, 255, 255));
		boton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton1.setMinimumSize(new Dimension(50, 20));
		boton1.setMaximumSize(new Dimension(81, 31));
		boton1.setPreferredSize(new Dimension(80, 30));
		boton1.setSize(new Dimension(288, 41));
		boton1.setFont(new Font("Poppins", Font.PLAIN, 11));
		boton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ConversorMonedas conversor = new ConversorMonedas();
		        conversor.setVisible(true);
		        boton1.setEnabled(false);
		        
		    }
		});
		getContentPane().add(boton1);

		JButton boton2 = new JButton("Conversor de Otra Moneda a MXN");
		boton2.setSize(new Dimension(288, 41));
		boton2.setFont(new Font("Poppins", Font.PLAIN, 11));
		boton2.setBackground(Color.WHITE);
		boton2.setBounds(24, 162, 288, 41);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversoramxn conversor = new Conversoramxn();
				  conversor.setVisible(true);
				  boton1.setEnabled(false);
			        boton2.setEnabled(false);
			}
		});
		getContentPane().add(boton2);


		JLabel lblNewLabel = new JLabel("Developed By Daniel Bermudez");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblNewLabel.setBounds(84, 286, 269, 14);
		getContentPane().add(lblNewLabel);
		
	

		setVisible(true);

	}
}
