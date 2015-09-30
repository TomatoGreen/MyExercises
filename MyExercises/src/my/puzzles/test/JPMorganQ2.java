package my.puzzles.test;

import java.io.*;
public class JPMorganQ2 {
	private static final String[] array1={"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] array2={"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
	private static final String[] array3={"Hundred", "Thousand", "Million", "Billion", "Trillion"};
	
	public static void convertNumberToString(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try{
			String input = "";
			int numberSize = 0;
			int startIndex = 0;
			int endIndex = 0;
			String[] nArray;
			while((input=in.readLine())!=null){
				if(Long.parseLong(input) > 999999999999999L){
					throw new Exception("Number is too big to convert.");
				}else if(Long.parseLong(input) == 0){
					System.out.println(array1[0]);
				}else if (Long.parseLong(input) < 0){
					throw new Exception("Cannot be negative.");
				}else{
					input = String.valueOf(Long.parseLong(input));
					numberSize = (input.length()-1)/3;
					nArray = new String[numberSize + 1];
					
					startIndex = 0;
					endIndex = input.length() - numberSize*3;
					nArray[0] = input.substring(startIndex, endIndex);
					
					startIndex += nArray[0].length();
					endIndex = startIndex + 3;
					
					for(int i=1; i<nArray.length; i++){
						nArray[i] = input.substring(startIndex, endIndex);
						startIndex += 3;
						endIndex = startIndex + 3;
					}
					printNumberArray(nArray);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printNumberArray(final String[] nArray) throws Exception {
		String s = "";
		int value = 0;
		String elm = "";
		if(nArray != null && nArray.length > 0){
			for(int i=0; i<nArray.length; i++){
				elm = nArray[i];
				value = Integer.parseInt(elm);
				if(value>0){
					if(elm.length()==3){
						value = Integer.parseInt(String.valueOf(elm.charAt(0)));
						if(value>0){
							s += array1[value] + " " + array3[0] + " ";
						}
					}
					
					if(elm.length()>1){
						value = Integer.parseInt(elm.substring(elm.length()-2));
						if(value>19){
							value = Integer.parseInt(elm.substring(elm.length() - 2, elm.length() - 1));
							s += array2[value - 2] + " ";
							value = Integer.parseInt(elm.substring(elm.length() - 1));
						}
					}else{
						value = Integer.parseInt(elm);
					}
					if(value>0){
						s += array1[value] + " ";
					}
					if(i<nArray.length-1){
						s += array3[nArray.length - 1 - i] + " ";
					}
				}
			}
			System.out.println(s);
		}else{
			System.out.println("No Input Found");
		}
	}
	
	
	public static void main(String[] args) {
		JPMorganQ2.convertNumberToString();
	}

}
