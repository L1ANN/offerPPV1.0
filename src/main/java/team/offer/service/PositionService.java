package team.offer.service;

import com.github.pagehelper.PageInfo;
import team.offer.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:03 2018/1/19
 * @Modified By:
 */
public interface PositionService {
    //职位详情
    Position detailOfPosition(Integer id) throws Exception;

    //职位搜索
    List<Position> queryPosition(String name, Map<String,List<String>> keyWords) throws Exception;


    //分页搜索
    PageInfo<Position> queryByPage(String name,Integer pageNo,Integer pageSize) throws Exception;
}
