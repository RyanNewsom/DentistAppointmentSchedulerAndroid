package ryannewsom.com.castlerockdental.schedule;

import java.util.List;

import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.base.BasePresenter;
import ryannewsom.com.castlerockdental.base.BaseView;

/**
 * Contract for the View and Presenters of an Appointment
 */
public interface AppointmentContract
{
    interface View extends BaseView<Presenter> {
        /**
         * Show the appointments
         * @param scheduledAppointments - latest list of scheduled appointments
         */
        void showAppointments(List<Appointment> scheduledAppointments);
    }

    interface Presenter extends BasePresenter {
        /**
         * UI needs to be refreshed
         */
        void refreshUI();

        /**
         * An Appointment was clicked
         * @param appointment - appointment that was clicked
         */
        void AppointmentClicked(Appointment appointment);
    }
}
