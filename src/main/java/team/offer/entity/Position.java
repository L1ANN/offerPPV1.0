package team.offer.entity;

public class Position {
    private Integer pkPositionId;

    private Integer comId;

    private String positionName;

    private String positionProperty;

    private String positionPlace;

    private String positionEducation;

    private String positionExperiment;

    private String positionSalary;

    private String positionWelfare;

    private String positionIntroduction;

    private String positionSkill;

    public Integer getPkPositionId() {
        return pkPositionId;
    }

    public void setPkPositionId(Integer pkPositionId) {
        this.pkPositionId = pkPositionId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getPostionName() {
        return positionName;
    }

    public void setPostionName(String postionName) {
        this.positionName = postionName == null ? null : postionName.trim();
    }

    public String getPositionProperty() {
        return positionProperty;
    }

    public void setPositionProperty(String positionProperty) {
        this.positionProperty = positionProperty == null ? null : positionProperty.trim();
    }

    public String getPositionPlace() {
        return positionPlace;
    }

    public void setPositionPlace(String positionPlace) {
        this.positionPlace = positionPlace == null ? null : positionPlace.trim();
    }

    public String getPositionEducation() {
        return positionEducation;
    }

    public void setPositionEducation(String positionEducation) {
        this.positionEducation = positionEducation == null ? null : positionEducation.trim();
    }

    public String getPositionExperiment() {
        return positionExperiment;
    }

    public void setPositionExperiment(String positionExperiment) {
        this.positionExperiment = positionExperiment == null ? null : positionExperiment.trim();
    }

    public String getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(String positionSalary) {
        this.positionSalary = positionSalary == null ? null : positionSalary.trim();
    }

    public String getPositionWelfare() {
        return positionWelfare;
    }

    public void setPositionWelfare(String positionWelfare) {
        this.positionWelfare = positionWelfare == null ? null : positionWelfare.trim();
    }

    public String getPositionIntroduction() {
        return positionIntroduction;
    }

    public void setPositionIntroduction(String positionIntroduction) {
        this.positionIntroduction = positionIntroduction == null ? null : positionIntroduction.trim();
    }

    public String getPositionSkill() {
        return positionSkill;
    }

    public void setPositionSkill(String positionSkill) {
        this.positionSkill = positionSkill == null ? null : positionSkill.trim();
    }

    @Override
    public String toString() {
        return "Position{" +
                "pkPositionId=" + pkPositionId +
                ", comId=" + comId +
                ", postionName='" + positionName + '\'' +
                ", positionProperty='" + positionProperty + '\'' +
                ", positionPlace='" + positionPlace + '\'' +
                ", positionEducation='" + positionEducation + '\'' +
                ", positionExperiment='" + positionExperiment + '\'' +
                ", positionSalary='" + positionSalary + '\'' +
                ", positionWelfare='" + positionWelfare + '\'' +
                ", positionIntroduction='" + positionIntroduction + '\'' +
                ", positionSkill='" + positionSkill + '\'' +
                '}';
    }
}