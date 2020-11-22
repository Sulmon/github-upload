// PLEASE KEEP IN MIND:
// Place your new/additional code immediately below the line marked "// TODO:"
// and/or replace the expression after the return statement if necessary.
// Do not change any given code above or below those lines!
// For higher computational precision perform all multiplications before divisions!
import java.lang.Math.*

public class Geometrie {
	// computes and returns the circumference of a
	// regular polygon with n edges of length a
	public static double umfangRegelmaessigesVieleck(int n, double a) {
		// TODO:
		return n*a;
	}

	// computes and returns the circumference of a circle with radius r
	// (hint: use Math.PI for a precise value of PI)
	public static double umfangKreis(double r) {
		// TODO:
		return  Math.PI*r*2;
	}

	// computes and returns the surface area of a trapezium (aka trapezoid)
	// with base edge a, opposite edge c, and height h
	public static double flaecheTrapez(double a, double c, double h) {
		// TODO:
		return (a+b)*h/2;
	}

	// computes and returns the volume of a square pyramid
	// with base length a and height h
	public static double volumenPyramide(double a, double h) {
		// TODO:
		return  a*a*h/3;
	}

	// computes and returns the surface area of a square pyramid
	// with base length a and height h
	// (hint: use Math.sqrt(x) to compute the square root of x)
	public static double flaechePyramide(double a, double h) {

		return ((a*a) + a* (Math.sqrt*((a*a) +(4*h)))) ;
	}

	// computes and returns the volume of a sphere with radius r
	public static double volumenKugel(double r) {

		return  4 (Math.PI*r*r*r)/3;
	}

	// computes and returns the surface area of a closed irregular polygon
	// with consecutive connected nodes at (xi, yi)
	// (hint: use Math.abs(x) to compute the absolute value of x, i.e. |x|)
	public static double flaecheVieleck8(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5, double x6, double y6, double x7, double y7) {

		double surface= 0.0;
		double[ ] x = { x0, x1, x2, x3, x4, x5, x6, x7 };
		double[ ] y = { y0, y1, y2, y3, y4, y5, y6, y7 };

		int j = 7;
		for (int i = 0; i < 8; i++) {
			surface += (x[j] + x[i]) * (y[j] - y[i]);
			j = i;

		}


		return Math.abs(surface / 2.0);
	}

	// classifies a triangle by the given sides a, b and c
	// and returns one of the values 0 to 3 as follows:
	// 0 : if a,b,c are illegal, i.e. do not form a valid triangle
	// 1 : if triangle is scalene
	// 2 : if triangle is isosceles
	// 3 : if triangle is equilateral
	public static int typDesDreiecks(long a, long b, long c) {
		if (a >= (b+c) || c >= (b+a) || b >= (a+c)){
			return 0;
		}
		else if (a!=b) {
			return 1;
		}
		else if (b!=c){
			return 2;
		}
		else return 3;
	}
}
