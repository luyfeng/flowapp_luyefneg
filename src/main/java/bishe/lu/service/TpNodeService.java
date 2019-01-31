package bishe.lu.service;

import bishe.lu.pojo.TpNode;

import java.util.List;

public interface TpNodeService {


//    public void saveNodeConnector();
//
//    public List<NodeConnector> queryNodeConnectorList(NodeConnector nodeConnector);

    public void saveTpNode();
    public List<TpNode> queryTpNodeList(TpNode tpNode);

}
