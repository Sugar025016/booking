package com.example.booking.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
//@Configuration
//@EnableRedisHttpSession
//public class SessionCaching {
//
//
//    /**
//     * redis 默认连接工厂
//     * 以下作用
//     * 1.作为spring session 分布式共享的Nosql数据源
//     * 2.作为系统缓存/key值监听等缓存功能RedisTemplate的链接工厂
//     * @return
//     */
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//
//        jedisConnectionFactory.setHostName("127.0.0.1");
//        jedisConnectionFactory.setPoolConfig(new JedisPoolConfig());
//        jedisConnectionFactory.setPort(6379);
//        jedisConnectionFactory.setPassword("password");
//        jedisConnectionFactory.setDatabase(0);
//        return jedisConnectionFactory;
//    }
//
//
//}
