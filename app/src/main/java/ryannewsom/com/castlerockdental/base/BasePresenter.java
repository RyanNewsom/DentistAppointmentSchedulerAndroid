package ryannewsom.com.castlerockdental.base;

/**
 * Base Presenter for MVP architecture
 */
public interface BasePresenter {
    /**
     * Ties to activity lifecycle
     */
    void onViewReady();

    /**
     * Ties to activity lifecycle
     */
    void start();

    /**
     * Ties to activity lifecycle
     */
    void stop();
}
