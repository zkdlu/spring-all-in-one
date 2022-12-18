package com.zkdlu.data.redis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate

@SpringBootTest
class RedisTest {

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, String>

    @Autowired
    lateinit var redisRepository: RedisRepository


    @Test
    fun `redis 테스트`() {
        redisTemplate.opsForValue()
            .set("key", "my value");

        val result = redisTemplate.opsForValue()
            .get("key")

        assertThat(result).isEqualTo("my value")
    }

    @Test
    fun `model 테스트`() {
        val redisModel = RedisModel("hello", "my id")
        redisRepository.save(redisModel)

        val find = redisRepository.findById("my id").get()

        assertThat(find.id).isEqualTo("my id")
        assertThat(find.data).isEqualTo("hello")
    }
}