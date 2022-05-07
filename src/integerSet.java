import java.util.Iterator;
import java.util.Random;

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
	
	//public static aSet<Integer> createSetFromUser(){
		
	//}
	
	public static void main(String[] args) {
		
		aSet<Integer> set1 = new aSet<Integer>();
		aSet<Integer> set2 = new aSet<Integer>();
		aSet<Integer> set3 = new aSet<Integer>();
		
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
		
	}
}
