package innerouterjoins;

import hw1.Person;

import java.util.Arrays;

import static join.Join.rightJoin;

/**
 * Created by EVGENIY on 25.02.14.
 */
public class ArraysHelperTest {

    public void testArrays(){

//        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
//        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        Person[] person = new Person[5];
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

        person[3] = new Person.Builder()
                .firstName("Alexandr")
                .secondName("Alexandrov")
                .position(Person.Position.TESTER)
                .build();

        person[4] = new Person.Builder(person[0])
                .build();

        Person[] leftArray = {person[0], person[1]};
        Person[] rightArray = {person[2], person[3], person[4]} ;

        System.out.print("First array: ");
        System.out.println(Arrays.toString(leftArray));

        System.out.print("Second array: ");
        System.out.println(Arrays.toString(rightArray));

        ArraysHelper helper = new ArraysHelper();

        Person[] innerJoinArray = helper.innerJoin(rightArray, leftArray);
        Person[] outerJoinArray = helper.outerJoin(leftArray, rightArray);
        Person[] rightJoinArray = rightJoin(leftArray, rightArray);

//        int[] innerJoinTrueArray = {1, 4, 5, 32};
//        int[] outerJoinTrueArray = {2, 3, 23, 24, 34, 45, 65, 78};

        Person[] innerJoinTrueArray = {person[0]};
        Person[] outerJoinTrueArray = {person[3], person[1], person[2]};

        System.out.print("Inner join array: ");
        System.out.print(Arrays.toString(innerJoinArray));
        System.out.println(" " + Arrays.equals(innerJoinArray, innerJoinTrueArray));

        System.out.print("Outer join array: ");
        System.out.print(Arrays.toString(outerJoinArray));
        System.out.println(" " + hw1.Person.equals(outerJoinArray, outerJoinTrueArray));

        System.out.print("Right join array: ");
        System.out.println(Arrays.toString(rightJoinArray));
    }
}

