package team.offer.entity;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:12 2018/1/18
 * @Modified By:
 */
public class Career {
    private Integer pkDirectionId;
    private String directionName;

    public int getPkDirectionId() {
        return pkDirectionId;
    }

    public void setPkDirectionId(Integer pkDirectionId) {
        this.pkDirectionId = pkDirectionId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    @Override
    public String toString() {
        return "Career{" +
                "pkDirectionId=" + pkDirectionId +
                ", directionName='" + directionName + '\'' +
                '}';
    }
}
