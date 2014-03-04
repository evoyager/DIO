package join;
/**
 * Created by EVGENIY on 18.02.14.
 */
import hw1.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Join {
    public static void main(String[] args) {
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
        ArrayList<Person> joinArray;
        joinArray = rightJoin(leftArray, rightArray);

        for(Person arrayElement:joinArray)
            System.out.print(arrayElement + " ");
        System.out.println(" ");

        ArrayList<Person> etalonArray = new ArrayList<Person>();

        etalonArray.add(person.get(2));
        etalonArray.add(person.get(3));
        etalonArray.add(person.get(4));
        etalonArray.add(person.get(0));
        etalonArray.add(person.get(1));

        System.out.println(etalonArray);

        boolean ListsAreEquals = false;
        for(int i = 0; i < joinArray.size(); i++) {
            if ((etalonArray.size() == joinArray.size()) && (joinArray.get(i).equals(etalonArray.get(i))))
                ListsAreEquals = true;
            else {
                ListsAreEquals = false;
                break;
            }
        }
        if (ListsAreEquals) System.out.println("ARRAYS ARE EQUALS!");

        HashSet<Person> mergeSet;

        mergeSet = merge(leftArray, rightArray);
        System.out.println(mergeSet);

        HashSet<Person> etalonSet = new HashSet<Person>();
        etalonSet.add(person.get(2));
        etalonSet.add(person.get(3));
        etalonSet.add(person.get(0));
        etalonSet.add(person.get(1));
        System.out.println(etalonSet);

        boolean SetsAreEquals = false;
        for(int i = 0; i < mergeSet.size(); i++) {
            //if ((etalonSet.size() == mergeSet.size()) && (mergeSet.get(i).equals(etalonSet.get(i))))
            if ((etalonSet.size() == mergeSet.size()) && (mergeSet.equals(etalonSet)))
                SetsAreEquals = true;
            else {
                SetsAreEquals = false;
                break;
            }
        }
        if (SetsAreEquals) System.out.println("SETS ARE EQUALS!");

    }
    public static ArrayList<Person> rightJoin(ArrayList<Person> leftArray, ArrayList<Person> rightArray) {

        ArrayList<Person> joinArray = new ArrayList<Person>();
        for(int i = 0; i < rightArray.size(); i++)
            joinArray.add(rightArray.get(i));
        for(int i = 0; i < leftArray.size(); i++)
            joinArray.add(leftArray.get(i));

        return joinArray;
    }

    public static HashSet<Person> merge(ArrayList<Person> leftArray, ArrayList<Person> rightArray){
        HashSet<Person> set = new HashSet<Person>();
        for(Person pers:leftArray)
            set.add(pers);
        for(Person pers:rightArray)
            set.add(pers);
        return set;
    }

}
