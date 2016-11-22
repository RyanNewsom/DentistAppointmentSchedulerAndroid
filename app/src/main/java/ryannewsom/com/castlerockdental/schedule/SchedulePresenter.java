package ryannewsom.com.castlerockdental.schedule;

import model.appointment.Appointment;

/**
 * Created by Ryan on 11/21/2016.
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
