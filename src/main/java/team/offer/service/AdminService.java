package team.offer.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import team.offer.entity.Admin;
import team.offer.entity.Company;
import team.offer.entity.User;
import java.util.List;
/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:04 2018/1/19
 * @Modified By:
 */
public interface AdminService {
    //管理员登录
    public boolean adminLogin(Object id,Object password) throws Exception;

    //用户管理
    public List<User> userManage() throws Exception;

    //删除用户
    public boolean deleteUser(Object id) throws Exception;

    //企业审核页面
    public List<Company> checkCompany() throws Exception;

    //审核具体企业
    public boolean verify(Object i,Object id) throws Exception;

    //管理所有企业上限页面
    public List<Company> listAllCompanys() throws Exception;

    //修改具体企业的发布岗位上限
    public Boolean setPositionLimit(Object limit,Object id) throws Exception;
}
