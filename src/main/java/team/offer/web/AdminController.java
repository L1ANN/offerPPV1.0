package team.offer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import team.offer.entity.Admin;
import team.offer.entity.User;
import team.offer.service.impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import team.offer.service.AdminService;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:21 2018/1/19
 * @Modified By:
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //登录
    @RequestMapping("/adminLogin.action")
    public String adminLogin(Model model, HttpServletRequest request) throws Exception{
        AdminService adminService = new AdminServiceImpl();
        boolean b = adminService.adminLogin(request.getParameter("id"),request.getParameter("password"));
        if(b){
            return "/redirect:/admin/userManage.action";
        }
        return "adminLogin";
    }

    //用户管理
    @RequestMapping("/userManage.action")
    public String userManage(Model model, HttpServletRequest request) throws Exception{
        AdminService adminService = new AdminServiceImpl();
        List<User> userList =  adminService.userManage();
        model.addAttribute("userList",userList);
        return "userManage";
    }

    //删除用户
    public String deleteUser(Model model, HttpServletRequest request) throws Exception{
        AdminService adminService = new AdminServiceImpl();
        adminService.deleteUser(request.getParameter("id"));
        return "userManage";
    }

    //企业审核
    @RequestMapping("/companyCheck.action")
    public String checkCompany(Model model, HttpServletRequest request) throws Exception{
        return null;
    }

    //企业发布岗位上限设置
    @RequestMapping("/setPositionLimit.action")
    public String setPositionLimit(Model model, HttpServletRequest request) throws Exception{
        return null;
    }
}
