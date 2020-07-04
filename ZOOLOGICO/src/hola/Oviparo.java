package hola;

import javax.swing.JLabel;

public class Oviparo extends Animal implements Vuelo{

	
	
	public Oviparo(String name, int age, String color) {
		super(name, age, color);
	
	}
	public void PonerHuevo() {
		System.out.print("Nazco mediante que mi madre ponga un huevo y de alli vengo");
	}
	void Guacamayo() {
		System.out.println("Guacamayo");
		
	}
	void Lechuza() {
		System.out.println("Lechuza");
	}
	void Pato() {
		System.out.println("Pato");
	}
	void Pinguino() {
		System.out.println("Pinguino");
	}
	void Serpiente() {
		System.out.println("Serpiente");
	}
	void Tortuga() {
		System.out.println("Tortuga");
	

	}
	void Cocodrilo() {
		System.out.println("Cocodrilo");
	}
}