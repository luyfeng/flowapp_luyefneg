package bishe.lu.controller;

import bishe.lu.controller.viewobject.FlowVo;
import bishe.lu.controller.viewobject.NodeVo;
import bishe.lu.utils.OdlUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/send")
public class PutFlowController {

    @RequestMapping("/putflow")
    public void putflow() {
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181,"admin","admin","default");

        FlowVo flow = new FlowVo();
        flow.setName("123456111");
        NodeVo node = new NodeVo();
        node.setId("00:00:00:00:00:00:00:02");
        node.setType("OF");
        flow.setNode(node);
        List<String> actions = new ArrayList<>();
        actions.add("SET_NW_TOS=63");
        flow.setActions(actions);
        flow.setNwSrc("10.0.0.1");
        flow.setNwDst("10.0.0.3");
        odlUtil.installFlow(flow);
    }

}
