package org.diosoft.Calendar.Events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by EVGENIY on 14.03.14.
 */
public class EventDriver {

    static ArrayList<Event> eventList = new ArrayList<Event>();

    enum eventKeys {STARTTIME, ENDTIME, ALLDAY, TITLE, BODY, EVENTATTENDERS, UID}

    public static void main(String[] args) throws ParseException {

        //INITIALIZATION
        System.out.println("INITIALIZATION");
        ArrayList<String> listOfAttenders =  new ArrayList<String>();

        listOfAttenders.add("vtegza@dio-soft.com");
        listOfAttenders.add("evgeniygusar@gmail.com");
        listOfAttenders.add("shapoval.ivan.ivanovich@gmail.com");
        listOfAttenders.add("sytniuk@gmail.com");
        listOfAttenders.add("nchigir@dio-soft.com");
        listOfAttenders.add("kshraiber@dio-soft.com");

        eventList.add(new Event.Builder()
                .setUid(UUID.fromString("d849f178-b062-4fd6-b79c-0b824a7b0c"))
                        //.setUid(UUID.randomUUID())
                .setTitle("End of DIO-soft courses")
                .setBody("Otprazdnovat okonchanie!")
                .setStartTime(new GregorianCalendar(2014, 2, 27, 11, 00, 00))
                .setAllDay(true)
                .setListOfAttenders(listOfAttenders)
                .build()
        );

        ArrayList<String> listOfAttenders2 =  new ArrayList<String>();

        listOfAttenders2.add("I");
        listOfAttenders2.add("Girlfriend");
        listOfAttenders2.add("Dima Smirnov");
        listOfAttenders2.add("Misha Shalimov");
        listOfAttenders2.add("Brother");
        listOfAttenders2.add("Mother");
        listOfAttenders2.add("Father");
        listOfAttenders2.add("Grandfather");
        listOfAttenders2.add("Grandmother");

        eventList.add(new Event.Builder()
                .setUid(UUID.fromString("477491d5-fe71-45e8-a1c9-986ec1905249"))
                        //.setUid(UUID.randomUUID())
                .setTitle("My Birthday")
                .setBody("Otprazdnovat s rodstvennikami i druziami")
                .setStartTime(new GregorianCalendar(2014, 4, 15, 17, 30, 00))
                .setAllDay(true)
                .setListOfAttenders(listOfAttenders2)
                .build()
        );

        printEventList(eventList);


        //FINDING EVENT
        System.out.println("\nFINDING EVENT");
        //findEvent(UUID.fromString("d849f178-b062-4fd6-b79c-0b824a7b0c"));
        System.out.println(findEvent(UUID.fromString("477491d5-fe71-45e8-a1c9-986ec1905249")));

        //EDITING
        System.out.println("\nEDITING");
        editEvent(UUID.fromString("477491d5-fe71-45e8-a1c9-986ec1905249"), eventKeys.EVENTATTENDERS, "sasha;petya;kolia");

        //SEARCH BY DATE
        System.out.println("\nSEARCH BY DATE");
        List<Event> searchList;
        searchList = search(new GregorianCalendar(2014, 4, 15, 17, 30, 00));
        printEventList(searchList);

        //IS PERSON AVAILABLE
        System.out.println("\nIS PERSON AVAILABLE");
        Person I = new Person();
        I.email = "evgeniygusar@gmail.com";
        boolean checkAvailable = isPersonAvailable(I, new GregorianCalendar(2014, 4, 15, 17, 30, 00));
        System.out.println(checkAvailable);

        //CHECK AVAILABILITY
        System.out.println("\nCHECK AVAILABILITY");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        List<Calendar> checkAvailabilityList;

        checkAvailabilityList = checkAvailability(I);

        for(Calendar c:checkAvailabilityList)
                System.out.println(sdf.format(c.getTime()));

        Person person = new Person();
        person.email = "kolia";

        checkAvailabilityList = checkAvailability(I, person);

        for(Calendar c:checkAvailabilityList)
            System.out.println(sdf.format(c.getTime()));


        //DELETING
        System.out.println("\nDELETING");
        System.out.println("\nBefore deleting: ");
        printEventList(eventList);

        System.out.println("\nAfter deleting: ");
        deleteEvent(UUID.fromString("d849f178-b062-4fd6-b79c-0b824a7b0c"));
        printEventList(eventList);

    }

    public static void printEventList(List<Event> eventList){
        int eventCounter = 1;
        for(Event e: eventList){
            System.out.println("[" + eventCounter + "] " + e);
            eventCounter++;
        }
    }

    public static List <Calendar> checkAvailability(Person... persons){
        List <Calendar> checkAvailabilityList = new ArrayList<Calendar>();
        for(Person p: persons){
            for(Event e:eventList){
                if (e.getEventAttenders().contains(p.email))
                    checkAvailabilityList.add(e.getStartTime());
            }

        }
        return checkAvailabilityList;
    }

    public static boolean isPersonAvailable(Person person, Calendar desireDate){
        List<Event> searchList = new ArrayList<Event>();
        for(Event e:eventList){
            if((e.getStartTime().getTimeInMillis() <= desireDate.getTimeInMillis()) &&
                    (e.getEndTime().getTimeInMillis() > desireDate.getTimeInMillis()) &&
                    (e.getEventAttenders().contains(person.email)))
                return false;
        }
        return true;
    }

    public static List<Event> search(Calendar date){
        List<Event> searchList = new ArrayList<Event>();
        for(Event e:eventList){
            if((e.getStartTime().getTimeInMillis() <= date.getTimeInMillis()) && (e.getEndTime().getTimeInMillis() > date.getTimeInMillis()))
                searchList.add(e);
        }
        return searchList;
    }

    public static Event findEvent(UUID uid){
        for(Event e: eventList){
            if(e.getUid().equals(uid)){
                //System.out.println("Founded event: ");
                //System.out.println(e);
                //System.out.println(eventList.indexOf(e));
                return e;
            }
        }
        //System.out.println("Event not found.");
        return null;
    }

    public static void deleteEvent(UUID uid){
        Event e = findEvent(uid);
        eventList.remove(e);
    }

    public static void editEvent(UUID uid, eventKeys key, String value) throws ParseException {

        Event e = findEvent(uid);
        //STARTTIME, ENDTIME, ALLDAY, TITLE, BODY, EVENTATTENDERS, UID
        switch (key)
        {
            case STARTTIME:
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
                cal.setTime(sdf.parse(value));
                e.setStartTime(cal);
                break;
            case ENDTIME:
                Calendar cal2 = Calendar.getInstance();
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
                cal2.setTime(sdf2.parse(value));
                e.setEndTime(cal2);

                break;
            case ALLDAY:
                if(value.equals("true"))
                    e.setAllDay(true);
                else if (value.equals("false"))
                    e.setAllDay(false);
                break;
            case TITLE:
                e.setTitle(value);
                break;
            case BODY:
                e.setBody(value);
                break;
            case EVENTATTENDERS:
                List<String> eventAttendersList = new ArrayList<String>();
                String[] eventAttenders;
                eventAttenders = value.split(";");
                for(String s: eventAttenders)
                    eventAttendersList.add(s);
                e.setEventAttenders(eventAttendersList);
                break;
            case UID:
                e.setUid(UUID.fromString(value));
                break;
        }
        System.out.println(e);
    }
}
