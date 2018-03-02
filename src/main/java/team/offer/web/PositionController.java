package team.offer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import team.offer.service.PositionService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:19 2018/1/19
 * @Modified By:
 */
@Controller("/position")
public class PositionController {
    @Resource
    private PositionService positionService;

    //职位详情
    @RequestMapping("/detail.action")
    public String detail(Model model, HttpServletRequest request) throws Exception{
        return null;
    }

    //职位搜索
    @RequestMapping("/query.action")
    public String query(Model model,HttpServletRequest request) throws Exception{
        return null;
    }
}
