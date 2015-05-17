package my.puzzles.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvestmentBrokerGroupTest {

	public static void main(String[] args) {
		Box box = new Box(1,2,3);
		int x = 42;
		int y = 24;
		box.swap(x, y);
		System.out.println("X = " + x + " Y = " + y);
		List<Double> prices = new ArrayList<Double>();
		prices.add(new Double(42.0));
		prices.add(42.0);
		List<String> sList = new ArrayList<String>();
		sList.add("ELEMENT1");
		sList.add("ELEMENT2");
		sList.add("ELEMENT3");
		String min = Collections.min(sList);
		System.out.println(min);
	}
//	   public static void main(String[] args) {
//		   List<String> aStringList = new ArrayList<String>();
//		   aStringList.add("ELEMENT1");
//		   aStringList.add("ELEMENT2");
//		   aStringList.add("ELEMENT3");
//		   aStringList.add("true");
//		   for(String s:aStringList)
//			   System.out.println(s);
//		   aStringList.remove(true);
//		   for(String s:aStringList)
//			   System.out.println(s);
//	        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
//
//	            if (b == 0x90) {
//
//	                System.out.print("We found it");
//
//	             }
//
//	        }
//
//	    }
}
