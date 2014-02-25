package innerouterjoins;

import java.util.Arrays;

/**
 * Created by EVGENIY on 25.02.14.
 */
public class ArraysHelper {

    public int[] innerJoin(int[] arr1, int[] arr2){
        int innerJoinArrayLength = arr1.length + arr2.length;
        int[] innerJoinArray = new int[innerJoinArrayLength];
        int innerJoinArrayEnd = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int num1:arr1){
            if((Arrays.binarySearch(arr2, num1) >= 0) && (Arrays.binarySearch(innerJoinArray, num1) < 0)){
                innerJoinArray[innerJoinArrayEnd] = num1;
                innerJoinArrayEnd++;
                Arrays.sort(innerJoinArray);
            }
        }

        int zerroPosition = 0;
        for(int num:innerJoinArray)
            if (num!=0)
                zerroPosition++;

        int innerJoinNewArrayLength = zerroPosition;
        int[] innerJoinNewArray = new int[innerJoinNewArrayLength];
        int innerJoinNewArrayElement = 0;
        for(int num:innerJoinArray){
            if (num != 0) {
                innerJoinNewArray[innerJoinNewArrayElement] = num;
                innerJoinNewArrayElement++;
            }
        }

        return innerJoinNewArray;
    }

    public int[] outerJoin(int[] arr1, int[] arr2){
        int outerJoinArrayLength = arr1.length + arr2.length;
        int[] outerJoinArray = new int[outerJoinArrayLength];
        int outerJoinArrayEnd = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int num:arr1){
            if(Arrays.binarySearch(arr2, num) < 0){
                outerJoinArray[outerJoinArrayEnd] = num;
                outerJoinArrayEnd++;
            }
        }

        for(int num:arr2){
            if(Arrays.binarySearch(arr1, num) < 0){
                outerJoinArray[outerJoinArrayEnd] = num;
                outerJoinArrayEnd++;
            }
        }

        int outerJoinNewArrayLength = Arrays.binarySearch(outerJoinArray, 0);
        int[] outerJoinNewArray = new int[outerJoinNewArrayLength];
        int outerJoinNewArrayElement = 0;
        for(int num:outerJoinArray){
            if (num != 0) {
                outerJoinNewArray[outerJoinNewArrayElement] = num;
                outerJoinNewArrayElement++;
            }
        }
        Arrays.sort(outerJoinNewArray);
        return outerJoinNewArray;
    }
}

