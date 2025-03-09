package metrics;
public class StepCounter {
    private int steps;
    public StepCounter() {
        steps = 0;
    }
    public void increment() {
        steps++;
    }
    public void reset() {
        steps = 0;
    }
    public int getSteps() {
        return steps;
    }
}
