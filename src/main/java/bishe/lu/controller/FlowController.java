package bishe.lu.controller;

import bishe.lu.pojo.TbFlow;
import bishe.lu.service.TbFlowService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


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
    @RequestMapping("/saveFlow")
    public String saveFlow(TbFlow flow) throws Exception {
        //1.获取数据
//        Map<String,String[]> data = httpServletRequest.getParameterMap();
        //2.封装数据
//        TbFlow flow = new TbFlow();
//        BeanUtils.populate(flow,data);

//        System.out.println("flow.order="+flow.getActionOrder()+"------name="+flow.getFlowName()+"-----id="+flow.getId());
//        System.out.println("flow="+flow.toString());

        //3.数据传递给service层
        flow.setId(sid.nextShort());
        tbFlowService.saveTbFlow(flow);

        //调转到列表页面
//        return LuJSONResult.ok("ok");
        return "redirect:/";
    }
    //2.查询所有flow
    @RequestMapping("/queryFlowList")
    public String queryFlowList(ModelMap map){
        TbFlow flow = new TbFlow();
        List<TbFlow> flowList = tbFlowService.queryTbFlowList(flow);
        map.addAttribute("flowList",flowList);
        return "thymeleaf/tb_flow";
    }



    //3.修改更新flow
    @RequestMapping("/updateFlow")
    public String updateFlow(TbFlow flow,ModelMap map){
        tbFlowService.updateTbFlow(flow);
        System.out.println("update----------"+flow.toString());
        return "redirect:/flow/queryFlowList";
    }

    //4.根据id查询flow
    @RequestMapping("/queryFlowById")
    public String queryFlowById(String id, ModelMap map){

       TbFlow flow = tbFlowService.queryTbFlowById(id);
       map.addAttribute("flowById",flow);
       System.out.println("-------flowById========="+flow.toString());
       return "thymeleaf/getFlowById";
    }

    //5.删除flow
    @RequestMapping("/deleteFlow")
    public String deleteFlow(String id){
        System.out.println("----------id=---"+id);
        tbFlowService.deleteTbFlow(id);
        return "redirect:/flow/queryFlowList";
    }
}
