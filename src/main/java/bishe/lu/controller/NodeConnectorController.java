package bishe.lu.controller;

import bishe.lu.controller.viewobject.DemoNodesAllVo;
import bishe.lu.controller.viewobject.DemoNodesConnetcorVo;
import bishe.lu.controller.viewobject.DemoNodesPCVo;
import bishe.lu.controller.viewobject.DemoNodesVo;
import bishe.lu.pojo.LuJSONResult;
import bishe.lu.pojo.NodeConnector;
import bishe.lu.pojo.TpLink;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.NodeConnectorService;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
import bishe.lu.service.model.nodesmodel.*;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController         // @RestController = @Controller + @ResponseBody
@RequestMapping("/nodeConnector")
public class NodeConnectorController {

    @Autowired
    private NodeConnectorService nodeConnectorService;

    @Autowired
    private TpLinkService tpLinkService;

    @Autowired
    private TpNodeService tpNodeService;

    @RequestMapping("/getdemoNodesAllapi")
    @ResponseBody
    public List<DemoNodesAllVo> getdemoNodesAllapi() {

        int i = 1;

        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);
        String str = null;
        str = odlUtil.getNodes();

        Gson gson = new Gson();

        //用gson把json字符串转化成javabean实体，数据存到NodesRootBean类中
        NodesRootBean nodesRootBean = gson.fromJson(str,NodesRootBean.class);

        List<DemoNodesAllVo> nodesAllVoList = new ArrayList<>();

//        BeanUtils.copyProperties(nodesRootBean,nodeConnector);

        NodesBean nodesBean = nodesRootBean.getNodes();
        List<NodeBean> nodeBeanList = nodesBean.getNode();
        for (NodeBean nodeBean : nodeBeanList){
            List<NodeConnectorBean> nodeConnectorBeanList = nodeBean.getNodeConnector();

            for (NodeConnectorBean nodeConnectorBean : nodeConnectorBeanList) {


                DemoNodesAllVo nodesAllVo = new DemoNodesAllVo();
                nodesAllVo.setNodeConnectorId(nodeConnectorBean.getId());
                nodesAllVo.setNodeConnectorname(nodeConnectorBean.getFlowNodeInventory_Name());
                nodesAllVo.setNumport(nodeConnectorBean.getFlowNodeInventory_PortNumber());
                nodesAllVo.setPortMac(nodeConnectorBean.getFlowNodeInventory_HardwareAddress());

                nodesAllVo.setLive(nodeConnectorBean.getFlowNodeInventory_State().isLive());
                nodesAllVo.setSpeed(nodeConnectorBean.getFlowNodeInventory_CurrentSpeed());
                nodesAllVo.settDrop(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getTransmitDrops());
                nodesAllVo.setrDrop(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getReceiveDrops());
                nodesAllVo.settErr(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getTransmitErrors());
                nodesAllVo.setrErr(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getReceiveErrors());

                nodesAllVo.settByte(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getBytes().getTransmitted());
                nodesAllVo.setrByte(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getBytes().getReceived());

                nodesAllVo.settPkt(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getPackets().getTransmitted());
                nodesAllVo.setrPkt(nodeConnectorBean.getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics().getPackets().getReceived());

                nodesAllVoList.add(nodesAllVo);

            }

        }

//        return LuJSONResult.ok(nodesAllVoList);
        return nodesAllVoList;
    }

    @RequestMapping("/getdemoNodesConnector")
    @ResponseBody
    public List<DemoNodesConnetcorVo> getdemoNodesConnector() {

        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);
        String str = null;
        str = odlUtil.getNodes();


        Gson gson = new Gson();

        //用gson把json字符串转化成javabean实体，数据存到NodesRootBean类中
        NodesRootBean nodesRootBean = gson.fromJson(str,NodesRootBean.class);

        List<DemoNodesConnetcorVo> nodesConnetcorVoList = new ArrayList<>();

//        BeanUtils.copyProperties(nodesRootBean,nodeConnector);

        NodesBean nodesBean = nodesRootBean.getNodes();
        List<NodeBean> nodeBeanList = nodesBean.getNode();
        for (NodeBean nodeBean : nodeBeanList){
            List<NodeConnectorBean> nodeConnectorBeanList = nodeBean.getNodeConnector();
//            nodeConnector.setPortNumber(nodeBean.getFlowNodeInventory_IpAddress());

            for (NodeConnectorBean nodeConnectorBean : nodeConnectorBeanList) {

                DemoNodesConnetcorVo nodesConnetcorVo = new DemoNodesConnetcorVo();
                nodesConnetcorVo.setNodeConnectorId(nodeConnectorBean.getId());
                nodesConnetcorVo.setName(nodeConnectorBean.getFlowNodeInventory_Name());
                nodesConnetcorVo.setPortNum(nodeConnectorBean.getFlowNodeInventory_PortNumber());
                nodesConnetcorVo.setMac(nodeConnectorBean.getFlowNodeInventory_HardwareAddress());
                nodesConnetcorVo.setSpeed(nodeConnectorBean.getFlowNodeInventory_CurrentSpeed());

                nodesConnetcorVoList.add(nodesConnetcorVo);

            }

        }

//        return LuJSONResult.ok(nodesConnetcorVoList);
        return nodesConnetcorVoList;
    }

    @RequestMapping("/getdemoNodesPC")
    @ResponseBody
    public List<DemoNodesPCVo> getdemoNodesPC() {

        int i = 1;

        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);
        String str = null;
        str = odlUtil.getNodes();


        Gson gson = new Gson();

        //用gson把json字符串转化成javabean实体，数据存到NodesRootBean类中
        NodesRootBean nodesRootBean = gson.fromJson(str,NodesRootBean.class);

        List<DemoNodesPCVo> nodesPCVoList = new ArrayList<>();

