import java.util.ListIterator;

public class KenKen {
	
	//checkIntegrity();
	
	
	
	public static int checkIntegrity(int[][][] kenken){
		
		//1. if kenken is empty or null throw an error
		if (kenken == null || kenken.length == 0)
			return 1; 
		
		//2. check partition is a non-null 2D array and contains type int[] arr.length >= 2
		
		for (int i = 0; i < kenken.length; i++) {
			if (kenken[i] == null || kenken[i].length < 2) {
				return 2;
			
			}
		}
		
		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			for (int j = 0; j < partition.length; j++) {
				if (partition[j] == null) {
					return 2; 
				}	
			}			
		}
		
		//3. int[] is a non-null and arr.length == 2

		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			for (int j = 0; j < partition.length; j++) {
				if (partition[j] == null || partition[j].length != 2) {
					return 3; 
				}	
			}			
		}
		
		//4. partition[i][j] where j=0 must be a pair {(result) int 240 , char '*'}
		
		//int[]roPair = partition[i]; //i is {result, operation} pair 
		
		for (int i = 0; i < kenken.length; i++) {
			//int[]partition = kenken[i][0];
			//for (int j = 0; j < partition.length; j++) {
				//int[]roPair = partition[j];
			if (kenken[i][0][1] < 0 || kenken[i][0][1] > 65535 ) { //change to any int or any char...? or specific op char only
				return 4; 
				}

		}
		//5. for each partition[i][j] can only be one of '+', '-', '/', '*', ' ' (whitespace)
		
		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
				int[]roPair = partition[0];				
				if (roPair[1] != '+' && roPair[1] != '-' && roPair[1] != '/' && roPair[1] != '*' && roPair[1] != ' '  ) { 
				return 5; 
			}
		}
	
		
		//6. partition[i][j] where j > 0(others aside from the first one must be non-negative int pairs		
		
		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			//partition = kenken[i];
			
			for (int j = 1; j < kenken[i].length; j++) {
				//partition = partition[j];
				if (partition[j].length != 2)
					
					return 6; 
				
				for (int k = 0; k < partition[j].length; k++)
				if (partition[j][k] < 0 ) {
					return 6; 
				}	
			}			
		}
		
		//7. if operation is ' ' (whitespace)aka freebie, then exactly one sub-entry must follow the {result, operation}-pair
		
		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			int[]roPair = partition[0];
			
			if (roPair[1] == ' '&& partition.length > 2) { 
				return 7; 
			}
		}
		
		
		//8.if operation is '-' or '/', then exactly two sub-entries must follow the {result, operation}-pair
		
		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			int[]roPair = partition[0];
			if (roPair[1] == '-' && partition.length != 3 || roPair[1] == '/' && partition.length != 3 ) { 
				return 8; 
			}
		}

		
		//9.if operation is '+' or '*', then at least two sub-entries must follow the {result, operation}-pair

		for (int i = 0; i < kenken.length; i++) {
			int[][]partition = kenken[i];
			int[]roPair = partition[0];
			if (roPair[1] == '+'  && partition.length < 3 || roPair[1] == '*' && partition.length < 3) { 
				return 9; 
			}
		}
		
		return 0;
	}
	
	
	//checkValidity();
	
	public static int checkValidity(int[][][] kenken){
		
		if (checkIntegrity(kenken) != 0) { //checks structural integrity
			return 1; 
		}
		
		//find max coordinates to make a model square; compare all x,y  coordinates against each other
		//did not have to find both x y...a square anyways
		int maxY = -1;
		int maxX = -1;
		for (int i = 0; i < kenken.length; i++) {
			int[][] partition = kenken[i];
			
			for (int j = 1; j < partition.length; j++) {
					//kenken[i][j[0]
				if (partition[j][1] > maxY) {
				maxY = partition[j][1];
						
				}
			}
			
			for (int j = 1; j < partition.length; j++) {
				//kenken[i][j[0]
			if (partition[j][0] > maxX) {
				maxX = partition[j][0];

				}
			}
		
		}
		
		if (maxY != maxX)
			return 2; 
		
		//++also make a condition for when x doesnt equal y

		boolean[][] isValid = new boolean[maxY+1][maxX+1];
		
		for (int i = 0; i < kenken.length; i++) {
			//for each partition			
			//looking at all values after p[0]
			//make changes for the length of boolean array if that has seen it 
			for (int j = 1; j < kenken[i].length; j++) {
				//for (int k = 0; k < kenken[i][j].length; k++) {
				if(isValid[kenken[i][j][0]][kenken[i][j][1]])
					return 2;	
				isValid[kenken[i][j][0]][kenken[i][j][1]]=true;
				
				//}
			}
		}
		
		//checks if it is entirely covering a square, if there is a false then there 
		//is a coordinate that doesnt exit 
		for (int i = 0; i < isValid.length; i++) {
			for (int j = 0; j < isValid[i].length; j++) {
				//if(!isValid[kenken[i][j][0]][kenken[i][j][1]])
				//if(!isValid[i][j])
				if(isValid[i][j] == false)
					return 2;
			}
		}
		
		return 0;// all the conditions are met
	}
	
	
	

	//solve();
	public static int[][] solve(int[][][] kenken){

		
		if (checkIntegrity(kenken) != 0 || checkValidity(kenken) != 0 ) { //checks structural integrity
			return null; 
		}
		
		//take out 
		
		
		
		int[][] twoDarr = { //
				{ 5, 6, 3, 4, 1, 2 }, //
				{ 6, 1, 4, 5, 2, 3 }, //
				{ 4, 5, 2, 3, 6, 1 }, //
				{ 3, 4, 1, 2, 5, 6 }, //
				{ 2, 3, 6, 1, 4, 5 }, //
				{ 1, 2, 5, 6, 3, 4 } //
		};
		
		
		

		return twoDarr; //2D-array of ints (int[][]) containing any arbitrary solution
		

		
	}
	

}
	


