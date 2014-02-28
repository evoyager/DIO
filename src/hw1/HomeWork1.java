package hw1;//local code review (vtegza): create java project @ 16.02.14
//local code review: use public access @ 16.02.14

public class HomeWork1 {
    public static void main(String[] args) {
        Person[] person = new Person[4];
        //local code review (vtegza): in most of cases it is more handy to put enum value instead of string @ 16.02.14
        person[0] = new Person.Builder()
                .firstName("Ivan")
                .secondName("Ivanov")
                .position(Person.Position.DEVELOPER)
                .build();

        person[1] = new Person.Builder()
                .firstName("Dmitriy")
                .secondName("Dmitriev")
                .position(Person.Position.TESTER)
                .build();

        person[2] = new Person.Builder()
                .firstName("Petr")
                .secondName("Petrov")
                .position(Person.Position.MANAGER)
                .build();

//        person[3] = new Person.Builder()
//                .firstName("Ivan")
//                .secondName("Ivanov")
//                .position(Person.Position.DEVELOPER)
//                .build();

        person[3] = new Person.Builder(person[0])
                .build();

//        person[1] = new Person("Dmitriy", "Dmitriev", Person.Position.TESTER);
//        person[2] = new Person("Petr", "Petrov", Person.Position.MANAGER);
//        person[3] = new Person("Ivan", "Ivanov", Person.Position.DEVELOPER);

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