package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//5
public class HostTrackerService_addressesBean {

    private String id;
    @SerializedName("first-seen")
    private String firstSeen;
    private String mac;
    @SerializedName("last-seen")
    private String lastSeen;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
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

    @Override
    public String toString() {
        return "HostTrackerService_addressesBean{" +
                "id='" + id + '\'' +
                ", firstSeen='" + firstSeen + '\'' +
                ", mac='" + mac + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
