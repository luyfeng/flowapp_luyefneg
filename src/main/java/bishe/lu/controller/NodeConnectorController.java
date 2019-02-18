package bishe.lu.controller;

import bishe.lu.pojo.NodeConnector;
import bishe.lu.pojo.TpLink;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.NodeConnectorService;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
