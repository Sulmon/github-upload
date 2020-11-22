public class Liste<T> {

	private Liste<T> next; // Bei der Syntax kommt <> immer hinter den Namen. (Variablendeklaration)
	private T element;

	public Liste() {

	}

	public static Liste neu() {
		return new Liste();
	}

	public static <T> Liste vorne(final Liste<T> inputListe, final T inputElement) {// <T> der Datentyp heisst T,
																					// generischer Typ.
		Liste<T> kopf = new Liste(); // Es wird eine neue Liste erzeugt (new) und einer Variable namens kopf
										// zugewiesen.
		kopf.element = inputElement; // Kopf ist vom Typ Liste. Wir weisen dem Kopf ein element zu. Der Punkt ist der
										// Aufloesungsoperator.
		// Bsp: jenny.stift = inputStift;
		kopf.next = inputListe;

		return kopf;

//        Liste <T> nudelsalat = new Liste(); // Konstruktor ist eine Methode, deshalb die Klammern!
//        nudelsalat.listofdoom.add(element); //Element wurde der listofdoom im Objekt Nudelsalat hinzugefuegt.
//        nudelsalat.listofdoom.addAll(liste.listofdoom);
//        return nudelsalat;
	}

	public static <T> T kopf(Liste<T> liste) {

		return liste == null ? null : liste.element; // muss return etwas vom Typ T zurueckgeben.

	}

	public static <T> Liste rest(Liste<T> restliste) {
		return restliste == null ? null : restliste.next;
	}
}
