package bishe.lu.controller.viewobject;

public class DemoNodesConnetcorVo {

    private String nodeConnectorId;
    private String name;
    private String portNum;
    private String mac;
    private String speed;

    @Override
    public String toString() {
        return "DemoNodesConnetcorVo{" +
                "nodeConnectorId='" + nodeConnectorId + '\'' +
                ", name='" + name + '\'' +
                ", portNum='" + portNum + '\'' +
                ", mac='" + mac + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getNodeConnectorId() {
        return nodeConnectorId;
    }

    public void setNodeConnectorId(String nodeConnectorId) {
        this.nodeConnectorId = nodeConnectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortNum() {
        return portNum;
    }

    public void setPortNum(String portNum) {
        this.portNum = portNum;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}
