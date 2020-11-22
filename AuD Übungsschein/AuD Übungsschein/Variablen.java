//package ubung1;
import java.lang.Math.*;

public class Variablen {
	// TODO: declare a constant named "FOO_BAR" with a value of -123.456 * 10^(-89)
	public static final double FOO_BAR = -123.456 * Math.pow(10, -89);

	// TODO: declare an enumeration named "Months" containing the
	// english names in CAPITAL_LETTERS (!) of all the 12 months of the year in correct chronological order
	enum Months { 
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
	}

	public static char[] someCharacters() {
		// TODO: declare, fill and return an 1-dimensional
		// array containing the ASCII-letters A to Z (capital letters)
		
		char[] letters = new char[26];
		int i = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			letters[i++] = c; 
		}
		
		return letters;
	}

	public static char[][] someMoreCharacters() {
		// TODO: declare, fill and return a 2-dimensional array containing
		// 1) the values (!) 0 to 25 in the first row,
		// 2) the ASCII-letters A to Z (capital letters) in the second row,
		// 3) the ASCII-characters (!) 0 to 9, then 0 to 9 again and finally 0 to 5 in the third row
		// 4) the ASCII-letters a to z (non-capital letters) in the fourth row,
		
		char[][] mChar = {
                			{(int) 0, (int) 1 , (int) 2, (int) 3, (int) 4, (int) 5, (int) 6, (int) 7, (int) 8, (int) 9, (int) 10, (int) 11, (int) 12, (int) 13, (int) 14,
                				(int) 15, (int) 16, (int) 17, (int) 18, (int) 19, (int) 20, (int) 21, (int) 22, (int) 23, (int) 24, (int) 25},
                			{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
                			{'0', '1', '2','3', '4', '5','6', '7', '8', '9'},
                			{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},
							};

		return mChar;
	}

	public static int[][][] theCube() {
		// TODO: declare, fill and return a 3-dimensional array
		// of size 3x3x3 (try to imagine a http://en.wikipedia.org/wiki/Rubik's_Cube)
		// containing only integer numbers such that
		// the value at [x][y][z] == (x+1)*100+(y+1)*10+(z+1)
		// (e.g. cube[2][1][0] == 321)
		
		int[][][] cube = new int [3][3][3];
		
		for (int i = 0 ; i <= 2 ; i ++) {
			
			for (int j = 0 ; j <= 2 ; j++) {
				
				for (int k = 0 ; k <= 2 ; k++) {
					
					cube[i][j][k] = ((i + 1) * 100) + ((j + 1)) * 10 + (k + 1);
				}
			}
		}
		

		return cube;
	}
}



