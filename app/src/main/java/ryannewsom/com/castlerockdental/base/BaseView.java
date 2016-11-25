package ryannewsom.com.castlerockdental.base;

import android.app.Activity;

/**
 * BaseView
 */
public interface BaseView<T> {
    /**
     * Sets this views presenter
     * @param presenter - presenter to be used
     */
    void setPresenter(T presenter);

    /**
     * Gets the activity
     * @return - activity
     */
    Activity getActivity();
}
