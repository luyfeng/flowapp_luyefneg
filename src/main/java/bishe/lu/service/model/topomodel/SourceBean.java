package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//5
public class SourceBean {

    @SerializedName("source-tp")
    private String sourceTp;
    @SerializedName("source-node")
    private String sourceNode;

    public String getSourceTp() {
        return sourceTp;
    }

    public void setSourceTp(String sourceTp) {
        this.sourceTp = sourceTp;
    }

    public String getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    @Override
    public String toString() {
        return "SourceBean{" +
                "sourceTp='" + sourceTp + '\'' +
                ", sourceNode='" + sourceNode + '\'' +
                '}';
    }
}
