package my.coreJava;

public class ConstructorTestParent {
	private double weight = 100;
	
	public ConstructorTestParent(){
		runConstructor();
	}
	public void runConstructor(){
		System.out.println(this.getClass().getName() + ":" + weight);
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ConstructorTestChild child = new ConstructorTestChild();
		System.out.println("Hello World!");
		ConstructorTestParent parentChild = new ConstructorTestChild();
		System.out.println("Hello World!");
		ConstructorTestParent parent = new ConstructorTestParent();
	}


}
