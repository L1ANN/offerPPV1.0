package team.offer.entity;

public class Company {
    private Integer pkComId;

    private Integer comNo;

    private String comEmail;

    private String comPassword;

    private String comName;

    private String comIndustry;

    private String comLocation;

    private Integer comSize;

    private String comLegalperson;

    private String comIntro;

    private String comContact;

    private Integer comPostlimit;

    private int comPass;

    public Integer getPkComId() {
        return pkComId;
    }

    public void setPkComId(Integer pkComId) {
        this.pkComId = pkComId;
    }

    public Integer getComNo() {
        return comNo;
    }

    public void setComNo(Integer comNo) {
        this.comNo = comNo;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail == null ? null : comEmail.trim();
    }

    public String getComPassword() {
        return comPassword;
    }

    public void setComPassword(String comPassword) {
        this.comPassword = comPassword == null ? null : comPassword.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getComIndustry() {
        return comIndustry;
    }

    public void setComIndustry(String comIndustry) {
        this.comIndustry = comIndustry == null ? null : comIndustry.trim();
    }

    public String getComLocation() {
        return comLocation;
    }

    public void setComLocation(String comLocation) {
        this.comLocation = comLocation == null ? null : comLocation.trim();
    }

    public Integer getComSize() {
        return comSize;
    }

    public void setComSize(Integer comSize) {
        this.comSize = comSize;
    }

    public String getComLegalperson() {
        return comLegalperson;
    }

    public void setComLegalperson(String comLegalperson) {
        this.comLegalperson = comLegalperson == null ? null : comLegalperson.trim();
    }

    public String getComIntro() {
        return comIntro;
    }

    public void setComIntro(String comIntro) {
        this.comIntro = comIntro == null ? null : comIntro.trim();
    }

    public String getComContact() {
        return comContact;
    }

    public void setComContact(String comContact) {
        this.comContact = comContact == null ? null : comContact.trim();
    }

    public Integer getComPostlimit() {
        return comPostlimit;
    }

    public void setComPostlimit(Integer comPostlimit) {
        this.comPostlimit = comPostlimit;
    }

    public int getComPass() {
        return comPass;
    }

    public void setComPass(int comPass) {
        this.comPass = comPass;
    }

    @Override
    public String toString() {
        return "Company{" +
                "pkComId=" + pkComId +
                ", comNo=" + comNo +
                ", comEmail='" + comEmail + '\'' +
                ", comPassword='" + comPassword + '\'' +
                ", comName='" + comName + '\'' +
                ", comIndustry='" + comIndustry + '\'' +
                ", comLocation='" + comLocation + '\'' +
                ", comSize=" + comSize +
                ", comLegalperson='" + comLegalperson + '\'' +
                ", comIntro='" + comIntro + '\'' +
                ", comContact='" + comContact + '\'' +
                ", comPostlimit=" + comPostlimit +
                ", comPass=" + comPass +
                '}';
    }
}