package hw1;//local code review: do not put two separated classes into the one file @ 16.02.14

public class Person {
    //local code review (vtegza): put it as standalone class or make it static @ 16.02.14
    public enum Position {
        DIRECTOR, DEVELOPER, TESTER,
        QAENGINEER, TEAMLEAD, MANAGER
    }
    public Person(String firstName, String secondName, Position position) {
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

    public boolean equals(Object obj){
        if (!(obj instanceof Person))
            return false;
        Person person = (Person)obj;
        return firstName.equals(person.firstName) &&
                secondName.equals(person.secondName) &&
                position.equals(person.position);
    }

    public int hashCode(){
        int hash = 37;
        hash = hash + firstName.hashCode();
        hash = hash + secondName.hashCode();
        hash = hash + position.hashCode();
        return hash;
    }


    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public final String getSecondName() {
        return secondName;
    }

    public final void setPosition(Position position) {
        this.position = position;
    }

    public final Position getPosition() {
        return position;
    }
}