//        BeanUtils.copyProperties(nodesRootBean,nodeConnector);

        NodesBean nodesBean = nodesRootBean.getNodes();
        List<NodeBean> nodeBeanList = nodesBean.getNode();
        for (NodeBean nodeBean : nodeBeanList){
            List<NodeConnectorBean> nodeConnectorBeanList = nodeBean.getNodeConnector();
//            nodeConnector.setPortNumber(nodeBean.getFlowNodeInventory_IpAddress());

//            DemoNodesPCVo nodesPCVo = new DemoNodesPCVo();

            for (NodeConnectorBean nodeConnectorBean : nodeConnectorBeanList) {

                String ovs = nodeConnectorBean.getId();

                if (nodeConnectorBean.getAddressTrackerAddresses() != null && nodeConnectorBean.getAddressTrackerAddresses().size() != 0) {

                    List<AddressTrackerAddresses> addressesList = nodeConnectorBean.getAddressTrackerAddresses();
                    for (AddressTrackerAddresses addresses : addressesList) {

                        DemoNodesPCVo nodesPCVo = new DemoNodesPCVo();
                        nodesPCVo.setPcname("host"+i++);

                        nodesPCVo.setPcid(addresses.getId());
                        nodesPCVo.setPcip(addresses.getIp());
                        nodesPCVo.setPcmac(addresses.getMac());
                        nodesPCVo.setLinkovs(ovs);
                        nodesPCVo.setNumport(nodeConnectorBean.getFlowNodeInventory_PortNumber());

                        nodesPCVoList.add(nodesPCVo);

                    }

                }

            }

        }

//        return LuJSONResult.ok(nodesPCVoList);
        return nodesPCVoList;
    }

    @RequestMapping("/getdemoNodes")
    @ResponseBody
    public List<DemoNodesVo> getdemoNodes() {

        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);
        String str = null;
        str = odlUtil.getNodes();


        Gson gson = new Gson();

        //用gson把json字符串转化成javabean实体，数据存到NodesRootBean类中
        NodesRootBean nodesRootBean = gson.fromJson(str,NodesRootBean.class);

        NodeConnector nodeConnector = new NodeConnector();

        List<DemoNodesVo> nodesVoList = new ArrayList<>();

//        BeanUtils.copyProperties(nodesRootBean,nodeConnector);

        NodesBean nodesBean = nodesRootBean.getNodes();
        List<NodeBean> nodeBeanList = nodesBean.getNode();
        for (NodeBean nodeBean : nodeBeanList){
            List<NodeConnectorBean> nodeConnectorBeanList = nodeBean.getNodeConnector();
//            nodeConnector.setPortNumber(nodeBean.getFlowNodeInventory_IpAddress());

            DemoNodesVo nodesVo = new DemoNodesVo();
            nodesVo.setOvsid(nodeBean.getId());
            nodesVo.setOvsname(nodeBean.getFlowNodeInventoryDescription());
            nodesVo.setLinkpc(nodeConnectorBeanList.size());
            System.out.println("linkpc=="+nodeConnectorBeanList.size());
            nodesVo.setVersion(nodeBean.getFlowNodeInventory_Software());

            nodesVoList.add(nodesVo);

//            for (NodeConnectorBean nodeConnectorBean : nodeConnectorBeanList){
//                nodeConnector.setId(nodeConnectorBean.getId());
//                nodeConnector.setPortNumber(nodeConnectorBean.getFlowNodeInventory_PortNumber());
//                nodeConnector.setHardwareAddress(nodeConnectorBean.getFlowNodeInventory_HardwareAddress());
//                nodeConnector.setCurrentSpeed(nodeConnectorBean.getFlowNodeInventory_CurrentSpeed());
//                nodeConnector.setPortName(nodeConnectorBean.getFlowNodeInventory_Name());
//                nodeConnector.setPortState(nodeConnectorBean.getFlowNodeInventory_State().isLive());

//            }
        }

//        return LuJSONResult.ok(nodesVoList);
        return nodesVoList;
    }

    //添加node
    @RequestMapping("/saveNodeConnector")
    @ResponseBody
    public void saveNodeConnector(){
        nodeConnectorService.saveNodeConnector();
    }

    //2.查询所有flow
//    @RequestMapping("/queryFlowList")
//    public String queryFlowList(ModelMap map){
//        TbFlow flow = new TbFlow();
//        List<TbFlow> flowList = tbFlowService.queryTbFlowList(flow);
//        map.addAttribute("flowList",flowList);
//        return "thymeleaf/tb_flow";
//    }

    //2.查询所有node
    @RequestMapping("/queryNodeConnectorList")
    public String queryNodeConnectorList(ModelMap map){
        NodeConnector nodeConnector = new NodeConnector();
        List<NodeConnector> nodeConnectorList = nodeConnectorService.queryNodeConnectorList(nodeConnector);
        map.addAttribute("nodeConnectorList",nodeConnectorList);

        //查询所有TPlink
        TpLink link = new TpLink();
        List<TpLink> tplinkList = tpLinkService.queryTpLinkList(link);
        map.addAttribute("tplinkList",tplinkList);

        //查询所有增加TPnode
        TpNode tpNode = new TpNode();
        List<TpNode> tpNodeList = tpNodeService.queryTpNodeList(tpNode);
        map.addAttribute("tpNodeList", tpNodeList);

        return "thymeleaf/node_connector";
    }


}
