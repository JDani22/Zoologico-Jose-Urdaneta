package zoo;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.*;
public class Veranimal extends JFrame  {
	public JPanel panel;
	public JLabel Cocodrilo;
	public JLabel Lechuza;
	public JLabel Guacamayo;
	public JLabel Pinguino;
	public JLabel Serpiente;
	public JLabel Tortuga;
	public JLabel Pato;
	public JLabel Oso;
	public JLabel Tigre;
	public JLabel Leon;
	public JLabel Jirafa;
	public JLabel Jaguar;
	public JLabel Elefante;
	public JLabel Conejo;
	public JLabel Chiguirre;
	public JTextField IngresarAnimal;
	public JTextField ClaveAnimal;
	public JLabel AnimalIntroducido;
	public JLabel GuacaVuela;
	public JLabel LechuVuela;
	public String dbName = "Register";
	public String URL = "jdbc:postgresql://localhost:5432/ZOOLOGICO";
	public String USER = "postgres";
	public String PASSWORD = "princho4";
	PreparedStatement ps;
	ResultSet res;
	//
	public JTextField ingresoMensaje;
    public JTextArea pantallaChat;
    public JMenuItem adjuntar;
    private static ServerSocket servidor;
    private static Socket cliente;
    private static String ipServidor;// = "127.0.0.1";
    public static Cliente ventanaCliente;
    public static String usuario;
    public boolean recibir;
	



public Veranimal() {
		this.setTitle("Animales");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		IniciarAnimales();
		this.setLocationRelativeTo(null);

	}
public Connection getConection() {
	Connection con = null;
	try {
		
		Class.forName("org.postgresql.Driver");
		con = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("conexion exitosa");
		JOptionPane.showMessageDialog(null,"conexion exitosa");
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}return con;
 }
	private void LimpiarCajas() {
		ClaveAnimal.setText(null);
		IngresarAnimal.setText(null);
		
	}
	public void IniciarAnimales(){
		ColocarAnimales();
		ColocarCosas();
		TodosLosAnimales();
		AnimalNuevo();
		ColocarAnimal();
		Boton2();
		Boton3();
		BotonEliminar();
		BotonModificar();
		BotonBuscar();
		ClaveAnimal();
		ListaAnimales();
	}
	public void ColocarAnimales()  {
	panel = new JPanel();
	panel.setLayout(null);
	this.getContentPane().add(panel);
	}
	public void ColocarCosas() {
	JLabel animales = new JLabel();
	animales.setText("ZOOLOGICO");
	animales.setBounds(440,20,1000,50);
	animales.setForeground(Color.RED);
	animales.setFont(new Font("arial",1,20));
	panel.add(animales);
	}
	public void TodosLosAnimales() {
		JButton boton1 = new JButton();
		boton1.setText("Lista de Animales");
		boton1.setEnabled(false);
		boton1.setBounds(100, 100, 200, 40);
		
		panel.add(boton1);
		JLabel AnimalNuevoRepetido = new JLabel();
		AnimalNuevoRepetido.setBounds(100, 215, 100, 200);
		panel.add(AnimalNuevoRepetido);
		
		ActionListener Boton01 = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
					AnimalNuevoRepetido.setText(""+IngresarAnimal.getText());
					try {
					Connection con =null;
					con =  getConection();
					
					ps= con.prepareStatement("Select * FROM Animales");
					res= ps.executeQuery();
					if(res.next()) {
						JOptionPane.showMessageDialog(null, res.getString("Animal"));
					}else {
						JOptionPane.showMessageDialog(null,"NO EXISTEN DATOS");
						}
					con.close();
					}catch(Exception a) {
						System.out.println(a);
					}
					}
			
		};
		boton1.addActionListener(Boton01);
	}
	public void AnimalNuevo() {
		JLabel	AnimalN = new JLabel();
		AnimalN.setBounds(450, 60, 100, 30);
		AnimalN.setText("Ingrese el Animal");
		panel.add(AnimalN);
	}		
	public void Boton2() {
		JButton Boton02 = new JButton();
		Boton02.setBounds(400, 240, 200, 40);
		Boton02.setText("Guardar");
		
		AnimalIntroducido = new JLabel();
		AnimalIntroducido.setBounds(400, 200, 250, 30);
		panel.add(AnimalIntroducido);
		panel.add(Boton02);
		JLabel AnimalRepetido2 = new JLabel();
		AnimalRepetido2.setBounds(100, 215, 100, 200);
		panel.add(AnimalRepetido2);
		
		
		
		ActionListener AgregarAnimal = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					con = getConection();
					ps= con.prepareStatement("INSERT INTO Animales (Animal,Id) VALUES(?,?)");
					ps.setString(1,IngresarAnimal.getText());
					ps.setString(2, ClaveAnimal.getText());
					int res= ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "Animal Guardado");
						LimpiarCajas();
					}else {
						JOptionPane.showMessageDialog(null, "Error al Guardar");
						LimpiarCajas();
					}
					con.close();
				}catch(Exception c) {
					System.err.print(c);
					
				}
				
			}
			
		};
		Boton02.addActionListener(AgregarAnimal);
	}
	public void ColocarAnimal() {
		IngresarAnimal = new JTextField();
		IngresarAnimal.setBounds(400, 100, 200, 40);
		panel.add(IngresarAnimal);
		
	}
	public void Boton3() {

		JButton Boton03 = new JButton();
		Boton03.setBounds(700, 100, 280, 40);
		Boton03.setText("Caracteristicas Especiales de Animales");
		panel.add(Boton03);
		GuacaVuela= new JLabel();
		GuacaVuela.setBounds(790, 250, 100, 40);
		panel.add(GuacaVuela);
		LechuVuela = new JLabel();
		LechuVuela.setBounds(790,230, 100, 40);
		panel.add(LechuVuela);
		JLabel Voladores = new JLabel();
		Voladores.setBounds(790,200, 100, 40);
		panel.add(Voladores);
		
		ActionListener CompAnimales = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuacaVuela.setText("Guacamayo");
				LechuVuela.setText("Lechuza");
				Voladores.setText("Voladores:");
				
				
			}
			
		};
		Boton03.addActionListener(CompAnimales);
		
	
	}

	public void BotonEliminar() {
		JButton BotonEliminar = new JButton();
		BotonEliminar.setBounds(400, 340, 200, 40);
		BotonEliminar.setText("Eliminar");
		panel.add(BotonEliminar);
		
		ActionListener BotonEliminarAcc = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					con = getConection();
					ps= con.prepareStatement("DELETE FROM Animales WHERE Id=?");
					ps.setString(1,ClaveAnimal.getText());
					int res= ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "Animal Borrado");
						LimpiarCajas();
					}else {
						JOptionPane.showMessageDialog(null, "Error Al Borrar");
						LimpiarCajas();
					}
					con.close();
				}catch(Exception c) {
					System.err.print(c);
					
				}
				
			}
			
		};
		BotonEliminar.addActionListener(BotonEliminarAcc);
		
	}
	public void BotonModificar() {
		JButton BotonModificar = new JButton();
		BotonModificar.setBounds(400, 440, 200, 40);
		BotonModificar.setText("Modificar");
		panel.add(BotonModificar);
		ActionListener BotonModificarAcc = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					con = getConection();
					ps= con.prepareStatement("UPDATE Animales SET Animal=? WHERE Id=?");
					ps.setString(1,IngresarAnimal.getText());
					ps.setString(2,ClaveAnimal.getText());
					int res= ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "Animal Modificado");
						LimpiarCajas();
					}else {
						JOptionPane.showMessageDialog(null, "Error al Modificar");
						LimpiarCajas();
					}
					con.close();
				}catch(Exception c) {
					System.err.print(c);
					
				}
				
			}
			
		};
		BotonModificar.addActionListener(BotonModificarAcc);
	}
	public void BotonBuscar() {
		JButton BotonBuscar = new JButton();
		BotonBuscar.setBounds(400, 540, 200, 40);
		BotonBuscar.setText("Buscar");
		panel.add(BotonBuscar);
		
		ActionListener BotonBuscarAcc = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					con=getConection();
					ps= con.prepareStatement("Select * From Animales WHERE Id = ?");
					ps.setString(1,ClaveAnimal.getText() );
					res = ps.executeQuery();
					if(res.next()) {
						ClaveAnimal.setText(res.getString("id"));
						IngresarAnimal.setText(res.getString("Animal"));
					}else {
						JOptionPane.showMessageDialog(null, "No existe ese animal en este zoologico");
					}
				}catch(Exception d){
					System.err.print(d);
				}
				
				
			}
			
		};
		BotonBuscar.addActionListener(BotonBuscarAcc);
		
	}
	public void ClaveAnimal() {
		ClaveAnimal = new JTextField();
		JLabel ID = new JLabel();
		ClaveAnimal.setBounds(400,175, 200, 40);
		panel.add(ClaveAnimal);
		ID.setBounds(500, 110, 100, 100);
		ID.setText("ID");
		panel.add(ID);
	}

	public void ListaAnimales() {
		JLabel Lista = new JLabel();
		Lista.setBounds(175, 105, 100, 100);
		Lista.setText("ID  /  Animales ");
		panel.add(Lista);
		Cocodrilo = new JLabel();
		Cocodrilo.setBounds(100, 110, 100, 200);
		Cocodrilo.setText("1/Cocodrilo");
		Lechuza = new JLabel();
		Lechuza.setBounds(100, 125, 100, 200);
		Lechuza.setText("2/Lechuza");
		Guacamayo = new JLabel();
		Guacamayo.setBounds(100, 140, 100, 200);
		Guacamayo.setText("3/Guacamayo");
		Pinguino = new JLabel();
		Pinguino.setBounds(100, 155, 100, 200);
		Pinguino.setText("4/Pinguino");
		Serpiente = new JLabel();
		Serpiente.setBounds(100, 170, 100, 200);
		Serpiente.setText("5/Serpiente");
		Tortuga = new JLabel();
		Tortuga.setText("6/Tortuga");
		Tortuga.setBounds(100, 185, 100, 200);
		Pato = new JLabel();
		Pato.setText("7/Pato");
		Pato.setBounds(100, 200, 100, 200);
		Oso = new JLabel();
		Oso.setText("8/Oso");
		Oso.setBounds(250, 110, 100, 200);
		Tigre = new JLabel();
		Tigre.setText("9/Tigre");
		Tigre.setBounds(250, 125, 100, 200);
		Leon = new JLabel();
		Leon.setText("10/Leon");
		Leon.setBounds(250, 140, 100, 200);
		Jirafa = new JLabel();
		Jirafa.setText("11/Jirafa");
		Jirafa.setBounds(250, 155, 100, 200);
		Jaguar = new JLabel();
		Jaguar.setText("12/Jaguar");
		Jaguar.setBounds(250, 170, 100, 200);
		Elefante = new JLabel();
		Elefante.setText("13/Elefante");
		Elefante.setBounds(250, 185, 100, 200);
		Conejo = new JLabel();
		Conejo.setText("14/Conejo");
		Conejo.setBounds(250, 200, 100, 200);
		Chiguirre = new JLabel();
		Chiguirre.setText("15/Chiguirre");
		Chiguirre.setBounds(250, 215, 100, 200);
		panel.add(Chiguirre);
		panel.add(Lechuza);
		panel.add(Conejo);
		panel.add(Elefante);
		panel.add(Jaguar);
		panel.add(Jirafa);
		panel.add(Leon);
		panel.add(Tigre);
		panel.add(Oso);
		panel.add(Pato);
		panel.add(Guacamayo);
		panel.add(Serpiente);
		panel.add(Lechuza);
		panel.add(Cocodrilo);
		panel.add(Pinguino);
		panel.add(Tortuga);
	
	}	
	}
	
	 



