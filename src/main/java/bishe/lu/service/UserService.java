package bishe.lu.service;

import bishe.lu.error.BusinessException;
import bishe.lu.service.model.UserModel;

public interface UserService {
    //通过用户ID获取用户对象的方法
    UserModel getUserById(Integer id);

    /*
    登陆
    telphone:用户注册手机
    password:用户加密后的密码
     */
    UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
