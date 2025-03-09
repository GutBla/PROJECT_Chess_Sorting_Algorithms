package metrics;

public class MetricsManager {
    private static final MetricsManager instance = new MetricsManager();
    private final StepCounter stepCounter;
    private final TimeCounter timeCounter;
    private MetricsManager() {
        stepCounter = new StepCounter();
        timeCounter = new TimeCounter();
    }
    public static MetricsManager getInstance() {
        return instance;
    }
    public StepCounter getStepCounter() {
        return stepCounter;
    }
    public TimeCounter getTimeCounter() {
        return timeCounter;
    }
    public void reset() {
        stepCounter.reset();
    }
}
