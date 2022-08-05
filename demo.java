import java.util.*;
class A{
	Scanner sc = new Scanner(System.in);
	A(){
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		System.out.println("Enter name: ");
		String name = sc.next();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		System.out.println("Enter salary: ");
		float sal = sc.nextFloat();
		System.out.println("Enter designation: ");
		String desig = sc.next();

		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Salary: "+sal);
		System.out.println("Designation: "+desig);
	}
}
class demo{

	public static void main(String[] args) {
		A a = new A();
		
	}
}