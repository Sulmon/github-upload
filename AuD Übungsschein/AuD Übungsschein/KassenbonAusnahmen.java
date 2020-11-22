public class KassenbonAusnahmen {
	
	//basically trying to break the code using illegal inputs 

	
	//TEST: Kassenbon(); 
	//1. java.lang.NegativeArraySizeException
    public static void ausnahme1() {

        new Kassenbon(-1);
    }
    
	//TEST: Kassenbon();
    //2. out of memory
    public static void ausnahme2() {

    	//make into out of memory
        new Kassenbon(Integer.MAX_VALUE);
    }
    
    
	//TEST: speichern(); 
    //3. java.lang.NumberFormatException: For input string: "DEF"
    public static void ausnahme3() {

        new Kassenbon(1).speichern("ABC", "DEF");
    }
    
    
	//TEST: speichern(); 
    //4. java.lang.ArrayIndexOutOfBoundsException: 0
    public static void ausnahme4() {

        new Kassenbon(0).speichern("bla", "1" );
    }
    
    
	//TEST: speichern(); 
    //5. java.lang.NullPointerException
    public static void ausnahme5() {

        new Kassenbon(1).speichern(null, null);
    }
    
    
	//TEST: letztesProdukt()
    //6. java.lang.ArrayIndexOutOfBoundsException: -1
    public static void ausnahme6() {

        new Kassenbon(2).letztesProdukt();
    }
    
    
	//TEST: summe()
    //7. java.lang.NullPointerException
    public static void ausnahme7() {

        new Kassenbon(4).summe();
    }

    
	//TEST: mittelwert()
    //8. java.lang.ArithmeticException: / by zero
    public static void ausnahme8() {

        new Kassenbon(3).mittelwert();
    }
}