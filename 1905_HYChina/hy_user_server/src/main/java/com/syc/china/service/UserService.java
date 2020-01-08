package com.syc.china.service;

import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.mapper.UserDetailMapper;
import com.syc.china.mapper.UserMapper;
import com.syc.china.pojo.*;
import com.syc.china.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 17:21
 */
@Service
public class UserService {


    @Autowired
    private AmqpTemplate amqpTemplate;  //消息队列

    @Autowired
    private StringRedisTemplate redisTemplate;  //redis

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private UserMapper userMapper;


    static final String KEY_PREFIX= "user:code:phone:";







    /*
        发送手机验证码
     */
    public void sendMobileCode(String mobile) {
        //生成随机验证码
        String code = NumberUtils.generateCode(6);
        //将验证码存到redis中，5min后过期
        redisTemplate.opsForValue().set(KEY_PREFIX+mobile,code,5, TimeUnit.MINUTES);
        //发送信息通知短信微服务，通知其发送信息
        Map<String,String> msg=new HashMap<>();
        msg.put("code",code);
        msg.put("phone",mobile);
        amqpTemplate.convertAndSend("hychina.sms.exchange","sms.verify.code",msg);
    }

    /*
        注册
     */
    public void register(User user,String code) {
        //1.检查验证码
        String key=KEY_PREFIX+user.getPhone();
        String redisCode = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(redisCode)||!code.equals(redisCode)){
            throw new HyException(ExceptionEnums.REGISTER_CODE_IS_ERROR);
        }
        //2.写入到数据库
        int i = userMapper.insertSelective(user);

        //3.删除redis中的验证码
        if (i>0){
            redisTemplate.delete(key);
        }
    }

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        List<User> users = userMapper.selectByExample(example);
        if (users!=null){
            return users.get(0);
        }
        return null;
    }


    /**
     * test
     * @param username
     * @return
     */
    public UserTest getUserByName(String username) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(username);
    }

    /**
     * 模拟数据库查询
     * @param username
     * @return
     */
    private UserTest getMapByName(String username){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        PermissionsTest permissions1 = new PermissionsTest("1","query");
        PermissionsTest permissions2 = new PermissionsTest("2","add");
        Set<PermissionsTest> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);

        RoleTest roleTest = new RoleTest("1","admin",permissionsSet);
        Set<RoleTest> roleSet = new HashSet<>();
        roleSet.add(roleTest);

        UserTest userTest = new UserTest("1","wsl","123456",roleSet);
        Map<String ,UserTest> map = new HashMap<>();
        map.put(userTest.getUserName(), userTest);

        PermissionsTest permissions3 = new PermissionsTest("3","query");
        Set<PermissionsTest> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        RoleTest role1 = new RoleTest("2","user",permissionsSet1);
        Set<RoleTest> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        UserTest user1 = new UserTest("2","zhangsan","123456",roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(username);
    }

    /**
     * 完善会员信息
     * @param userDetail
     */
    public void addUserDetail(UserDetail userDetail) {
        

    }
}
