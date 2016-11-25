package ryannewsom.com.castlerockdental.networking;

/**
 * Created by Ryan on 11/24/2016.
 */

public class NetworkingError {
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public NetworkingError(){

    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
