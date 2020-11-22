import java.util.Comparator;

public class UnimodaleSuche {

    public static <T> T suche(UnimodaleListe<T> list, int von, int bis, Comparator<T> scheissAuD) {
        if (list == null || von < 0 || bis < 0 || bis < von){
            return null;
        }
        if (von == bis) {
            return list.hole(von);
        }

        int mittelwert = ((bis - von) / 2) + von;
        T middle = list.hole(mittelwert);
        T afterMiddle = list.hole(mittelwert + 1);
        int compareResult = scheissAuD.compare(middle, afterMiddle);
        if (compareResult > 0) {
            if (von + 1 == mittelwert) {
                T vonElement = list.hole(von);
                return scheissAuD.compare(vonElement, middle) > 0 ? vonElement : middle;
            }
            return suche(list, von, mittelwert, scheissAuD);
        } else {
            if (bis == mittelwert + 2) {
                T bisElement = list.hole(bis);
                return scheissAuD.compare(afterMiddle, bisElement) > 0 ? afterMiddle : bisElement;
            }
            return suche(list, mittelwert + 1, bis, scheissAuD);
        }
    }


    public static <T extends Comparable> T suche(UnimodaleListe<T> list, int von, int bis) {
        if (list == null || von < 0 || bis < 0 || bis < von){
            return null;
        }
        if (von == bis) {
            return list.hole(von);
        }

        int mittelwert = ((bis - von) / 2) + von;
        T middle = list.hole(mittelwert);
        T afterMiddle = list.hole(mittelwert + 1);
        int compareResult = middle.compareTo(afterMiddle);
        if (compareResult > 0) {
            if (von + 1 == mittelwert) {
                T vonElement = list.hole(von);
                return vonElement.compareTo(middle) > 0 ? vonElement : middle;
            }
            return suche(list, von, mittelwert);
        } else {
            if (bis == mittelwert + 2) {
                T bisElement = list.hole(bis);
                return afterMiddle.compareTo(bisElement) > 0 ? afterMiddle : bisElement;
            }
            return suche(list, mittelwert + 1, bis);
        }
    }
}
