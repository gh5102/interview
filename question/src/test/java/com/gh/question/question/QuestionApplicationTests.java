package com.gh.question.question;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class QuestionApplicationTests {

    @Test
    void contextLoads() {
        Date date = new Date();
        System.out.println(date);
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }

}
