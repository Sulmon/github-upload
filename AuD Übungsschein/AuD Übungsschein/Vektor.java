public class Vektor {

	protected double[] komponenten;

	// a)

	public Vektor(int dimension) {
		komponenten = new double[dimension];
	}

	// b) Uebernimmt die Daten aus dem uebergebenen Array.

	public Vektor(double[] komponenten) {

		// this(komponenten.length);
		this.komponenten = new double[komponenten.length];
		for (int i = 0; i < komponenten.length; i++)
			this.komponenten[i] = komponenten[i];
	}

	// c) Laenge des Vektors zurueckgeben

	public int dimension() {
		return komponenten.length;
	}

	public double komponente(int i) {
		return komponenten[i];
	}

	// d)

	public void initialisiere(double[] komponenten) {

		if (dimension() == komponenten.length) {
			for (int i = 0; i < komponenten.length; i++) {
				this.komponenten[i] = komponenten[i];
			}
		}

	}

	// e) Multipliziert ein Skalar m mit diesem Vektor

	public void skalarMultiplikation(double m) {

		for (int i = 0; i < komponenten.length; i++)
			komponenten[i] = komponenten[i] * m;

	}

	// f) Das Skalarprodukt zweier Vektoren berechnen

	public double skalarProdukt(Vektor v) {

		if (dimension() != v.komponenten.length)
			return Double.NaN;

		double sum = 0;
		for (int i = 0; i < v.komponenten.length; i++) {
			sum = komponenten[i] * v.komponenten[i] + sum;
		}
		return sum;
	}

	public static double skalarProdukt(Vektor v1, Vektor v2) {

		if (v1.komponenten.length != v2.komponenten.length) {
			return Double.NaN;
		}
		double sum = 0;
		for (int i = 0; i < v2.komponenten.length; i++) {
			sum = v1.komponenten[i] * v2.komponenten[i] + sum;
		}
		return sum;
	}

	// g) Addition zweier Vektoren

	public void addition(Vektor v) {
		if (dimension() == v.komponenten.length) {
			for (int i = 0; i < v.komponenten.length; i++) {
				komponenten[i] = v.komponenten[i] + komponenten[i];
			}
		}

	}

	public static Vektor addition(Vektor v1, Vektor v2) {
		if (v1.komponenten.length != v2.komponenten.length) {
			return null;
		}
		Vektor bla = new Vektor(v2.komponenten.length);
		for (int i = 0; i < v1.komponenten.length; i++) {
			bla.komponenten[i] = v1.komponenten[i] + v2.komponenten[i];
		}
		return bla;
	}

	// h) Berechnet die euklidsche Form eines Vektors

	public double norm() {
		Vektor x = new Vektor(komponenten);
		Vektor y = new Vektor(komponenten);

		return Math.sqrt(skalarProdukt(x, y));
	}

	// i) konvertiert den aktuellen Vektor in seinen Einheitsvektor

	public void normiere() {

		double t = norm();
		for (int i = 0; i < komponenten.length; i++) {
			komponenten[i] = komponenten[i] / t;
		}

	}
}
