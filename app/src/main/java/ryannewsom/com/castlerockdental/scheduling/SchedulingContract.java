package ryannewsom.com.castlerockdental.scheduling;

import android.app.AlertDialog;

import model.users.entityinfo.ContactInfo;
import ryannewsom.com.castlerockdental.base.BasePresenter;
import ryannewsom.com.castlerockdental.base.BaseView;

/**
 * Contract for View and Presenter of Scheduling an Appointment
 */
public interface SchedulingContract {
    interface View extends BaseView<SchedulingContract.Presenter> {
        void showWorking(boolean show);
        void showSuccess(AlertDialog alertDialog);
        void showFailure(AlertDialog alertDialog);
    }

    interface Presenter extends BasePresenter {
        public void submitAppointment(String firstName, String lastName, ContactInfo contactInfo);
    }
}
