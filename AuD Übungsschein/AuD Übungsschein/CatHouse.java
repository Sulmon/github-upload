
//import java.util.ArrayList;


public class CatHouse extends CatBase {

	// is it considered a class attribute? //does it need to be declared in CatRoom
	// as well?
	// A: Yes this is a class attribute and no it should not exist in the CatRoom
	// A: As shown in the UML of the task, it is not a valid UML
	private CatRoom[][] crs;

	// --------constructor-----------------
	public CatHouse(int height, int width) {

		super(height, width);

		crs = new CatRoom[height][width];
	}

	// ----------methods-------------------

	public boolean canPlace(CatRoom r, int x, int y) throws IllegalArgumentException {
		
		//catroom.getHeight, get.Width will get me the size of the room
		//x and y are coordinates of the upper left corner of the room 
		
		//only looks at one individual tile(coordinate pair) 
		//if size allows, room allows, empty( marker -1) return true
		
		if (r == null)
			throw new IllegalArgumentException("Room cannot be null");

		if (x < 0 || y < 0 ) {
			throw new IllegalArgumentException("Value must be non-negative");
		}
		
		if (x >= crs[0].length || y >= crs.length ) {
			throw new IllegalArgumentException("Coords Out of Bounds");
		}
		
		if (x + r.width > this.width  || y + r.height > this.height || x >= this.width || y >= this.height ) {
			return false; 
		}
		
	/*	if (x + r.width > this.width || y + r.height > this.height || x >= this.width || y >= this.height) {
			throw new IllegalArgumentException("Room Out of Bounds");
		}*/

		for (int i = y; i < y + r.getHeight(); i++) {
			for (int j = x; j < x + r.getWidth(); j++) {
				if (crs[i][j] != null) {
					return false;
				}
			}
		}

		return true;
	}
	
		
	public void place(CatRoom r, int x, int y) {
	
		if (x < 0 || y < 0 || x >= this.width || y >= this.height || x + r.getWidth()-1 >= this.getWidth()
				|| y + r.getHeight()-1>= this.getHeight()) {
//			System.out.println(y+" yxplace1  "+x);
			throw new IllegalArgumentException();
		}
		
		if (canPlace(r, x, y)) {
	/*		return;
		}*/

			if (r.getX() != -1 && r.getY() != -1) {
			remove(r);
			}
			r.setXY(x, y);
			for (int i = y; i < y + r.getHeight(); i++) {
				for (int j = x; j < x + r.getWidth(); j++) {
					crs[i][j] = r;
			}
		}
		//r.setXY(x, y);
	}
}
	

	public void remove(CatRoom r) { 
		// only remove the given room coordinates

		if (r == null) {
			throw new IllegalArgumentException("input is null");
		}
		if (r.getY() < 0 || r.getX() < 0) {
			throw new IllegalArgumentException("value must be non-negative");
		}

/*		if (r.getY() + r.width > this.width || r.getY() + r.height > this.height || r.getY() >= this.width
				|| r.getY() >= this.height) {
			throw new IllegalArgumentException("Room Out of Bounds");
		}*/

		
		for (int i = 0; i < crs.length; i++) {
			
			for (int j = 0; j < crs[0].length; j++) {
				
				if (crs[i][j] == r) {
					crs[i][j] = null;
					
					// The room has been removed from the house but still exists in-memory so we
					// need to reset its x and y
					r.setXY(-1, -1);
		
			}
		}
		
	}
}
	
	// gets a complete room that holds a coorpair x,y
	public CatRoom getCatRoomAt(int x, int y) {
		

	
	
		if (x < 0 || y < 0 ) {
			throw new IllegalArgumentException("illegal argument");
		}

		if (x >= crs[0].length || y >= crs.length ) {
			throw new IllegalArgumentException("Coords Out of Bounds");
		}
		
		if (x >= this.width || y >= this.height ) {
			throw new IllegalArgumentException("illegal argument");
		}

		return crs[y][x];
	}

	// rooms in the house
	// backtracking goal is to check if we can get all the rooms to fit in the house
	// using different permutations(arrangement)
	// only if it is possible(in case of true) we can place
	// if impossible, return false

	// depends on correct implementation of canPlace, place and remove...component
	// of backtracking
	
	public boolean placeAll(CatRoom[] rs) {
		
		int roomCounter = 0;
		//count to create a stop point
		for (CatRoom room : rs) {
			if (room.getY() != -1) {
				roomCounter++;
			}
			else 
			{
				break;
			}
		}
		
		//base case
		if (roomCounter == rs.length) {
			return true;
		}
		
		while (rs[roomCounter].placeNextPossible(this) == true) {
			if (placeAll(rs)) {
				return true;
			}
		}
		
		if(rs[roomCounter].getY()!=-1) {
			
			remove(rs[roomCounter]);
		}
		

		return false;
	}
}