package join;

import hw1.Person;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by EVGENIY on 11.03.14.
 */
public class JoinMerge {
    private final Join join ;

    public JoinMerge(Join join) {
        this.join = join;
    }

    public  HashSet<Person> joinMerge(ArrayList<Person> leftArray, ArrayList<Person> rightArray,ArrayList<Person> thirdArray) {
        ArrayList<Person> resultArray = new ArrayList<Person>();
        resultArray = join.rightJoin(leftArray, rightArray);
        HashSet<Person> set = new HashSet<Person>();
        set = join.merge(resultArray, thirdArray);

        return set;
    }
}
