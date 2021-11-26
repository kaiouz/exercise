package io.kaiouz.exercise.redis.sentinel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisSentinelConfiguration {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(@Value("${redis.master}") String master,
                                                           @Value("${redis.host}") String host,
                                                           @Value("${redis.port}") int port) {
        org.springframework.data.redis.connection.RedisSentinelConfiguration sentinelConfig =
                new org.springframework.data.redis.connection.RedisSentinelConfiguration()
                        .master(master)
                .sentinel(host, port);
        return new LettuceConnectionFactory(sentinelConfig);
    }

}
