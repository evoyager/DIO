package org.diosoft.Calendar.Events;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by EVGENIY on 13.03.14.
 */
public class Event {
    private HashMap<String, Object> eventMap = new HashMap<String, Object>();

    private Calendar startTime, endTime;
    private boolean allDay;
    private String title;
    private String body;
    private List<String> eventAttenders;
    private UUID uid;

    public List<String> getEventAttenders() {
        return eventAttenders;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEventAttenders(List<String> eventAttenders) {
        this.eventAttenders = eventAttenders;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public UUID getUid() {
        return uid;
    }

    private Event(Builder builder){
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.allDay = builder.allDay;
        this.title = builder.title;
        this.body = builder.body;
        this.eventAttenders = builder.eventAttenders;
        this.uid = builder.uid;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        return "Start time: " + sdf.format(startTime.getTime()) + ", End time: " + sdf.format(endTime.getTime()) +
                ", uid: " + uid + ", title: " + title + ", body: " + body + "\neventAttenders: " + eventAttenders;
    }

    public static class Builder {
        private Calendar startTime, endTime;
        private boolean allDay;
        private String title;
        private String body;
        private List<String> eventAttenders;
        private UUID uid;

        public Builder() {}

        public Builder(Event original){
            this.startTime = original.startTime;
            this.endTime = original.endTime;
            this.allDay = original.allDay;
            this.title = original.title;
            this.body = original.body;
            this.eventAttenders = original.eventAttenders;
            this.uid = original.uid;
        }

        public Builder setUid(UUID uid) {
            this.uid = uid;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setAllDay(boolean allDay) {
            if (allDay == true){
                int year = startTime.get(Calendar.YEAR);
                int month = startTime.get(Calendar.MONTH);
                int dayOfMonth = startTime.get(Calendar.DAY_OF_MONTH);
                endTime = new GregorianCalendar(year, month, dayOfMonth+1, 00, 00, 00);
            }
            this.allDay = allDay;
            return this;
        }

        public Builder setStartTime(Calendar startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(Calendar endTime) {

            this.endTime = endTime;
            return this;
        }

        public Builder setListOfAttenders(List<String> eventAttenders) {
            this.eventAttenders = eventAttenders;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }
}
