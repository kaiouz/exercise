package io.kaiouz.exercise.redis.sentinel;

import io.kaiouz.exercise.redis.RedisConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RedisSentinelConfiguration.class, RedisConfiguration.class})
@TestPropertySource(properties = {"redis.master=mymaster","redis.host=127.0.0.1", "redis.port=26379"})
public class RedisSentinelTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void writeAndRead() {
        ValueOperations<String, String> op =  redisTemplate.opsForValue();
        op.set("RedisReplicationTest", "1");

        String val = op.get("RedisReplicationTest");

        Assert.assertEquals(val, "1");
    }

}
