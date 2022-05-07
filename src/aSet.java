import java.util.ArrayList;
import java.util.Iterator;

public class aSet<T extends Comparable<T>>  {

	private ArrayList<T> setArray;

	// Empty constructor
	public aSet() {
		setArray = new ArrayList<T>();
	}

	// Constructor with an array of the Generic type - insert each element to the
	// set
	public aSet(T[] paramArr) {

		for (T arg : paramArr) {
			insert(arg);
		}
	}

//	public int compareTo(T obj) {
//		
//		if ()
//		return -1; 
//
//		return 0;
//	}
	

	public boolean equals(Object setObj) {

		aSet<T> toCompare;

		if (setObj == null || !(setObj instanceof aSet))
			return false;

		toCompare = (aSet<T>)setObj;
		
		Iterator<T> thisIter = iterator();
		Iterator<T> otherIter = toCompare.iterator();
	
		while (thisIter.hasNext() && otherIter.hasNext())
		{
			T currMem = thisIter.next();
			T otherMem = otherIter.next();
			
			if (currMem.compareTo(otherMem) != 0)
				return false;
		}
		
		// Check if 1 set still has members and other dont
		if ( (!thisIter.hasNext() && otherIter.hasNext()) ||
				(thisIter.hasNext() && !otherIter.hasNext()) )
			return false;
		

		return true;
		
//		if (set.compareTo(set1) == 0)
//		return true;

	}

	// The method return true if the obj exist in the Set already, false if not.
	public boolean isMember(T obj) {
			
		
		for( T arg: setArray)
		{
			if (arg.compareTo(obj) == 0)
				return true;
			
		}
//		
//		if (setArray.contains(obj))
//			return true;
		return false;

	}

	// The method will insert a Generic type variable to the set - will return true
	// if inserted, false if not
	public boolean insert(T objToInsert) {

		if (this.isMember(objToInsert))
			return false;
		else
			setArray.add(objToInsert);

		return true;

	}

	// The method will delete the parameter Obj from the Set (if exist), if not
	// exist - do nothing
	public void delete(T objToRemove) {

		int indexOfObj;

		if (this.isMember(objToRemove)) {
			indexOfObj = setArray.indexOf(objToRemove);
			// setArray.remove(objToRemove);
			setArray.remove(indexOfObj);
		}
	}

	// The method will print the Set
	public String toString() {

		String returnedStr = "{";

		for (int i = 0; i < setArray.size() - 1; i++)
			returnedStr += setArray.get(i) + ",";

		if (setArray.size() > 0)
			returnedStr += setArray.get(setArray.size() - 1);

		returnedStr += "}";

		return returnedStr;
	}

	// the method will return the Iterator object for this Set
	public Iterator<T> iterator() {

		return setArray.iterator();
	}

	// The method get new set and calculate its union with the current set
	public void union(aSet<T> newSetForUnion) {

		Iterator<T> newSetIterator = newSetForUnion.iterator();

		while (newSetIterator.hasNext()) {

			T currMem = newSetIterator.next();

			if (!this.isMember(currMem)) {
				this.insert(currMem);
			}
		}
	}

	// The method gets a new set and return the intersection of the 2 groups -
	// inside the caller
	public void intersect(aSet<T> newSetForIntersect) {

		ArrayList<T> theIntersect = new ArrayList<T>();

		T currMem;

		Iterator<T> currIterator = this.iterator();

		while (currIterator.hasNext()) {

			currMem = currIterator.next();

			if (newSetForIntersect.isMember(currMem)) {
				theIntersect.add(currMem);
			}
		}

		setArray = new ArrayList<>(theIntersect);
	}

	// The method return true if the given set it a subset of the current set. false
	// if not
	public boolean isSubset(aSet<T> possibleSubSet) {

		Iterator<T> setIterator = possibleSubSet.iterator();
		T currMem;

		while (setIterator.hasNext()) {
			currMem = setIterator.next();

			if (!this.isMember(currMem))
				return false;
		}
		return true;
	}

	
	  public static void main(String[] args) {
	  
	  
	  aSet<String> set = new aSet<String>(); 
	  aSet<String> set1 = new aSet<String>();
	  
	  set.insert("Segev"); 
	  set.insert("hey"); 
	  set.insert("gev");
	//  set.insert("Shona");
	  
	  set1.insert("hey");
	  set1.insert("gev");
	  
	  System.out.println(set);
	  System.out.println(set1);
	  
	  
	  System.out.println( set.equals(set1));
	  System.out.println( set.isMember("hy"));

	  
	  
	//  set.intersect(set1);
	  
	  
	  }
	 
}
