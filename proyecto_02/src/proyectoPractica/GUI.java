package proyectoPractica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Arreglos.PersonaArreglo;
import Clases.Persona;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAgregar;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	private JTable tabla;
	private String [] cabezera = {"NOMBRES","APELLIDOS","DNI"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	PersonaArreglo personaArreglo;
	public GUI() {
		
		personaArreglo = new PersonaArreglo();
		personaArreglo.crearArrayList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(721, 23, 89, 23);
		contentPane.add(btnAgregar);
		
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(39, 25, 53, 19);
		contentPane.add(lblNewLabel);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(253, 25, 53, 19);
		contentPane.add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(472, 25, 53, 19);
		contentPane.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(113, 24, 117, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(316, 22, 117, 20);
		contentPane.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(513, 22, 117, 20);
		contentPane.add(txtDni);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 912, 341);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		
	}
	
	public void set_table() {
		
	    DefaultTableModel model = new DefaultTableModel(); // Crea el modelo de la tabla con los datos y la cabecera
	    model.setColumnIdentifiers(cabezera);
	    int longitud = personaArreglo.longitud();
	    
	    for(int i = 0; i < longitud; i++) {
	    	//ArrayList<Persona> persona = personaArreglo.devolverInformacion();
	    	Persona persona = personaArreglo.getPersona(i); 
	    	
	    	Object [] row = {persona.getNombre(), persona.getApellido(), persona.getDni()};
	    	
	    	model.addRow(row);
	    	
	    }
	    tabla.setModel(model); // Establece el modelo en la tabla
	}
	
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
			
			set_table();
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		
		
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDni.getText();
		
		Persona persona = new Persona(nombre, apellido, dni );
		personaArreglo.insertarPersona(persona);
		
		}
	
	/*protected void actionPerformedBtnReporte(ActionEvent e) {
		tabla.setToolTipText(personaArreglo.devolverInformacion());
	}*/
}
