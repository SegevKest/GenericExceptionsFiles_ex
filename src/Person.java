//Created the Person Class for Q1.C
// The person will have ID, First and Last name and Date of Birth
// The person will implement the Comparable interface - so it will be able to compare 2 persons.
public class Person implements Comparable<Person> {

	private String idNum;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	
	// constructor of Person Class
	// Gets ID, First and Last name and BirthDate
	public Person(String idNumber, String fName, String lName, String birthDate) throws IllegalArgumentException {
		
		if ( idContainsLetters(idNumber))
			throw new IllegalArgumentException("The id must include only digits!");
			
		idNum = idNumber;
		firstName = fName;
		lastName = lName;
		dateOfBirth = birthDate;
	}
	
	
	// The compareTo method as required, due to implementation of Comparable interface
	// Compare the Persons with ID number.
	public int compareTo(Person otherPerson) {
		
			// This Person is lexicographically first
		if (this.idNum.compareTo(otherPerson.idNum) > 0)
			return 1;
		else {
			// Other Person is is lexicographically first
			if (this.idNum.compareTo(otherPerson.idNum) < 0) 
				return -1;
		}		
		// Both are lexicographically equivalent
		return 0;
	}
	
	
	// Override the Equals method, to check equality of 2 Persons - with their ID
	public boolean equals(Object other) {
		
		if (other == null || !(other instanceof Person))
			return false;
		
		Person pToCheck = (Person)other;
		
		return this.idNum.equals(pToCheck.idNum);
	}
	
	
	// Override the toString method -  print the person's details.
	public String toString() {
		
		return "ID: "+idNum + "\nName: "+firstName + " "+ lastName + "\nDate Of Birth: "+dateOfBirth;
	}
	
	
	private boolean idContainsLetters(String givenIdNum) {
		
		for ( int i = 0; i<givenIdNum.length(); i++) {
			
			if (! Character.isDigit(givenIdNum.charAt(i)))
				return true;
			
		}
		return false;
	}
}
