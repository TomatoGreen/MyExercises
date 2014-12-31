package my.puzzles.test;

import my.puzzles.ReverseWords;


public class ReverseWordsTest {

	public static void main(String[] args) {
		ReverseWords solutions = new ReverseWords();
		
		//Reverse String
		String input = "";
		System.out.println(solutions.reverseWords(input));
		System.out.println(solutions.reverseWords2(input));
	}

}
