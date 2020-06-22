package hola;

public abstract class Animal {

	public String name;
	public int age;
	public String color;
	
	public Animal(String name, int age, String color) {
		this.name= name;
		this.age= age;
		this.color= color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age= age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color= color;
	}
	public void Dormir() {
		System.out.print("duermen");
	}
	public void Comer() {
		System.out.print("comen");
	}
}
