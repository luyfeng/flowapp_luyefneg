package bishe.lu.pojo;

import javax.persistence.*;

@Table(name = "tp_link")
public class TpLink {
    @Id
    @Column(name = "link_id")
    private String linkId;

    @Column(name = "dest_node")
    private String destNode;

    @Column(name = "dest_tp")
    private String destTp;

    @Column(name = "source_tp")
    private String sourceTp;

    @Column(name = "source_node")
    private String sourceNode;

    /**
     * @return link_id
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * @param linkId
     */
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    /**
     * @return dest_node
     */
    public String getDestNode() {
        return destNode;
    }

    /**
     * @param destNode
     */
    public void setDestNode(String destNode) {
        this.destNode = destNode;
    }

    /**
     * @return dest_tp
     */
    public String getDestTp() {
        return destTp;
    }

    /**
     * @param destTp
     */
    public void setDestTp(String destTp) {
        this.destTp = destTp;
    }

    /**
     * @return source_tp
     */
    public String getSourceTp() {
        return sourceTp;
    }

    /**
     * @param sourceTp
     */
    public void setSourceTp(String sourceTp) {
        this.sourceTp = sourceTp;
    }

    /**
     * @return source_node
     */
    public String getSourceNode() {
        return sourceNode;
    }

    /**
     * @param sourceNode
     */
    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    @Override
    public String toString() {
        return "TpLink{" +
                "linkId='" + linkId + '\'' +
                ", destNode='" + destNode + '\'' +
                ", destTp='" + destTp + '\'' +
                ", sourceTp='" + sourceTp + '\'' +
                ", sourceNode='" + sourceNode + '\'' +
                '}';
    }
}