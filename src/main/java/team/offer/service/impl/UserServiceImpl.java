package team.offer.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.offer.dao.UserDao;
import team.offer.entity.Position;
import team.offer.entity.User;
import team.offer.service.UserService;
import team.offer.service.exception.DeleteRepeatException;
import team.offer.util.MD5Util;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 12:55 2018/1/18
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    //注入mapper
    @Resource
    private UserDao userDao;


    @Transactional
    /**
     * 使用注解控制事务方法的优点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     */
    public User findUserById(Integer id) throws Exception {

        return userDao.queryUserById(id);
    }

    public boolean register(User user) throws Exception {
        //判断用户是否重复注册
        if (userDao.queryUserByEmail(user.getUserEmail()) != null) {
            return false;
        } else {
            //密码加密
            String encodedPassword = MD5Util.MD5(user.getUserPassword());
            user.setUserPassword(encodedPassword);
            //保存到数据库
            userDao.insertUser(user);
            return true;
        }
    }

    public boolean login(User user) throws Exception {
        //将密码进行MD5加密
        user.setUserPassword(MD5Util.MD5(user.getUserPassword()));
        //进行登录验证
        if(userDao.queryUserByEmailAndPassword(user.getUserEmail(),user.getUserPassword())!=null){
            //如果验证通过，保存用户上线时间
            long loginTime = System.currentTimeMillis();
            userDao.updateTime(user.getUserEmail(),loginTime);
            return true;
        }else{
            return false;
        }
    }
    public boolean verifyEmail(String email) throws Exception{
        //验证邮箱是否存在，存在返回true，否则返回false
        if(userDao.queryUserByEmail(email)==null){
            return false;
        }else{
            return true;
        }
    }

    public void forgetPassword(String email,String password) throws Exception {
        userDao.updateUserPasswordByEmail(email,MD5Util.MD5(password));
    }

    public boolean changePassword(User loginUser,String oldPassword, String newPassword) throws Exception {
        //验证输入的旧密码是否正确
        if(!loginUser.getUserPassword().equals(MD5Util.MD5(oldPassword))){
            return false;
        }else{
            //如果正确，将新密码加密后存入数据库
            userDao.updateUserPasswordByEmail(loginUser.getUserEmail(),MD5Util.MD5(newPassword));
            return true;
        }
    }

    public List<Position> collection(Integer id) throws Exception {
        return null;
    }

    public void deleteCollection(Integer id) throws Exception {

    }

    public List<Position> newApplication(Integer id) throws Exception {
        return null;
    }

    public List<Position> consultedApplication(Integer id) throws Exception {
        return null;
    }

    public List<Position> arrangedApplication(Integer id) throws Exception {
        return null;
    }

    public void deliverPosition(Integer uid, Integer pid) throws Exception {

    }

    public void collectionPosition(Integer uid, Integer pid) throws Exception {

    }
}
