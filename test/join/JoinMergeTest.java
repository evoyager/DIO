package join;

import hw1.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.mockito.Mockito.*;

/**
 * Created by EVGENIY on 11.03.14.
 */
public class JoinMergeTest {
    ArrayList<Person> person = new ArrayList<Person>();
    ArrayList<Person> leftList= new ArrayList<Person>();
    ArrayList<Person> rightList = new ArrayList<Person>();

    @Before
    public void setUp(){

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

        leftList.add(person.get(0));
        leftList.add(person.get(1));

        rightList.add(person.get(2));
        rightList.add(person.get(3));
        rightList.add(person.get(4));
    }

    @Test
    public void testJoinMerge() throws Exception {

        //input
        Join join = mock(Join.class);

        ArrayList<Person> ar1 = leftList;
        ArrayList<Person> ar2 = rightList;

        ArrayList<Person>result1 = new  ArrayList<Person>();

        result1.add(person.get(2));
        result1.add(person.get(3));
        result1.add(person.get(4));
        result1.add(person.get(0));
        result1.add(person.get(1));

        ArrayList<Person> ar3 = ar2;

        HashSet<Person> result2 = new HashSet<Person>();

        result1.add(person.get(2));
        result1.add(person.get(3));
        result1.add(person.get(4));
        result1.add(person.get(0));
        result1.add(person.get(1));

        when(join.rightJoin(ar1,ar2)).thenReturn(result1);

        result2.add(person.get(2));
        result2.add(person.get(3));
        result2.add(person.get(0));
        result2.add(person.get(1));

        when(join.merge(result1, ar3)).thenReturn(result2);

        JoinMerge testClass = new JoinMerge(join);

        HashSet<Person> result3 = new HashSet<Person>();

        result3 = testClass.joinMerge(ar1,ar2,ar3);

        verify(join).merge(result1,ar3);
        verify(join).rightJoin(ar1, ar2);
        verifyNoMoreInteractions(join);
    }
}
