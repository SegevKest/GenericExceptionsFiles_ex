
public class Person implements Comparable<Person> {

	private String idNum;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	
	public Person(String idNumber, String fName, String lName, String birthDate) {
		
		idNum = idNumber;
		firstName = fName;
		lastName = lName;
		dateOfBirth = birthDate;
	}
	
	public int compareTo(Person otherPerson) {
		
			// This Person is lexicographically first
		if (this.idNum.compareTo(otherPerson.idNum) > 0)
			return 1;
		else {
			
			// Other Person is is lexicographically first
			if (this.idNum.compareTo(otherPerson.idNum) < 0) {
				
				return -1;
			}
			
			// Both are lexicographically equivalent
			return 0;
		}
		
	}
	
	
	public boolean equals(Object other) {
		
		if (other == null || !(other instanceof Person))
			return false;
		
		Person pToCheck = (Person)other;
		
		return this.idNum.equals(pToCheck.idNum);
	}
	
	
	public String toString() {
		
		return idNum + ", "+firstName + " "+ lastName;
	}
	
}
