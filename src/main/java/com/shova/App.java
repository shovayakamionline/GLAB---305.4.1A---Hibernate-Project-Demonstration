package com.shova;

import com.shova.controller.FindUser_Hql;

public class App {
    public static void main(String[] args) {
        FindUser_Hql user = new FindUser_Hql();
//        user.findUser();
//        user.findUserSelect();
//        user.getRecordById();
//        user.getRecords();
//        user.getMaxSalary();
        user.getMaxSalaryGroupBy();
        user.NamedQueryExample();
    }
}
