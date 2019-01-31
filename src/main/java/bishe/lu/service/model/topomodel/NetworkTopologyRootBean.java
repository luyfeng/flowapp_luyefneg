package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;
//1
public class NetworkTopologyRootBean {

    @SerializedName("network-topology")
    private  NetworkTopologyBean networkTopology;

    public NetworkTopologyBean getNetworkTopology() {
        return networkTopology;
    }

    public void setNetworkTopology(NetworkTopologyBean networkTopology) {
        this.networkTopology = networkTopology;
    }

    @Override
    public String toString() {
        return "NetworkTopologyRootBean{" +
                "networkTopology=" + networkTopology +
                '}';
    }
}
