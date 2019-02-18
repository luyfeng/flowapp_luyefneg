package bishe.lu.controller;

import bishe.lu.pojo.TpLink;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/topo")
public class TopoController {

    @Autowired
    private TpLinkService tpLinkService;

    @Autowired
    private TpNodeService tpNodeService;

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

}
