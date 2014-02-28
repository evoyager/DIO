package innerouterjoins;

import hw1.Person;

import java.util.Arrays;

/**
 * Created by EVGENIY on 25.02.14.
 */
public class ArraysHelper {

    public Person[] innerJoin(Person[] arr1, Person[] arr2){
        int innerJoinArrayLength = arr1.length + arr2.length;
        Person[] innerJoinArray = new Person[innerJoinArrayLength];
        int innerJoinArrayEnd = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(Person pers:arr1){
            //if((Arrays.binarySearch(arr2, pers) >= 0) && (Arrays.binarySearch(innerJoinArray, pers) < 0)){
            if((hw1.Person.personSearch(arr2, pers) >= 0) && (hw1.Person.personSearch(innerJoinArray, pers) < 0)){
                innerJoinArray[innerJoinArrayEnd] = pers;
                innerJoinArrayEnd++;
                //Arrays.sort(innerJoinArray);
            }
        }

        int zerroPosition = 0;
        for(Person pers:innerJoinArray)
            if (pers!=null)
                zerroPosition++;

        int innerJoinNewArrayLength = zerroPosition;
        Person[] innerJoinNewArray = new Person[innerJoinNewArrayLength];
        int innerJoinNewArrayElement = 0;
        for(Person pers:innerJoinArray){
            if (pers != null) {
                innerJoinNewArray[innerJoinNewArrayElement] = pers;
                innerJoinNewArrayElement++;
            }
        }

        return innerJoinNewArray;
    }

    public Person[] outerJoin(Person[] arr1, Person[] arr2){
        int outerJoinArrayLength = arr1.length + arr2.length;
        Person[] outerJoinArray = new Person[outerJoinArrayLength];
        int outerJoinArrayEnd = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(Person pers:arr1){
            if(Arrays.binarySearch(arr2, pers) < 0){
                outerJoinArray[outerJoinArrayEnd] = pers;
                outerJoinArrayEnd++;
            }
        }

        for(Person pers:arr2){
            if(Arrays.binarySearch(arr1, pers) < 0){
                outerJoinArray[outerJoinArrayEnd] = pers;
                outerJoinArrayEnd++;
            }
        }

        int zerroPosition = 0;
        for(Person pers:outerJoinArray)
            if (pers!=null)
                zerroPosition++;

        //int outerJoinNewArrayLength = Arrays.binarySearch(outerJoinArray, null);
        int outerJoinNewArrayLength = zerroPosition;
        Person[] outerJoinNewArray = new Person[outerJoinNewArrayLength];
        int outerJoinNewArrayElement = 0;
        for(Person pers:outerJoinArray){
            if (pers != null) {
                outerJoinNewArray[outerJoinNewArrayElement] = pers;
                outerJoinNewArrayElement++;
            }
        }
        Arrays.sort(outerJoinNewArray);
        return outerJoinNewArray;
    }
}

