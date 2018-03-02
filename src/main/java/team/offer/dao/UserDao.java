package team.offer.dao;

import org.apache.ibatis.annotations.Param;
import team.offer.entity.Position;
import team.offer.entity.User;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 17:30 2018/1/18
 * @Modified By:
 */
public interface UserDao {

    //根据用户id查询用户
    User queryUserById(@Param("id")Integer id) throws Exception;

    //根据邮箱获取用户信息
    User queryUserByEmail(@Param("email")String email) throws Exception;

    //增加一条用户记录
    void insertUser(User user) throws Exception;

    //更新用户上线时间
    void updateTime(@Param("email")String email,@Param("time")long time) throws Exception;

    //根据邮箱和密码查询用户
    User queryUserByEmailAndPassword(@Param("email")String email,@Param("password")String password) throws Exception;

    //根据邮箱修改用户密码
    int updateUserPasswordByEmail(@Param("email")String email, @Param("password")String password) throws Exception;

    //根据id查询用户收藏的职位
    List<Position> queryCollectionById(@Param("id")Integer id) throws Exception;

    //根据职位id删除用户收藏的职位
    void deleteCollectionById(@Param("uid")Integer uid,@Param("pid")Integer pid) throws Exception;

    //根据用户id查询新投递的职位
    List<Position> queryNewApplicationById(@Param("id")Integer id) throws Exception;

    //根据用户id查询已查阅的职位
    List<Position> queryConsultedApplicationById(@Param("id")Integer id) throws Exception;

    //根据用户id查询待安排的职位
    List<Position> queryArrangedApplicationById(@Param("id")Integer id) throws Exception;

    //根据用户id和职位id查询申请id
    Integer queryApplicationIdByUidAndPid(@Param("uid")Integer uid,@Param("pid")Integer pid) throws Exception;

    //增加一条申请表记录
    void insertApplication(@Param("uid")Integer uid,@Param("pid")Integer pid) throws Exception;

    //根据用户id和职位id查询收藏id
    Integer queryCollectionIdByUidAndPid(@Param("uid")Integer uid,@Param("pid")Integer pid) throws Exception;

    //增加一条收藏表记录
    void insertCollection(@Param("uid")Integer uid,@Param("pid")Integer pid) throws Exception;
}
