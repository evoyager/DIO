class HomeWork1 {
	public static void main(String[] args) {
			Person[] person = new Person[4];
			person[0] = new Person("Ivan", "Ivanov", "DEVELOPER");
			person[1] = new Person("Dmitriy", "Dmitriev", "TESTER");
			person[2] = new Person("Petr", "Petrov", "MANAGER");
			person[3] = new Person("Ivan", "Ivanov", "DEVELOPER");
			
			System.out.println("V companii DREAM SOFT rabotaut takie sotrudniki: ");
			int count = 1;
			for(Person pers:person) {
				System.out.print(count + ". ");
				System.out.println(pers);
				count++;
			}
			System.out.println("person[0].equals(person[1]): " + person[0].equals(person[1]));
			System.out.println("person[0].equals(person[3]): " + person[0].equals(person[3]));
			System.out.println("person[0] == person[3]: " + (person[0]==person[3]));
			System.out.println("person[0].hashCode(): " + person[0].hashCode() + ", person[3].hashCode(): " + person[3].hashCode());
			person[3] = person[0];
			System.out.println("person[3] = person[0];" + "\n" + "person[0].equals(person[3]): " + person[0].equals(person[3]));
			System.out.println("person[0] == person[3]: " + (person[0]==person[3]));
			System.out.println("person[0].hashCode(): " + person[0].hashCode() + ", person[3].hashCode(): " + person[3].hashCode());
			
	}
}

class Person {
	public enum Position {
			DIRECTOR, DEVELOPER, TESTER,
			QAENGINEER, TEAMLEAD, MANAGER
	}
	public Person(String firstName, String secondName, String position) {
		setFirstName(firstName);
		setSecondName(secondName);
		setPosition(position);
	}
	
	public String toString() {
		return firstName + " " + secondName + " " + position;
	}
	
	private String firstName;
	private String secondName;
	private Position position;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setPosition(String position) {
		this.position = Position.valueOf(position);
	}
	
	public Position getPosition() {
		return position;
	}
}