
//java API not allowed
public class Kryptogramm {
	
	//a) method to extract characters; parameter input is string array of operands 
	//input looks like this: { "Send", "More", "Money" }; 3 total operands ; last one is the solution
	//no duplicates chars 
	public static char[] extrahiereZeichen(String[] operanden) {
		
		//do we need to know this size beforehand? yes
		//if using String, no need for array

		String control = ""; 
		//string manipulation
		for ( int i = 0; i < operanden.length; i++ ) {
			
			for ( int j = 0; j < operanden[i].length(); j++ ) {
				//extracting chars for each string	
				char c = operanden[i].charAt(j);
				//
					if (control.indexOf(c) == -1) {//excluding duplicates 
						control += c; 
						//end of for loop will look like "SendMory"
					}   
				}
			}
		// create new array holding each char
		char[] chars = new char[control.length()];
		for ( int k = 0; k < control.length(); k++) {
			chars[k] = control.charAt(k); 
			
		}
		
		return chars; 
	}

	//b) get values
	//input is a single operand & 2d array of assignment/allocation(zuordnung) 
	// example calculation { 9567, 1085, 10652 } for all 3 operands;
	//this evaluation will make evaluation for only one string
	//for example "send" key: s-9, e-5, n-6, d-7, return 9567
	
	public static long werteAus(String operand, char[][] zuordnung) {
		
		
		long werte = 0;
		//String werte ="";//initialize with an empty string 
		
		for ( int j = 0; j < operand.length(); j++ ) {
			
			char c = operand.charAt(j);//get each char in string operand
			
			for (int i = 0; i < zuordnung.length; i++ ) {
				
				if (c == zuordnung[i][0]) {
					
					
					werte = werte * 10; //use int instead string too long
					
					werte += zuordnung[i][1];
					break;
					
					//System.out.println(String.valueOf((int) zuordnung[i][1]));
					//werte += ((int)zuordnung[i][1]);// concatenate at each iteration
					//System.out.println(werte); 
				}
			}
		}
		
		//long eval = Long.valueOf(werte);
		//System.out.println(eval); 
		
		return werte; 
		
	}
	
		
	//----------------------------------------c) solve-------------------------------------------
	//difference from b) we have find the keys itself that satisfies the equation  
	//uses cascade recursion(really necessary?) & backtracking 
	//solution will look like this { { 'S', 9 }, { 'e', 5 }, { 'n', 6 }, { 'd', 7 }, { 'M', 1 }, { 'o', 0 }, { 'r', 8 }, { 'y', 2 } };
	
	
	private static boolean isFinal(String[] word, char[][] keyTable) {
		
		long finalSum = 0;
		int lastword = word.length - 1; 
		
		
		for (int i = 0; i < lastword; i++) {
			finalSum = finalSum + werteAus(word[i], keyTable);
		}

		if (finalSum == werteAus(word[lastword], keyTable)) {
			return true;
			
		} else 
			
			return false;
	}
	
	public static char[][] loese(String[] operanden){
		
		
		//extract all letters
		//returns [S, e, n, d, M, o, r, y]
		char[] exChar = extrahiereZeichen(operanden); 
		//create a table of the length of extracted array
		char[][] keyTable = new char[exChar.length][2];
		
		for (int i = 0; i < exChar.length; i++) {
			keyTable[i][0] = exChar[i];
		} 
		
		for (int i = 0; i < exChar.length; i++) {
			keyTable[i][1] = '*';
		} 
		
		int []digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; 
		int charIdx = 0; 
		
		return helperBacktrack(keyTable, operanden, charIdx, digits); 
	}
	

	
	private static char[][] helperBacktrack(char[][] keyTable, String[] word, int charIdx, 
			int[] digits){
//index controls how many numbers are assigned at each check from the digits
//first time it will check the key 
//{ { 'S', 0 }, { 'e', 1 }, { 'n', 2 }, { 'd', 3 }, { 'M', 4 }, { 'o', 5 }, { 'r', 6 }, { 'y', 7 } }; //but this key will fail so it will start over
//{ { 'S', 0 }, { 'e', 1 }, { 'n', 2 }, { 'd', 3 }, { 'M', 4 }, { 'o', 5 }, { 'r', 6 }, { 'y', 8 } }; //next it will try
		if (charIdx == keyTable.length) {
			

			if (isFinal(word, keyTable)) {
				return keyTable;	
			} 
			else 
			{
				return null;//this return null jumps back to middleChar
			}
		}

		for(int i = 0; i < digits.length; i++) {
			if(digits[i] != '*') {
				keyTable[charIdx][1] = (char) digits[i];
				
				
//[*, 1, 2, 3, 4, 5, 6, 7, 8, 9]; 
//after 1 # is assigned, it is assigned a -1 so that it 
//cannot be used again for current char
				digits[i] = '*';
				
				
			} else {
//it will continue == skip assigning values once it reaches 8(length of chars)
//used digits are assigned a -1; 
//[*, *, *, *, *...8, 9] 8, 9 are not used in this key
				continue;	
			} 
// above is is not being saved anywhere
//we are simply writing out the instructions for the recursive call

//if this is not null; we found a solution
			if(helperBacktrack(keyTable, word, charIdx + 1, digits) != null) {
				return keyTable;
			}
//here the remaining number will be plugged in to exhaust the all of the digits (for zahlen.length) 
			digits[i] = i;

		}
			return null;// this also jumps back to recursion

	}


}
	



