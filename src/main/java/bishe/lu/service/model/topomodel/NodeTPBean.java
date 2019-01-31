package bishe.lu.service.model.topomodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//4
public class NodeTPBean {

    @SerializedName("node-id")
    private String nodeId;
    @SerializedName("termination-point")
    private List<TerminationPointBean> terminationPointBeanList;
    @SerializedName("host-tracker-service:addresses")
    private List<HostTrackerService_addressesBean> hostTrackerService_addressesBeanList;
    @SerializedName("host-tracker-service:id")
    private String hostTrackerServiceId;
    @SerializedName("host-tracker-service:attachment-points")
    private List<HostTrackerService_attachmentPointsBean> hostTrackerService_attachmentPointsBeanList;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<TerminationPointBean> getTerminationPointBeanList() {
        return terminationPointBeanList;
    }

    public void setTerminationPointBeanList(List<TerminationPointBean> terminationPointBeanList) {
        this.terminationPointBeanList = terminationPointBeanList;
    }

    public List<HostTrackerService_addressesBean> getHostTrackerService_addressesBeanList() {
        return hostTrackerService_addressesBeanList;
    }

    public void setHostTrackerService_addressesBeanList(List<HostTrackerService_addressesBean> hostTrackerService_addressesBeanList) {
        this.hostTrackerService_addressesBeanList = hostTrackerService_addressesBeanList;
    }

    public String getHostTrackerServiceId() {
        return hostTrackerServiceId;
    }

    public void setHostTrackerServiceId(String hostTrackerServiceId) {
        this.hostTrackerServiceId = hostTrackerServiceId;
    }

    public List<HostTrackerService_attachmentPointsBean> getHostTrackerService_attachmentPointsBeanList() {
        return hostTrackerService_attachmentPointsBeanList;
    }

    public void setHostTrackerService_attachmentPointsBeanList(List<HostTrackerService_attachmentPointsBean> hostTrackerService_attachmentPointsBeanList) {
        this.hostTrackerService_attachmentPointsBeanList = hostTrackerService_attachmentPointsBeanList;
    }

    @Override
    public String toString() {
        return "NodeTPBean{" +
                "nodeId='" + nodeId + '\'' +
                ", terminationPointBeanList=" + terminationPointBeanList +
                ", hostTrackerService_addressesBeanList=" + hostTrackerService_addressesBeanList +
                ", hostTrackerServiceId='" + hostTrackerServiceId + '\'' +
                ", hostTrackerService_attachmentPointsBeanList=" + hostTrackerService_attachmentPointsBeanList +
                '}';
    }
}
