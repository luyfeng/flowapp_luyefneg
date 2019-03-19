package bishe.lu.controller;

import bishe.lu.controller.viewobject.TpLinkVO;
import bishe.lu.controller.viewobject.TpNodeVO;
import bishe.lu.pojo.LuJSONResult;
import bishe.lu.pojo.TpLink;
import bishe.lu.pojo.TpNode;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.TpNodeService;
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

    //1.1-a 查询所有TPlink api
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
