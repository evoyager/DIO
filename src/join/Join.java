package join;
/**
 * Created by EVGENIY on 18.02.14.
 */
public class Join {
    public static void main(String[] args) {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] joinArray;
        joinArray = leftJoin(leftArray, rightArray);
        /*if (joinArray.length == leftArray.length + rightArray.length)
            System.out.println("Array is joined right!");*/
        for(int arrayElement:joinArray)
            System.out.print(arrayElement + " ");
        System.out.println(" ");
        int[] sortedArray, sortedLeftArray, sortedRightArray;
        sortedArray = sortArray(joinArray);
        sortedLeftArray = sortArray(leftArray);
        sortedRightArray = sortArray(rightArray);
        for(int arrayElement:sortedArray)
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
            if ((etalonArray.length == sortedArray.length) && (sortedArray[i] == etalonArray[i]))
                ArraysAreEquals = true;
            else {
                ArraysAreEquals = false;
                break;
            }
        }
        if (ArraysAreEquals) System.out.println("ARRAYS ARE EQUALS!");

    }
    public static int[] leftJoin(int[] leftArray, int[] rightArray) {

        int[] joinArray = new int[leftArray.length + rightArray.length];
        for(int i = 0; i < leftArray.length; i++)
            joinArray[i] = leftArray[i];
        for(int i = 0; i < rightArray.length; i++)
            joinArray[i+leftArray.length] = rightArray[i];

        boolean ArrayAreEquals = false;
        for( int i = 0; i < joinArray.length; i++)
            if (i < leftArray.length) {
                if (joinArray[i] == leftArray[i])
                    ArrayAreEquals = true;
                else {
                    ArrayAreEquals = false;
                    break;
                }
            }
            else {
                if (joinArray[i] == rightArray[i-leftArray.length])
                    ArrayAreEquals = true;
                else {
                    ArrayAreEquals = false;
                    break;
                }
            }

        if ((joinArray.length == leftArray.length + rightArray.length)&& ArrayAreEquals)
            System.out.println("Arrays are joined right!");

        return joinArray;
    }

    public static int[] sortArray(int[] array) {
        int max, pos, buf;
        for(int i = 0; i < array.length; i++) {
            max = array[i];
            pos = i;
            for(int j = i+1; j < array.length; j++) {
                if (array[j] > max) {
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
