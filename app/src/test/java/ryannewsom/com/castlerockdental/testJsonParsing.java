package ryannewsom.com.castlerockdental;

import com.google.gson.Gson;

import org.junit.Test;

import model.appointment.Appointment;
import ryannewsom.com.castlerockdental.networking.Utils;

/**
 * Created by Ryan on 11/22/2016.
 */

public class testJsonParsing {
    @Test
    public void testParseAppointment() throws Exception {
        String json = "{\"user\":null,\"time\":1510912800000,\"office\":{\"contactInfo\":{\"cellNumber\":\"3034541287\",\"physicalAddress\":{\"streetNumber\":12345,\"street\":\"Ravenwood Street\",\"zipCode\":80016,\"city\":\"Parker\",\"state\":\"CO\"}},\"officeId\":\"5834f4526a900e0004caffce\"},\"appointmentId\":\"5834f4576a900e0004cb0e30\"}";

        Gson gson = new Gson();
        gson.fromJson(json, Appointment.class);
    }

}
