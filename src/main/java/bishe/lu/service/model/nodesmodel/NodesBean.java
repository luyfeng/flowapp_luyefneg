package bishe.lu.service.model.nodesmodel;

import java.util.List;

//2
public class NodesBean {

    private List<NodeBean> node;

    public void setNode(List<NodeBean> node) {
        this.node = node;
    }

    public List<NodeBean> getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "NodesBean{" +
                "node=" + node +
                '}';
    }
}
