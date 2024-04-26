import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConversorTemp extends JFrame {

	private JPanel PaneTemp;
	private JTextField txtFahrenheit;
	private JTextField txtCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemp frame = new ConversorTemp();
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
	public ConversorTemp() {
		setTitle("Convertidor de Temperaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 291);
		PaneTemp = new JPanel();
		PaneTemp.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PaneTemp);
		PaneTemp.setLayout(null);
		
		JLabel Label4 = new JLabel("Ingresa la cantidad a convertir:");
		Label4.setFont(new Font("Poppins", Font.BOLD, 12));
		Label4.setBounds(63, 23, 209, 14);
		PaneTemp.add(Label4);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setFont(new Font("Poppins", Font.BOLD, 12));
		lblFahrenheit.setBounds(73, 67, 93, 14);
		PaneTemp.add(lblFahrenheit);
		
		JLabel lblCelsius = new JLabel("Celcius:");
		lblCelsius.setFont(new Font("Poppins", Font.BOLD, 12));
		lblCelsius.setBounds(95, 109, 77, 14);
		PaneTemp.add(lblCelsius);
		
		txtFahrenheit = new JTextField();
		txtFahrenheit.setBounds(155, 64, 86, 20);
		PaneTemp.add(txtFahrenheit);
		txtFahrenheit.setColumns(10);
		
		txtCelsius = new JTextField();
		txtCelsius.setBounds(155, 106, 86, 20);
		PaneTemp.add(txtCelsius);
		txtCelsius.setColumns(10);
		
		JButton btnConvertToFahrenheit = new JButton("Convertir a Fahrenheit");
		btnConvertToFahrenheit.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnConvertToFahrenheit.setBounds(78, 150, 163, 23);
		PaneTemp.add(btnConvertToFahrenheit);
		
		JButton btnConvertToCelsius = new JButton("Convertir a Celcius");
		btnConvertToCelsius.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnConvertToCelsius.setBounds(78, 184, 163, 23);
		PaneTemp.add(btnConvertToCelsius);
		
		JLabel lblNewLabel = new JLabel("Developed by Daniel Bermudez");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblNewLabel.setBounds(74, 227, 209, 14);
		PaneTemp.add(lblNewLabel);
	}

}
