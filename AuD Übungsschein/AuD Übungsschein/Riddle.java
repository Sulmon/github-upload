//package uebung022;

public class Riddle {

    // a) Implement the implies method, which expects two truth values a and b as arguments, and returns as result.

    public static boolean implies(boolean a, boolean b) {
        return !a || b;
    }

    // b) Now, for the formulas A0. , , A3 are each provided a method named a0 to a3, which returns the result of the corresponding calculation.
    // As parameters all these methods expect an assignment of the boolean variables for Stan, Cartman and Kyle in exactly this order.

    public static boolean a0(boolean Stan, boolean Cartman, boolean Kyle) {
        return implies(!Stan, !Kyle);
    }

    public static boolean a1(boolean Stan, boolean Cartman, boolean Kyle) {
        return implies(!Cartman, !Stan);
    }

    public static boolean a2(boolean Stan, boolean Cartman, boolean Kyle) {
        return (Cartman ^ Kyle ^ Stan);
    }

    public static boolean a3(boolean Stan, boolean Cartman, boolean Kyle) {
        return implies(Cartman, !(Kyle && Stan)) || implies(Kyle, !(Cartman && Stan)) || implies(Stan, !(Cartman && Kyle));
    }


    //c) Now complete the method eval, which should check whether the given truth assignment of the three persons all four formulas A0. , .A3 are fulfilled.
    //The order of the parameters should be retained according to the previous subtask.

    public static boolean eval(boolean Stan, boolean Cartman, boolean Kyle) {
        return a0(Stan, Cartman, Kyle) &&
                a1(Stan, Cartman, Kyle) &&
                a2(Stan, Cartman, Kyle) &&
                a3(Stan, Cartman, Kyle);
    }


	//According to Fact F2, exactly one of the three must be the thief.
	//In order to find the thief, three possible assignments of the variables Stan, Cartman and Kyle have to be tried. Finally, implement a checkRiddle method with no arguments.
	//It is to determine the thief by examining all three possibilities. The method should return 0 for Stan, 1 for Cartman, or 2 for Kyle.
	//If no assignment satisfies the formulas (the puzzle can not be solved), should be returned.
	//Note: Your implementation should also work for other puzzles (ie changed a0 to a3). Therefore, it is not enough here to determine the thief by hand and enter

    public static int checkRiddle() {
        if (eval(true, false, false)){
            return 0;
        } else if (eval(false, true, false)) {
            return 1;
        } else if (eval(false, false, true)) {
            return 3;
        }
        return -1;
    }
}








