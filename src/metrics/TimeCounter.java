package metrics;

public class TimeCounter {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public String getFormattedElapsedTime() {
        long elapsedMillis = getElapsedTime();
        long seconds = (elapsedMillis / 1000) % 60;
        long minutes = (elapsedMillis / (1000 * 60)) % 60;
        return String.format("%02d:%02d.%03d", minutes, seconds, elapsedMillis % 1000);
    }
}