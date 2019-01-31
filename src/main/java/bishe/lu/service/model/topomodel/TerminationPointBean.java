package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//5
public class TerminationPointBean {

    @SerializedName("tp-id")
    private String tpId;

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    @Override
    public String toString() {
        return "TerminationPointBean{" +
                "tpId='" + tpId + '\'' +
                '}';
    }
}
