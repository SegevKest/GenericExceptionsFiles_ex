import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class integerSet {

	
	
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
	
	// Method that gets 2 numbers from user and build set and return it
	public static aSet<Integer> createSetFromUser(){
		
		aSet<Integer> newSet = new aSet<Integer>();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers to create the new Set: \n");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
	
		newSet.insert(num1);
		newSet.insert(num2);		
		
		sc.close();
		
		return newSet;
	
	}
	
	public static void main(String[] args) {
		
		aSet<Integer> set1 = new aSet<Integer>();
		aSet<Integer> set2 = new aSet<Integer>();
		aSet<Integer> set3 = new aSet<Integer>();
		aSet<Integer> setFromUser = null;
		
		fillSetWithRandomNumbers(set1);
		fillSetWithRandomNumbers(set2);
		fillSetWithRandomNumbers(set3);
		
		System.out.println("Sets");
		System.out.println("Set 1 "+ set1);
		System.out.println("Set 2 "+ set2);
		System.out.println("Set 3 "+ set3);
		
		System.out.println("\nUnion of 2 first sets");
		set1.union(set2);
		System.out.println("Result "+ set1);
		
		System.out.println("\nIntersection of 2 remain sets");
		set1.intersect(set3);
		System.out.println("Result "+ set1);
		
		setFromUser = createSetFromUser();
		System.out.println("\nNew set received from User: "+ setFromUser);
		System.out.println("User set is subset of set 1:  "+ set1.isSubset(setFromUser));
		System.out.println("User set is subset of set 2:  "+ set2.isSubset(setFromUser));
		System.out.println("User set is subset of set 3:  "+ set3.isSubset(setFromUser));

		
	}
}
