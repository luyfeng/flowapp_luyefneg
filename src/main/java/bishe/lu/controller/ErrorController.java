package bishe.lu.controller;

import bishe.lu.pojo.LuJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		
		int a = 1 / 0;
		
		return "thymeleaf/error";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public LuJSONResult getAjaxerror() {
		
		int a = 1 / 1;
		
		return LuJSONResult.ok(a);
	}
}