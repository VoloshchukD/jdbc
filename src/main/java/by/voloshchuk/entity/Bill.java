package by.voloshchuk.entity;

public class Bill extends AbstractIdentifiedEntity {

    private String status;

    private String information;

    private Integer amountDue;

    private Integer projectId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Integer amountDue) {
        this.amountDue = amountDue;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "status='" + status + '\'' +
                ", information='" + information + '\'' +
                ", amountDue=" + amountDue +
                ", projectId=" + projectId +
                '}';
    }

}
