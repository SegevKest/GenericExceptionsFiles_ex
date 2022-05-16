import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class mainProgramQuestionOne {

	private static Scanner sc = new Scanner(System.in);
	
	// Q 1-A+B
	// Get a set as a parameter and Fill it with Random numbers
	public static void fillSetWithRandomNumbers( aSet<Integer> set) {
		
		boolean insertResult;
		final int UP_LIMIT = 100, NUMS = 10;
		int i=0;
		
		Random rnd = new Random();
		Iterator<Integer> iter = set.iterator();
		
		while(i<NUMS) {
			
			insertResult = set.insert(rnd.nextInt(UP_LIMIT));
			
			if (insertResult)
				i++;
		}
	}
	
	// Method that gets 2 numbers from user and build set and return new Set
	public static aSet<Integer> createSetFromUser(){
		
		aSet<Integer> newSet = new aSet<Integer>();
		
		System.out.println("\nEnter 2 numbers to create the new Set: \n");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		newSet.insert(num1);
		newSet.insert(num2);		
		
		
		return newSet;
	
	}
	
	// Get a single integer from user to perform all required operations
	public static int getNumberFromUser() {
		
		System.out.println("\nEnter a number to perform all operations: \n");
		int num1 = sc.nextInt();
			
		return num1;
	}
	
	// This method will contain all the logic of Q.1 - A+B
	public static void questionOneAandB() {
		
		aSet<Integer> set1 = new aSet<Integer>();
		aSet<Integer> set2 = new aSet<Integer>();
		aSet<Integer> set3 = new aSet<Integer>();
		aSet<Integer> setFromUser = null;
		
		int numFromUser= 0;
		
		// Fill the sets with Random numbers
		fillSetWithRandomNumbers(set1);
		fillSetWithRandomNumbers(set2);
		fillSetWithRandomNumbers(set3);
		
		System.out.println("Sets");
		System.out.println("Set 1 :"+ set1);
		System.out.println("Set 2 :"+ set2);
		System.out.println("Set 3 :"+ set3);
		
		// Union of the 2 first Sets : 1+2
		System.out.println("\nUnion of 2 first sets");
		set1.union(set2);
		System.out.println("Result "+ set1);
		
		// Intersection of 2 remain sets 1+3
		System.out.println("\nIntersection of 2 remain sets");
		set1.intersect(set3);
		System.out.println("Result "+ set1);
		
		
		// Check Set from user is Subset of each set
		setFromUser = createSetFromUser();
		System.out.println("\nNew set received from User: "+ setFromUser);
		System.out.println("User set is subset of set 1:  "+ set1.isSubset(setFromUser));
		System.out.println("User set is subset of set 2:  "+ set2.isSubset(setFromUser));
		System.out.println("User set is subset of set 3:  "+ set3.isSubset(setFromUser));

		
		// Get Number from user and perform actions
		numFromUser = getNumberFromUser();
		System.out.println("\nNumber received from User: "+ numFromUser);
		
		System.out.println("\nSet 1: "+set1 +". Is Number member of Set: "+ set1.isMember(numFromUser));
		
		set2.insert(numFromUser);
		System.out.println("\nAdded Number from user to second Set: " + set2 );
		
		set3.delete(numFromUser);
		System.out.println("\nDeleted Number from user from third Set: " + set3);
		
		
		sc.close();
		
		
	}
	
	
	// Q 1.C 
	// The methods gets return the Min E from the Set
	public static <E extends Comparable<E>> E returnMinInSet(aSet<E> givenSet){
		
		Iterator<E> setIter = givenSet.iterator();
		E currItem, minE = null;
		
		// Checks if there is any value in the Array list
		if (setIter.hasNext())
			minE = setIter.next();
		
		
		while (setIter.hasNext()) {
			
			currItem = setIter.next();
		
			// Compare Min with currItem
			if (currItem.compareTo(minE) < 0)
				minE = currItem;
		}
		
		return minE;
	}
	
	// This method contains the logic and Set creation of Persons for Q.1 - C
	public static void questionOneC() {
		
		Person p1 = new Person("536654", "Segev","Kes","22031993");
		Person p2 = new Person("2648", "Yuv","Kesq","12012000");
		Person p3 = new Person("111111111112", "Dan","Kes","21032003");
		Person p4 = new Person("111111111111", "Shon","Kes","13091968");
		Person p5= new Person("536654", "Segev","Kes","22031993");
		
		
		aSet<Person> p = new aSet<Person>();
		p.insert(p1);		
		p.insert(p2);
		p.insert(p3);
		p.insert(p4);
		p.insert(p5);
		
		System.out.println("\nThe Minimal Person that returned is: \n"+returnMinInSet(p));
	}

	
	// The main function -  with 2 calls for the relevant methods 
	public static void main(String[] args) {

		questionOneAandB();
		
		//questionOneC();
		
	}
}
