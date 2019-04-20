package bishe.lu.controller.viewobject;

public class DemoNodesPCVo {

    private int pcid;
    private String pcname;
    private String pcip;
    private String pcmac;
    private String linkovs;
    private String numport;

    public void setPcid(int pcid) {
        this.pcid = pcid;
    }

    public int getPcid() {
        return pcid;
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

    public String getLinkovs() {
        return linkovs;
    }

    public void setLinkovs(String linkovs) {
        this.linkovs = linkovs;
    }

    public String getNumport() {
        return numport;
    }

    public void setNumport(String numport) {
        this.numport = numport;
    }

    @Override
    public String toString() {
        return "DemoNodesPCVo{" +
                "pcid='" + pcid + '\'' +
                ", pcname='" + pcname + '\'' +
                ", pcip='" + pcip + '\'' +
                ", pcmac='" + pcmac + '\'' +
                ", linkovs='" + linkovs + '\'' +
                ", numport='" + numport + '\'' +
                '}';
    }
}
