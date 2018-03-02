package team.offer.service.impl;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.offer.dao.PositionDao;
import team.offer.entity.Position;
import team.offer.service.PositionService;

import static org.junit.Assert.*;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 15:33 2018/3/1
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({
        "classpath*:spring/spring-dao.xml",
        "classpath*:spring/spring-service.xml"
})
public class PositionServiceImplTest {

    @Autowired
    private PositionService positionService;
    @Test
    public void queryByPage() throws Exception {
        PageInfo<Position> page = positionService.queryByPage(null,1,1);
        System.out.println(page.getList());
    }

}