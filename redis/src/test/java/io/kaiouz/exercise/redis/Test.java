package io.kaiouz.exercise.redis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Test.Config.class)
@TestPropertySource(properties = {"a[0]=1111", "a[1]=2222"})
public class Test {

    @Value("${a}")
    List<String> a;

    @org.junit.Test
    public void test() {
        System.out.println(a);
    }


    @Configuration
    static class Config {

    }
}
