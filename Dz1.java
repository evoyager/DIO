class Dz1 {
	public static void main(String[] args) {
			Employee[] employee = new Employee[3];
			employee[0] = new Employee("Ivan", "Ivanov", "DEVELOPER");
			employee[1] = new Employee("Dmitriy", "Dmitriev", "TESTER");
			employee[2] = new Employee("Petr", "Petrov", "MANAGER");
			System.out.println("V companii DREAM SOFT rabotaut takie sotrudniki: ");
			int count = 1;
			for(Employee emp:employee) {
				System.out.print(count + ". ");
				System.out.println(emp);
				count++;
			}
	}
}

class Employee {
	public enum Position {
			DIRECTOR, DEVELOPER, TESTER,
			QAENGINEER, TEAMLEAD, MANAGER
	}
	public Employee(String firstName, String secondName, String position) {
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