package com.studentApp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("studentDAOMysql")
public class StudentDAOMysql {
    //implement code for mysql database connectivity
}
