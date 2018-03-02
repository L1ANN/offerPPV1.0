package team.offer.service;

import org.springframework.stereotype.Service;
import sun.reflect.annotation.ExceptionProxy;
import team.offer.entity.Company;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:04 2018/1/19
 * @Modified By:
 */

public interface CompanyService {
    public Company  getCompanyById(int id)throws Exception;

    public Company getCompanyByEmail(String email) throws Exception;

    public void insertCompany(Company company) throws Exception;

    public List<Company> getCompanyList()throws Exception;

    public void updateCompany(Company company)throws Exception;
}
