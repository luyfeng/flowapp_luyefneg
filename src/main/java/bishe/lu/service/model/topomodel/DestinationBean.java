package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//5
public class DestinationBean {

    @SerializedName("dest-node")
    private String destNode;
    @SerializedName("dest-tp")
    private String destTp;

    public String getDestNode() {
        return destNode;
    }

    public void setDestNode(String destNode) {
        this.destNode = destNode;
    }

    public String getDestTp() {
        return destTp;
    }

    public void setDestTp(String destTp) {
        this.destTp = destTp;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destNode='" + destNode + '\'' +
                ", destTp='" + destTp + '\'' +
                '}';
    }

}
