package team.offer.dao;

import org.springframework.stereotype.Repository;
import team.offer.entity.Company;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 15:58 2018/1/19
 * @Modified By:
 */
@Repository
public interface CompanyDao {
    //增加一个企业用户
    public void insertCompany(Company company)throws Exception;

    //根据id查询(单个)用户
    public Company getCompanyById(int id)throws Exception;

    //根据email查询(单个)用户
    public Company getCompanyByEmail(String email)throws Exception;

    //获取公司列表
    public List<Company> getCompanyList()throws Exception;

    //更新公司信息
    public void updateCompany(Company company)throws Exception;

}
