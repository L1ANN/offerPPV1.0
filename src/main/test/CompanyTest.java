

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.offer.dao.CompanyDao;
import team.offer.entity.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class CompanyTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testInsertCompany() throws Exception
    {
////        Company company=new Company();
////        company.setComNo(1);
////        company.setComEmail("test@test.com");
////        company.setComName("alimama");
////        company.setComPassword("haha");
////        company.setComPostlimit(10);
////        company.setComSize(10);
////        company.setComContact("1233456789");
////        company.setComIndustry("esports");
////        company.setComIntro("test");
////        company.setComLegalperson("mayun");
////        company.setComLocation("hangzhou");
//
//        companyDao.insertCompany(company);
    }

}
