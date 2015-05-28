package my.coreJava;

public class ConstructorTestChild extends ConstructorTestParent {

	private double height = 90;
	public ConstructorTestChild(){
		runConstructor();
	}
	public void runConstructor(){
		System.out.println(this.getClass().getName() + ":" + height);
	}
}
