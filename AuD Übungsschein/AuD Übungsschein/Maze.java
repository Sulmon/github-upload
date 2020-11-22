public class Maze {

	// a) Soll for den Raum [y][x] pruefen, ob er Teil einer Sackgasse ist.

	public static boolean isDeadEnd(boolean[][][] maze, boolean[][] deadEnds, int y, int x) {

		int z = 0; // Variable z counts walls

		if (maze[y][x][0] == false)
			z = z + 1;

		if (maze[y][x][1] == false)
			z = z + 1;

		if (maze[y][x][2] == false)
			z = z + 1;

		if (maze[y][x][3] == false)
			z = z + 1;

		if (maze[y][x][0] == true) {
			if (y >= 1 && deadEnds[y - 1][x] == true) // NORTH
				z = z + 1;
		}

		if (maze[y][x][1] == true) {
			if (x < deadEnds[y].length - 1 && deadEnds[y][x + 1] == true) // OSTEN
				z = z + 1;
		}

		if (maze[y][x][2] == true) {
			if (y < deadEnds.length - 1 && deadEnds[y + 1][x] == true) // SOUTH
				z = z + 1;

		}

		if (maze[y][x][3] == true) {
			if (x >= 1 && deadEnds[y][x - 1] == true) // SOUTH
				z = z + 1;

		}

		if (z >= 3)
			return true; // weil es eine Sackgasse hier gibt

		return false;
	}

	public static int[] seekDeadEnd(boolean[][][] maze, boolean[][] deadEnds) {
		// TODO Auto-generated method stub

		for (int i = 0; i < deadEnds.length; i++) {
			for (int j = 0; j < deadEnds[i].length; j++) {

				if (isDeadEnd(maze, deadEnds, i, j) && deadEnds[i][j] == false) {
					int[] k = new int[2];
					k[0] = i;
					k[1] = j;
					return k;
				}
			}
		}

		return null;

	}

	public static boolean[][] solveMaze(boolean[][][] maze, boolean[][] deadEndsActuals) {
		// TODO Auto-generated method stub
		while (seekDeadEnd(maze, deadEndsActuals) != null) {

			int[] l = seekDeadEnd(maze, deadEndsActuals);
			int i = l[0];
			int j = l[1];
			deadEndsActuals[i][j] = true;

		}

		return deadEndsActuals;
	}

	public static int getSteps(boolean[][][] maze, boolean[][] deadEndsActuals) {
		solveMaze(maze, deadEndsActuals);
		int z = 0;
		for (int i = 0; i < deadEndsActuals.length; i++) {
			for (int j = 0; j < deadEndsActuals[i].length; j++) {
				if (deadEndsActuals[i][j] == false)
					z = z + 1;
			}
		}

		return z;
	}
}
