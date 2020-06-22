package hola;

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("Presione la opcion que quiera elegir");
		System.out.println(" 1.Viviparos ");
		System.out.println(" 2.Oviparos");
		System.out.println(" 3.Ingresar nuevo animal y mostrar todos");
		System.out.println(" 4.Animales voladores ");
		Viviparo A = new Viviparo(null,0, null);
		Oviparo B = new Oviparo(null, 0, null);
		int vara = sc.nextInt();
		switch(vara)
		{
		case 1:
			A.Parto();
			System.out.println("");
			System.out.println("Animales Viviparos:"); 
			System.out.println("");
			A.Oso();
			A.Chiguire();
			A.Conejo();
			A.Elefante();
			A.Jaguar();
			A.Jirafa();
			A.Leon();
			A.Tigre();
			break;
		case 2:
			B.PonerHuevo();
			System.out.println("");
			System.out.println("Animales Oviparos");
			System.out.println("");
			B.Guacamayo();
			B.Lechuza();
			B.Pato();
			B.Pinguino();
			B.Serpiente();
			B.Tortuga();
			B.Cocodrilo();
			break;
		case 3:
			System.out.println("Si el animal es oviparo presione 0, si es viviparo presione cualquier otro numero");
			int voro =sc.nextInt();
			System.out.println("Ingrese el nombre del animal");
			Scanner ss = new Scanner(System.in);
			String pera = ss.nextLine();
			if (voro == 0) {
				System.out.println("Lista de animales");
				System.out.println("");
				A.Oso();
				A.Chiguire();
				B.Cocodrilo();
				A.Conejo();
				A.Elefante();
				A.Jaguar();
				A.Jirafa();
				A.Leon();
				A.Tigre();
				B.Guacamayo();
				B.Lechuza();
				B.Pato();
				B.Pinguino();
				B.Serpiente();
				B.Tortuga();
				System.out.println("" + pera);
			}
			else {
				System.out.println("Lista de animales");
				System.out.println("");
				A.Oso();
				A.Chiguire();
				B.Cocodrilo();
				A.Conejo();
				A.Elefante();
				A.Jaguar();
				A.Jirafa();
				A.Leon();
				A.Tigre();
				B.Guacamayo();
				B.Lechuza();
				B.Pato();
				B.Pinguino();
				B.Serpiente();
				B.Tortuga();
				System.out.println(pera);
			}
			break;
		case 4:
			System.out.println("Lista de animales voladores");
			System.out.println("");
			B.Guacamayo();
			B.Volar();
			System.out.println("");
			B.Lechuza();
			B.Volar();
			
			break;
			
			default:
				System.out.println("El numero que puso no abarca ninguna de las opciones anteriores");
			
	}
	}
}
