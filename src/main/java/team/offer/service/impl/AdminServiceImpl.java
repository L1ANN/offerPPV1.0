package team.offer.service.impl;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import team.offer.dao.AdminDao;
        import team.offer.entity.Admin;
        import team.offer.entity.Company;
        import team.offer.entity.User;
        import team.offer.service.AdminService;

        import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:07 2018/1/19
 * @Modified By:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    //管理员登录
    public boolean adminLogin(Object id,Object password) throws Exception{
        Admin admin = new Admin();
        admin = adminDao.findAdminById(Integer.parseInt(id.toString()));
        if(admin.getAdminnistratorPassword().equals(password))
            return true;
        return false;
    }


    //用户管理
    public List<User> userManage() throws Exception{
        List<User> userList = adminDao.listInactiveUsers();
        return userList;
    }

    //删除用户
    public boolean deleteUser(Object id) throws Exception{
        adminDao.deleteUser(Integer.parseInt(id.toString()));
        return true;
    }

    //企业审核页面
    public List<Company> checkCompany() throws Exception {
        List<Company> companyList = adminDao.listNotPassCompanys();
        return companyList;
    }

    //审核具体的企业
    public boolean verify(Object i,Object id) throws Exception{
        adminDao.modifyCompanyPass(Integer.parseInt(i.toString()),Integer.parseInt(id.toString()));
        return true;
    }

    //管理所有企业上限页面
    public List<Company> listAllCompanys() throws Exception{
        List<Company> companyList = adminDao.findAllCompanys();
        return companyList;
    }

    //修改具体的企业发布岗位上限
    public Boolean setPositionLimit(Object limit,Object id) throws Exception{
        adminDao.setPositionLimit(Integer.parseInt(limit.toString()),Integer.parseInt(id.toString()));
        return false;
    }
}

