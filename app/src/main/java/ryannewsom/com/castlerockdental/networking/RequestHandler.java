package ryannewsom.com.castlerockdental.networking;

import java.util.List;

import model.appointment.Appointment;

/**
 * Created by Ryan on 11/22/2016.
 */

public interface RequestHandler {
    public List<Appointment> getScheduledAppointments();
    public List<Appointment> getAvailableAppointments();
    public boolean scheduleAppointment(Appointment updatedAppointment);
}
