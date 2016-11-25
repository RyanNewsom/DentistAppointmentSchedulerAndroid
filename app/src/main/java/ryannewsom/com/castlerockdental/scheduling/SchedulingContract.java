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
        /**
         * Show the user that the view is working
         * @param show - should show
         */
        void showWorking(boolean show);

        /**
         * Show successful request
         * @param alertDialog - alert dialog to be shown
         */
        void showSuccess(AlertDialog alertDialog);

        /**
         * Show that the request failed
         * @param alertDialog - error dialog
         */
        void showFailure(AlertDialog alertDialog);
    }

    interface Presenter extends BasePresenter {
        /**
         * Submit an appointment
         * @param firstName - user first name
         * @param lastName - user last name
         * @param contactInfo - user contact info
         */
        void submitAppointment(String firstName, String lastName, ContactInfo contactInfo);
    }
}
