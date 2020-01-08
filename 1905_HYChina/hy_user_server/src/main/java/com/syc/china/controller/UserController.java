package com.syc.china.controller;

import com.syc.china.dto.UserDto;
import com.syc.china.pojo.User;
import com.syc.china.pojo.UserDetail;
import com.syc.china.pojo.UserTest;
import com.syc.china.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 17:17
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /*
        发送手机验证码
     */
    @GetMapping("/getMobileCode")
    public ResponseEntity<Void> sendMobileCode(String mobile){
        System.out.println(mobile);
        userService.sendMobileCode(mobile);
        return ResponseEntity.ok(null);
    }


    /*
        注册
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user,@RequestParam("code")String code){
        System.out.println(user);
        userService.register(user,code);
        return ResponseEntity.ok(null);
    }


    /*
        填写详细信息
     */
    @PostMapping("/detail")
    public ResponseEntity<Void> addUserDetail(UserDetail userDetail){
        userService.addUserDetail(userDetail);
        return ResponseEntity.ok(null);

    }




    /*
        登陆
     */
    @PostMapping("/login")
    public ResponseEntity<Void> login(UserDto user){

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //进行验证
        try {
           if (user.isRememberMe()){
                token.setRememberMe(true);
            }
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }



   /* *//**
     * 测试
     * @param user
     * @return
     *//*
    @RequestMapping("/login")
    public String login(UserTest user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }
    //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }*/


}
