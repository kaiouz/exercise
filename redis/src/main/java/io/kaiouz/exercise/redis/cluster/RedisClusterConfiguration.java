package io.kaiouz.exercise.redis.cluster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisClusterConfiguration {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(@Value("${redis.cluster}") String[] nodes) {

        org.springframework.data.redis.connection.RedisClusterConfiguration clusterConfiguration =
                new org.springframework.data.redis.connection.RedisClusterConfiguration();

        for (String node : nodes) {
            String[] hp = node.split(":");
            clusterConfiguration.clusterNode(hp[0], Integer.parseInt(hp[1]));
        }

        return new LettuceConnectionFactory(clusterConfiguration);
    }

}
