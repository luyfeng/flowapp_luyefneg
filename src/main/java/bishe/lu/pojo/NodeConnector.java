package bishe.lu.pojo;

import javax.persistence.*;

@Table(name = "node_connector")
public class NodeConnector {
    @Id
    private String id;

    @Column(name = "port_number")
    private String portNumber;

    @Column(name = "hardware_address")
    private String hardwareAddress;

    @Column(name = "current_speed")
    private String currentSpeed;

    @Column(name = "port_name")
    private String portName;

    @Column(name = "port_state")
    private Boolean portState;

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
     * @return port_number
     */
    public String getPortNumber() {
        return portNumber;
    }

    /**
     * @param portNumber
     */
    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * @return hardware_address
     */
    public String getHardwareAddress() {
        return hardwareAddress;
    }

    /**
     * @param hardwareAddress
     */
    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    /**
     * @return current_speed
     */
    public String getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @param currentSpeed
     */
    public void setCurrentSpeed(String currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * @return port_name
     */
    public String getPortName() {
        return portName;
    }

    /**
     * @param portName
     */
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * @return port_state
     */
    public Boolean getPortState() {
        return portState;
    }

    /**
     * @param portState
     */
    public void setPortState(Boolean portState) {
        this.portState = portState;
    }

    @Override
    public String toString() {
        return "NodeConnector{" +
                "id='" + id + '\'' +
                ", portNumber='" + portNumber + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", currentSpeed='" + currentSpeed + '\'' +
                ", portName='" + portName + '\'' +
                ", portState=" + portState +
                '}';
    }
}