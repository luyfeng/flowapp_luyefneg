package bishe.lu.controller;

import bishe.lu.pojo.NodeConnector;
import bishe.lu.service.NodeConnectorService;
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
        return "thymeleaf/node_connector";
    }


}
