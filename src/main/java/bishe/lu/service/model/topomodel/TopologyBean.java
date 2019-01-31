package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//3
public class TopologyBean {

    @SerializedName("topology-id")
    private String topologyId;
    @SerializedName("link")
    private List<LinkBean> linkBeanList;
    @SerializedName("node")
    private List<NodeTPBean> nodeTPBeanList;

    public String getTopologyId() {
        return topologyId;
    }

    public void setTopologyId(String topologyId) {
        this.topologyId = topologyId;
    }

    public List<LinkBean> getLinkBeanList() {
        return linkBeanList;
    }

    public void setLinkBeanList(List<LinkBean> linkBeanList) {
        this.linkBeanList = linkBeanList;
    }

    public List<NodeTPBean> getNodeTPBeanList() {
        return nodeTPBeanList;
    }

    public void setNodeTPBeanList(List<NodeTPBean> nodeTPBeanList) {
        this.nodeTPBeanList = nodeTPBeanList;
    }

    @Override
    public String toString() {
        return "TopologyBean{" +
                "topologyId='" + topologyId + '\'' +
                ", linkBeanList=" + linkBeanList +
                ", nodeTPBeanList=" + nodeTPBeanList +
                '}';
    }
}
