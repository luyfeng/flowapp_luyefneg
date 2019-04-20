package bishe.lu.pojo.putflow;

public class Duration {
    private long nanosecond;
    private int second;

    public long getNanosecond() {
        return nanosecond;
    }

    public void setNanosecond(long nanosecond) {
        this.nanosecond = nanosecond;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "nanosecond=" + nanosecond +
                ", second=" + second +
                '}';
    }
}
