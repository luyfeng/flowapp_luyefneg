package bishe.lu.pojo.putflow;

import java.util.List;

/**
 * Auto-generated: 2019-04-12 19:54:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
//1
public class PutFlowRootBean {

    private List<Flow> flow;
    public void setFlow(List<Flow> flow) {
        this.flow = flow;
    }
    public List<Flow> getFlow() {
        return flow;
    }

    @Override
    public String toString() {
        return "PutFlowRootBean{" +
                "flow=" + flow +
                '}';
    }
}