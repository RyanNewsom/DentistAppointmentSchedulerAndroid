package ryannewsom.com.castlerockdental.networking;

import com.android.volley.Response;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import model.appointment.Appointment;

/**
 * Created by Ryan on 11/22/2016.
 */

public class Utils {
    public static <T> List<T> convertJsonStringToList(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }

    /**
     * Created by Ryan on 11/22/2016.
     */

    public static class ResponseListener implements Response.Listener<String> {
        @Override
        public void onResponse(String response) {
            Gson gson = new Gson();
            Appointment appointment = gson.fromJson(response, Appointment.class);
            //notify listener
        }
    }
}
