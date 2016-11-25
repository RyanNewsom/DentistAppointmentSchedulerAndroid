package ryannewsom.com.castlerockdental.appointments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.R;
import ryannewsom.com.castlerockdental.schedule.AppointmentAdapter;
import ryannewsom.com.castlerockdental.schedule.AppointmentAdapterClickListener;
import ryannewsom.com.castlerockdental.scheduling.ScheduleAppointmentFragment;
import ryannewsom.com.castlerockdental.scheduling.SchedulingPresenter;


/**
 * Displays the currently available appointments
 */
public class AvailableAppointmentsFragment extends Fragment implements AppointmentContract.View,
        AppointmentAdapterClickListener{
    private AppointmentContract.Presenter mPresenter;
    @BindView(R.id.schedule_recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public AvailableAppointmentsFragment() {
        // Required empty public constructor
    }

    public static AvailableAppointmentsFragment newInstance() {
        AvailableAppointmentsFragment fragment = new AvailableAppointmentsFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter == null){
            mPresenter = new AppointmentsPresenter(this, getActivity().getApplicationContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_appointments, container, false);
        ButterKnife.bind(this, v);

        initRecyclerView();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refreshUI();
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle(getString(R.string.available_appointments));
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.refreshUI();
    }

    private void initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showAppointments(List<Appointment> scheduledAppointments) {
        // specify an adapter (see also next example)
        mSwipeRefreshLayout.setRefreshing(false);

        mAdapter = new AppointmentAdapter(this, scheduledAppointments);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(AppointmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onAppointmentClicked(Appointment appointment) {
        ScheduleAppointmentFragment fragment = ScheduleAppointmentFragment.newInstance(appointment);
        fragment.setPresenter(new SchedulingPresenter(fragment, appointment, getContext()));

        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_main,
                fragment).commit();
    }
}
