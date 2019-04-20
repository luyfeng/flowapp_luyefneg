package bishe.lu.pojo.putflow;

import com.google.gson.annotations.SerializedName;

//3
public class OpendaylightFlowStatisticsFlowStatistics {
    @SerializedName("packet-count")
    private int packetCount;
    @SerializedName("byte-count")
    private int byteCount;
    private Duration duration;

    public int getPacketCount() {
        return packetCount;
    }

    public void setPacketCount(int packetCount) {
        this.packetCount = packetCount;
    }

    public int getByteCount() {
        return byteCount;
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "OpendaylightFlowStatisticsFlowStatistics{" +
                "packetCount=" + packetCount +
                ", byteCount=" + byteCount +
                ", duration=" + duration +
                '}';
    }
}
