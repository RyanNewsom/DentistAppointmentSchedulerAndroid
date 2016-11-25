package ryannewsom.com.castlerockdental.base;

import android.app.Activity;

/**
 * Created by Ryan on 11/21/2016.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    Activity getActivity();
}
