package model.appointment;

import android.text.format.DateFormat;

import java.io.Serializable;
import java.util.Date;

import model.users.User;
import model.users.entityinfo.Office;

/**
 * Appointment
 */
public class Appointment implements Serializable{
    private String appointmentId;
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
        this.appointmentId = id;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public long getTime() {
        return time;
    }

    public String getFormattedLocalTime(){
        String formattedTime = null;
        date = new Date(time);

        DateFormat df = new android.text.format.DateFormat();
        formattedTime = (String) df.format("MM-dd hh:mm aaa", new Date(time));
        return formattedTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "mId='" + appointmentId + '\'' +
                ", mUser=" + user +
                ", mTime=" + date +
                ", mOffice=" + office +
                '}';
    }
}
