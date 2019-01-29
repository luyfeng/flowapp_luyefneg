package bishe.lu.service.model.nodesmodel;

//1
public class NodesRootBean {

    private NodesBean nodes;

    public void setNodes(NodesBean nodes) {
        this.nodes = nodes;
    }

    public NodesBean getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "NodesRootBean{" +
                "nodes=" + nodes +
                '}';
    }
}
