package bishe.lu.pojo;

import javax.persistence.*;

@Table(name = "tb_flow")
public class TbFlow {
    @Id
    private String id;

    @Column(name = "flow_id")
    private String flowId;

    private String priority;

    @Column(name = "table_id")
    private String tableId;

    @Column(name = "hard_timeout")
    private String hardTimeout;

    @Column(name = "idle_timeout")
    private String idleTimeout;

    @Column(name = "flow_name")
    private String flowName;

    @Column(name = "in_port")
    private String inPort;

    @Column(name = "instruction_order")
    private String instructionOrder;

    @Column(name = "action_order")
    private String actionOrder;

    @Column(name = "output_node_connector")
    private String outputNodeConnector;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return flow_id
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * @param flowId
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return table_id
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * @param tableId
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    /**
     * @return hard_timeout
     */
    public String getHardTimeout() {
        return hardTimeout;
    }

    /**
     * @param hardTimeout
     */
    public void setHardTimeout(String hardTimeout) {
        this.hardTimeout = hardTimeout;
    }

    /**
     * @return idle_timeout
     */
    public String getIdleTimeout() {
        return idleTimeout;
    }

    /**
     * @param idleTimeout
     */
    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    /**
     * @return flow_name
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * @param flowName
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    /**
     * @return in_port
     */
    public String getInPort() {
        return inPort;
    }

    /**
     * @param inPort
     */
    public void setInPort(String inPort) {
        this.inPort = inPort;
    }

    /**
     * @return instruction_order
     */
    public String getInstructionOrder() {
        return instructionOrder;
    }

    /**
     * @param instructionOrder
     */
    public void setInstructionOrder(String instructionOrder) {
        this.instructionOrder = instructionOrder;
    }

    /**
     * @return action_order
     */
    public String getActionOrder() {
        return actionOrder;
    }

    /**
     * @param actionOrder
     */
    public void setActionOrder(String actionOrder) {
        this.actionOrder = actionOrder;
    }

    /**
     * @return output_node_connector
     */
    public String getOutputNodeConnector() {
        return outputNodeConnector;
    }

    /**
     * @param outputNodeConnector
     */
    public void setOutputNodeConnector(String outputNodeConnector) {
        this.outputNodeConnector = outputNodeConnector;
    }

    @Override
    public String toString() {
        return "TbFlow{" +
                "id='" + id + '\'' +
                ", flowId='" + flowId + '\'' +
                ", priority='" + priority + '\'' +
                ", tableId='" + tableId + '\'' +
                ", hardTimeout='" + hardTimeout + '\'' +
                ", idleTimeout='" + idleTimeout + '\'' +
                ", flowName='" + flowName + '\'' +
                ", inPort='" + inPort + '\'' +
                ", instructionOrder='" + instructionOrder + '\'' +
                ", actionOrder='" + actionOrder + '\'' +
                ", outputNodeConnector='" + outputNodeConnector + '\'' +
                '}';
    }
}