package bishe.lu.controller;

import bishe.lu.pojo.LuJSONResult;
import bishe.lu.pojo.QueryVo;
import bishe.lu.pojo.TbFlow;
import bishe.lu.service.TbFlowService;
import bishe.lu.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController        // @RestController = @Controller + @ResponseBody
@RequestMapping("/flow")
public class FlowController {

    @Autowired
    private TbFlowService tbFlowService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用来获取id，可以得到不重复的id
    @Autowired
    private Sid sid;

    @RequestMapping("/tb_flow")
    public String tb_flow(){
        return "thymeleaf/tb_flow";
    }

    //1.增加flow
//    @RequestMapping("/saveFlow")
//    public String saveFlow(TbFlow flow) throws Exception {
//        //1.获取数据
////        Map<String,String[]> data = httpServletRequest.getParameterMap();
//        //2.封装数据
////        TbFlow flow = new TbFlow();
////        BeanUtils.populate(flow,data);
//
////        System.out.println("flow.order="+flow.getActionOrder()+"------name="+flow.getFlowName()+"-----id="+flow.getId());
////        System.out.println("flow="+flow.toString());
//
//        //3.数据传递给service层
//        flow.setId(sid.nextShort());
//        tbFlowService.saveTbFlow(flow);
//
//        //调转到列表页面
////        return LuJSONResult.ok("ok");
//        return "redirect:/";
//    }

    //1.增加flow
    @RequestMapping("/saveFlow")
    @ResponseBody
    public String saveFlow(TbFlow flow) throws Exception {

        //3.数据传递给service层
        flow.setId(sid.nextShort());
        tbFlowService.saveTbFlow(flow);

        //调转到列表页面
//        return LuJSONResult.ok("ok");
        return "redirect:/flow/queryFlowList";
    }

    //2.查询所有flow （用form表单方式传递数据）
    @RequestMapping("/queryFlowList")
//    public String queryFlowList(TbFlow test, ModelMap map){
    public String queryFlowList(QueryVo vo, ModelMap map){

        TbFlow flow = new TbFlow();
        List<TbFlow> flowList = tbFlowService.queryTbFlowList(flow);
        map.addAttribute("flowList",flowList);

//        List<TbFlow> flowList1 = tbFlowService.selectFlowListByQueryVo2(test);
//        map.addAttribute("flowList1",flowList1);
//
//        map.addAttribute("tableId",test.getTableId());
//        map.addAttribute("flowId",test.getFlowId());
//        map.addAttribute("inPort",test.getInPort());
//        map.addAttribute("outputNodeConnector",test.getOutputNodeConnector());

        /**
         * 2019.3.6
         * 分页查询
         * 鸡肋
         * //        PageHelper.startPage(currentPage,1);
         * //        PageInfo<TbFlow> pageInfo = new PageInfo<>(blogs)
         */
        Page<TbFlow> flowList1 = tbFlowService.selectPageByQueryVo(vo);
        map.addAttribute("flowList1",flowList1);
        map.addAttribute("tableId",vo.getTableId());
        map.addAttribute("flowId",vo.getFlowId());
        map.addAttribute("inPort",vo.getInPort());
        map.addAttribute("outputNodeConnector",vo.getOutputNodeConnector());

//        for(int i=1; flowList1.getTotal() / 5 + 1 > 0; i++) {
//            vo.setPageNums();
//            }


//        return "thymeleaf/tb_flow";
        return "thymeleaf/flowui";
    }

    //2.2 api方式 查询所有flow (这样可以用ajax方式传递数据)
    @RequestMapping("apiFlowList")
    @ResponseBody
    public LuJSONResult apiFlowList(){
        TbFlow flow = new TbFlow();
        List<TbFlow> list = tbFlowService.queryTbFlowList(flow);
        return LuJSONResult.ok(list);
    }



    //3.修改更新flow
//    @RequestMapping("/updateFlow")
//    public String updateFlow(TbFlow flow,ModelMap map){
//        tbFlowService.updateTbFlow(flow);
//        System.out.println("update----------"+flow.toString());
//        return "redirect:/flow/queryFlowList";
//    }
    //3.修改更新flow
    @RequestMapping("/updateFlow")
    @ResponseBody
    public String updateFlow(TbFlow flow){
        tbFlowService.updateTbFlow(flow);
        System.out.println("update----------"+flow.toString());
        return "redirect:/flow/queryFlowList";
    }

    //4.根据id查询flow
//    @RequestMapping("/queryFlowById")
//    public String queryFlowById(String id, ModelMap map){
//
//        TbFlow flow = tbFlowService.queryTbFlowById(id);
//        map.addAttribute("flowById",flow);
//        System.out.println("-------flowById========="+flow.toString());
//        return "thymeleaf/getFlowById";
////       return "thymeleaf/flowui";
//    }

    //4.根据id查询flow
    @RequestMapping(value = "/queryFlowById",method = RequestMethod.GET)
    @ResponseBody
    public LuJSONResult queryFlowById(@RequestParam("id") String id){

        TbFlow flow = tbFlowService.queryTbFlowById(id);
        System.out.println("-------flowById========="+flow.toString());
        return LuJSONResult.ok(flow);
//       return "thymeleaf/flowui";
    }



    //5.删除flow
//    @RequestMapping("/deleteFlow")
//    public String deleteFlow(String id){
//        System.out.println("----------id=---"+id);
//        tbFlowService.deleteTbFlow(id);
//        return "redirect:/flow/queryFlowList";
//    }

    //5.删除flow
    @RequestMapping("/deleteFlow")
    @ResponseBody
    public String deleteFlow(String id){
        System.out.println("----------id=---"+id);
        tbFlowService.deleteTbFlow(id);
        return "redirect:/flow/queryFlowList";
    }
}
