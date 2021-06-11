package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.BillDao;












//BILLS//
//        INSERT INTO `teams`.`bills` (`status`, `information`, `amount_due`, `project_id`) VALUES ('NOT_PAID', 'Week 1', '1000', '1');
//        SELECT * FROM teams.bills WHERE bill_id = 1
//        UPDATE `teams`.`bills` SET `status` = 'PAID', `information` = 'Week 2', `amount_due` = '1000' WHERE (`bill_id` = '1');
//        DELETE FROM `teams`.`bills` WHERE (`bill_id` = '1');
//for user-customer to find all his bills
//        SELECT * FROM teams.bills INNER JOIN teams.projects ON teams.projects.project_id=teams.bills.project_id INNER JOIN teams.technical_tasks
//        ON teams.projects.technical_task_id=teams.technical_tasks.technical_task_id WHERE teams.technical_tasks.customer_id = 1

public class BillDaoImpl implements BillDao {



}
