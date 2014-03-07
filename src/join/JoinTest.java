package join;

import hw1.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static join.Join.merge;
import static join.Join.rightJoin;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by EVGENIY on 06.03.14.
 */
public class JoinTest {
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
    public void testRightJoin() throws Exception {

        boolean ListsAreEquals = true;

        ArrayList<Person> joinList;
        ArrayList<Person> etalonList = new ArrayList<Person>();

        etalonList.add(person.get(2));
        etalonList.add(person.get(3));
        etalonList.add(person.get(4));
        etalonList.add(person.get(0));
        etalonList.add(person.get(1));

        joinList = rightJoin(leftList, rightList);

        for(int i = 0; i < joinList.size(); i++) {
            if ((etalonList.size() == joinList.size()) && (joinList.get(i).equals(etalonList.get(i))))
                ListsAreEquals = true;
            else {
                ListsAreEquals = false;
                break;
            }
        }
        assertEquals(ListsAreEquals, true);
    }

    @Test
    public void testRightJoinEqualsList() throws Exception {

        boolean ListsAreEquals = true;

        rightList = leftList;

        ArrayList<Person> joinList;
        ArrayList<Person> etalonList = new ArrayList<Person>();

        etalonList.add(person.get(0));
        etalonList.add(person.get(1));
        etalonList.add(person.get(0));
        etalonList.add(person.get(1));

        joinList = rightJoin(leftList, rightList);

        for(int i = 0; i < joinList.size(); i++) {
            if ((etalonList.size() == joinList.size()) && (joinList.get(i).equals(etalonList.get(i))))
                ListsAreEquals = true;
            else {
                ListsAreEquals = false;
                break;
            }
        }
        assertEquals(ListsAreEquals, true);
    }

    @Test
    public void testRightJoinNullLeftList() throws Exception {

        boolean ListsAreEquals = true;

        leftList.set(0, null);
        leftList.set(1, null);

        ArrayList<Person> joinList;
        ArrayList<Person> etalonList = new ArrayList<Person>();

        etalonList.add(person.get(2));
        etalonList.add(person.get(3));
        etalonList.add(person.get(4));

        etalonList.add(null);
        etalonList.add(null);

        joinList = rightJoin(leftList, rightList);

        try{
            for(int i = 0; i < joinList.size(); i++) {
                if ((etalonList.size() == joinList.size()) && (joinList.get(i).equals(etalonList.get(i))))
                    ListsAreEquals = true;
                else {
                    ListsAreEquals = false;
                    break;
                }
            }
        }catch(NullPointerException e){

        }
        assertEquals(ListsAreEquals, true);
    }

    @Test
    public void testRightJoinNullRightList() throws Exception {

        boolean ListsAreEquals = true;

        rightList.set(0, null);
        rightList.set(1, null);
        rightList.set(2, null);

        ArrayList<Person> joinList;
        ArrayList<Person> etalonList = new ArrayList<Person>();

        etalonList.add(person.get(0));
        etalonList.add(person.get(1));

        etalonList.add(null);
        etalonList.add(null);
        etalonList.add(null);

        joinList = rightJoin(leftList, rightList);

        try{
            for(int i = 0; i < joinList.size(); i++) {
                if ((etalonList.size() == joinList.size()) && (joinList.get(i).equals(etalonList.get(i))))
                    ListsAreEquals = true;
                else {
                    ListsAreEquals = false;
                    break;
                }
            }
        }catch(NullPointerException e){

        }
        assertEquals(ListsAreEquals, true);
    }

    @Test
    public void testRightJoinNullLists() throws Exception {

        boolean ListsAreEquals = true;

        leftList.set(0, null);
        leftList.set(1, null);

        rightList.set(0, null);
        rightList.set(1, null);
        rightList.set(2, null);

        ArrayList<Person> joinList= rightJoin(leftList, rightList);
        ArrayList<Person> etalonList = new ArrayList<Person>();

        try{
            for(int i = 0; i < 5; i++)
                etalonList.add(null);
            for(int i = 0; i < joinList.size(); i++) {
                if ((etalonList.size() == joinList.size()) && (joinList.get(i).equals(etalonList.get(i))))
                    ListsAreEquals = true;
                else {
                    ListsAreEquals = false;
                    break;
                }
            }
        }catch(NullPointerException e){}

        assertEquals(ListsAreEquals, true);
    }

    @Test
    public void testRightJoinEmptyLists() throws Exception {
        ArrayList<Person> leftList = new ArrayList<Person>();
        ArrayList<Person> rightList = new ArrayList<Person>();
        ArrayList<Person> joinList = rightJoin(leftList, rightList);
        assertEquals(joinList, new ArrayList<Person>());
    }

    @Test
    public void testMergeWithDublicates() throws Exception {

        boolean SetsAreEquals = false;

        HashSet<Person> mergeSet;

        mergeSet = merge(leftList, rightList);

        HashSet<Person> etalonSet = new HashSet<Person>();
        etalonSet.add(person.get(2));
        etalonSet.add(person.get(3));
        etalonSet.add(person.get(0));
        etalonSet.add(person.get(1));

        for(int i = 0; i < mergeSet.size(); i++) {
            if ((etalonSet.size() == mergeSet.size()) && (mergeSet.equals(etalonSet)))
                SetsAreEquals = true;
            else {
                SetsAreEquals = false;
                break;
            }
        }
        assertEquals(SetsAreEquals, true);
    }

    @Test
    public void testMergeWithoutDublicates() throws Exception {

        boolean SetsAreEquals = false;

        HashSet<Person> mergeSet;

        rightList.remove(person.get(4));

        mergeSet = merge(leftList, rightList);

        HashSet<Person> etalonSet = new HashSet<Person>();
        etalonSet.add(person.get(2));
        etalonSet.add(person.get(3));
        etalonSet.add(person.get(0));
        etalonSet.add(person.get(1));

        for(int i = 0; i < mergeSet.size(); i++) {
            if ((etalonSet.size() == mergeSet.size()) && (mergeSet.equals(etalonSet)))
                SetsAreEquals = true;
            else {
                SetsAreEquals = false;
                break;
            }
        }
        assertEquals(SetsAreEquals, true);
    }
}
