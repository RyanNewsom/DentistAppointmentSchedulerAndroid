package ryannewsom.com.castlerockdental.schedule;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.R;

/**
 * Adapter for Appointment data
 */
public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private List<Appointment> mAppointments;
    private AppointmentAdapterClickListener mClickListener;

    //Holds our views for each card
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Appointment currentAppointment;
        public TextView mDateTextView;
        public TextView mPatientsName;

        private AppointmentAdapterClickListener mClickListener;

        public ViewHolder(View v, AppointmentAdapterClickListener listener) {
            super(v);
            mClickListener = listener;
            mDateTextView = (TextView) v.findViewById(R.id.date_textview);
            mPatientsName = (TextView) v.findViewById(R.id.patientname_textview);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onAppointmentClicked(currentAppointment);
                }
            });
        }
    }

    public AppointmentAdapter(AppointmentAdapterClickListener listener, @Nullable List<Appointment> appointments){
        super();
        mClickListener = listener;
        mAppointments = appointments;
    }


    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_card, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ViewHolder vh = new ViewHolder(v, mClickListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Appointment current = mAppointments.get(position);
        holder.currentAppointment = current;
        String username = "";
        if(current.getUser() != null) {
            username = current.getUser().getName();
        }

        holder.mDateTextView.setText(current.getFormattedLocalTime());
        holder.mPatientsName.setText(username);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(mAppointments != null) {
            return mAppointments.size();
        } else{
            return 0;
        }
    }

}
