package innerouterjoins;

import hw1.Person;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by EVGENIY on 25.02.14.
 */
public class ArraysHelper {

    public ArrayList<Person> innerJoin(ArrayList<Person> arr1, ArrayList<Person> arr2){
        ArrayList<Person> innerJoinArray = new ArrayList<Person>();
        for(Person pers:arr1){
            if((hw1.Person.personSearch(arr2, pers) >= 0) && (hw1.Person.personSearch(innerJoinArray, pers) < 0)){
                innerJoinArray.add(pers);
            }
        }

//        int zerroPosition = 0;
//        for(Person pers:innerJoinArray)
//            if (pers!=null)
//                zerroPosition++;
//
//        int innerJoinNewArrayLength = zerroPosition;
//        ArrayList<Person> innerJoinNewArray = new ArrayList<Person>();
//        int innerJoinNewArrayElement = 0;
//        for(Person pers:innerJoinArray){
//            if (pers != null) {
//                innerJoinNewArray.set(innerJoinNewArrayElement, pers);
//                innerJoinNewArrayElement++;
//            }
//        }

        return innerJoinArray;
    }

    public ArrayList<Person> outerJoin(ArrayList<Person> arr1, ArrayList<Person> arr2){
        ArrayList<Person> outerJoinArray = new ArrayList<Person>();
        for(Person pers:arr1){
            if(hw1.Person.personSearch(arr2, pers) < 0){
                outerJoinArray.add(pers);
            }
        }

//        int zerroPosition = 0;
//        for(Person pers:outerJoinArray)
//            if (pers!=null)
//                zerroPosition++;
//
//        int outerJoinNewArrayLength = zerroPosition;
//        ArrayList<Person> outerJoinNewArray = new ArrayList<Person>();
//        int outerJoinNewArrayElement = 0;
//        for(Person pers:outerJoinArray){
//            if (pers != null) {
//                outerJoinNewArray.set(outerJoinNewArrayElement, pers);
//                outerJoinNewArrayElement++;
//            }
//        }

        return outerJoinArray;
    }
}

