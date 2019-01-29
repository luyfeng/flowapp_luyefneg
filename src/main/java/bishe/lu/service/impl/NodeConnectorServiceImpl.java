package bishe.lu.service.impl;

import bishe.lu.mapper.NodeConnectorMapper;
import bishe.lu.pojo.NodeConnector;
import bishe.lu.service.NodeConnectorService;
import bishe.lu.service.model.nodesmodel.NodeBean;
import bishe.lu.service.model.nodesmodel.NodeConnectorBean;
import bishe.lu.service.model.nodesmodel.NodesBean;
import bishe.lu.service.model.nodesmodel.NodesRootBean;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeConnectorServiceImpl implements NodeConnectorService {

    @Autowired
    private NodeConnectorMapper nodeConnectorMapper;

    @Override
    public void saveNodeConnector() {

        OdlUtil odlUtil = new OdlUtil("10.1.11.15",8181);
        String str = null;
        str = odlUtil.getNodes();


        Gson gson = new Gson();

        //用gson把json字符串转化成javabean实体，数据存到NodesRootBean类中
        NodesRootBean nodesRootBean = gson.fromJson(str,NodesRootBean.class);

        NodeConnector nodeConnector = new NodeConnector();

//        BeanUtils.copyProperties(nodesRootBean,nodeConnector);

        NodesBean nodesBean = nodesRootBean.getNodes();
        List<NodeBean> nodeBeanList = nodesBean.getNode();
        for (NodeBean nodeBean : nodeBeanList){
            List<NodeConnectorBean> nodeConnectorBeanList = nodeBean.getNodeConnector();
            for (NodeConnectorBean nodeConnectorBean : nodeConnectorBeanList){
                nodeConnector.setId(nodeConnectorBean.getId());
                nodeConnector.setPortNumber(nodeConnectorBean.getFlowNodeInventory_PortNumber());
                nodeConnector.setHardwareAddress(nodeConnectorBean.getFlowNodeInventory_HardwareAddress());
                nodeConnector.setCurrentSpeed(nodeConnectorBean.getFlowNodeInventory_CurrentSpeed());
                nodeConnector.setPortName(nodeConnectorBean.getFlowNodeInventory_Name());
                nodeConnector.setPortState(nodeConnectorBean.getFlowNodeInventory_State().isLive());
                nodeConnectorMapper.insert(nodeConnector);
            }
        }
//        return nodeConnector;

    }

//    @Override
//    public void saveNodeConnector() {
//        nodeConnectorMapper.insert(convertFromDataObject());
//
//    }

    @Override
    public List<NodeConnector> queryNodeConnectorList(NodeConnector nodeConnector) {

        List<NodeConnector> nodeConnectorList = nodeConnectorMapper.select(nodeConnector);

        return nodeConnectorList;
    }


}
