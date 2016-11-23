package ryannewsom.com.castlerockdental.networking;

import com.android.volley.Response;
import com.google.gson.Gson;

import model.appointment.Appointment;

/**
 * Created by Ryan on 11/22/2016.
 */

public class ResponseListener implements Response.Listener<String> {
    @Override
    public void onResponse(String response) {
        Gson gson = new Gson();
        Appointment appointment = gson.fromJson(response, Appointment.class);
        //notify listener
    }
}
