package bishe.lu.controller.viewobject;

public class DemoNodesVo {

    private String ovsid;
    private String ovsname;
    private int linkpc;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    @Override
    public String toString() {
        return "DemoNodesVo{" +
                "ovsid='" + ovsid + '\'' +
                ", ovsname='" + ovsname + '\'' +
                ", linkpc=" + linkpc +
                ", version='" + version + '\'' +
                '}';
    }
}
