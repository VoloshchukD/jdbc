package by.voloshchuk.entity;

import java.sql.Date;
import java.util.List;

public class Project extends AbstractIdentifiedEntity {

    private Date startDate;

    private String status;

    private Integer payment;

    private TechnicalTask technicalTask;

    private List<User> employees;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public TechnicalTask getTechnicalTask() {
        return technicalTask;
    }

    public void setTechnicalTask(TechnicalTask technicalTask) {
        this.technicalTask = technicalTask;
    }

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "startDate=" + startDate +
                ", status='" + status + '\'' +
                ", payment=" + payment +
                ", technicalTask=" + technicalTask +
                ", employees=" + employees +
                '}';
    }

}
