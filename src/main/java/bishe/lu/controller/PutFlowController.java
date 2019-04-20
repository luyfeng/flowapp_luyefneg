package bishe.lu.controller;

import bishe.lu.controller.viewobject.FlowVo;
import bishe.lu.controller.viewobject.NodeVo;
import bishe.lu.pojo.TbFlow;
import bishe.lu.pojo.putflow.*;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/send")
public class PutFlowController {

    @RequestMapping("/put")
    public void putf(TbFlow flow) {
        OdlUtil odlUtil = new OdlUtil("10.211.55.10", 8181, "admin", "admin");

        String flowId = flow.getFlowId();
        String priority = flow.getPriority();
        String tableId = flow.getTableId();
        String hardTimeout = flow.getHardTimeout();
        String idleTimeout = flow.getIdleTimeout();
        String flowName = flow.getFlowName();
        String inPort = flow.getInPort();
        String instructionOder = flow.getInstructionOrder();
        String actionOder = flow.getActionOrder();
        String outputNodeConnector = flow.getOutputNodeConnector();
        String nodeId = "openflow:1";
//        String

        String json = "{\n" +
                "    \"flow\": [\n" +
                "        {\n" +
                "            \"id\": "+"\""+flowId+"\",\n" +
                "            \"priority\": "+priority+",\n" +
                "            \"table_id\": "+tableId+",\n" +
                "            \"hard-timeout\": "+hardTimeout+",\n" +
                "            \"idle-timeout\": "+idleTimeout+",\n" +
                "            \"flow-name\": \""+flowName+"\",\n" +
                "            \"match\": {\n" +
                "                \"in-port\": \""+inPort+"\"\n" +
                "            },\n" +
                "            \"instructions\": {\n" +
                "                \"instruction\": [\n" +
                "                    {\n" +
                "                        \"order\": "+instructionOder+",\n" +
                "                        \"apply-actions\": {\n" +
                "                            \"action\": [\n" +
                "                                {\n" +
                "                                    \"order\": "+actionOder+",\n" +
                "                                    \"output-action\": {\n" +
                "                                        \"output-node-connector\": \""+outputNodeConnector+"\",\n" +
                "                                        \"max-length\": 65535\n" +
                "                                    }\n" +
                "                                },\n" +
                "                                 {\n" +
                "                                            \"order\": 1,\n" +
                "                                            \"output-action\": {\n" +
                "                                                \"output-node-connector\": \"CONTROLLER\",\n" +
                "                                                \"max-length\": 65535\n" +
                "                                            }\n" +
                "                                 }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        System.out.println("json=="+json);
        System.out.println("list=="+flow.toString());
        odlUtil.putFlow(json,nodeId,tableId,flowId);



    }


    @RequestMapping("/putflow")
    public void putflow() {
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181,"admin","admin","default");

//        FlowVo flow = new FlowVo();
//        flow.setName("123456111");
//        NodeVo node = new NodeVo();
//        node.setId("00:00:00:00:00:00:00:02");
//        node.setType("OF");
//        flow.setNode(node);
//        List<String> actions = new ArrayList<>();
//        actions.add("SET_NW_TOS=63");
//        flow.setActions(actions);
//        flow.setNwSrc("10.0.0.1");
//        flow.setNwDst("10.0.0.3");
//        odlUtil.installFlow(flow);

        PutFlowRootBean root = new PutFlowRootBean();
//        Flow flow = new Flow();
        List<Flow> flowList = new ArrayList<>();
        for (Flow flow : flowList) {
            flow.setId("102");
            flow.setPriority(22);
            flow.setTable_id(0);
//            flow.setOpendaylightFlowStatisticsFlowStatistics();
            flow.setHardTimeout(0);
            flow.setIdleTimeout(0);
            flow.setFlowName("lulu");

            Match match = new Match();
            match.setInPort("openflow:1:2");

            flow.setMatch(match);

            Instructions instructions = new Instructions();

            List<Instruction> instructionList = new ArrayList<>();
            for (Instruction instruction : instructionList) {
                instruction.setOrder(0);

                ApplyActions applyActions = new ApplyActions();

                List<Action> actionList = new ArrayList<>();
                for (int i=0; i<actionList.size(); i++) {
                    actionList.get(i).setOrder(0);

                    OutputAction outputAction = new OutputAction();
                    outputAction.setOutputNodeCconnector("1");
                    outputAction.setMaxLength(65535);

                    actionList.get(i).setOutputAction(outputAction);
                }

                applyActions.setAction(actionList);

            }





//            instruction.setApplyActions();
        }
    }


}
