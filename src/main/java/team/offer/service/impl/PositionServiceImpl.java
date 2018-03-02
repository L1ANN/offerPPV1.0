package team.offer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import team.offer.dao.PositionDao;
import team.offer.entity.Position;
import team.offer.entity.User;
import team.offer.service.PositionService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:06 2018/1/19
 * @Modified By:
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    public Position detailOfPosition(Integer id) throws Exception {
        return null;
    }

    public List<Position> queryPosition(String name, Map<String, List<String>> keyWords) throws Exception {
        return null;
    }

    public PageInfo<Position> queryByPage(String name, Integer pageNo, Integer pageSize) throws Exception{
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null ?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Position> list = positionDao.queryPosition(name);
        //用PageInfo对结果进行包装
        PageInfo<Position> page = new PageInfo<Position>(list);
        return page;
    }
}
