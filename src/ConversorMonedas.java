import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConversorMonedas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel Pane2;
	private JComboBox<String> comboBox;
	private HashMap<String, Double> tiposCambio;
	private JLabel labelCantidad, labelResultado;
	private JTextField campoCantidad, campoResultado;
	private JButton botonConvertir, botonCopiar;

	/**
	 * Create the frame.
	 */
	public ConversorMonedas() {
		setTitle("Conversor de Pesos Mexicanos a Otras Monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 290);
		setResizable(false);
		Pane2 = new JPanel();
		Pane2.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Pane2);
		Pane2.setLayout(null);

		iniciarComponentes();

		setVisible(true);

	}

	private void iniciarComponentes() {
		comboBox = new JComboBox<String>();
		comboBox.setBounds(119, 50, 90, 20);
		comboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won sul-coreano" }));
		Pane2.add(comboBox);

		JLabel JLabel3 = new JLabel("Seleccione a que moneda quiere convertir:");
		JLabel3.setFont(new Font("Poppins", Font.BOLD, 11));
		JLabel3.setBounds(41, 25, 242, 14);
		Pane2.add(JLabel3);

		labelCantidad = new JLabel("Cantidad de Pesos Mexicanos:");
		labelCantidad.setFont(new Font("Poppins", Font.BOLD, 12));
		labelCantidad.setBounds(10, 81, 193, 32);
		Pane2.add(labelCantidad);

		labelResultado = new JLabel("Resultado:");
		labelResultado.setFont(new Font("Poppins", Font.BOLD, 12));
		labelResultado.setBounds(72, 158, 73, 20);
		Pane2.add(labelResultado);

		campoCantidad = new JTextField();
		campoCantidad.setBounds(213, 87, 86, 20);
		Pane2.add(campoCantidad);
		campoCantidad.setColumns(10);

		campoResultado = new JTextField();
		campoResultado.setBounds(155, 158, 86, 20);
		Pane2.add(campoResultado);
		campoResultado.setColumns(10);

		botonConvertir = new JButton("Convertir");
		botonConvertir.setBounds(120, 124, 89, 23);
		Pane2.add(botonConvertir);

		botonCopiar = new JButton("Copiar");
		botonCopiar.setBounds(155, 189, 89, 23);
		Pane2.add(botonCopiar);

		tiposCambio = new HashMap<>();
		tiposCambio.put("Dólar", 0.050);
		tiposCambio.put("Euro", 0.043);
		tiposCambio.put("Libra Esterlina", 0.037);
		tiposCambio.put("Yen Japonés", 5.32);
		tiposCambio.put("Won sul-coreano", 60.15);

		botonConvertir.addActionListener(this);
		botonCopiar.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Developed By Daniel Bermudez");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblNewLabel.setBounds(84, 226, 186, 14);
		Pane2.add(lblNewLabel);
	}

	private void convertirMoneda() {
		String monedaSeleccionada = (String) comboBox.getSelectedItem();
		String cantidad = campoCantidad.getText();
		Double tipoCambio = tiposCambio.get(monedaSeleccionada);

		if (cantidad.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad para convertir", "Error",
					JOptionPane.ERROR_MESSAGE);

		} else {
			try {

				Double cantidadDouble = Double.parseDouble(cantidad);
				Double resultado = cantidadDouble * tipoCambio;
				campoResultado.setText(String.format("%.2f", resultado));
			} catch (

			NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad válida", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonConvertir) {
			convertirMoneda();
		} else if (e.getSource() == botonCopiar) {
			copiarResultado();
		}
	}

	private void copiarResultado() {
		String resultado = campoResultado.getText();
		if (!resultado.isEmpty()) {
			try {
				StringSelection stringSelection = new StringSelection(resultado);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(this, "Resultado copiado al portapapeles", "Copiado",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(this, "Error al copiar el resultado al portapapeles", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
