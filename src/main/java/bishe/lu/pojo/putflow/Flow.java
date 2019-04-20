package bishe.lu.pojo.putflow;

import com.google.gson.annotations.SerializedName;

//2
public class Flow {
    private String id;
    private int priority;
    private int table_id;
    @SerializedName("Opendaylight-flow-statistics:flow-statistics")
    private OpendaylightFlowStatisticsFlowStatistics opendaylightFlowStatisticsFlowStatistics;
    @SerializedName("hard-timeout")
    private int hardTimeout;
    @SerializedName("idle-timeout")
    private int idleTimeout;
    @SerializedName("flow-name")
    private String flowName;
    private Match match;
    private Instructions instructions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public OpendaylightFlowStatisticsFlowStatistics getOpendaylightFlowStatisticsFlowStatistics() {
        return opendaylightFlowStatisticsFlowStatistics;
    }

    public void setOpendaylightFlowStatisticsFlowStatistics(OpendaylightFlowStatisticsFlowStatistics opendaylightFlowStatisticsFlowStatistics) {
        this.opendaylightFlowStatisticsFlowStatistics = opendaylightFlowStatisticsFlowStatistics;
    }

    public int getHardTimeout() {
        return hardTimeout;
    }

    public void setHardTimeout(int hardTimeout) {
        this.hardTimeout = hardTimeout;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public void setInstructions(Instructions instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "id='" + id + '\'' +
                ", priority=" + priority +
                ", table_id=" + table_id +
                ", opendaylightFlowStatisticsFlowStatistics=" + opendaylightFlowStatisticsFlowStatistics +
                ", hardTimeout=" + hardTimeout +
                ", idleTimeout=" + idleTimeout +
                ", flowName='" + flowName + '\'' +
                ", match=" + match +
                ", instructions=" + instructions +
                '}';
    }
}
