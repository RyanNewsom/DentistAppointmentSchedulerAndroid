package model.appointment;

import java.util.Date;

import model.users.User;
import model.users.entityinfo.Office;

/**
 * Appointment
 */
public class Appointment {
    private String id;
    private User user;
    private Date time;
    private Office office;

    public Appointment(User user, Date time, Office office){
        this.user = user;
        this.time = time;
        this.office = office;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Date getTime() {
        return time;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "mId='" + id + '\'' +
                ", mUser=" + user +
                ", mTime=" + time +
                ", mOffice=" + office +
                '}';
    }
}
