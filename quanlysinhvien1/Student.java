package quanlysinhvien1;

import java.util.Scanner;

public class Student {
	static int count=0;

	int id=0,age;
	String name,address;
	float gpa;
	public Student() {
		super();
		id=count ++;
	}
	public Student(int id, int age, String name, String address, float gpa) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.address = address;
		this.gpa = gpa;
		id=count ++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public void display() {
		System.out.println(this);
	}
	public void input() {
		Scanner scanner=new Scanner(System.in);
//		System.out.println("nhap id:");
//		id=Integer.parseInt(scanner.nextLine());
		
		
		System.out.println("nhap ten :");
		name=scanner.nextLine();
		
		System.out.println("nhap address :");
		address=scanner.nextLine();
		
		System.out.println("nhap age :");
		age=Integer.parseInt(scanner.nextLine());
		
		System.out.println("nhap gpa :");
		gpa=Float.parseFloat(scanner.nextLine());
	}
	public String getFileline() {
		return id+","+name+","+address+","+age+","+gpa+"\n";
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + ", gpa=" + gpa + "]";
	}
	
}
