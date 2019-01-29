package bishe.lu.service.model.nodesmodel;

import com.google.gson.annotations.SerializedName;

//4
public class NodeConnectorBean {

    private String id;
    @SerializedName("flow-node-inventory:port-number")
    private String FlowNodeInventory_PortNumber;
    @SerializedName("flow-node-inventory:hardware-address")
    private String FlowNodeInventory_HardwareAddress;
//    @SerializedName("flow-node-inventory:current-speed")
//    private long FlowNodeInventory_CurrentSpeed;
    @SerializedName("flow-node-inventory:current-speed")
    private String FlowNodeInventory_CurrentSpeed;
    @SerializedName("flow-node-inventory:name")
    private String FlowNodeInventory_Name;
    @SerializedName("flow-node-inventory:state")
    private FlowNodeInventory_StateBean FlowNodeInventory_State;

    public String getId() {
        return id;
    }

    public String getFlowNodeInventory_PortNumber() {
        return FlowNodeInventory_PortNumber;
    }

    public String getFlowNodeInventory_HardwareAddress() {
        return FlowNodeInventory_HardwareAddress;
    }

    public String getFlowNodeInventory_CurrentSpeed() {
        return FlowNodeInventory_CurrentSpeed;
    }

    public String getFlowNodeInventory_Name() {
        return FlowNodeInventory_Name;
    }

    public FlowNodeInventory_StateBean getFlowNodeInventory_State() {
        return FlowNodeInventory_State;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlowNodeInventory_PortNumber(String flowNodeInventory_PortNumber) {
        FlowNodeInventory_PortNumber = flowNodeInventory_PortNumber;
    }

    public void setFlowNodeInventory_HardwareAddress(String flowNodeInventory_HardwareAddress) {
        FlowNodeInventory_HardwareAddress = flowNodeInventory_HardwareAddress;
    }

    public void setFlowNodeInventory_CurrentSpeed(String flowNodeInventory_CurrentSpeed) {
        FlowNodeInventory_CurrentSpeed = flowNodeInventory_CurrentSpeed;
    }

    public void setFlowNodeInventory_Name(String flowNodeInventory_Name) {
        FlowNodeInventory_Name = flowNodeInventory_Name;
    }

    public void setFlowNodeInventory_State(FlowNodeInventory_StateBean flowNodeInventory_State) {
        FlowNodeInventory_State = flowNodeInventory_State;
    }

    @Override
    public String toString() {
        return "NodeConnectorBean{" +
                "id='" + id + '\'' +
                ", FlowNodeInventory_PortNumber='" + FlowNodeInventory_PortNumber + '\'' +
                ", FlowNodeInventory_HardwareAddress='" + FlowNodeInventory_HardwareAddress + '\'' +
                ", FlowNodeInventory_CurrentSpeed=" + FlowNodeInventory_CurrentSpeed +
                ", FlowNodeInventory_Name='" + FlowNodeInventory_Name + '\'' +
                ", FlowNodeInventory_State=" + FlowNodeInventory_State +
                '}';
    }
}
