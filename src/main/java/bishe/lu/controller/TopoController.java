package bishe.lu.controller;

import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //1.2 增加TPnode
    @RequestMapping("/saveTpNode")
    @ResponseBody
    public void saveTpNode() {
        tpNodeService.saveTpNode();
    }

}
