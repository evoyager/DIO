package join;
/**
 * Created by EVGENIY on 18.02.14.
 */
import hw1.*;
public class Join {
    public static void main(String[] args) {
        Person[] person = new Person[4];
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


        Person[] leftArray = {person[0], person[1]};
        Person[] rightArray = {person[2], person[3]} ;
//        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
//        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        Person[] joinArray;
        joinArray = rightJoin(leftArray, rightArray);
        /*if (joinArray.length == leftArray.length + rightArray.length)
            System.out.println("Array is joined right!");*/
        for(Person arrayElement:joinArray)
            System.out.print(arrayElement + " ");
        System.out.println(" ");
        Person[] sortedArray, sortedLeftArray, sortedRightArray;
        sortedArray = sortArray(joinArray);
//        sortedLeftArray = sortArray(leftArray);
//        sortedRightArray = sortArray(rightArray);
        for(Person arrayElement:sortedArray)
            System.out.print(arrayElement + " ");
        System.out.println(" ");
        /*for(int arrayElement:sortedLeftArray)
            System.out.print(arrayElement + " ");
        System.out.println(" ");
        for(int arrayElement:sortedRightArray)
            System.out.print(arrayElement + " ");*/
        int[] etalonArray = {78, 65, 45, 34, 32, 32, 24, 23, 5, 5, 5, 4, 4, 3, 2, 1, 1};
        boolean ArraysAreEquals = false;
        for(int i = 0; i < sortedArray.length; i++) {
            if ((etalonArray.length == sortedArray.length) && (sortedArray[i].equals(etalonArray[i])))
                ArraysAreEquals = true;
            else {
                ArraysAreEquals = false;
                break;
            }
        }
        if (ArraysAreEquals) System.out.println("ARRAYS ARE EQUALS!");

    }
    public static Person[] rightJoin(Person[] leftArray, Person[] rightArray) {

        Person[] joinArray = new Person[leftArray.length + rightArray.length];
        for(int i = 0; i < rightArray.length; i++)
            joinArray[i] = rightArray[i];
        for(int i = 0; i < leftArray.length; i++)
            joinArray[rightArray.length+i] = leftArray[i];

//        boolean ArrayAreEquals = false;
//        for( int i = 0; i < joinArray.length; i++)
//            if (i < rightArray.length) {
//                if (joinArray[i] == rightArray[i])
//                    ArrayAreEquals = true;
//                else {
//                    ArrayAreEquals = false;
//                    break;
//                }
//            }
//            else {
//                if (joinArray[i] == leftArray[i-rightArray.length])
//                    ArrayAreEquals = true;
//                else {
//                    ArrayAreEquals = false;
//                    break;
//                }
//            }

//        if ((joinArray.length == leftArray.length + rightArray.length)&& ArrayAreEquals)
//            System.out.println("Arrays are joined right!");

        return joinArray;
    }

    public static Person[] sortArray(Person[] array) {
        Person max, buf;
        int pos;
        for(int i = 0; i < array.length; i++) {
            max = array[i];
            pos = i;
            for(int j = i+1; j < array.length; j++) {
//                if (array[j] > max) {
                  if (array[j].greater(max)) {
                    max = array[j];
                    pos = j;
                }
            }
            buf = array[i];
            array[i] = max;
            array[pos] = buf;
        }
        return array;
    }
}
