package ryannewsom.com.castlerockdental.appointments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.R;
import ryannewsom.com.castlerockdental.scheduling.ScheduleAppointmentFragment;

/**
 * Displays an Appointment
 */
public class AppointmentFragment extends Fragment {
    protected Appointment mAppointment;

    @BindView(R.id.date_textview)
    protected TextView mDateView;

    @BindView(R.id.name_textview)
    protected TextView mName;

    @BindView(R.id.streetname_textview)
    protected TextView mStreetView;

    @BindView(R.id.citystatezip_textview)
    protected TextView mCityStateZipView;

    @BindView(R.id.cellnumber_textview)
    protected TextView mCellNumberView;

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
        View v = inflater.inflate(R.layout.fragment_appointment, container, false);
        ButterKnife.bind(this, v);

        addAppointmentDataToView();

        return v;
    }

    //Updates view w/ appointment values
    private void addAppointmentDataToView() {
        mDateView.setText(mAppointment.getFormattedLocalTime());
        mName.setText(mAppointment.getUser().getName());
        mStreetView.setText(mAppointment.getUser().getContactInfo().getPhysicalAddress().getFullStreet());
        mCityStateZipView.setText(mAppointment.getUser().getContactInfo().getPhysicalAddress().getFullCityStateZip());
        mCellNumberView.setText(mAppointment.getUser().getContactInfo().getCellNumber());
    }

}
