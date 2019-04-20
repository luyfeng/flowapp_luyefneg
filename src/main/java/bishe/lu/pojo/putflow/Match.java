package bishe.lu.pojo.putflow;

import com.google.gson.annotations.SerializedName;

//3
public class Match {

    @SerializedName("in-port")
    private String inPort;

    public String getInPort() {
        return inPort;
    }

    public void setInPort(String inPort) {
        this.inPort = inPort;
    }
}
