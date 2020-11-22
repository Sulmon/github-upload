public class KassenbonVerbessert extends Kassenbon {

//subclass of org.Kassenbon
	
    private int anzahl = 0;

    
    private static int help(int i) {
    	
    	if (i < 0) {
    		throw new IllegalArgumentException("input is negative");	
    	} 
    	else if (i > 100000) {
    		throw new IllegalArgumentException("input too big");	
    	}
    	
    	return i; 
    }
    
    
    
    public KassenbonVerbessert(int i) {
        super(help(i));//inherits parameters..but how is it used?
                

    }
   
    @Override //means that the method is overriding the parent class 
    public void speichern(String produkt, String preis) throws NullPointerException, IllegalArgumentException, RuntimeException  {
    	
   //------------------illegal parameter handling----------------------------
    	
    	
    
    	
    	//the null case 5. speichern(null, null); 
        if (produkt == null) {
            throw new NullPointerException(" Product not allowed to be null ");
        
        //longer than max
        } else if (produkt.length() > MAX_PRODUKT_LAENGE) {
            throw new IllegalArgumentException("Produkt ist laenger als "+MAX_PRODUKT_LAENGE+" zeichen. ");
        
        //stored products full
        } else if (produkte.length <= anzahl) {
            throw new RuntimeException(" Gespeicherte Produkte sind voll "); // uebergebene Parameter sind richtig, deshalb Runtime Exception
        }
        
        
        
       	
        try { //where is it best?
    	 super.speichern(produkt, preis);
        }
        
         catch (NumberFormatException e) {
            throw new IllegalArgumentException("keine gueltige zahl: " + preis);
        }
        anzahl++;
    }

    
    
    @Override
    public String letztesProdukt() {
        if (anzahl < 1) {
            throw new RuntimeException("Noch keine Produkte vorhanden");//no products in basket
            

        }
        return super.letztesProdukt();
    }

    public int summe() {
    	
    try {
        int summe = 0;
        for (int i = 0; i < anzahl; i++) {
            summe += preise[i];
        }
        return summe;
    }
    catch (NullPointerException e) {
    	return 0;
    	}
    }
    
    //number too big, cannot sum

    public int mittelwert() {
       if(anzahl < 1){
           throw new RuntimeException("runtime error"); 
       }
       
       return super.mittelwert();

    }

}