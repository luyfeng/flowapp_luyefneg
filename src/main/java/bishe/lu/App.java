package bishe.lu;

import bishe.lu.dao.UserDOMapper;
import bishe.lu.dataobject.UserDO;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
//@SpringBootApplication(scanBasePackages = {"bishe.lu"})
@SpringBootApplication
@RestController
//扫描mybatis mapper 包路径
//@MapperScan("bishe.lu.dao")
@MapperScan(basePackages = {"bishe.lu.dao","bishe.lu.mapper"})
//扫描所有需要的包，包含一些自用的工具类包 所在的路径  默认扫描bishe.lu
@ComponentScan(basePackages = {"bishe.lu","org.n3r.idworker"})
public class App
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null){
            return "用户对象不存在";
        }else {
            return userDO.getName();
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
