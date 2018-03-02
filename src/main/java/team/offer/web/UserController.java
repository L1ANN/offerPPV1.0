package team.offer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import team.offer.entity.User;
import team.offer.entity.UserValidation;
import team.offer.service.UserService;
import team.offer.util.JavaEmailSender;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 19:30 2018/1/18
 * @Modified By:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //--------------------------------------------注册-------------------------------------------//
    //跳转注册页面
    @RequestMapping(value = "/registerUI.action", method = {RequestMethod.GET})
    public String registerUI(HttpServletRequest request) throws Exception {
        return "user/register";
    }

    //发送验证码
    @RequestMapping(value = "/sendEmail.action", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object sendEmail(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        String msg = "ok";
        String toEmail = request.getParameter("email");
        String requestURL = request.getParameter("request");
        //如果发送验证码请求来自 忘记密码 页面，需要验证邮箱是否存在
        if(requestURL.equals("forgetemail")&&!userService.verifyEmail(toEmail)){
            map.put("result","emailFalse");
            return map;
        }
        String title = "offer++注册验证码";
        String content = (int) (Math.random() * 999999) + "";
        JavaEmailSender.sendEmail(toEmail, title, content);
        map.put("result", msg);
        //发送邮箱后，将验证码和发送邮箱时的系统时间记入session中
        request.getSession().setAttribute("code", content);
        request.getSession().setAttribute("code_time",System.currentTimeMillis());
        return map;
    }

    //注册
    @RequestMapping(value = "/register.action", method = {RequestMethod.POST})
    public String register(Model model, String inputCode, String confirmPassword, HttpServletRequest request, @Validated User user, BindingResult result) throws Exception {
        //对邮箱和密码进行数据检验
        if (result.hasErrors()) {
            //如果参数绑定出错，获取所有错误
            List<ObjectError> errors = result.getAllErrors();
            model.addAttribute("errors", errors);
            //数据回显
            model.addAttribute("user", user);
            model.addAttribute("inputCode", inputCode);
            return "user/register";
        } else {
            //验证验证码，以及验证时间是否超过60s
            String registerCode = (String) request.getSession().getAttribute("code");
            if ((!registerCode.equals(inputCode))||(System.currentTimeMillis()-(Long)request.getSession().getAttribute("code_time")>60000)) {
                //数据回显
                model.addAttribute("user", user);
                model.addAttribute("inputCode", inputCode);
                model.addAttribute("codeError", "验证码错误");
                return "user/register";
            }
            //验证码验证后，删除session中的验证码和时间
            request.getSession().removeAttribute("code");
            request.getSession().removeAttribute("code_time");
            //验证密码和确认密码是否相同
            if (!confirmPassword.equals(user.getUserPassword())) {
                //数据回显
                model.addAttribute("user", user);
                model.addAttribute("inputCode", inputCode);
                model.addAttribute("confirmError", "确认密码和密码不同");
                return "user/register";
            }
            //验证是否重复注册
            if (!userService.register(user)) {
                //数据回显
                model.addAttribute("user", user);
                model.addAttribute("inputCode", inputCode);
                model.addAttribute("repeatEmail", "邮箱重复注册");
                return "user/register";
            } else {
                //注册成功，跳转到首页
                return "user/index";
            }
        }

    }

    //--------------------------------------------登录-------------------------------------------//
    //跳转登录页面
    @RequestMapping(value = "/loginUI.action", method = {RequestMethod.GET})
    public String loginUI(Model model, HttpServletRequest request) throws Exception {
        //判断cookie中是否有loginInfo，如果有则是记住我状态
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginInfo")) {
                String[] loginInfo = cookie.getValue().split(",");
                model.addAttribute("email", loginInfo[0]);
                model.addAttribute("password", loginInfo[1]);
                model.addAttribute("remember", 1);
            }
        }
        return "user/login";
    }

    //登录
    @RequestMapping(value = "/login.action", method = {RequestMethod.POST})
    public String login(Model model, User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String remember = request.getParameter("remember");
        String password = user.getUserPassword();
        //如果登录验证通过
        if (userService.login(user)) {
            //将user加入到session中
            request.getSession().setAttribute("user", user);
            //如果勾选记住我，将user保存到cookie
            if (!(remember == null || remember.equals(""))) {
                Cookie userCookie = new Cookie("loginInfo", user.getUserEmail() + "," + password);
                userCookie.setMaxAge(30 * 24 * 60 * 60);
                userCookie.setPath("/");
                response.addCookie(userCookie);
            }
            //取消勾选记住我，删除cookie
            else {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("loginInfo")) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
            //跳转到首页
            return "user/changepassword";

        } else {
            model.addAttribute("user", user);
            model.addAttribute("error", "用户名或密码错误");
            return "user/login";
        }
    }

    //--------------------------------------------忘记密码-------------------------------------------//
    //跳转到忘记密码邮箱验证页面
    @RequestMapping(value = "/forgetEmailUI.action", method = {RequestMethod.GET})
    public String forgetUI(Model model, HttpServletRequest request) throws Exception {
        return "user/forgetemail";
    }

    //忘记密码——邮箱验证
    @RequestMapping("/forgetEmail.action")
    public String forgetEmail(Model model, String email, String inputCode, HttpServletRequest request) throws Exception {
        //验证验证码是否正确
        String code = (String) request.getSession().getAttribute("code");
        if(!userService.verifyEmail(email)){
            model.addAttribute("email", email);
            model.addAttribute("inputCode", inputCode);
            model.addAttribute("error","邮箱错误，请重新输入");
            return "user/forgetemail";
        }
        //如果验证码正确并且验证时间没超过60s，验证成功并跳转到修改密码页面
        if (inputCode.equals(code)&&(System.currentTimeMillis()-(Long)request.getSession().getAttribute("code_time")<60000)) {
            model.addAttribute("email",email);
            request.getSession().removeAttribute("code");
            request.getSession().removeAttribute("code_time");
            return "user/forgetpassword";
        }
        //错误，数据回显
        else {
            model.addAttribute("email", email);
            model.addAttribute("inputCode", inputCode);
            model.addAttribute("codeError","验证码错误");
            return "user/forgetemail";
        }
    }

    //忘记密码——修改密码
    @RequestMapping("/forgetPassword.action")
    public String forgetPassword(Model model, String confirmPassword, HttpServletRequest request, @Validated UserValidation user, BindingResult result) throws Exception {
        //对密码进行数据校验
        if (result.hasErrors()) {
            //获取错误信息，数据回显
            List<ObjectError> errors = result.getAllErrors();
            model.addAttribute("errors", errors);
            model.addAttribute("password", user.getUserPassword());
            model.addAttribute("confirmPassword", confirmPassword);
            return "user/forgetpassword";
        } else {
            try {
                //如果确认密码与密码不同，返回错误
                if (!confirmPassword.equals(user.getUserPassword())) {
                    model.addAttribute("password", user.getUserPassword());
                    model.addAttribute("confirmPassword", confirmPassword);
                    model.addAttribute("confirmError", "确认密码与密码不一致");
                    return "user/forgetpassword";
                }
                String email = request.getParameter("email");
                //修改密码成功，返回登录页面
                userService.forgetPassword(email, user.getUserPassword());
                return "user/login";
            }catch(Exception ex){
                model.addAttribute("password", user.getUserPassword());
                model.addAttribute("confirmPassword", confirmPassword);
                model.addAttribute("error", "密码修改失败");
                return "user/forgetpassword";
            }
        }
    }

    //--------------------------------------------修改密码-------------------------------------------//
    //跳转到修改密码页面
    @RequestMapping(value="/changePasswordUI.action",method={RequestMethod.GET})
    public String changePasswordUI(Model model,HttpServletRequest request) throws Exception{
        return "user/changepassword";
    }

    //修改密码
    @RequestMapping("/changePassword.action")
    public String changePassword(Model model, HttpServletRequest request, @Validated UserValidation user, BindingResult result) throws Exception {
        //将需要回显的数据保存到str中
        Map<String,String> str = new HashMap<String,String>();
        String oldPassword = request.getParameter("oldPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        str.put("oldPassword",oldPassword);
        str.put("newPassword",user.getUserPassword());
        str.put("confirmNewPassword",confirmNewPassword);
        //如果数据校验有误，数据回显
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            model.addAttribute("errors",errors);
            model.addAttribute("data",str);
            return "user/changepassword";
        }else{
            //如果新密码与确认密码不一致，数据回显
            if(!user.getUserPassword().equals(confirmNewPassword)){
                model.addAttribute("data",str);
                model.addAttribute("confirmError","新密码与确认密码不同");
                return "user/changepassword";
            }
            User loginUser = (User)request.getSession().getAttribute("user");
            //验证旧密码是否正确，不正确回显
            if(!userService.changePassword(loginUser,oldPassword,user.getUserPassword())){
                model.addAttribute("data",str);
                model.addAttribute("oldError","旧密码错误，请重新输入");
                return "user/changepassword";
            }else{
                //旧密码正确，修改密码
                model.addAttribute("result","修改密码成功");
                return "user/changepassword";
            }
        }

    }

    //查看收藏的岗位
    @RequestMapping("/queryCollection.action")
    public String queryCollection(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //删除收藏的岗位
    @RequestMapping("/deleteCollection.action")
    public String deleteCollection(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //查看新投递
    @RequestMapping("/newApplication.action")
    public String newApplication(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //查看已查阅
    @RequestMapping("/consulted.action")
    public String consulted(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //查看待安排
    @RequestMapping("/arranged.action")
    public String arranged(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //投递职位
    @RequestMapping("/deliver.action")
    public String deliver(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //收藏职位
    @RequestMapping("/collection.action")
    public String collection(Model model, HttpServletRequest request) throws Exception {
        return null;
    }

    //获取用户个人信息
    @RequestMapping("/detail.action")
    public String getUserDetail(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Integer userId = Integer.parseInt(id);
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "userdetail";

    }

}
