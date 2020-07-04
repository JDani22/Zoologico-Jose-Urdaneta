package hola;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Veranimal extends JFrame {
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
	public JLabel AnimalIntroducido;
	public JLabel GuacaVuela;
	public JLabel LechuVuela;
	public Veranimal() {
		this.setTitle("Animales");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		IniciarAnimales();
		this.setLocationRelativeTo(null);

	}
	public void IniciarAnimales(){
		ColocarAnimales();
		ColocarCosas();
		TodosLosAnimales();
		AnimalNuevo();
		ColocarAnimal();
		Boton2();
		Boton3();
	}
	public void ColocarAnimales(){
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
		boton1.setBounds(100, 100, 200, 40);
		Cocodrilo = new JLabel();
		Cocodrilo.setBounds(100, 110, 100, 200);
		Lechuza = new JLabel();
		Lechuza.setBounds(100, 125, 100, 200);
		panel.add(Lechuza);
		Guacamayo = new JLabel();
		Guacamayo.setBounds(100, 140, 100, 200);
		Pinguino = new JLabel();
		Pinguino.setBounds(100, 155, 100, 200);
		Serpiente = new JLabel();
		Serpiente.setBounds(100, 170, 100, 200);
		Tortuga = new JLabel();
		Tortuga.setBounds(100, 185, 100, 200);
		panel.add(Tortuga);
		Pato = new JLabel();
		Pato.setBounds(100, 200, 100, 200);
		Oso = new JLabel();
		Oso.setBounds(250, 110, 100, 200);
		Tigre = new JLabel();
		Tigre.setBounds(250, 125, 100, 200);
		Leon = new JLabel();
		Leon.setBounds(250, 140, 100, 200);
		Jirafa = new JLabel();
		Jirafa.setBounds(250, 155, 100, 200);
		Jaguar = new JLabel();
		Jaguar.setBounds(250, 170, 100, 200);
		Elefante = new JLabel();
		Elefante.setBounds(250, 185, 100, 200);
		Conejo = new JLabel();
		Conejo.setBounds(250, 200, 100, 200);
		Chiguirre = new JLabel();
		Chiguirre.setBounds(250, 215, 100, 200);
		panel.add(Chiguirre);
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
		panel.add(boton1);
		JLabel AnimalNuevoRepetido = new JLabel();
		AnimalNuevoRepetido.setBounds(100, 215, 100, 200);
		panel.add(AnimalNuevoRepetido);
		
		ActionListener Boton01 = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Cocodrilo.setText("Cocodrilo");
				Lechuza.setText("Lechuza");
				Guacamayo.setText("Guacamayo");
				Pinguino.setText("Pinguino");
				Serpiente.setText("Serpiente");
				Tortuga.setText("Tortuga");
				Pato.setText("Pato");
				Oso.setText("Oso");
				Tigre.setText("Tigre");
				Leon.setText("Leon");
				Jirafa.setText("Jirafa");
				Jaguar.setText("Jaguar");
				Elefante.setText("Elefante");
				Conejo.setText("Conejo");
				Chiguirre.setText("Chiguirre");
				AnimalNuevoRepetido.setText(""+IngresarAnimal.getText());
				
				
				
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
		Boton02.setText("Mostrar Animal");
		AnimalIntroducido = new JLabel();
		AnimalIntroducido.setBounds(400, 200, 250, 30);
		panel.add(AnimalIntroducido);
		panel.add(Boton02);
		JLabel AnimalRepetido2 = new JLabel();
		AnimalRepetido2.setBounds(100, 215, 100, 200);
		panel.add(AnimalRepetido2);
		
		
		
		ActionListener AgregarAnimal = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AnimalIntroducido.setText(""+IngresarAnimal.getText());
				AnimalRepetido2.setText(""+IngresarAnimal.getText());
				
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
	 }



