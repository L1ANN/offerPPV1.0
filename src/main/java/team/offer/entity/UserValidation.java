package team.offer.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 10:26 2018/3/1
 * @Modified By:
 */
public class UserValidation {
    @NotEmpty(message="密码不能为空")
    @Length(min=6,max=16,message="密码长度必须在6-16之间")
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
