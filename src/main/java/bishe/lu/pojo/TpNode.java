package bishe.lu.pojo;

import javax.persistence.*;

@Table(name = "tp_node")
public class TpNode {
    @Id
    @Column(name = "node_id")
    private String nodeId;

    @Column(name = "termination_point_tp_id")
    private String terminationPointTpId;

    @Column(name = "addresse_id")
    private String addresseId;

    @Column(name = "first_seen")
    private String firstSeen;

    private String mac;

    @Column(name = "last_seen")
    private String lastSeen;

    private String ip;

    @Column(name = "host_tracker_service_id")
    private String hostTrackerServiceId;

    @Column(name = "attachment_point_tp_id")
    private String attachmentPointTpId;

    @Column(name = "corresponding_tp")
    private String correspondingTp;

    private Boolean active;

    /**
     * @return node_id
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return termination_point_tp_id
     */
    public String getTerminationPointTpId() {
        return terminationPointTpId;
    }

    /**
     * @param terminationPointTpId
     */
    public void setTerminationPointTpId(String terminationPointTpId) {
        this.terminationPointTpId = terminationPointTpId;
    }

    /**
     * @return addresse_id
     */
    public String getAddresseId() {
        return addresseId;
    }

    /**
     * @param addresseId
     */
    public void setAddresseId(String addresseId) {
        this.addresseId = addresseId;
    }

    /**
     * @return first_seen
     */
    public String getFirstSeen() {
        return firstSeen;
    }

    /**
     * @param firstSeen
     */
    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    /**
     * @return mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return last_seen
     */
    public String getLastSeen() {
        return lastSeen;
    }

    /**
     * @param lastSeen
     */
    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return host_tracker_service_id
     */
    public String getHostTrackerServiceId() {
        return hostTrackerServiceId;
    }

    /**
     * @param hostTrackerServiceId
     */
    public void setHostTrackerServiceId(String hostTrackerServiceId) {
        this.hostTrackerServiceId = hostTrackerServiceId;
    }

    /**
     * @return attachment_point_tp_id
     */
    public String getAttachmentPointTpId() {
        return attachmentPointTpId;
    }

    /**
     * @param attachmentPointTpId
     */
    public void setAttachmentPointTpId(String attachmentPointTpId) {
        this.attachmentPointTpId = attachmentPointTpId;
    }

    /**
     * @return corresponding_tp
     */
    public String getCorrespondingTp() {
        return correspondingTp;
    }

    /**
     * @param correspondingTp
     */
    public void setCorrespondingTp(String correspondingTp) {
        this.correspondingTp = correspondingTp;
    }

    /**
     * @return active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
}