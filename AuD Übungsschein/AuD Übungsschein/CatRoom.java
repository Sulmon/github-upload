
public class CatRoom extends CatBase {

	// default values -1
	private int x = -1; // are coordinates of the upper left corner
	private int y = -1;

	// call attribute of the class

	// -------------Constructor--------------
	public CatRoom(int height, int width) {

		// height, width stretches dims x, y, width (x-Dimension) height (y-Dimension)
		// superclass delegates..but how is it used here..this h,w corresponds to the
		// CatBase h,w

		super(height, width);

	}

	// need getters for private or protected class attributes
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	// hint: ~ means package-private, meaning in Java not to specify, the effect is
	// that all classes in the same package can access the method.

	void setXY(int x, int y) {
		// ~ no need for any public or private
		// not public, should be only accessible from CatRoom
		// updates values called using getters
		this.x = x;
		this.y = y;
	}

	// finds next possible x,y for the room
	// base case to keep searching

	public boolean placeNextPossible(CatHouse ch) {
		
		if (ch == null) {
			throw new IllegalArgumentException("input is null");
		}
		
		if(this.getY()!=-1) {
			
			int a = getY() != -1 ? getY() : 0;
			int b = getX()!= -1 ? getX() : 0;
			ch.remove(this);
	
			int x2 = b + 1;
				for(int j = a; j < ch.height; j++) {
					for(int k = x2; k < ch.width; k++) {
						if(ch.canPlace(this, k, j)) {
							ch.place(this, k, j);
							return true;
							
						}
					}
					x2 = 0;
				}
		}
		else 
		{
			
		for (int j = 0; j < ch.height; j++) {
			for (int k = 0; k < ch.width; k++) {
				if (ch.canPlace(this, k, j)) {
					ch.place(this, k, j);
					return true;
				}
			}
		}
	}return false;
}
}
