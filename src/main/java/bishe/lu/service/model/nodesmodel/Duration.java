package bishe.lu.service.model.nodesmodel;

public class Duration {
//    "second": 8462,
//    "nanosecond": 541000000
    private int second;
    private String nanosecond;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getNanosecond() {
        return nanosecond;
    }

    public void setNanosecond(String nanosecond) {
        this.nanosecond = nanosecond;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "second=" + second +
                ", nanosecond='" + nanosecond + '\'' +
                '}';
    }
}
