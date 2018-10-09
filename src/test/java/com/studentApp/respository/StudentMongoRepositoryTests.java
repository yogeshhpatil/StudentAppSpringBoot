package com.studentApp.respository;

import com.studentApp.repository.StudentMongoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentMongoRepositoryTests {

    @Autowired
    StudentMongoRepository mongoRepository;

    @Test
    public void testBeanCreation(){
        Assert.assertNotEquals(null,mongoRepository);
    }
}
