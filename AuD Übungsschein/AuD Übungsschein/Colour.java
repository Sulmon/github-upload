
public enum Colour {
	// adt Colour

	// enums
		WHITE, BLACK;
	

	public Colour flip() {
		if (this == WHITE)
			return BLACK;
		else
			return WHITE;
	}

}
