package entity;

import java.util.Date;
import java.util.List;

public class Project extends AbstractIdentifiedEntity {

    private Date startDate;

    private String status;

    private Integer payment;

    private TechnicalTask technicalTask;

    private List<User> employees;

}
