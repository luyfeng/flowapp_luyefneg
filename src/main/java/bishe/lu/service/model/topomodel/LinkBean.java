package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//4
public class LinkBean {

    @SerializedName("link-id")
    private String linkId;
    @SerializedName("destination")
    private DestinationBean destinationBean;
    @SerializedName("source")
    private SourceBean sourceBean;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public DestinationBean getDestinationBean() {
        return destinationBean;
    }

    public void setDestinationBean(DestinationBean destinationBean) {
        this.destinationBean = destinationBean;
    }

    public SourceBean getSourceBean() {
        return sourceBean;
    }

    public void setSourceBean(SourceBean sourceBean) {
        this.sourceBean = sourceBean;
    }

    @Override
    public String toString() {
        return "LinkBean{" +
                "linkId='" + linkId + '\'' +
                ", destinationBean=" + destinationBean +
                ", sourceBean=" + sourceBean +
                '}';
    }
}
