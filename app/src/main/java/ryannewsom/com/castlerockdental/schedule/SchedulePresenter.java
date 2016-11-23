package ryannewsom.com.castlerockdental.schedule;

import model.appointment.Appointment;

/**
 * Presenter for the Scheduling data
 */

public class SchedulePresenter implements ScheduleContract.Presenter {
    private ScheduleContract.View mView;

    public SchedulePresenter(ScheduleContract.View view){
        mView = view;
    }
    @Override
    public void onViewReady() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void refreshUI() {
        mView.showScheduledAppointments(null);
    }

    @Override
    public void scheduledAppointmentClicked(Appointment appointment) {

    }
}
