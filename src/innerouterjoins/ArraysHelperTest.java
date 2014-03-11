package innerouterjoins;

import hw1.Person;

import java.util.ArrayList;
import java.util.Arrays;

//import static join.Join.rightJoin;

/**
* Created by EVGENIY on 25.02.14.
*/
public class ArraysHelperTest {

    public void testArrays(){

//        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
//        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        ArrayList<Person> person = new ArrayList<Person>();

        person.add(new Person.Builder()
                .firstName("Ivan")
                .secondName("Ivanov")
                .position(Person.Position.DEVELOPER)
                .build());
        person.add(new Person.Builder()
                .firstName("Dmitriy")
                .secondName("Dmitriev")
                .position(Person.Position.TESTER)
                .build());

        person.add(new Person.Builder()
                .firstName("Petr")
                .secondName("Petrov")
                .position(Person.Position.MANAGER)
                .build());

        person.add(new Person.Builder()
                .firstName("Alexandr")
                .secondName("Alexandrov")
                .position(Person.Position.TESTER)
                .build());

        person.add(new Person.Builder(person.get(0))
                .build());

        ArrayList<Person> leftArray = new ArrayList<Person>();
        ArrayList<Person> rightArray = new ArrayList<Person>();

        leftArray.add(person.get(0));
        leftArray.add(person.get(1));

        rightArray.add(person.get(2));
        rightArray.add(person.get(3));
        rightArray.add(person.get(4));

//        Person[] leftArray = {person[0], person[1]};
//        Person[] rightArray = {person[2], person[3], person[4]} ;

        System.out.print("First array: ");
        System.out.println(leftArray);

        System.out.print("Second array: ");
        System.out.println(rightArray);

        ArraysHelper helper = new ArraysHelper();

        ArrayList<Person> innerJoinArray = new ArrayList<Person>();
        innerJoinArray = helper.innerJoin(rightArray, leftArray);
        ArrayList<Person> outerJoinArray1 = helper.outerJoin(leftArray, rightArray);
        ArrayList<Person> outerJoinArray2 = helper.outerJoin(rightArray, leftArray);
        //ArrayList<Person> outerJoinArray = rightJoin(outerJoinArray2, outerJoinArray1);

        //ArrayList<Person> rightJoinArray = rightJoin(leftArray, rightArray);

        ArrayList<Person> innerJoinTrueArray = new ArrayList<Person>();
        innerJoinTrueArray.add(person.get(0));
        ArrayList<Person> outerJoinTrueArray = new ArrayList<Person>();
        outerJoinTrueArray.add(person.get(3));
        outerJoinTrueArray.add(person.get(1));
        outerJoinTrueArray.add(person.get(2));

        System.out.print("Inner join array: ");
        System.out.print(innerJoinArray);
        System.out.println(" " + innerJoinArray.containsAll(innerJoinTrueArray));

        System.out.print("Outer join array: ");
//        System.out.print(outerJoinArray);
//        System.out.println(" " + outerJoinArray.containsAll(outerJoinTrueArray));
//
//        System.out.print("Right join array: ");
//        System.out.println(rightJoinArray);
    }
}

