package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//5
public class HostTrackerService_attachmentPointsBean {

    @SerializedName("tp-id")
    private String tpId;
    @SerializedName("corresponding-tp")
    private String correspondingTp;
    private Boolean active;

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    public String getCorrespondingTp() {
        return correspondingTp;
    }

    public void setCorrespondingTp(String correspondingTp) {
        this.correspondingTp = correspondingTp;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "HostTrackerService_attachmentPointsBean{" +
                "tpId='" + tpId + '\'' +
                ", correspondingTp='" + correspondingTp + '\'' +
                ", active=" + active +
                '}';
    }
}
