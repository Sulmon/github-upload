
public enum Direction {
	
	
	//enums
	 E, N, W, S;
	
	//Direction dir;
	
	//instance methods
	 public Direction turnCW(){
		 
		 switch(this) {
			case E:
				return S;

			case N:
				return E;

			case W:
				return N;

			case S:
				return W;
			
			default:
				return E;

		}
	 }
	 
	 
	 //con
	 
	 public Direction turnCounterCW(){
		 
		 switch(this) {
			case E:
				return N;

			case N:
				return W;

			case W:
				return S;

			case S:
				return E;
			
			default:
				return E;
		 
		 
		}
	 }

}
