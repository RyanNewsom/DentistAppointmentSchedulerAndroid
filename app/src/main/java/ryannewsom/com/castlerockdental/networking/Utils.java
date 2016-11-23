package ryannewsom.com.castlerockdental.networking;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 11/22/2016.
 */

public class Utils {
    public static <T> List<T> convertJsonStringToList(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }
}
