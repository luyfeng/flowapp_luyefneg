package bishe.lu.pojo.putflow;

import com.google.gson.annotations.SerializedName;

/**
 * Auto-generated: 2019-04-12 19:54:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
//7
public class OutputAction {

    @SerializedName("output-node-connector")
    private String outputNodeCconnector;
    @SerializedName("max-length")
    private int maxLength;

    public String getOutputNodeCconnector() {
        return outputNodeCconnector;
    }

    public void setOutputNodeCconnector(String outputNodeCconnector) {
        this.outputNodeCconnector = outputNodeCconnector;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return "OutputAction{" +
                "outputNodeCconnector='" + outputNodeCconnector + '\'' +
                ", maxLength=" + maxLength +
                '}';
    }
}