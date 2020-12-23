package indi.me.inventory.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import indi.me.inventory.entity.User;
import indi.me.inventory.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author xiaoyulin
 * @since 2020-12-19
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //登录
    public boolean login(String name,String password){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.eq(User::getName,name).eq(User::getPassword,password);
        Integer count = userMapper.selectCount(lambdaQueryWrapper);
        return count > 0;
    }
}
