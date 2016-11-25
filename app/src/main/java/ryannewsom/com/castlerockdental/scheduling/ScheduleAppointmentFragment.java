package ryannewsom.com.castlerockdental.scheduling;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.appointment.Appointment;
import model.users.entityinfo.ContactInfo;
import model.users.entityinfo.PhysicalAddress;
import ryannewsom.com.castlerockdental.R;

/**
 * View which aShollows Scheduling of an Appointment
 */
public class ScheduleAppointmentFragment extends Fragment implements SchedulingContract.View{
    public static final String APPOINTMENT = "APPOINTMENT";

    private SchedulingContract.Presenter mPresenter;
    protected Appointment mAppointment;

    @BindView(R.id.name_textview)
    protected EditText mFirstNameView;

    @BindView(R.id.lastname_textview)
    protected EditText mLastNameView;

    @BindView(R.id.streetname_textview)
    protected EditText mStreetNumView;

    @BindView(R.id.street_textview)
    protected EditText mStreetNameView;

    @BindView(R.id.citystatezip_textview)
    protected EditText mZipView;

    @BindView(R.id.city_textview)
    protected EditText mCityView;

    @BindView(R.id.state_textview)
    protected EditText mStateView;

    @BindView(R.id.cellnumber_textview)
    protected EditText mCellNumberView;

    @BindView(R.id.date_textview)
    protected TextView mDateView;

    @BindView(R.id.submit_button)
    protected Button mSubmitButton;

    @BindView(R.id.progress_bar)
    protected ProgressBar mProgressSpinner;

    public ScheduleAppointmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        if(args != null){
            mAppointment = (Appointment) args.getSerializable(APPOINTMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_schedule_appointment, container, false);
        ButterKnife.bind(this, v);
        getActivity().setTitle("Make Appointment");
        mDateView.setText(mAppointment.getFormattedLocalTime());

        return v;
    }

    public static ScheduleAppointmentFragment newInstance(Appointment appointment) {
        Bundle args = new Bundle();
        args.putSerializable(APPOINTMENT, appointment);
        ScheduleAppointmentFragment fragment = new ScheduleAppointmentFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @OnClick(R.id.submit_button)
    public void onSubmit(){
        //field validation
        final String firstName = mFirstNameView.getText().toString();
        final String lastName = mLastNameView.getText().toString();
        int streetNumber = Integer.parseInt(mStreetNumView.getText().toString());
        String street = mStreetNameView.getText().toString();
        int zipCode = Integer.parseInt(mZipView.getText().toString());
        String city = mCityView.getText().toString();
        String state = mStateView.getText().toString();
        String cellNumber = mCellNumberView.getText().toString();

        PhysicalAddress address = new PhysicalAddress(streetNumber, street, city, state, zipCode);
        final ContactInfo contactInfo = new ContactInfo(cellNumber, address);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mPresenter.submitAppointment(firstName, lastName, contactInfo);
            }
        }).start();
    }

    @Override
    public void showWorking(final boolean show) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(show) {
                    mProgressSpinner.setVisibility(View.VISIBLE);
                } else {
                    mProgressSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void showSuccess(AlertDialog alertDialog) {
        alertDialog.show();
    }

    @Override
    public void showFailure(AlertDialog alertDialog) {
        alertDialog.show();
    }

    @Override
    public void setPresenter(SchedulingContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
