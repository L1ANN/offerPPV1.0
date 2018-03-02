package team.offer.web;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.offer.entity.Company;
import team.offer.service.CompanyService;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:19 2018/1/19
 * @Modified By:
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    //@Qualifier("companyService")
    private CompanyService companyService;

    //测试
    @RequestMapping("/test.action")
    public String test(){
        return "test";
    }

    //首页
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //获取指定email的公司详细信息
    @RequestMapping("/getCompany/{email}.action")
    public ModelAndView getCompany(@PathVariable("email") String email)throws Exception{
        Company company = companyService.getCompanyByEmail(email);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("companyDetails");
        mv.addObject("company",company);
        return mv;
    }

    //所有公司的详细信息
    @RequestMapping("/companysDetails.action")
    public ModelAndView getCompanyList()throws Exception{
        List<Company> companyList=companyService.getCompanyList();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("companysDetails");
        mv.addObject("companyList",companyList);
        return mv;
    }

    //请求公司注册页面
    @RequestMapping("/registerCompany.action")
    public String registerCompany(){
        return "registerCompany";
    }


    //公司注册
    @RequestMapping("/companyRegister.action")
    public String companyRegister(Company company){

        try {
            if(company!=null) {
                companyService.insertCompany(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "companyDetails";
    }

    //请求公司登录页面
    @RequestMapping("/signCompany.action")
    public String companySign(){

        return "signCompany";
    }

    //公司登录
    @RequestMapping("/companySignIn.action")
    public String companySignIn(@RequestParam("email") String email,@RequestParam("password") String password)throws Exception{
        Company company = companyService.getCompanyByEmail(email);

        if((company!=null)&&password.equals(company.getComPassword())){
            return "redirect:/company/getCompany/"+company.getComEmail()+".action";
        }
        else {
            return "redirect:/company/signCompany.action";
        }
    }



    //请求密码修改页面
    @RequestMapping("/changeComPassword/{id}.action")
    public String changePassword(@PathVariable("id") int id,Model model)throws Exception {
        Company company=companyService.getCompanyById(id);
        model.addAttribute(company);
        return "redirect:../changeComPassword";
    }

    //修改密码
    @RequestMapping(value="/updateCompany.action",method= RequestMethod.POST)
    public String updateCompany
    (String oldPass,String newPass,String newPassConfirm,Model model){

        return "companyDetails";
    }
}
