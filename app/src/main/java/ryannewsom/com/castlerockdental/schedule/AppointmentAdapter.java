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

    //Holds our views for each card
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mDateTextView;
        public TextView mPatientsName;
        public ViewHolder(View v) {
            super(v);
            mDateTextView = (TextView) v.findViewById(R.id.date_textview);
            mPatientsName = (TextView) v.findViewById(R.id.patientname_textview);
        }
    }

    public AppointmentAdapter(@Nullable List<Appointment> appointments){
        super();
        mAppointments = appointments;
    }


    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Appointment current = mAppointments.get(position);
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
