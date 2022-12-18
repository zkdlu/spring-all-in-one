package com.zkdlu.data.redis

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import redis.embedded.RedisServer
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Configuration
class EmbeddedConfig {
    @Value("\${spring.redis.port}")
    private val redisPort = 0
    private var redisServer: RedisServer? = null
    @PostConstruct
    fun redisServer() {
        redisServer = RedisServer(redisPort)
        redisServer!!.start()
    }

    @PreDestroy
    fun stopRedis() {
        if (redisServer != null) {
            redisServer!!.stop()
        }
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}