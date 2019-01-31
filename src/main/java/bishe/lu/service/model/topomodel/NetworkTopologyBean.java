package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//2
public class NetworkTopologyBean {

    @SerializedName("topology")
    private List<TopologyBean> topologyBeanList;

    public List<TopologyBean> getTopologyBeanList() {
        return topologyBeanList;
    }

    public void setTopologyBeanList(List<TopologyBean> topologyBeanList) {
        this.topologyBeanList = topologyBeanList;
    }

    @Override
    public String toString() {
        return "NetworkTopologyBean{" +
                "topologyBeanList=" + topologyBeanList +
                '}';
    }
}
