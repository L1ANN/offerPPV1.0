package team.offer.entity;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:17 2018/1/18
 * @Modified By:
 */
public class Admin {
    private Integer pkAdministrator_name;
    private String adminnistratorPassword;

    public Integer getPkAdministrator_name() {
        return pkAdministrator_name;
    }

    public void setPkAdministrator_name(Integer pkAdministrator_name) {
        this.pkAdministrator_name = pkAdministrator_name;
    }

    public String getAdminnistratorPassword() {
        return adminnistratorPassword;
    }

    public void setAdminnistratorPassword(String adminnistratorPassword) {
        this.adminnistratorPassword = adminnistratorPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "pkAdministrator_name=" + pkAdministrator_name +
                ", adminnistratorPassword='" + adminnistratorPassword + '\'' +
                '}';
    }
}
