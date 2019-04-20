package bishe.lu.service.model.nodesmodel;

import com.google.gson.annotations.SerializedName;

public class AddressTrackerAddresses {
//    "id": 2,
//    "mac": "52:0d:46:95:4d:fd",
//    "last-seen": 1555588345109,
//    "ip": "10.0.0.1",
//    "first-seen": 1555588345109
    private int id;
    private String mac;
    @SerializedName("last-seen")
    private String lastSeen;
    private String ip;
    @SerializedName("first-seen")
    private String firstSeen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    @Override
    public String toString() {
        return "AddressTrackerAddresses{" +
                "id=" + id +
                ", mac='" + mac + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", ip='" + ip + '\'' +
                ", firstSeen='" + firstSeen + '\'' +
                '}';
    }
}
