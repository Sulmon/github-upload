

public class MyApplication implements Controller {
	
	//DataStore and MyApplication has a composite relationship
	//They cannot exist without one another
	
	private DataStore dataStore; 
	
	private static void fillDataStore() {/*empty*/} //need to be static?
	
	public static void main(String args[]) {/*empty*/} //private 

	
}



//-----interface-----	
interface Controller{
	//passes method signature to Myapplication
	//in this case no method exists
	
}

//Subject & Observer has a Aggregational relationship
//Subject "has-a" observer

interface Observer{
	//passes method signature to DataStoreObserver
	
	public void update(); //no curly brackets for methods in interface 

	
}
	



abstract class Subject{
//Parent of Datastore
	
	private static final int MAX_OBSERVERS = 10; 
	
	private Observer[] observer = new Observer[MAX_OBSERVERS]; //-observer 0...MAX observers aggregation
	
	public void attachObserver(Observer o)  {/*empty*/}
	
	public void detachObserver(Observer o)  {/*empty*/}
	
	public void update() {/*empty*/}
	
}


//sub-class of Subject
//-----Data---------

class DataStore extends Subject {
	
	private int[][] values;
	
	public void Datastore(int height, int width) {/*empty*/}
	
	public boolean setValue(int row, int col, int value) {
		return false;
	}
	
	public int getValue(int row, int col) {
		return 0;
	}
	
	public int getHeight() {
		return 0;}
	
	public int getWidth() {
		return 0;}
	
	
}



abstract class DataStoreObserver implements Observer{
	
	//------> dotted arrow to interface Observer(need the update method)
	public void update() {
		
	}
	
	protected DataStore dataStore; 
	
//Parent of ViewTable & ViewSum
	
	protected DataStoreObserver(DataStore dataStore) {/*empty*/}
	
}


//sub-class of DataStoreObserver

//-------table----------
//Parent of  ViewTableLandscape & ViewTableNormal
abstract class ViewTable extends DataStoreObserver{

	private final static int COL_WIDTH = 7; 
	
	protected ViewTable(DataStore dataStore) {
		
		super(dataStore); 
	}
	
	protected static String format(int value) {
		return "";  
	}
	
	protected static void printSeparator(int width) {
		
	}
	
}

//----sub-classes of ViewTable----
class ViewTableLandscape extends ViewTable{
	
	public ViewTableLandscape(DataStore dataStore) {
		
		super(dataStore); 
	}
	
	public void update() {/*empty*/}
	
}

class ViewTableNormal extends ViewTable{
	
	public ViewTableNormal(DataStore dataStore) {
		
		super(dataStore);
		
	}
	
	public void update() {/*empty*/}
	
}



//sub-class of DataStoreObserver

//------sum---------
//Parent of  ViewCol & ViewRow
abstract class ViewSum extends DataStoreObserver{
	
	protected ViewSum(DataStore dataStore) {
		
		super(dataStore);
	}
	
	//abstract has no body
	protected abstract int sum(int index);
	
}


//----sub-classes of ViewSum----
class ViewSumColumn extends ViewSum {
	
	public ViewSumColumn(DataStore dataStore) {
		
		super(dataStore);
	}
	
	public void update() {/*empty*/}
	
	public int sum(int row) {
		return 0;}
	
}


class ViewSumRow extends ViewSum {
	
	public ViewSumRow(DataStore dataStore) {
		
		super(dataStore);
		
	}
	
	public void update() {/*empty*/}
	
	public int sum(int col) {
		return 0;}
	
	
	
}











