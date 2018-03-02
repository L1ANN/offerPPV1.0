package team.offer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.offer.entity.Position;
import team.offer.entity.User;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 13:07 2018/2/26
 * @Modified By:
 */
//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration(locations = {"classpath*:spring/spring-dao.xml"})
public class UserDaoTest {

    //注入Dao实现类依赖
    @Resource
    private UserDao userDao;

    @Test
    public void queryUserByEmail() throws Exception {
        User user = userDao.queryUserByEmail("342141672@qq.com");
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUserEmail("347621846@qq.com");
        user.setUserPassword("123456789");
        userDao.insertUser(user);
    }

    @Test
    public void queryUserByEmailAndPassword() throws Exception {
        User user = userDao.queryUserByEmailAndPassword("342141672@qq.com","123456");
        System.out.println(user);
    }

    @Test
    public void updateUserPasswordByEmail() throws Exception {
        int count = userDao.updateUserPasswordByEmail("342141672@qq.com","123456789");
        System.out.println(count);
    }

    @Test
    public void queryCollectionById() throws Exception {
        List<Position> position = userDao.queryCollectionById(1);
        System.out.println(position);
    }

    @Test
    public void deleteCollectionById() throws Exception {
        userDao.deleteCollectionById(1,2);
    }

    @Test
    public void queryNewApplicationById() throws Exception {
        List<Position> positions = userDao.queryNewApplicationById(1);
        System.out.println(positions);
    }

    @Test
    public void queryConsultedApplicationById() throws Exception {
        List<Position> positions = userDao.queryConsultedApplicationById(1);
        System.out.println(positions);
    }

    @Test
    public void queryArrangedApplicationById() throws Exception {
        List<Position> positions = userDao.queryArrangedApplicationById(1);
        System.out.println(positions);
    }

    @Test
    public void queryApplicationIdByUidAndPid() throws Exception {
        Integer id = userDao.queryApplicationIdByUidAndPid(1,1);
        System.out.println(id);
    }

    @Test
    public void insertApplication() throws Exception {
        userDao.insertApplication(1,4);
    }

    @Test
    public void queryCollectionIdByUidAndPid() throws Exception {
        Integer id = userDao.queryCollectionIdByUidAndPid(1,1);
        System.out.println(id);
    }

    @Test
    public void insertCollection() throws Exception {
        userDao.insertCollection(1,2);
    }

    @org.junit.Test
    public void queryUserById() throws Exception {
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }

}