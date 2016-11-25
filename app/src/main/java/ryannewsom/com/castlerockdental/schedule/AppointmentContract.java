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
        void showAppointments(List<Appointment> scheduledAppointments);
    }

    interface Presenter extends BasePresenter {
        void refreshUI();
        void AppointmentClicked(Appointment appointment);
    }
}
