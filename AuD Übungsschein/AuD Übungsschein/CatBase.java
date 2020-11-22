
public abstract class CatBase {

	protected final int height;
	protected final int width;

	// ----------constructor-----------

	public CatBase(int height, int width) {
		if (height < 0 || width < 0) {
			throw new IllegalArgumentException("height and width may not be smaller then 0");
		}

		// initialize and assign incoming values to class attributes
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
}