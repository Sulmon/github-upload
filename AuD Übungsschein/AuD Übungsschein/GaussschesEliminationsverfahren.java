

public class GaussschesEliminationsverfahren {

	public static void pivotisiere(long[][] matrix, long[] vektor, int position) {

		for (int c = position; c < matrix[0].length; c++) {
			
			int maxRow = 0; // initialize to find maxRow
			if ((c + 1) < matrix[0].length) {
				
				double maxValue = 0;
				for (int row = c; row < matrix.length; row++) {
					
					if (Math.abs(matrix[row][c]) > maxValue && Math.abs(matrix[row][c]) > 0) {
						maxRow = row;
						maxValue = Math.abs(matrix[row][c]);
					}
				}

				if (maxRow == -1) { // error case
					break;

				} else if (maxRow != 0) { // swap happens
					
					long temp;
					for (int i = c; i < matrix[c].length; i++) {
						temp = matrix[c][i];
						matrix[c][i] = matrix[maxRow][i];
						matrix[maxRow][i] = temp;

						long vtemp = vektor[i];
						vektor[i] = vektor[maxRow];
						vektor[maxRow] = vtemp;
					}
				}
			}
		}

		// return matrix;
	}

	public static void eliminiere(long[][] matrix, long[] vektor, int position) {

		int c = position;
		for (int i = c + 1; i < matrix[0].length; i++) { 
			long alpha = matrix[c][c];
			long beta = matrix[i][c];

			if (alpha != 0 && beta != 0) {
				matrix[i][c] = beta / alpha; 
				vektor[i] = beta * vektor[c] - alpha * vektor[i];

				for (int j = c + 1; j < matrix[0].length; j++) { 
					// second row start
					matrix[i][j] = beta * matrix[c][j] - alpha * matrix[i][j]; 

				}
			}
		}
	}

	public static double[] loese(long[][] matrix, long[] vektor) {

		int col = matrix[0].length;
		double los[] = new double[col];

		for (int r = col - 1; r >= 0; r--) {
			
			double value = 0;			
			for (int c = col - 1; c > r; c--) {
				value = value + los[c] * matrix[r][c];
			}
			
			value = vektor[r] - value;
			los[r] = value / matrix[r][r];
		}
		return los;
	}

/*	public static void main(String[] args) {

		long[][] dices = { { 3, 11, 19 }, { 5, 13, 23 }, { 7, 17, 29 } };
		long[] vektor = { 101, 103, 107 };

		pivotisiere(dices, vektor, 0);
		eliminiere(dices, vektor, 0);
		pivotisiere(dices, vektor, 1);
		eliminiere(dices, vektor, 1);
		double[] losung = loese(dices, vektor);

		System.out.println(Arrays.toString(dices[0]));
		System.out.println(Arrays.toString(dices[1]));
		System.out.println(Arrays.toString(dices[2]));
		System.out.println(Arrays.toString(vektor));
		System.out.println(Arrays.toString(losung));
	}*/

}
