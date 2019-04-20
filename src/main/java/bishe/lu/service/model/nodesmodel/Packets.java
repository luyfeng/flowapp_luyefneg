package bishe.lu.service.model.nodesmodel;

public class Packets {
//  "transmitted": 1747,
//  "received": 21
    private int transmitted;
    private int received;

    public int getTransmitted() {
        return transmitted;
    }

    public void setTransmitted(int transmitted) {
        this.transmitted = transmitted;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "Packets{" +
                "transmitted=" + transmitted +
                ", received=" + received +
                '}';
    }
}
