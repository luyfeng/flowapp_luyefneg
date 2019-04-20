package bishe.lu.service.model.nodesmodel;

import com.google.gson.annotations.SerializedName;

public class OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics {
//    "transmit-drops": 0,
//    "receive-frame-error": 0,
//    "receive-over-run-error": 0,
//    "bytes": {
//        "transmitted": 149211,
//        "received": 1566
//    },
//    "receive-drops": 0,
//    "collision-count": 0,
//    "duration": {
//        "second": 8462,
//        "nanosecond": 541000000
//    },
//    "receive-errors": 0,
//    "packets": {
//    "transmitted": 1747,
//        "received": 21
//    },
//    "transmit-errors": 0,
//    "receive-crc-error": 0
//}
    @SerializedName("transmit-drops")
    private int transmitDrops;
    @SerializedName("receive-frame-error")
    private int receiveFrameError;
    @SerializedName("receive-over-run-error")
    private int receiveOverRunError;
    private Bytes bytes;
    @SerializedName("receive-drops")
    private int receiveDrops;
    @SerializedName("collision-count")
    private int collisionCount;
    private Duration duration;
    @SerializedName("receive-errors")
    private int receiveErrors;
    private Packets packets;
    private int transmitErrors;
    private int receiveCrcError;

    public int getTransmitDrops() {
        return transmitDrops;
    }

    public void setTransmitDrops(int transmitDrops) {
        this.transmitDrops = transmitDrops;
    }

    public int getReceiveFrameError() {
        return receiveFrameError;
    }

    public void setReceiveFrameError(int receiveFrameError) {
        this.receiveFrameError = receiveFrameError;
    }

    public int getReceiveOverRunError() {
        return receiveOverRunError;
    }

    public void setReceiveOverRunError(int receiveOverRunError) {
        this.receiveOverRunError = receiveOverRunError;
    }

    public Bytes getBytes() {
        return bytes;
    }

    public void setBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public int getReceiveDrops() {
        return receiveDrops;
    }

    public void setReceiveDrops(int receiveDrops) {
        this.receiveDrops = receiveDrops;
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getReceiveErrors() {
        return receiveErrors;
    }

    public void setReceiveErrors(int receiveErrors) {
        this.receiveErrors = receiveErrors;
    }

    public Packets getPackets() {
        return packets;
    }

    public void setPackets(Packets packets) {
        this.packets = packets;
    }

    public int getTransmitErrors() {
        return transmitErrors;
    }

    public void setTransmitErrors(int transmitErrors) {
        this.transmitErrors = transmitErrors;
    }

    public int getReceiveCrcError() {
        return receiveCrcError;
    }

    public void setReceiveCrcError(int receiveCrcError) {
        this.receiveCrcError = receiveCrcError;
    }

    @Override
    public String toString() {
        return "OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics{" +
                "transmitDrops=" + transmitDrops +
                ", receiveFrameError=" + receiveFrameError +
                ", receiveOverRunError=" + receiveOverRunError +
                ", bytes=" + bytes +
                ", receiveDrops=" + receiveDrops +
                ", collisionCount=" + collisionCount +
                ", duration=" + duration +
                ", receiveErrors=" + receiveErrors +
                ", packets=" + packets +
                ", transmitErrors=" + transmitErrors +
                ", receiveCrcError=" + receiveCrcError +
                '}';
    }
}
