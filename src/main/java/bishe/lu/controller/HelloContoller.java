package bishe.lu.controller;

import bishe.lu.pojo.LuJSONResult;
import bishe.lu.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

	@Autowired
	private Resource resource;
	
	@RequestMapping("/hello")
	public Object hello() {
		return "hello springboot~~";
	}
	
	@RequestMapping("/getResource")
	public LuJSONResult getResource() {
		
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		
		return LuJSONResult.ok(bean);
	}
	
}
