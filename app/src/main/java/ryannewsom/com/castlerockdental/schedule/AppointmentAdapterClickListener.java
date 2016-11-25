package ryannewsom.com.castlerockdental.schedule;

import model.appointment.Appointment;

/**
 * When an individual Appointment gets clicked
 */
public interface AppointmentAdapterClickListener {
    public void onAppointmentClicked(Appointment appointment);
}
