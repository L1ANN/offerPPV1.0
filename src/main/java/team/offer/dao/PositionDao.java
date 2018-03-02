package team.offer.dao;

import team.offer.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 15:59 2018/1/19
 * @Modified By:
 */
public interface PositionDao {
    //根据职位id查询职位
    Position queryPositionById(Integer id) throws Exception;

    //根据名称和查询关键字搜索职位集合
    List<Position> queryPositionByConditions(String name, Map<String,List<String>> keyWords) throws Exception;

    //分页查询
    List<Position> queryPosition(String name) throws Exception;
}
