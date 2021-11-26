package io.kaiouz.exercise.redis.cluster;

import io.kaiouz.exercise.redis.RedisConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RedisClusterConfiguration.class, RedisConfiguration.class})
@TestPropertySource(properties = {"redis.cluster=127.0.0.1:7001,127.0.0.1:7002,127.0.0.1:7003"})
public class RedisClusterTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void writeAndRead() {
        ValueOperations<String, String> op =  redisTemplate.opsForValue();

        for (int i = 0; i < 1000; i++) {
            op.set("foo"+i, i+"");
        }
    }
}
