package ryannewsom.com.castlerockdental.appointments;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.networking.Config;
import ryannewsom.com.castlerockdental.networking.Utils;

/**
 * Handles presentation for the list of unscheduled appointments
 */

public class AppointmentsPresenter implements AppointmentContract.Presenter {
    public static final String TAG = "AppointmentsPresenter";
    private RequestQueue mRequestQueue;
    private AppointmentContract.View mView;

    public AppointmentsPresenter(AppointmentContract.View view, Context context){
        mView = view;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void refreshUI() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringRequest scheduleRequest = new StringRequest(Request.Method.GET, Config.AVAILABLE_APPOINTMENTS_UR,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                List<Appointment> appointments = Utils.convertJsonStringToList(response, Appointment[].class);
                                mView.showAppointments(appointments);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Request Failed: " + error.getLocalizedMessage());
                    }
                });

                mRequestQueue.add(scheduleRequest);
            }
        }).start();
    }

    @Override
    public void AppointmentClicked(Appointment appointment) {

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
}
