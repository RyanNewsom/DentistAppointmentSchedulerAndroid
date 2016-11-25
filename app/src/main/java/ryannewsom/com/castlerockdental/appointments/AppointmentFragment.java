package ryannewsom.com.castlerockdental.appointments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.R;
import ryannewsom.com.castlerockdental.scheduling.ScheduleAppointmentFragment;

/**
 */
public class AppointmentFragment extends Fragment {
    protected Appointment mAppointment;

    @BindView(R.id.firstname_textview)
    protected EditText mFirstNameView;

    @BindView(R.id.lastname_textview)
    protected EditText mLastNameView;

    @BindView(R.id.streetnum_textview)
    protected EditText mStreetNumView;

    @BindView(R.id.street_textview)
    protected EditText mStreetNameView;

    @BindView(R.id.zipcode_textview)
    protected EditText mZipView;

    @BindView(R.id.city_textview)
    protected EditText mCityView;

    @BindView(R.id.state_textview)
    protected EditText mStateView;

    @BindView(R.id.cellnumber_textview)
    protected EditText mCellNumberView;

    @BindView(R.id.date_textview)
    protected TextView mDateView;

    public AppointmentFragment() {
        // Required empty public constructor
    }

    /**
     * Creates a new instance
     * @param appointment - appointment to be viewed
     * @return - new instance
     */
    public static AppointmentFragment newInstance(Appointment appointment) {
        AppointmentFragment fragment = new AppointmentFragment();
        Bundle args = new Bundle();

        args.putSerializable(ScheduleAppointmentFragment.APPOINTMENT, appointment);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        if (bundle != null) {
            mAppointment = (Appointment) bundle.getSerializable(
                    ScheduleAppointmentFragment.APPOINTMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment, container, false);
    }

}
