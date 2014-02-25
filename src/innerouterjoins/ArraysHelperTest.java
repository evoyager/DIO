package innerouterjoins;

import java.util.Arrays;

/**
 * Created by EVGENIY on 25.02.14.
 */
public class ArraysHelperTest {

    public void testArrays(){

        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        ArraysHelper helper = new ArraysHelper();

        int[] innerJoinArray = helper.innerJoin(rightArray, leftArray);
        int[] outerJoinArray = helper.outerJoin(leftArray, rightArray);

        int[] innerJoinTrueArray = {1, 4, 5, 32};
        int[] outerJoinTrueArray = {2, 3, 23, 24, 34, 45, 65, 78};

        System.out.println(Arrays.toString(innerJoinArray));
        System.out.println(Arrays.equals(innerJoinArray, innerJoinTrueArray));

        System.out.println(Arrays.toString(outerJoinArray));
        System.out.println(Arrays.equals(outerJoinArray, outerJoinTrueArray));
    }
}

