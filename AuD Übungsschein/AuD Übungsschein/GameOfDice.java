//package ubung1;

public class GameOfDice {

	/*
	public static void main(String[] args) {

	      String[] dices = {"6", "2", "4", "4"};
	      int c = game(dices);
	      System.out.println(c);
	   }

	*/
	public static int game(String dices[]){
		
		
		int p2sum = 0;
	    int p1sum = 0;
	    int max = 6;
	    int[] xdices = new int[dices.length];
	    
	    
	    if (dices.length % 2 != 0) {
	        return -1;
	    }
	    
	    
	    for(int i=0; i< dices.length; i++)
	    	 xdices[i]=Integer.parseInt(dices[i]);
	    
	    
	    for (int i = 0; i < xdices.length; i++ ) {
	    	if(xdices[i] > max) 
	    		return -1;
		}
	     
	     
		for (int i = dices.length / 2 ; i < xdices.length; i++) {
	            p2sum += xdices[i];
	        }
	        
	        for (int i = 0 ; i < xdices.length / 2 ; i++) {
	            p1sum += xdices[i];    
	        }
	        
	        
	    if (p1sum > p2sum) {
	        return 1;
	   
	    } else if (p1sum == p2sum) {
	        return 0;
	        
	        
	    } else if (p1sum < p2sum) {
	        return 2;
	    
	    } else
	    	return 10;
	    
	}
	
}
