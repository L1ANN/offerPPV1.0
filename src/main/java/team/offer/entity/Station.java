package team.offer.entity;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 16:14 2018/1/18
 * @Modified By:
 */
public class Station {
    private Integer pkStationId;
    private Integer directionId;
    private String stationName;

    public Integer getPkStationId() {
        return pkStationId;
    }

    public void setPkStationId(Integer pkStationId) {
        this.pkStationId = pkStationId;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Station{" +
                "pkStationId=" + pkStationId +
                ", directionId=" + directionId +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
