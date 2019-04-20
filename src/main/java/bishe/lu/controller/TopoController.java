package bishe.lu.controller;

import bishe.lu.controller.viewobject.TpLinkVO;
import bishe.lu.controller.viewobject.TpNodeVO;
import bishe.lu.pojo.LuJSONResult;
import bishe.lu.pojo.TpLink;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
import bishe.lu.service.model.topomodel.*;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/topo")
public class TopoController {

    @Autowired
    private TpLinkService tpLinkService;

    @Autowired
    private TpNodeService tpNodeService;

    @RequestMapping("/getAllTpLinkapi")
    @ResponseBody
    public List<TpLink> getAllTpLinkapi() {

        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpLinks();

        Gson gson = new Gson();

        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);

        List<TpLink> tpLinkList = new ArrayList<>();

        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<LinkBean> linkBeanList = topologyBean.getLinkBeanList();
            for (LinkBean linkBean : linkBeanList) {

                TpLink tpLink = new TpLink();

                tpLink.setLinkId(linkBean.getLinkId());
                tpLink.setDestNode(linkBean.getDestinationBean().getDestNode());
                tpLink.setDestTp(linkBean.getDestinationBean().getDestTp());
                tpLink.setSourceTp(linkBean.getSourceBean().getSourceTp());
                tpLink.setSourceNode(linkBean.getSourceBean().getSourceNode());

                tpLinkList.add(tpLink);
            }
        }

//        return LuJSONResult.ok(tpLinkList);
        return tpLinkList;
    }

    @RequestMapping("/getAllTpNodeapi")
    @ResponseBody
    public LuJSONResult getAllTpNodeapi() {

        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpNodes();

        Gson gson = new Gson();
        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);

        List<TpNode> tpNodeList = new ArrayList<>();

        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<NodeTPBean> nodeTPBeanList = topologyBean.getNodeTPBeanList();
            for (NodeTPBean nodeTPBean : nodeTPBeanList) {

                TpNode tpNode = new TpNode();

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

                tpNodeList.add(tpNode);

            }
        }
        return LuJSONResult.ok(tpNodeList);
    }

    @RequestMapping("/getv2NodeListapi")
    @ResponseBody
    public LuJSONResult getv2NodeListapi() {

        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpNodes();

        Gson gson = new Gson();
        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);
        TpNode tpNode = new TpNode();

        List<TpNodeVO> nodeVOList = new ArrayList<>();

        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<NodeTPBean> nodeTPBeanList = topologyBean.getNodeTPBeanList();
            for (NodeTPBean nodeTPBean : nodeTPBeanList) {

                TpNodeVO nodeVO = new TpNodeVO();
                nodeVO.setX((int)(100+Math.random()*200));
                nodeVO.setY((int)(100+Math.random()*200));
                //把NetworkTopologyRootBean类的值赋给tpNode
                nodeVO.setName(nodeTPBean.getNodeId());
                nodeVOList.add(nodeVO);


            }
        }
        System.out.println("nodeVOListv2====="+nodeVOList);
        return LuJSONResult.ok(nodeVOList);
    }

    //1.1.-b 调用接口获取link数据 接口直接获取
    @RequestMapping("/getv2LinkListapi")
    @ResponseBody
    public LuJSONResult getv2LinkListapi() {
        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpLinks();

        Gson gson = new Gson();

        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);

