package bishe.lu.controller;

import bishe.lu.controller.viewobject.UserVO;
import bishe.lu.error.BusinessException;
import bishe.lu.error.EmBusinessError;
import bishe.lu.response.CommonReturnType;
import bishe.lu.service.UserService;
import bishe.lu.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 2019/01/22
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin//解决跨域问题
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户登录接口
    @RequestMapping(value = "/login",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})//consumes = {CONTENT_TYPE_FORMED}可以加也可以不加
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "telphone")String telphone,
                                  @RequestParam(name = "password")String password) throws BusinessException {
        //入参校验
        if (org.apache.commons.lang3.StringUtils.isEmpty(telphone)||StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //用户登录服务，用来校验用户登录时候合法
        UserModel userModel = userService.validateLogin(telphone,password);

        //将登陆凭证加入到用户登录成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);

        return CommonReturnType.create(null);
    }





    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        //若获取的对应用户信息不存在
        if (userModel == null){
//            userModel.setEncrptPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }


        //将核心域模型用户对象转化为可供UI使用的viewobject
        UserVO userVO = convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);

    }

    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }



}
