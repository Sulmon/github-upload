
public class Wanderlust {

    // a)

    public static int solve(ReiseCheck rc, int[] values, int[][] next, int goal, int city, int[] path, int pathIdx) {
        rc.check();

        goal = goal - values[city]; 
        path[pathIdx] = city;

        if (goal == 0) { 
                      
            rc.report(path);
            return 1;
        } else if (goal < 0) {
            path[pathIdx] = -1;
            return 0;
        }

        int foundPaths = 0;
        int[] possibleCities = next[city]; // Von Stadt A zu Stadt B, C, etc. Welche Moeglichkeiten gibt es zu welchen Staedten
                                           // man zur naechsten Stadt kommt
        for (int possibleCity : possibleCities) { // For each Schleife. Variante einer for Scheife. Iteriert ueber Liste an
                                                  // possibleCities und stellt die aktuell iterierte Stadt in Variable
                                                  // possibleCity. Zeile 43 verwendet die iterierte Stadt.
            foundPaths = foundPaths + solve(rc, values, next, goal, possibleCity, path, pathIdx + 1);
        }

        return foundPaths;
    }

    // b)
    
    public static int solveMem(ReiseCheck rc, int[] values, int[][] next, int goal, int city, int[][] mem) {
        rc.check();

        if (mem[city][goal] != -1) {
            return mem[city][goal];
        }

        goal = goal - values[city];

        if (goal == 0) {
            return 1;
        } else if (goal < 0) {
            return 0;
        }

        int foundPaths = 0;
        int[] possibleCities = next[city];
        for (int possibleCity : possibleCities) {
            foundPaths = foundPaths + solveMem(rc, values, next, goal, possibleCity, mem);
        }
        mem[city][goal] = foundPaths;

        return foundPaths;
    }

    // c)
    
    public static int solveIt(ReiseCheck rc, int[] values, int[][] next, int goal, int city) {
     	
      
    	rc.check();
    	// initialize mem
        int[][] mem = new int[next.length][goal + 1];
          for (int i = 0; i < mem.length; i++) {
              for (int j = 0; j < mem[i].length; j++) {
                  mem[i][j] = -1;
              }
          }


          int foundPaths = 0;
          int[] possibleCities = next[city];
          for (int possibleCity : possibleCities) {
              int currentGoal = goal;
              for (int i = 0; i < next[possibleCity].length; i++) {
//                  while (currentGoal >= 0) {
                      currentGoal -= values[i];

                      if (mem[city][goal] != -1) {
                          return mem[city][goal];
                      }

//                          mem[i][currentGoal] = 1;
                      if (currentGoal == 0) {
                          foundPaths++;
                          mem[i][goal] += 1;
                      }
                  }
//              }
          }
          foundPaths = 2;
          return foundPaths;
      }
  }
