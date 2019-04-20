package bishe.lu.controller.viewobject;

public class DemoNodesAllVo {
    private String ovsid;
    private String ovsname;
    private int linkpc;
    private String version;

    private int pcid;
    private String pcname;
    private String pcip;
    private String pcmac;
//    private String linkovs;
    private String numport;

    private String nodeConnectorId;
    private String nodeConnectorname;
//    private String portNum;
    private String portMac;

    private boolean live;
    private String speed;
    private int tDrop;
    private int rDrop;
    private int tErr;
    private int rErr;
    private int tByte;
    private int rByte;
    private int tPkt;
    private int rPkt;

    @Override
    public String toString() {
        return "DemoNodesAllVo{" +
                "ovsid='" + ovsid + '\'' +
                ", ovsname='" + ovsname + '\'' +
                ", linkpc=" + linkpc +
                ", version='" + version + '\'' +
                ", pcid=" + pcid +
                ", pcname='" + pcname + '\'' +
                ", pcip='" + pcip + '\'' +
                ", pcmac='" + pcmac + '\'' +
                ", numport='" + numport + '\'' +
                ", nodeConnectorId='" + nodeConnectorId + '\'' +
                ", nodeConnectorname='" + nodeConnectorname + '\'' +
                ", portMac='" + portMac + '\'' +
                ", live=" + live +
                ", speed='" + speed + '\'' +
                ", tDrop=" + tDrop +
                ", rDrop=" + rDrop +
                ", tErr=" + tErr +
                ", rErr=" + rErr +
                ", tByte=" + tByte +
                ", rByte=" + rByte +
                ", tPkt=" + tPkt +
                ", rPkt=" + rPkt +
                '}';
    }

    public String getOvsid() {
        return ovsid;
    }

    public void setOvsid(String ovsid) {
        this.ovsid = ovsid;
    }

    public String getOvsname() {
        return ovsname;
    }

    public void setOvsname(String ovsname) {
        this.ovsname = ovsname;
    }

    public int getLinkpc() {
        return linkpc;
    }

    public void setLinkpc(int linkpc) {
        this.linkpc = linkpc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPcid() {
        return pcid;
    }

    public void setPcid(int pcid) {
        this.pcid = pcid;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public String getPcip() {
        return pcip;
    }

    public void setPcip(String pcip) {
        this.pcip = pcip;
    }

    public String getPcmac() {
        return pcmac;
    }

    public void setPcmac(String pcmac) {
        this.pcmac = pcmac;
    }

    public String getNumport() {
        return numport;
    }

    public void setNumport(String numport) {
        this.numport = numport;
    }

    public String getNodeConnectorId() {
        return nodeConnectorId;
    }

    public void setNodeConnectorId(String nodeConnectorId) {
        this.nodeConnectorId = nodeConnectorId;
    }

    public String getNodeConnectorname() {
        return nodeConnectorname;
    }

    public void setNodeConnectorname(String nodeConnectorname) {
        this.nodeConnectorname = nodeConnectorname;
    }

    public String getPortMac() {
        return portMac;
    }

    public void setPortMac(String portMac) {
        this.portMac = portMac;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int gettDrop() {
        return tDrop;
    }

    public void settDrop(int tDrop) {
        this.tDrop = tDrop;
    }

    public int getrDrop() {
        return rDrop;
    }

    public void setrDrop(int rDrop) {
        this.rDrop = rDrop;
    }

    public int gettErr() {
        return tErr;
    }

    public void settErr(int tErr) {
        this.tErr = tErr;
    }

    public int getrErr() {
        return rErr;
    }

    public void setrErr(int rErr) {
        this.rErr = rErr;
    }

    public int gettByte() {
        return tByte;
    }

    public void settByte(int tByte) {
        this.tByte = tByte;
    }

    public int getrByte() {
        return rByte;
    }

    public void setrByte(int rByte) {
        this.rByte = rByte;
    }

    public int gettPkt() {
        return tPkt;
    }

    public void settPkt(int tPkt) {
        this.tPkt = tPkt;
    }

    public int getrPkt() {
        return rPkt;
    }

    public void setrPkt(int rPkt) {
        this.rPkt = rPkt;
    }
}
