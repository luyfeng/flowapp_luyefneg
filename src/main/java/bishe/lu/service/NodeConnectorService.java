package bishe.lu.service;

import bishe.lu.pojo.NodeConnector;

import java.util.List;

public interface NodeConnectorService {

        public void saveNodeConnector();

        public List<NodeConnector> queryNodeConnectorList(NodeConnector nodeConnector);

}
