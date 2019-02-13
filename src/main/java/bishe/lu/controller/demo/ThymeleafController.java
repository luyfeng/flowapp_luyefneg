package bishe.lu.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("th")
public class ThymeleafController {

	@RequestMapping("/flowui")
    public String flowui(ModelMap map) {
        map.addAttribute("name", "thymeleaf-lululu");
        return "thymeleaf/flowui";
    }

    @RequestMapping("/echartdemo")
    public String echartdemo() {
	    return "thymeleaf/echartdemo";
    }

    @RequestMapping("/node_connector")
    public String node_connector() {
//	    return "thymeleaf/node_connector";
        return "redirect:/nodeConnector/queryNodeConnectorList";
    }
	
	@RequestMapping("/center")
    public String center() {
        return "thymeleaf/center/center";
    }


	
//	@RequestMapping("test")
//    public String test(ModelMap map) {
//
//		User u = new User();
//		u.setName("superadmin");
//		u.setAge(10);
//		u.setPassword("123465");
//		u.setBirthday(new Date());
//		u.setDesc("<font color='green'><b>hello imooc</b></font>");
//
//		map.addAttribute("user", u);
//
//		User u1 = new User();
//		u1.setAge(19);
//		u1.setName("imooc");
//		u1.setPassword("123456");
//		u1.setBirthday(new Date());
//
//		User u2 = new User();
//		u2.setAge(17);
//		u2.setName("LeeCX");
//		u2.setPassword("123456");
//		u2.setBirthday(new Date());
//
//		List<User> userList = new ArrayList<>();
//		userList.add(u);
//		userList.add(u1);
//		userList.add(u2);
//
//		map.addAttribute("userList", userList);
//
//        return "thymeleaf/test";
//    }
	
//	@PostMapping("postform")
//    public String postform(User u) {
//
//		System.out.println("姓名：" + u.getName());
//		System.out.println("年龄：" + u.getAge());
//
//        return "redirect:/th/test";
//    }
//
//	@RequestMapping("showerror")
//    public String showerror(User u) {
//
//		int a = 1 / 0;
//
//        return "redirect:/th/test";
//    }
}