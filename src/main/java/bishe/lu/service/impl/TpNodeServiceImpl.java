package bishe.lu.service.impl;

import bishe.lu.mapper.TpNodeMapper;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.TpNodeService;
import bishe.lu.service.model.topomodel.*;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
@Service
public class TpNodeServiceImpl implements TpNodeService {

    @Autowired
    private TpNodeMapper tpNodeMapper;

    @Override
    public void saveTpNode() {

        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.1.11.15",8181);

        String str = null;
        str = odlUtil.getTpNodes();

        Gson gson = new Gson();
        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);
        TpNode tpNode = new TpNode();
        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<NodeTPBean> nodeTPBeanList = topologyBean.getNodeTPBeanList();
            for (NodeTPBean nodeTPBean : nodeTPBeanList) {
                //把NetworkTopologyRootBean类的值赋给tpNode
                tpNode.setNodeId(nodeTPBean.getNodeId());
                tpNode.setTerminationPointTpId(nodeTPBean.getTerminationPointBeanList().get(0).getTpId());
                //判断HostTrackerService_addressesBean是否存在
                if (nodeTPBean.getHostTrackerService_addressesBeanList() == null){
                    tpNode.setAddresseId("------");
                }else {tpNode.setAddresseId(nodeTPBean.getHostTrackerService_addressesBeanList().get(0).getId());}

                if (nodeTPBean.getHostTrackerService_addressesBeanList() != null){
                    tpNode.setFirstSeen(nodeTPBean.getHostTrackerService_addressesBeanList().get(0).getFirstSeen());
                }else {tpNode.setFirstSeen("------");}

                if (nodeTPBean.getHostTrackerService_addressesBeanList() != null){
                    tpNode.setMac(nodeTPBean.getHostTrackerService_addressesBeanList().get(0).getMac());
                }else {tpNode.setMac("------");}

                if (nodeTPBean.getHostTrackerService_addressesBeanList() != null){
                    tpNode.setLastSeen(nodeTPBean.getHostTrackerService_addressesBeanList().get(0).getLastSeen());
                }else {tpNode.setLastSeen("------");}

                if (nodeTPBean.getHostTrackerService_addressesBeanList() != null){
                    tpNode.setIp(nodeTPBean.getHostTrackerService_addressesBeanList().get(0).getIp());
                }else {tpNode.setIp("------");}

                //判断hostTrackerServiceId是否存在
                if (nodeTPBean.getHostTrackerServiceId() != null){
                    tpNode.setHostTrackerServiceId(nodeTPBean.getHostTrackerServiceId());
                }else {tpNode.setHostTrackerServiceId("------");}


                //判断hostTrackerService_attachmentPointsBean是否存在
                if (nodeTPBean.getHostTrackerService_attachmentPointsBeanList() != null){
                    tpNode.setAttachmentPointTpId(nodeTPBean.getHostTrackerService_attachmentPointsBeanList().get(0).getTpId());
                }else {tpNode.setAttachmentPointTpId("------");}

                if (nodeTPBean.getHostTrackerService_attachmentPointsBeanList() != null){
                    tpNode.setCorrespondingTp(nodeTPBean.getHostTrackerService_attachmentPointsBeanList().get(0).getCorrespondingTp());
                }else {tpNode.setCorrespondingTp("------");}

                //判断hostTrackerService_attachmentPointsBean是否存在
                if (nodeTPBean.getHostTrackerService_attachmentPointsBeanList() != null){
                    tpNode.setActive(nodeTPBean.getHostTrackerService_attachmentPointsBeanList().get(0).getActive());
                }else {tpNode.setActive(null);}

                //存入数据库
                tpNodeMapper.insert(tpNode);
            }
        }



    }

    @Override
    public List<TpNode> queryTpNodeList(TpNode tpNode) {
        List<TpNode> tpNodeList = tpNodeMapper.select(tpNode);

        return tpNodeList;
    }
}
