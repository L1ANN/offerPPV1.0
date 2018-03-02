package team.offer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.offer.dao.CompanyDao;
import team.offer.entity.Company;
import team.offer.service.CompanyService;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:07 2018/1/19
 * @Modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService{


    @Autowired
    private CompanyDao companyDao;

    //根据id获取company实例
    public Company getCompanyById(int id){
        Company company=null;
        try {
            company = companyDao.getCompanyById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return company;
    }

    //根据email获取company实例
    public Company getCompanyByEmail(String email){
        Company company=null;
        try {
            company=companyDao.getCompanyByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return company;
    }

    //插入company
    public void insertCompany(Company company){
        try {
            companyDao.insertCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取所有公司列表
    public List<Company> getCompanyList()throws Exception{
        return companyDao.getCompanyList();
    }

    //更新公司信息
    public void updateCompany(Company company)throws Exception{
        companyDao.updateCompany(company);
    }

}