//        TpLink tpLink = new TpLink();

        List<TpLinkVO> linkVOList = new ArrayList<>();


        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<LinkBean> linkBeanList = topologyBean.getLinkBeanList();
            for (LinkBean linkBean : linkBeanList) {
                TpLinkVO linkVO = new TpLinkVO();

//                tpLink.setLinkId(linkBean.getLinkId());
                linkVO.setTarget(linkBean.getDestinationBean().getDestNode());
//                tpLink.setDestTp(linkBean.getDestinationBean().getDestTp());
                linkVO.setSource(linkBean.getSourceBean().getSourceTp());
//                tpLink.setSourceNode(linkBean.getSourceBean().getSourceNode());
                linkVOList.add(linkVO);

            }
        }
        System.out.println("linkVOListv2===="+linkVOList);
        return LuJSONResult.ok(linkVOList);
    }

    //1.1-a 查询所有TPlink api 数据库获取
    @RequestMapping("/getTpLinkListapi")
    @ResponseBody
    public LuJSONResult getTpLinkListapi() {

        TpLink link = new TpLink();
        List<TpLink> linkList = tpLinkService.queryTpLinkList(link);

        List<TpLinkVO> linkVOList = new ArrayList<>();

        int i = linkList.size()-1;
        System.out.println("i="+i);

        for (TpLink tpLink : linkList) {
            /**
             * TpLinkVO要在这里new对象，不能放在循环外面，list每一个元素都是一个新的TpLinkVO对象；所以不能放在循环外面，
             * 要放在循环里，每存入一个对象后，就新建一个对象，来存数据；
             */

            TpLinkVO linkVO = new TpLinkVO();
            linkVO.setSource(tpLink.getSourceNode());
            linkVO.setTarget(tpLink.getDestNode());
            linkVOList.add(linkVO);

            System.out.println("linkVO====="+linkVO+"*****i===="+i);
        }
        System.out.println("linkVOList===="+linkVOList);
        return LuJSONResult.ok(linkVOList);
    }

    //2.1-a 查询所有TPnode api
    @RequestMapping("/getTpNodeListapi")
    @ResponseBody
    public LuJSONResult getTpNodeListapi() {
//        double x;
//        double y;
        TpNode node = new TpNode();
        List<TpNode> nodeList = tpNodeService.queryTpNodeList(node);
        System.out.println("nodeList===="+nodeList);

//        TpNodeVO nodeVO = new TpNodeVO();
        List<TpNodeVO> nodeVOList = new ArrayList<>();

        for (TpNode tpNode : nodeList){
            /**
             * TpNodeVO要在这里new对象，list每一个元素都是一个新的TpNodeVO对象，所以不能放在循环外面，
             * 要放在循环里，每存入一个对象后，就新建一个对象，来存数据；
             */

            TpNodeVO nodeVO = new TpNodeVO();
            nodeVO.setX((int)(100+Math.random()*200));
            nodeVO.setY((int)(100+Math.random()*200));
            nodeVO.setName(tpNode.getNodeId());
            nodeVOList.add(nodeVO);
            System.out.println("nodeVO==========="+nodeVO);
        }
//        nodeVOList.add("1");
//        nodeVOList.add("2");

        System.out.println("nodeVOList====="+nodeVOList);
        return LuJSONResult.ok(nodeVOList);
    }

    //1.1 增加TPlink
    @RequestMapping("/saveTpLink")
    @ResponseBody
    public void saveTpLink() {
        tpLinkService.saveTpLink();

    }



    //2.查询所有TPlink
    @RequestMapping("/queryTpLinkList")
    public String queryTpLinkList(ModelMap map){
        TpLink link = new TpLink();
        List<TpLink> tplinkList = tpLinkService.queryTpLinkList(link);
        map.addAttribute("tplinkList",tplinkList);
        return "thymeleaf/node_connector";
    }

    //1.2 增加TPnode
    @RequestMapping("/saveTpNode")
    @ResponseBody
    public void saveTpNode() {
        tpNodeService.saveTpNode();
    }



    //2.查询所有增加TPnode
    @RequestMapping("/queryTpNodeList")
    public String queryTpNodeList(ModelMap map){
        TpNode tpNode = new TpNode();
        List<TpNode> tpNodeList = tpNodeService.queryTpNodeList(tpNode);
        map.addAttribute("tpNodeList", tpNodeList);
        return "thymeleaf/node_connector";
    }


    //url
    @RequestMapping("/links")
    @ResponseBody
    public void links() {
        TpNode node = new TpNode();

    }

}
