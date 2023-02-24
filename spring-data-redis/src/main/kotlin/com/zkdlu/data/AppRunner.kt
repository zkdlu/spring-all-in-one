package com.zkdlu.data

import org.redisson.api.RBatch
import org.redisson.api.RedissonClient
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(
    private val redisClient: RedissonClient,
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val batch: RBatch = redisClient.createBatch()
        batch.getMap<String, String>("test").fastPutAsync("1", "2")
        batch.getMap<String, String>("test").putAsync("2", "5")

        batch.execute()
    }
}