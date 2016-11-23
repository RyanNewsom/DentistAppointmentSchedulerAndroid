package model.appointment;

import android.text.format.DateFormat;

import java.util.Date;

import model.users.User;
import model.users.entityinfo.Office;

/**
 * Appointment
 */
public class Appointment {
    private String id;
    private User user;
    private Date date;
    private long time;
    private Office office;

    public Appointment(User user,Office office, long time){
        this.user = user;
        this.office = office;
        this.time = time;
    }

    private Appointment(){
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Office getOffice() {
        return office;
    }

    public void setAppointmentId(final String id) {
        this.id = id;
    }

    public String getAppointmentId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public String getFormattedLocalTime(){
        date = new Date(time);
        String formattedTime = null;

        DateFormat df = new android.text.format.DateFormat();
        formattedTime = (String) df.format("MM-dd hh:mm aaa", new Date(time));
        return formattedTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "mId='" + id + '\'' +
                ", mUser=" + user +
                ", mTime=" + date +
                ", mOffice=" + office +
                '}';
    }
}
