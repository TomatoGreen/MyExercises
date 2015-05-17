package my.puzzles.test;

import java.io.*;
public class JPMorganQ2 {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	    String s = "", hundred = "Hundred", thousand = "Thousand", million = "Million", converted = "";
	    String[] nArray={"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	    String[] tArray={"Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
	    int index = 0, value = 0;
 	    try{
		    while ((s = in.readLine()) != null) {
		    	if(!s.trim().equals("")){
		    		try{
		    			Integer.parseInt(s);
		    		}catch(Exception e){
		    			System.out.println("Invalid Input: " + s);
		    			continue;
		    		}
		    		converted = "Dollars";
		    		index = s.length()-1;
		    		for(int i=0; i<s.length(); i++){
		    			value = Integer.parseInt(String.valueOf(s.charAt(index)));
		    			if(value!=0){
		    				switch (i) {
			    	            case 0: converted = nArray[value-1] + converted;
			    	                    break;
			    	            case 1: converted = tArray[value-1] + converted;
			    	                    break;
			    	            case 2:	converted = nArray[value-1] + hundred + converted;
			    	            		break;
			    	            case 3:	converted = nArray[value-1] + thousand + converted;
			    	            		break;
			    	            case 4: converted = tArray[value-1] + converted;
	    	            				break;
			    	            case 5: converted = nArray[value-1] + hundred + converted;
	    	            				break;
			    	            case 6: converted = nArray[value-1] + million + converted;
	    	            				break;
			    	            case 7: converted = tArray[value-1] + converted;
	            						break;
			    	            case 8: converted = nArray[value-1] + hundred + converted;
	            						break;
			    	            default: break;
		    				}
		    			}
		    			index--;
		    		}
		    		System.out.println(converted);
		    	}else{
		    		System.out.println(s);
		    	}
		    }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}

}
