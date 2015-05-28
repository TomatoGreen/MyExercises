package my.puzzles;

import java.util.StringTokenizer;

public class ReverseWords {
	public String reverseWords(String s){
		String output="";
		StringTokenizer tokenizer = new StringTokenizer(s, " ");
		while(tokenizer.hasMoreElements()){
			if(output.equals(""))
				output = tokenizer.nextToken();
			else
				output = tokenizer.nextToken() + " " + output;
		}
		return "\'" + output + "\'";
	}
	
	public String reverseWords2(String s){
		String output = "", word = "";
		for(int i = 0; i <= s.length(); i++){
			if(i==s.length()){
				if(word.equals("") && output.length()>1)
					output = output.substring(1, output.length());
				else
					output = word + output;
			}else if(s.charAt(i)==' '){
				if(!word.equals("")){
					output = s.charAt(i) + word + output;
					word = "";
				}
			}else{
				word += s.charAt(i); 
			}
		}
		return "\'" + output + "\'";
	}
}
