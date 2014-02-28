package hw1;

import java.util.Comparator;

public class Person implements Comparator<Person>, Comparable<Person> {

    public int compareTo(Person p){
        return (this.firstName).compareTo(p.firstName);
    }

    public int compare(Person p1, Person p2){
        return (p1.firstName.compareTo(p2.firstName));
    }

    public boolean greater(Person p){
        if ((this.firstName).compareTo(p.firstName) > 0)
            return true;
        else return false;
    }


    private final String firstName;
    private final String secondName;
    private final Position position;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.position = builder.position;
    }

    public final String getFirstName() {
        return firstName;
    }
    public final String getSecondName() {
        return secondName;
    }
    public final Position getPosition() {
        return position;
    }


    public enum Position {
        DIRECTOR, DEVELOPER, TESTER,
        QAENGINEER, TEAMLEAD, MANAGER
    }
//    public Person(String firstName, String secondName, Position position) {
//        setFirstName(firstName);
//        setSecondName(secondName);
//        setPosition(position);
//    }

    public static int personSearch(Person[] array, Person person) throws NullPointerException{
        for(int i = 0; i < array.length; i++){
            try{
                if (array[i].equals(person))
                    return i;
            }catch(NullPointerException e){
            }
        }
        return -1;
    }

    public static boolean equals(Person[] arr1, Person[] arr2){
        boolean arraysAreEqual = true;
        for(int i = 0; i < arr1.length; i++){
            if((arr1[i].equals(arr2[i]))&&(arr1.length == arr2.length));
            else {
                arraysAreEqual = false;
                return arraysAreEqual;
            }
        }
        return arraysAreEqual;
    }

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

    public String toString() {
        return firstName + " " + secondName + " " + position;
    }

    public static class Builder {
        private String firstName;
        private String secondName;
        private Person.Position position;

        public Builder() {

        }

        public Builder(Person original){
            this.firstName = original.firstName;
            this.secondName = original.secondName;
            this.position = original.position;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName){
            this.secondName = secondName;
            return this;
        }

        public Builder position(Person.Position position){
            this.position = position;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

//    public final void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public final void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//    public final void setPosition(Position position) {
//        this.position = position;
//    }


}