package ryannewsom.com.castlerockdental.scheduling;

import android.app.AlertDialog;

import model.users.entityinfo.ContactInfo;
import ryannewsom.com.castlerockdental.base.BasePresenter;
import ryannewsom.com.castlerockdental.base.BaseView;
import ryannewsom.com.castlerockdental.schedule.AppointmentContract;

/**
 * Created by Ryan on 11/23/2016.
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
