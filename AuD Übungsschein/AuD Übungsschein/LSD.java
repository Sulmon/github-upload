//import java.awt.Color;

public class LSD {

	// private & final attributes
	// genau zwei private und finale //one of a LSD type and another for initial
	// direction

	private final Direction dir; //
	private final LSD prevState; // previous state

	
	//----------------constructor------------------------------------
	private LSD(LSD object) {// make a step; need current
		this.prevState = object;
		this.dir = null;

	}

	// where to put initial direction?
	public LSD(Direction object) {
		this.dir = object;
		this.prevState = null;

	}
	
	//-----------------methods----------------------------------------
	// startet Ameise auf neuem Raster mit Richtung
/*	public LSD New(Direction object) {// use this reference instead of parameter for all methods

		LSD newState = new LSD(object);

		return newState; // represents new state?
	}*/

	// Ameise macht einen Schritt nach obigen Regeln
	public LSD step() {
		return new LSD(this);// which constructor is it using? getting dir or lsd object
	}

	
	// gibt aktuelle Farbe im uebergebenen Feld (x, y)
	public Colour getCol(Long x, Long y) {

		Colour color = Colour.WHITE;

		// base case
		// previous state is null
		if (this.prevState == null) {
			return Colour.WHITE;

		} else if (prevState.getX() == x && prevState.getY() == y){
			
			return prevState.getCol(x, y).flip(); 
		}
		else 
		{
				
			return prevState.getCol(x, y); // when do we flip the color?
		}
	}

	// gibt aktuelle Ausrichtung der Ameise
	public Direction getDir() { // this is get next direction?

		
		if (this.prevState == null) {
			return this.dir; 
		}
		
		if (prevState.getCol(prevState.getX(), prevState.getY()) == Colour.WHITE) {
			return prevState.getDir().turnCW();

		} else {
			return prevState.getDir().turnCounterCW();
		}

		// return this.dir;
	}

	// gibt aktuelle x-Koordinate der Ameise
	public Long getX() {
		
		
		if (prevState == null) {
			return 0L; 
		}
		
		
	
		// base case
		// direction will always be set
		
		
			switch (getDir()) {

			case E:
				return prevState.getX() + 1;

			case W:
				return prevState.getX() - 1;

			default:
				return prevState.getX();

			}

	}

	// calculate recursively

	// gibt aktuelle y-Koordinate der Ameise
	public Long getY() {


		if (prevState == null) {
			return 0L; 
		}
		
		
	
		// base case
		// direction will always be set
		
		
			switch (getDir()) {

			case N:
				return prevState.getY() + 1;

			case S:
				return prevState.getY() - 1;

			default:
				return prevState.getY();

		}
	}

}

